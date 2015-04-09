package com.zht.project.test.web;

import java.io.Serializable;
import javax.validation.Valid;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zht.framework.web.controller.BaseController;
import org.zht.framework.web.utils.FastjsonUtil;
import org.zht.framework.data.ParamObject;
import org.zht.framework.data.ParamItem;
import org.zht.framework.data.DataSet;
import org.zht.framework.data.RowMap;
import org.zht.framework.data.Querylogic;
import com.zht.project.test.model.Demo;
import com.zht.project.test.service.IDemoService;
@Controller 
@RequestMapping("/project/demo")
public class DemoController extends BaseController {

	private String jspPrefix="/project/demo/";
	@Autowired
	private IDemoService demoService;
	
	
/*--------------------------------------------------------------------------------*/  	
	
	private static final  RowMap rowMap=new RowMap( 
	"name","name",
	"ZInteger","ZInteger",
	"zByte","zByte",
	"zDouble","zDouble",
	"ZBigDecimal","ZBigDecimal",
	"zBoolean","zBoolean",
	"zDate","zDate",
	"zDateTime","zDateTime",
	"zTimeStamp","zTimeStamp",
	"id","id");
/*--------------------------------------------------------------------------------*/  		
	@RequiresPermissions("Demo:loadDemoGridView")
    @RequestMapping(value="/loadDemoGridView")
    @ResponseBody 
    public Object loadDemoGridView(@ModelAttribute("paramObject") ParamObject paramObject){
    
		paramObject.addParamItem("key_name", new ParamItem("name","%??%",paramObject.getReqParam("name"),"LIKE"));
		paramObject.addParamItem("key_zByte", new ParamItem("zByte",paramObject.getReqParam("zByte"),"="));
		paramObject.addParamItem("key_zBoolean", new ParamItem("zBoolean",paramObject.getReqParam("zBoolean"),""));
		
	    DataSet grid= demoService.$base_loadDataSetFromOneEntity(paramObject, rowMap);
	    return FastjsonUtil.convert(grid);
    }
/*--------------------------------Detail------------------------------------------------*/  
	@RequiresPermissions("Demo:enterDemoDetail")
	@RequestMapping(value="/enterDemoDetail")
	public String enterDemoDetail(Model model , Serializable id) throws Exception {	
		Demo demo=demoService.$base_find(id);
		setDataAttribute(model,demo,"demo");
		return jspPrefix+"demoDetail";
	}	
/*-------------------------Add-------------------------------------------------------*/   	
	@RequiresPermissions("Demo:enterAddDemo")
	@RequestMapping(value="/enterAddDemo")
	public String enterAddDemo() throws Exception {	
		return jspPrefix+"demoAdd";
	}	   
	@RequiresPermissions("Demo:addDemo")
    @ResponseBody
    @RequestMapping(value="/addDemo") 
    public Object addDemo(@Valid @ModelAttribute("demo")Demo demo,BindingResult bindingResult){
    	processValidateResult(bindingResult);
    	demoService.$base_save(demo);
    	return ajaxDoneSuccess("数据添加成功 ");
    }
    
/*---------------------------Update-----------------------------------------------------*/    
	@RequiresPermissions("Demo:enterUpdateDemo")
	@RequestMapping(value="/enterUpdateDemo") 
 	public String enterUpdateDemo(Model model , Serializable id) throws Exception {
		Demo demo=demoService.$base_find(id);
		setDataAttribute(model,demo,"demo");
		return jspPrefix+"demoUpdate";
	}       
	@RequiresPermissions("Demo:updateDemo")
    @ResponseBody
    @RequestMapping(value="/updateDemo") 
    public Object updateDemo(@Valid @ModelAttribute("demo")Demo demo,BindingResult bindingResult) throws Exception{
    	processValidateResult(bindingResult);
    	demoService.$base_update(demo);
    	return ajaxDoneSuccess("数据修改成功 ");
    }
/*------------------------------simpleDelete--------------------------------------------------*/    
	@RequiresPermissions("Demo:simpleDeleteDemo")
	@ResponseBody 
	@RequestMapping(value="/simpleDeleteDemo")
    public Object simpleDeleteDemo(Serializable id) throws Exception {
    	demoService.$base_delete$Just(id);
    	return ajaxDoneSuccess("数据删除成功 ");
    }
    @RequiresPermissions("Demo:simpleBatchDeleteDemo")
	@ResponseBody 
	@RequestMapping(value="/simpleBatchDeleteDemo")
    public Object simpleBatchDeleteRbacUserSession(Serializable[] ids) throws Exception {
    	demoService.$base_deleteByIdsInCase$Just(ids);
    	return ajaxDoneSuccess("数据删除成功 ");
    }
}
