/**
 * Copyright (c) 2015 https://github.com/zhaohuatai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.zht.common.rabc.service;


import java.util.List;
import org.zht.framework.data.DataSet;
import org.zht.framework.service.IBaseService;
import com.zht.common.rabc.model.RbacRole;
public interface IRbacRoleService extends IBaseService<RbacRole>{
 public void deleteRbacRole(Long[] ids);
 
 
 //------------------------------USER------------------------------------------------
 public List<?> findRoleCodeUserHaveForCombox(Long userId,Boolean isEnable);
 /**
  * userRole(+)   user extends group (+)    user extends Department (+) -- userRole(-)
  * 用户所拥有的角色Code集合
  * @param userId
  * @param isEnable
  * @return
  */
 public List<String> findRoleCodeUserHave(Long userId,Boolean isEnable);
 /**
  * userRole(+)   user extends group (+)    user extends Department (+) -- userRole(-)
  * @param userName
  * @param isEnable
  * @return
  */
 public List<String> findRoleCodeUserHave(String userName,Boolean isEnable);
 /**
  * roleCode from=>userRole: by userId
  * @param userId
  * @param isEnable
  * @return
  */
 public List<String> findRoleCodeInUserRoleByUserId(Long userId,Boolean isEnable);
 public DataSet findRoleDataSetInUserRoleByUserId(Long userId,Boolean isEnable);
 
 public List<String> findRoleCodeInUserRoleRejectByUserId(Long userId,Boolean isEnable);
 public DataSet findRoleDataSetInUserRoleRejectByUserId(Long userId,Boolean isEnable);
 
 public List<String> findRoleCodeFromUserExtendsGroupsByUserId(Long userId,Boolean isEnable);
 public DataSet findRoleDataSetFromUserExtendsGroupsByUserId(Long userId,Boolean isEnable);
 
 
 public List<String> findRoleCodeFromUserExtendsDepartmentsByUserId(Long userId,Boolean isEnable);
 public DataSet findRoleDataSetFromUserExtendsDepartmentsByUserId(Long userId,Boolean isEnable);
 
 public DataSet findRoleDataSetNotInUserRole$UserRoleReject(Long userId,Boolean isEnable);
 
 public void removeRolesFromUserRole(Long[] roleIds,Long userId);
 
 public void addRolesToUserRole(Long[] roleIds,Long userId);
 
 public void removeRolesFromUserRoleReject(Long[] roleIds,Long userId);
 
 public void addRolesToUserRoleReject(Long[] roleIds,Long userId);

 //---------------------------------GROUP-------------------------------------------------
 /**
  * from_grouprole + from_parents  --> 去掉重复
  * @param groupId：用户组ID
  * @param isEnable：role是否enable，若为空则不限制
  * @return
  */
 public List<String> findRoleCodeGroupHave(Long groupId,Boolean isEnable);
 
 
 public List<String> findRoleCodeInGroupRole(Long groupId,Boolean isEnable);
 /**
  * 只是从 GroupRole 表中根据GroupId 查询 RoleCode 
  * @param groupId ：用户组ID
  * @param isEnable：role是否enable，若为空则不限制
  * @return
  */
 public DataSet findRoleDataSetInGroupRole(Long groupId,Boolean isEnable);
 

 /**
  *  表中根据GroupId 查询 不在  GroupRole 表中的 RoleCode 
  * @param groupId：用户组ID
  * @param isEnable：role是否enable，若为空则不限制
  * @return
  */
 public DataSet findRoleDataSetNotInGroupRole(Long groupId,Boolean isEnable);
 
 public List<String> findRoleCodeFromParentGroups(Long groupId,Boolean isEnable);
 
 /**
  * 查询父级用户组 所有的 roleCode ，（直到根节点的累加）
  * @param groupId：用户组ID
  * @param isEnable  ：role是否enable，若为空则不限制
  * @return
  */
 public DataSet findRoleDataSetFromGroupParents(Long groupId,Boolean isEnable);
 
 public void removeRolesFromGroupRole(Long[] roleIds,Long groupId);
 
 public void addRolesToGroupRole(Long[] roleIds,Long groupId);
 
 //---------------------------------DEPART-------------------------------------------------
 
 public List<String> findRoleCodeSysDepartmentHave(Long sysDepartmentId,Boolean isEnable);
 
 public DataSet findRoleDataSetInSysDepartmentRole(Long sysDepartmentId,Boolean isEnable);
 
 public List<String> findRoleCodeInSysDepartmentRole(Long sysDepartmentId,Boolean isEnable);

 public DataSet findRoleDataSetNotInSysDepartmentRole(Long sysDepartmentId,Boolean isEnable);
 
 public List<String> findRoleCodeFromParentSysDepartments(Long sysDepartmentId,Boolean isEnable);
 public DataSet findRoleDataSetFromSysDepartmentParents(Long sysDepartmentId,Boolean isEnable);
 


 public void removeRolesFromSysDepartmentRole(Long[] roleIds,Long sysDepartmentId);
 
 public void addRolesToSysDepartmentRole(Long[] roleIds,Long sysDepartmentId);
 
 
}
