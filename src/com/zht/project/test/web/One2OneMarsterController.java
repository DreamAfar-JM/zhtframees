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
import com.zht.project.test.model.One2OneMarster;
import com.zht.project.test.service.IOne2OneMarsterService;
@Controller 
@RequestMapping("/project/one2one")
public class One2OneMarsterController extends BaseController {

	private String jspPrefix="/project/one2one/";
	@Autowired
	private IOne2OneMarsterService one2OneMarsterService;
	
	
/*--------------------------------------------------------------------------------*/  	
	
	private static final  RowMap rowMap=new RowMap( 
	"name","name",
	"slaver","slaver.name",
	"id","id");
/*--------------------------------------------------------------------------------*/  		
	
    @RequestMapping(value="/loadOne2OneMarsterGridView")
    @ResponseBody 
    public Object loadOne2OneMarsterGridView(@ModelAttribute("paramObject") ParamObject paramObject){
    
		
	    DataSet grid= one2OneMarsterService.$base_loadDataSetFromOneEntity(paramObject, rowMap);
	    return FastjsonUtil.convert(grid);
    }
/*--------------------------------Detail------------------------------------------------*/  
	public String enterOne2OneMarsterDetail(Model model , Serializable id) throws Exception {	
		One2OneMarster one2OneMarster=one2OneMarsterService.$base_find(id);
		setDataAttribute(model,one2OneMarster,"one2OneMarster");
		return jspPrefix+"one2OneMarsterDetail";
	}	
/*-------------------------Add-------------------------------------------------------*/   	
	public String enterAddOne2OneMarster() throws Exception {	
		return jspPrefix+"one2OneMarsterAdd";
	}	   
	 
    @ResponseBody
    @RequestMapping(value="/addOne2OneMarster") 
    public Object addOne2OneMarster(@Valid @ModelAttribute("one2OneMarster")One2OneMarster one2OneMarster,BindingResult bindingResult){
    	processValidateResult(bindingResult);
    	one2OneMarsterService.$base_save(one2OneMarster);
    	return ajaxDoneSuccess("数据添加成功 ");
    }
    
/*---------------------------Update-----------------------------------------------------*/    

 	public String enterUpdateOne2OneMarster(Model model , Serializable id) throws Exception {
		One2OneMarster one2OneMarster=one2OneMarsterService.$base_find(id);
		setDataAttribute(model,one2OneMarster,"one2OneMarster");
		return jspPrefix+"one2OneMarsterUpdate";
	}       
	
    @ResponseBody
    @RequestMapping(value="/updateOne2OneMarster") 
    public Object updateOne2OneMarster(@Valid @ModelAttribute("one2OneMarster")One2OneMarster one2OneMarster,BindingResult bindingResult) throws Exception{
    	 processValidateResult(bindingResult);
		one2OneMarsterService.$base_update(one2OneMarster);
    	return ajaxDoneSuccess("数据修改成功 ");
    }
/*------------------------------simpleDelete--------------------------------------------------*/    
	@ResponseBody 
	@RequestMapping(value="/simpleDeleteOne2OneMarster")
    public Object simpleDeleteOne2OneMarster(Serializable id) throws Exception {
    	one2OneMarsterService.$base_delete$Just(id);
    	return ajaxDoneSuccess("数据删除成功 ");
    }
	@ResponseBody 
	@RequestMapping(value="/simpleBatchDeleteOne2OneMarster")
    public Object simpleBatchDeleteRbacUserSession(Serializable[] ids) throws Exception {
    	one2OneMarsterService.$base_deleteByIdsInCase$Just(ids);
    	return ajaxDoneSuccess("数据删除成功 ");
    }
}
