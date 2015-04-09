/**
 * Copyright (c) 2015 https://github.com/zhaohuatai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.zht.common.rabc.service;


import java.util.List;

import org.zht.framework.data.DataSet;
import org.zht.framework.data.ParamObject;
import org.zht.framework.data.RowMap;
import org.zht.framework.service.IBaseService;

import com.zht.common.rabc.model.RbacUser;

public interface IRbacUserService extends IBaseService<RbacUser>{
 
 
 public DataSet loadRbacUserDataSet(ParamObject paramObject,RowMap rowMap);
 
 public RbacUser findUserByName(String username) ;
//---------------------------------------------------------------------------------------------
 public Boolean checkDefaultRole(String username) ;
 
//----------------------GROUP@S-----------------------------------------------------------------------
 public DataSet loadUserDataSetIsInGroup(ParamObject paramObject,RowMap rowMap,Long groupId,Boolean isIn);
 public void removeUserFromGroup(Long[] userIds,Long groupId);
 public void addUserToGroup(Long[] userIds,Long groupId);
 public List<Long> findUserIdsByGroupId(Long groupid);
 //-------------------------------Department@S---------------------------------------------------------------------------
 public DataSet loadUserDataSetIsInSysDepartment(ParamObject paramObject,RowMap rowMap,Long departmentId,Boolean isIn);
 public void removeUserFromSysDepartment(Long[] userIds,Long departmentId);
 public void addUserToSysDepartment(Long[] userIds,Long departmentId);
 public List<Long> findUserIdsByDepartmentId(Long departmentId);
 
 
}
