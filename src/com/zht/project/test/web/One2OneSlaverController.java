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
import com.zht.project.test.model.One2OneSlaver;
import com.zht.project.test.service.IOne2OneSlaverService;
@Controller 
@RequestMapping("/project/onetoe")
public class One2OneSlaverController extends BaseController {

	private String jspPrefix="/project/onetoe/";
	@Autowired
	private IOne2OneSlaverService one2OneSlaverService;
	
	
/*--------------------------------------------------------------------------------*/  	
	
	private static final  RowMap rowMap=new RowMap( "id","id",
	"name","name",
		"marster","marster.name"
	);
/*--------------------------------------------------------------------------------*/  		
	
    @RequestMapping(value="/loadOne2OneSlaverGridView")
    @ResponseBody 
    public Object loadOne2OneSlaverGridView(@ModelAttribute("paramObject") ParamObject paramObject){
    
		
	    DataSet grid= one2OneSlaverService.$base_loadDataSetFromOneEntity(paramObject, rowMap);
	    return FastjsonUtil.convert(grid);
    }
/*--------------------------------Detail------------------------------------------------*/  
	public String enterOne2OneSlaverDetail(Model model , Serializable id) throws Exception {	
		One2OneSlaver one2OneSlaver=one2OneSlaverService.$base_find(id);
		setDataAttribute(model,one2OneSlaver,"one2OneSlaver");
		return jspPrefix+"one2OneSlaverDetail";
	}	
/*-------------------------Add-------------------------------------------------------*/   	
	public String enterAddOne2OneSlaver() throws Exception {	
		return jspPrefix+"one2OneSlaverAdd";
	}	   
	 
    @ResponseBody
    @RequestMapping(value="/addOne2OneSlaver") 
    public Object addOne2OneSlaver(@Valid @ModelAttribute("one2OneSlaver")One2OneSlaver one2OneSlaver,BindingResult bindingResult){
    	processValidateResult(bindingResult);
    	one2OneSlaverService.$base_save(one2OneSlaver);
    	return ajaxDoneSuccess("数据添加成功 ");
    }
    
/*---------------------------Update-----------------------------------------------------*/    

 	public String enterUpdateOne2OneSlaver(Model model , Serializable id) throws Exception {
		One2OneSlaver one2OneSlaver=one2OneSlaverService.$base_find(id);
		setDataAttribute(model,one2OneSlaver,"one2OneSlaver");
		return jspPrefix+"one2OneSlaverUpdate";
	}       
	
    @ResponseBody
    @RequestMapping(value="/updateOne2OneSlaver") 
    public Object updateOne2OneSlaver(@Valid @ModelAttribute("one2OneSlaver")One2OneSlaver one2OneSlaver,BindingResult bindingResult) throws Exception{
    	 processValidateResult(bindingResult);
		one2OneSlaverService.$base_update(one2OneSlaver);
    	return ajaxDoneSuccess("数据修改成功 ");
    }
/*------------------------------simpleDelete--------------------------------------------------*/    
	@ResponseBody 
	@RequestMapping(value="/simpleDeleteOne2OneSlaver")
    public Object simpleDeleteOne2OneSlaver(Serializable id) throws Exception {
    	one2OneSlaverService.$base_delete$Just(id);
    	return ajaxDoneSuccess("数据删除成功 ");
    }
	@ResponseBody 
	@RequestMapping(value="/simpleBatchDeleteOne2OneSlaver")
    public Object simpleBatchDeleteRbacUserSession(Serializable[] ids) throws Exception {
    	one2OneSlaverService.$base_deleteByIdsInCase$Just(ids);
    	return ajaxDoneSuccess("数据删除成功 ");
    }
}
