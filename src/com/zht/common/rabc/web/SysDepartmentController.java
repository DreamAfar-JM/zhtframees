/**
 * Copyright (c) 2015 https://github.com/zhaohuatai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.zht.common.rabc.web;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zht.framework.data.DataSet;
import org.zht.framework.data.ParamItem;
import org.zht.framework.data.ParamObject;
import org.zht.framework.data.Querylogic;
import org.zht.framework.data.RowMap;
import org.zht.framework.web.controller.BaseController;
import org.zht.framework.web.utils.FastjsonUtil;

import com.zht.common.rabc.aop.RefreashAuthCacahe;
import com.zht.common.rabc.model.SysDepartment;
import com.zht.common.rabc.model.RbacUser;
import com.zht.common.rabc.service.ISysDepartmentService;
import com.zht.common.rabc.service.IRbacRoleService;
import com.zht.common.rabc.service.IRbacUserService;
/**
 * 
* @ClassName :SysDepartmentController     
* @Description :   
* @createTime :2015年4月3日  下午4:18:15   
* @author ：zhaohuatai   
* @version :1.0
 */
@Controller 
@RequestMapping("/rbac/sysDepartment")
public class SysDepartmentController extends BaseController {
	private String jspPrefix="/common/rbac/sysDepartment/";
	
	@Autowired
	private ISysDepartmentService sysDepartmentService;
	@Autowired
	private IRbacUserService rbacUserService;
	@Autowired
	private IRbacRoleService rbacRoleService;

	
//---------------------------tree---view-------------------------------------------

	@RequiresPermissions("SysDepartment:loadSysDepartmentCombotree")
    @SuppressWarnings("rawtypes")
	@RequestMapping(value="/loadSysDepartmentCombotree")
    @ResponseBody 
    public Object loadSysDepartmentCombotree() throws Exception{
    	List<Map> list=sysDepartmentService.loadSysDepartmentCombotree();  
        return FastjsonUtil.convert(list);
    }
//-------------------------------------------CRUD--------------------------------------------

	@RequiresPermissions("SysDepartment:enterSysDepartmentPage")
	@RequestMapping(value="/enterSysDepartmentPage")
    public Object enterSysDepartmentPage(){
		return jspPrefix+"sysDepartmentTreeGrid";
    }

	@RequiresPermissions("SysDepartment:loadSysDepartmentTreeGrid")
	@ResponseBody 
    @RequestMapping(value="/loadSysDepartmentTreeGrid")
    public Object loadSysDepartmentTreeGrid() throws Exception{
    	DataSet dataSet=sysDepartmentService.loadSysDepartmentTreeGrid();  
        return FastjsonUtil.convert(dataSet);
    }

	@RequiresPermissions("SysDepartment:enterAddSysDepartment")
    @RequestMapping(value="/enterAddSysDepartment")
    public String enterAddSysDepartment(){
        return jspPrefix+"sysDepartmentAdd";
    }

	@RequiresPermissions("SysDepartment:enterEidtSysDepartment")
    @RequestMapping(value="/enterEidtSysDepartment")
    public String enterEidtSysDepartment(Long id,Model model){
    	SysDepartment rbacSysDepartment=sysDepartmentService.$base_find(id);
    	setDataAttribute(model,rbacSysDepartment,"rbacSysDepartment");
        return jspPrefix+"sysDepartmentEdit";
    }

	@RequiresPermissions("SysDepartment:addSysDepartment")
    @RefreashAuthCacahe
    @RequestMapping(value="/addSysDepartment")
    @ResponseBody 
    public Object addSysDepartment(@Valid @ModelAttribute("sysDepartment")SysDepartment sysDepartment,BindingResult bindingResult){
    	processValidateResult(bindingResult);
    	sysDepartmentService.$base_save(sysDepartment);
		return ajaxDoneSuccess("数据添加成功 ");
    }

	@RequiresPermissions("SysDepartment:updateSysDepartment")
    @RefreashAuthCacahe
    @RequestMapping(value="/updateSysDepartment")
    @ResponseBody 
    public Object updateSysDepartment(@Valid @ModelAttribute("sysDepartment")SysDepartment sysDepartment,BindingResult bindingResult){
    	processValidateResult(bindingResult);
    	sysDepartmentService.$base_update(sysDepartment);
		return ajaxDoneSuccess("数据修改成功 ");
    }

	@RequiresPermissions("SysDepartment:deleteSysDepartment")
    @RefreashAuthCacahe
    @RequestMapping(value="/deleteSysDepartment")
    @ResponseBody 
    public Object deleteSysDepartment(Long id){
    	sysDepartmentService.deleteSysDepartment(id);
		return ajaxDoneSuccess("数据删除成功 ");
    }
    
//-----------------------------Assignment--USER----------------------------------------------------------

	@RequiresPermissions("SysDepartment:enterUserAssignment")
    @RequestMapping(value="/enterUserAssignment")
    public String enterUserAssignment(Long id,Model model){
    	SysDepartment sysDepartment=sysDepartmentService.$base_find(id);
    	setDataAttribute(model,sysDepartment,"sysDepartment");
    	return jspPrefix+"groupUserAssignment";
    }
    
    RowMap userRowMap=new RowMap(RbacUser.class).addColMap("defaultRole", "defaultRbacRole.name");

	@RequiresPermissions("SysDepartment:loadUserGridViewIsInSysDepartment")
    @RequestMapping(value="/loadUserGridViewIsInSysDepartment")
    @ResponseBody 
    public Object loadUserGridViewIsInSysDepartment(@ModelAttribute("paramObject") ParamObject paramObject,Long groupId,Boolean isIn){
	    paramObject.addParamItem("userName", new ParamItem("userName","%"+paramObject.getReqParam("userName") +"%",Querylogic.L_like));
	    paramObject.addParamItem("enabled",  new ParamItem("enabled",paramObject.getReqParam("enabled"),Querylogic.L_equal));
	    DataSet grid= rbacUserService.loadUserDataSetIsInSysDepartment(paramObject, userRowMap,groupId,isIn);
	   return FastjsonUtil.convert(grid);
    }

	@RequiresPermissions("SysDepartment:removeUserFromSysDepartment")
    @RefreashAuthCacahe
    @RequestMapping(value="/removeUserFromSysDepartment")
    @ResponseBody 
    public Object removeUserFromSysDepartment(Long[] userIds,Long groupId){
    	rbacUserService.removeUserFromSysDepartment(userIds,groupId);
		return ajaxDoneSuccess("数据修改成功 ");
    }

	@RequiresPermissions("SysDepartment:addUserToSysDepartment")
    @RequestMapping(value="/addUserToSysDepartment")
    @ResponseBody 
    public Object addUserToSysDepartment(Long[] userIds,Long groupId){
    	rbacUserService.addUserToSysDepartment(userIds,groupId);
		return ajaxDoneSuccess("数据修改成功 ");
    }
 
  //-------------------------------DEPARTMENT-ROLE----Assign-----------------------------------------------

	@RequiresPermissions("SysDepartment:enterRoleAssignment")
	@RequestMapping(value="/enterRoleAssignment")
    public String enterRoleAssignment(Long id,Model model){
    	SysDepartment sysDepartment=sysDepartmentService.$base_find(id);
    	setDataAttribute(model,sysDepartment,"sysDepartment");
    	return jspPrefix+"groupRoleAssignment";
    }

	@RequiresPermissions("SysDepartment:loadRoleGridForSysDepartmentRoleAssign")
    @RequestMapping(value="/loadRoleGridForSysDepartmentRoleAssign")
    @ResponseBody 
    public Object loadRoleGridForSysDepartmentRoleAssign(Long groupId,String type){
    	DataSet grid=null;
    	if("InSysDepartmentRole".equals(type)){
    		grid= rbacRoleService.findRoleDataSetInGroupRole( groupId, null);
    	}else if("NotInSysDepartmentRole".equals(type)){
    		grid=  rbacRoleService.findRoleDataSetNotInGroupRole( groupId, null);
    	}else if("FromParents".equals(type)){
    		grid=  rbacRoleService.findRoleDataSetFromGroupParents( groupId, null);
    	}else{
    		grid=new DataSet(0L,null);
    	}
	    return FastjsonUtil.convert(grid);
    }

	@RequiresPermissions("SysDepartment:addRolesToSysDepartmentRole")
    @RefreashAuthCacahe
    @RequestMapping(value="/addRolesToSysDepartmentRole")
    @ResponseBody 
    public Object addRolesToSysDepartmentRole(Long[] roleIds,Long sysDepartmentId){
    	rbacRoleService.addRolesToSysDepartmentRole(roleIds,sysDepartmentId);
		return ajaxDoneSuccess("数据修改成功 ");
    }

	@RequiresPermissions("SysDepartment:removeRolesFromSysDepartmentRole")
    @RefreashAuthCacahe
    @RequestMapping(value="/removeRolesFromSysDepartmentRole")
    @ResponseBody 
    public Object removeRolesFromSysDepartmentRole(Long[] roleIds,Long sysDepartmentId){
    	rbacRoleService.removeRolesFromSysDepartmentRole(roleIds,sysDepartmentId);
		return ajaxDoneSuccess("数据修改成功 ");
    }
}
