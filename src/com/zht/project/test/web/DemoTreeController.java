package com.zht.project.test.web;

import java.io.Serializable;
import javax.validation.Valid;
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
import com.zht.project.test.model.DemoTree;
import com.zht.project.test.service.IDemoTreeService;
@Controller 
@RequestMapping("/project/demoTree")
public class DemoTreeController extends BaseController {

	private String jspPrefix="/project/demoTree/";
	@Autowired
	private IDemoTreeService demoTreeService;
	
	
/*--------------------------------------------------------------------------------*/  	
	
	private static final  RowMap rowMap=new RowMap( 
	"name","name",
	"PDemoTree","PDemoTree.",
	"id","id");
/*--------------------------------------------------------------------------------*/  		
	
    @RequestMapping(value="/loadDemoTreeGridView")
    @ResponseBody 
    public Object loadDemoTreeGridView(@ModelAttribute("paramObject") ParamObject paramObject){
    
		paramObject.addParamItem("key_PDemoTree", new ParamItem("PDemoTree.id",paramObject.getReqParam("PDemoTree.id"),"=",Querylogic.T_Long));
		
	    DataSet grid= demoTreeService.$base_loadDataSetFromOneEntity(paramObject, rowMap);
	    return FastjsonUtil.convert(grid);
    }
/*--------------------------------Detail------------------------------------------------*/  
	public String enterDemoTreeDetail(Model model , Serializable id) throws Exception {	
		DemoTree demoTree=demoTreeService.$base_find(id);
		setDataAttribute(model,demoTree,"demoTree");
		return jspPrefix+"demoTreeDetail";
	}	
/*-------------------------Add-------------------------------------------------------*/   	
	public String enterAddDemoTree() throws Exception {	
		return jspPrefix+"demoTreeAdd";
	}	   
	 
    @ResponseBody
    @RequestMapping(value="/addDemoTree") 
    public Object addDemoTree(@Valid @ModelAttribute("demoTree")DemoTree demoTree,BindingResult bindingResult){
    	processValidateResult(bindingResult);
    	demoTreeService.$base_save(demoTree);
    	return ajaxDoneSuccess("数据添加成功 ");
    }
    
/*---------------------------Update-----------------------------------------------------*/    

 	public String enterUpdateDemoTree(Model model , Serializable id) throws Exception {
		DemoTree demoTree=demoTreeService.$base_find(id);
		setDataAttribute(model,demoTree,"demoTree");
		return jspPrefix+"demoTreeUpdate";
	}       
	
    @ResponseBody
    @RequestMapping(value="/updateDemoTree") 
    public Object updateDemoTree(@Valid @ModelAttribute("demoTree")DemoTree demoTree,BindingResult bindingResult) throws Exception{
    	processValidateResult(bindingResult);
    	demoTreeService.$base_update(demoTree);
    	return ajaxDoneSuccess("数据修改成功 ");
    }
/*------------------------------simpleDelete--------------------------------------------------*/    
	@ResponseBody 
	@RequestMapping(value="/simpleDeleteDemoTree")
    public Object simpleDeleteDemoTree(Serializable id) throws Exception {
    	demoTreeService.$base_delete$Just(id);
    	return ajaxDoneSuccess("数据删除成功 ");
    }
	@ResponseBody 
	@RequestMapping(value="/simpleBatchDeleteDemoTree")
    public Object simpleBatchDeleteRbacUserSession(Serializable[] ids) throws Exception {
    	demoTreeService.$base_deleteByIdsInCase$Just(ids);
    	return ajaxDoneSuccess("数据删除成功 ");
    }
}
