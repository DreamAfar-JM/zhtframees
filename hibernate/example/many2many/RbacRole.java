package com.zht.framework.hibernate.example.many2many;

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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *RBAC 角色 POJO实体类 
 * @author zhaoht
 * @version v 1.0
 * @modify 2012-12-07-17
 * 
 */
//@Entity()
@Table(name = "rbac_role", uniqueConstraints = { @UniqueConstraint(columnNames = "code") })
@org.hibernate.annotations.Table(appliesTo = "rbac_role",comment="角色")
public class RbacRole implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 定义最终静态类型 ： 角色code的前缀
	 */
	public static final String AUTHORITY_PREFIX = "ROLE_";
	

	@Transient
	public String getPrefixedName() {
		return AUTHORITY_PREFIX + code;
	}
	
	/**
	 *主键ID
	 */
	@Id()
    @Column(name = "id")
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	
	/**
	 * 角色编码
	 */
	@Column(name = "code", length = 255, nullable = false)
	private String code;	
	
	/**
	 * 角色名称
	 */
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	
	/**
	 * 描述、备注
	 */
	@Column(name = "description", length = 255, nullable = true)
	private String description;
	
	/**
	 * 是否禁用
	 */
	@Column(name = "enabled",  nullable = false)
	private Boolean enabled;
		
	
	
	/**
	 * 多对多关联许可资源
	 */
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="rbac_role_permission", joinColumns = { 
        @JoinColumn(name="roleId", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="permissionId", nullable=false, updatable=false) })
	private Set<RbacPermission> rbacRolePermission = new HashSet<RbacPermission>(0);
	
	
	
	/**
	 * 多对多关联rabcuser
	 */
	//被维护端---中间表有RbacUSer维护**
	@ManyToMany(cascade=CascadeType.REFRESH,mappedBy="rbacUserRole") 
//	@ManyToMany(fetch=FetchType.EAGER)
//    @JoinTable(name="rbac_user_role",  joinColumns = { 
//        @JoinColumn(name="roleId", nullable=false, updatable=false) }, inverseJoinColumns = { 
//        @JoinColumn(name="userId", nullable=false, updatable=false) })
	private Set<RbacUser> rbacUsers = new HashSet<RbacUser>(0);
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Set<RbacUser> getRbacUsers() {
		return rbacUsers;
	}
	public void setRbacUsers(Set<RbacUser> rbacUsers) {
		this.rbacUsers = rbacUsers;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Set<RbacPermission> getRbacRolePermission() {
		return rbacRolePermission;
	}

	public void setRbacRolePermission(Set<RbacPermission> rbacRolePermission) {
		this.rbacRolePermission = rbacRolePermission;
	}

	public RbacRole() {
        super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		if(obj instanceof RbacRole == false) return false;
		if(this == obj) return true;
		RbacRole other = (RbacRole)obj;
		return new EqualsBuilder()
					.append(getId(),other.getId())
					.append(getName(),other.getName())
					.append(getDescription(),other.getDescription())
					.append(getEnabled(),other.getEnabled())
		.isEquals();
	}
}
