/**
 * Copyright (c) 2015 https://github.com/zhaohuatai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.zht.common.rabc.service;

import java.util.List;
import java.util.Map;

import org.zht.framework.data.DataSet;
import org.zht.framework.service.IBaseService;

import com.zht.common.rabc.model.SysDepartment;
/**
 * 
* @ClassName :ISysDepartmentService     
* @Description :   
* @createTime :2015年4月3日  下午4:24:02   
* @author ：zhaohuatai   
* @version :1.0
 */
public interface ISysDepartmentService extends IBaseService<SysDepartment>{
	
	 public DataSet loadSysDepartmentTreeGrid();
	 
	 @SuppressWarnings("rawtypes")
	 public List<Map> loadSysDepartmentCombotree() ;
	 
	 public void deleteSysDepartment(Long id);
	 
	 public List<Long> findDepartmentIdsByUserId(Long userId);
	 
	 public List<Long> findDepartmentIdsByRoleId(Long roleId);
}