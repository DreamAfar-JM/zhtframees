/**
 * Copyright (c) 2015 https://github.com/zhaohuatai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.zht.common.rabc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.zht.framework.annos.TreeConstruct;
import org.zht.framework.annos.TreeParentFied;
import org.zht.framework.zhtdao.identity.PKBaseEntity;
/**
 * 
* @ClassName :SysDepartment     
* @Description :   
* @createTime :2015年4月3日  下午4:14:07   
* @author ：zhaohuatai   
* @version :1.0
 */
@Entity()
@Table(name = "sys_department")
@TreeConstruct
public class SysDepartment  extends PKBaseEntity{
	private static final long serialVersionUID = 1L;

	public SysDepartment() {}
	public SysDepartment(Long id) {
		this.setId(id);
	}
	@Column(name = "name", length = 30, nullable = false,unique=true)
	private String name;
	
	
	@Column(name = "description", length = 60 )
	private String description; //描述
	
	@Column(name = "enabled",nullable = false )
	private Boolean enabled;//可用
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createTime;
	
	@Column(name = "creater", length = 30 )
	private String creater;
	
	@TreeParentFied
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private SysDepartment parentSysDepartment;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.REMOVE, mappedBy="parentSysDepartment")
	private Set<SysDepartment> childSysDepartments = new HashSet<SysDepartment>(0);
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public SysDepartment getParentSysDepartment() {
		return parentSysDepartment;
	}

	public void setParentSysDepartment(SysDepartment parentSysDepartment) {
		this.parentSysDepartment = parentSysDepartment;
	}



	public Set<SysDepartment> getChildSysDepartments() {
		return childSysDepartments;
	}

	public void setChildSysDepartments(Set<SysDepartment> childSysDepartments) {
		this.childSysDepartments = childSysDepartments;
	}
}
