/**
 * Copyright (c) 2015 https://github.com/zhaohuatai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.zht.framework.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.zht.framework.data.ParamObject;
import org.zht.framework.exception.ParameterException;
import org.zht.framework.exception.ServiceLogicalException;
import org.zht.framework.message.DJSONMessage;
import org.zht.framework.util.LogUtil;
import org.zht.framework.validate.ValidateHandler;
public class BaseController {
	
	protected static final String forward="forward";
	protected static final String closeCurrent="closeCurrent";
	
	protected static final String defaultAjaxSuccess="数据修改成功";
	protected static final String defaultAjaxError="数据修改失败 : ";
	protected static final String defaultValidateError="数据校验失败 : ";
	protected static final String defaultAuthError= "权限认证失败 : ";
	protected DJSONMessage ajaxDone(int statusCode, String message,String callbackType,String navTabId, String forwardUrl) {
		DJSONMessage dMessage = new DJSONMessage();
		dMessage.setStatusCode(""+statusCode);
		dMessage.setMessage(""+message);
		dMessage.setNavTabId(""+navTabId);
		dMessage.setCallbackType(""+callbackType);
		dMessage.setForwardUrl(""+forwardUrl);
		return dMessage;
	}

	protected DJSONMessage ajaxDoneSuccess(String message) {
		return ajaxDone(200, message, "","","");
	}
	protected DJSONMessage ajaxDoneError(String message) {
		return ajaxDone(300, message, "","","");
	}
	protected DJSONMessage ajaxServerError(String message) {
		return ajaxDone(500, message, "","","");
	}
	protected DJSONMessage ajaxAuthError(String message) {
		return ajaxDone(401, message, "","","");
	}
	protected DJSONMessage ajaxDoneSuccess(String message,String navTabId,String callbackType) {
		return ajaxDone(200, message,callbackType, navTabId,"");
	}

	
	
	protected DJSONMessage ajaxDoneError(String message,String navTabId,String callbackType) {
		return ajaxDone(300, message, callbackType,navTabId,"");
	}
	
	
	//--------------------------------------------------AAAA----------------------------------------------
	protected static void setPageInfoAttribute(Model model, ParamObject paramObject) {
		if(model==null||paramObject==null){
			return;
		}
		model.addAttribute("webParams",paramObject.getWebParams()).addAttribute("paramObject",paramObject);
	}
	
	protected static void setDataAttribute(Model model, List<?> dataList,String dataName,Long totalCount,String countNnme) {
		if(model==null||dataList==null||dataName==null){
			return;
		}
		model.addAttribute(dataName,dataList).addAttribute(countNnme,totalCount==null?0L:totalCount);
	}
	
	protected static void setDataAttribute(Model model, List<?> dataList,String dataName,Long totalCount) {
		if(model==null||dataList==null||dataName==null){
			return;
		}
		model.addAttribute(dataName,dataList).addAttribute("totalCount",totalCount==null?0L:totalCount);
	}
	/**
	 * 
	 * @param model
	 * @param data
	 * @param dataName
	 */
	protected static void setDataAttribute(Model model, Object data,String dataName) {
		if(model==null||data==null||dataName==null){
			return;
		}
		model.addAttribute(dataName,data);
	}
	
	protected static void setDataAttributeAndPageInfo(Model model, List<?> dataList,String dataName,Long totalCount,String countNnme,ParamObject paramObject) {
		if(model==null||dataList==null||dataName==null||paramObject==null){
			return;
		}
		model.addAttribute(dataName,dataList).addAttribute(countNnme,totalCount==null?0L:totalCount);
		model.addAttribute("webParams",paramObject.getWebParams()).addAttribute("paramObject",paramObject);
	}
	
	protected static void setDataAttributeAndPageInfo(Model model, List<?> dataList,String dataName,Long totalCount,ParamObject paramObject) {
		if(model==null||dataList==null||dataName==null||paramObject==null){
			return;
		}
		model.addAttribute(dataName,dataList).addAttribute("totalCount",totalCount==null?0L:totalCount);
		model.addAttribute("webParams",paramObject.getWebParams()).addAttribute("paramObject",paramObject);
	}
	
//-----------------------------------------------------------------------------------------------------------	
	protected static void setPageInfoAttribute(ModelAndView modelView, ParamObject paramObject) {
		if(modelView==null||paramObject==null){
			return;
		}
		modelView.addObject("webParams",paramObject.getWebParams()).addObject("paramObject",paramObject);
	}
	
	protected static void setDataAttribute(ModelAndView modelView, List<?> dataList,String dataName,Long totalCount,String countNnme) {
		if(modelView==null||dataList==null||dataName==null){
			return;
		}
		modelView.addObject(dataName,dataList).addObject(countNnme,totalCount==null?0L:totalCount);
	}
	
	protected static void setDataAttribute(ModelAndView modelView, List<?> dataList,String dataName,Long totalCount) {
		if(modelView==null||dataList==null||dataName==null){
			return;
		}
		modelView.addObject(dataName,dataList).addObject("totalCount",totalCount==null?0L:totalCount);
	}
	
	protected static void setDataAttribute(ModelAndView modelView, Object data,String dataName) {
		if(modelView==null||data==null||dataName==null){
			return;
		}
		modelView.addObject(dataName,data);
	}
	
	protected static void setDataAttributeAndPageInfo(ModelAndView modelView, List<?> dataList,String dataName,Long totalCount,String countNnme,ParamObject paramObject) {
		if(modelView==null||dataList==null||dataName==null||paramObject==null){
			return;
		}
		modelView.addObject(dataName,dataList).addObject(countNnme,totalCount==null?0L:totalCount);
		modelView.addObject("webParams",paramObject.getWebParams()).addObject("paramObject",paramObject);
	}
	
	protected static void setDataAttributeAndPageInfo(ModelAndView modelView, List<?> dataList,String dataName,Long totalCount,ParamObject paramObject) {
		if(modelView==null||dataList==null||dataName==null||paramObject==null){
			return;
		}
		modelView.addObject(dataName,dataList).addObject("totalCount",totalCount==null?0L:totalCount);
		modelView.addObject("webParams",paramObject.getWebParams()).addObject("paramObject",paramObject);
	}
//-----------------------------------------------------------------------------------------------------------	
	
	protected void processValidateResult(BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			throw new ParameterException(ValidateHandler.getDefaultError(bindingResult));
		}
	}
	protected void processValidateResult(NativeWebRequest request){
		if (ValidateHandler.hasErrors(request)) {
			throw new ParameterException(ValidateHandler.getDefaultErrorFromResolver(request));
    	}
	}

	protected ModelAndView returnServiceLogicError(String errorMsg) {
		ModelAndView mav = new ModelAndView("error/serviceLogicError");
		mav.addObject("serviceLogicError", errorMsg);
		return mav;
	}
		
	//ModelAndView(String viewName, Map model)
	private  ModelAndView returnMeaasgeMV(String viewName,String msg) {
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("message", msg);
		return mav;
	}
	@ExceptionHandler
	@ResponseBody
	public Object processGlobalExceptions(HttpServletRequest request,Exception e ) throws Exception {
		request.setAttribute("exceptionMessage", e);
		if (e instanceof ServiceLogicalException) {
			return ajaxDoneError(e.getMessage());
		} else if (e instanceof ParameterException) {
			return ajaxDoneError(defaultValidateError + e.getMessage());
		} else if (e instanceof UnauthorizedException) {//未授权
			 String accept = request.getHeader("accept");
			 if(accept!=null&&accept.contains("application/json")){
				 return ajaxAuthError(defaultAuthError + e.getMessage());
			 }else{
				return returnMeaasgeMV("error/UnauthorizedException","没有权限"+e.getMessage());
			 }
		}else if (e instanceof UnauthenticatedException) {//未认证
			return ajaxAuthError(defaultAuthError + e.getMessage());
		} 
//		else if (e instanceof UnknownAccountException) {
//			return ajaxAuthError(defaultAuthError + e.getMessage());
//		} 
		else if(e instanceof Exception){
			LogUtil.genErrorLog(request,"Exception:"+e.getMessage(), e);
			e.printStackTrace();
			
			return  ajaxServerError("服务器内部错误："+ e.getMessage()) ;
		}
		else{
			throw e;
		}
	} 
	
	
}
