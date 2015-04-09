/**
 * Copyright (c) 2015 https://github.com/zhaohuatai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.zht.common.generator.excute.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.zht.common.codegen.model.GenEntity;
import com.zht.common.codegen.model.GenEntityProperty;
import com.zht.common.generator.constant.GenConstant;
import com.zht.common.generator.excute.ActionGenerator;
import com.zht.common.generator.genpojo.ActionModel;

public class ActionGeneratorImpl extends AbstractGenerator implements ActionGenerator{
	
	@Override
	public void generatorAction(String entityFullClassName,String controllerNameSpace,GenEntity genEntity,List<GenEntityProperty> genEntityPropertyList){
		
		ActionModel actionModel=new ActionModel();
		//实体名
		String entitySimpleName =StringUtils.substringAfterLast(entityFullClassName, ".");
		//路径
		String str=StringUtils.substringBeforeLast(entityFullClassName, ".");
			   str=StringUtils.substringBeforeLast(str, ".");
		String packageName=str+".web";
		String servicePackageName=str+".service";
		
		actionModel.setPackageName(packageName);
		actionModel.setEntitySimpleClassName(entitySimpleName);
		actionModel.setServicePackageName(servicePackageName);
		actionModel.setEntityFullClassName(entityFullClassName);
		actionModel.setControllerNameSpace(controllerNameSpace);
		
		actionModel.setGenEntityPropertyList(genEntityPropertyList);
		actionModel.setGenEntity(genEntity);
		
		String className=entitySimpleName+"Controller";
		
		 Map<String, Object> data = new HashMap<String, Object>();
	     data.put("model", actionModel);
	     String filePath=new String(GenConstant.project_path+"src/"+package2path(packageName)+"/"+className+".java");
	     super.generate(GenConstant.action_template_dir, data, filePath);
	}

}
