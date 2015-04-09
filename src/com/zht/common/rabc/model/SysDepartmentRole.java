/**
 * Copyright (c) 2015 https://github.com/zhaohuatai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.zht.common.rabc.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.zht.framework.zhtdao.identity.PKBaseEntity;
/**
 * 
* @ClassName :SysDepartmentRole     
* @Description :   
* @createTime :2015年4月3日  下午4:13:57   
* @author ：zhaohuatai   
* @version :1.0
 */
@Entity()
@Table(name = "sys_department_role")
public class SysDepartmentRole  extends PKBaseEntity{
	private static final long serialVersionUID = 1L;

	public SysDepartmentRole() {}
	
	public SysDepartmentRole(Long id) {
		this.setId(id);
	}
	
	public SysDepartmentRole(SysDepartment sysDepartment, RbacRole rbacRole) {
		super();
		this.sysDepartment = sysDepartment;
		this.rbacRole = rbacRole;
	}



	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="sys_department_id")
	private SysDepartment sysDepartment;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="rbac_role_id")
	private RbacRole rbacRole;

	public SysDepartment getSysDepartment() {
		return sysDepartment;
	}

	public void setSysDepartment(SysDepartment sysDepartment) {
		this.sysDepartment = sysDepartment;
	}

	public RbacRole getRbacRole() {
		return rbacRole;
	}

	public void setRbacRole(RbacRole rbacRole) {
		this.rbacRole = rbacRole;
	}
	
	
}
