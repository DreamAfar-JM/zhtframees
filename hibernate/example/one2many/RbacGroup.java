package com.zht.framework.hibernate.example.one2many;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 *RBAC 组 POJO实体类 
 * @author zhaoht
 * @version v 1.0
 * @modify 2012-12-07-17
 * 
 */
//@Entity()
@Table(name = "rbac_group", uniqueConstraints = { @UniqueConstraint(columnNames = "name") })
@org.hibernate.annotations.Table(appliesTo = "rbac_group",comment="组信息")
public class RbacGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	public RbacGroup() {

	}

	/**
	 * 主键ID
	 */
	private Long id;

	/**
	 * 外键---父类ID
	 */
	private RbacGroup parentRbacGroup;

	/**
	 * 组名
	 */
	private String name;

	/**
	 * 组简称
	 */
	private String briefname;

	/**
	 * 组描述、备注
	 */
	private String description; //描述

	/**
	 * 是否可用
	 */
	private Boolean enabled;//可用

	@Id()
	@Column(name = "id")
	@GeneratedValue(strategy = IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentid", nullable = false)
	public RbacGroup getParentRbacGroup() {
		return parentRbacGroup;
	}

	public void setParentRbacGroup(RbacGroup parentRbacGroup) {
		this.parentRbacGroup = parentRbacGroup;
	}

	@Column(name = "name", length = 255, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "briefname", length = 100, nullable = false)
	public String getBriefname() {
		return briefname;
	}

	public void setBriefname(String briefname) {
		this.briefname = briefname;
	}

	@Column(name = "description", length = 255, nullable = true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "enabled", nullable = false)
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}
