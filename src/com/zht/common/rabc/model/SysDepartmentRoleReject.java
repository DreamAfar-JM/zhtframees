//package com.zht.common.rabc.model;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import org.zht.framework.zhtdao.identity.PKBaseEntity;
//
//@Entity()
//@Table(name = "sys_department_role_reject")
//public class SysDepartmentRoleReject  extends PKBaseEntity{
//	private static final long serialVersionUID = 1L;
//
//	public SysDepartmentRoleReject() {}
//	
//	@ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="sys_department_id")
//	private SysDepartment sysDepartment;
//	
//	@ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="rbac_role_id")
//	private RbacRole rbacRole;
//
//	public SysDepartment getSysDepartment() {
//		return sysDepartment;
//	}
//
//	public void setSysDepartment(SysDepartment sysDepartment) {
//		this.sysDepartment = sysDepartment;
//	}
//
//	public RbacRole getRbacRole() {
//		return rbacRole;
//	}
//
//	public void setRbacRole(RbacRole rbacRole) {
//		this.rbacRole = rbacRole;
//	}
//	
//	
//}
