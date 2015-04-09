package com.zht.framework.hibernate.example.one2many;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.zht.framework.hibernate.example.many2many.RbacPermission;


/**
 *RBAC 资源 POJO实体类 
 * @author zhaoht
 * @version v 1.0
 * @modify 2012-12-07-17
 * 
 */
//@Entity()
@Table(name = "rbac_resource")
@org.hibernate.annotations.Table(appliesTo = "rbac_resource",comment="资源")
public class RbacResource implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public RbacResource() {

	}

	/**
	 * 主键--ID
	 */
	@Id()
	@Column(name = "id")
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	/**
	 * 外键--树形结构父节点
	 */
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="parentid")
	private RbacResource parentRbacResource;	

	/**
	 * 资源名称
	 */
	@Column(name = "name", length = 255, nullable = false)
    private String name;

	/**
	 * 秘书、备注
	 */
	@Column(name = "description", length = 255, nullable = true)
    private String description;

	/**
	 * 是否禁用
	 */
	@Column(name = "enabled", nullable = false)
    private Boolean enabled;

	/**
	 * 外键--树形子节点  资源
	 */
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY, mappedBy = "parentRbacResource")
	private Set<RbacResource> childRbacResources = new HashSet<RbacResource>(0);

	/**
	 * 关联--许可资源
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "rbacResource")
	@javax.persistence.OrderBy("id")
	private Set<RbacPermission> rbacPermissions = new HashSet<RbacPermission>(0);
	
	
	public Set<RbacResource> getChildRbacResources() {
		return this.childRbacResources;
	}

	public void setChildRbacResources(Set<RbacResource> rbacResources) {
		this.childRbacResources = rbacResources;
	}

	public Set<RbacPermission> getRbacPermissions() {
		return this.rbacPermissions;
	}

	public void setRbacPermissions(Set<RbacPermission> rbacPermissions) {
		this.rbacPermissions = rbacPermissions;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public RbacResource getParentRbacResource() {
		return parentRbacResource;
	}
	public void setParentRbacResource(RbacResource parentRbacResource) {
		this.parentRbacResource = parentRbacResource;
	}
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
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
					.append(getId())
					.append(getName())
					.append(getDescription())
					.append(getEnabled())
		.toHashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof RbacResource == false) return false;
		if(this == obj) return true;
		RbacResource other = (RbacResource)obj;
		return new EqualsBuilder()
					.append(getId(),other.getId())
					.append(getName(),other.getName())
					.append(getDescription(),other.getDescription())
					.append(getEnabled(),other.getEnabled())
		.isEquals();
	}
}
