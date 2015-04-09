package com.zht.framework.hibernate.example.many2many;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

import com.zht.framework.hibernate.example.one2many.RbacGroup;


/**
 *RBAC 用户 POJO实体类 
 * @author zhaoht
 * @version v 1.0
 * @modify 2012-12-07-17
 * 
 */
//@Entity()
@Table(name = "rbac_user", uniqueConstraints = { @UniqueConstraint(columnNames = "loginname") })
@org.hibernate.annotations.Table(appliesTo = "rbac_user",comment="用户")
public class RbacUser implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	/**
	 * RBACUSER---ID
	 */
//	@Id()
//    @Column(name = "id")
//	@GeneratedValue(strategy = IDENTITY)
	
	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;	
	
	/**
	 * 登录名
	 */
	@Column(name = "loginname", length = 255, nullable = false ,unique=true)
	private String loginname;	
	
	/**
	 * 别名
	 */
	@Column(name = "alias", length = 255, nullable = true)
	private String alias;	
	
	/**
	 * 密码
	 */
	@Column(name = "password", length = 255, nullable = true)
	private String password;
	
	/**
	 * 用户名
	 */
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	
	/**
	 * 描述、备注
	 */
	@Column(name = "description", length = 255, nullable = true)
	private String description;
	
	/**
	 * 是否被禁用
	 */
	@Column(name = "enabled",  nullable = false)
	private Boolean enabled;
	
	/**
	 * 账户是否过期
	 */
	@Column(name = "accountNonExpired",  nullable = false)
	private Boolean accountNonExpired ;
	
	/**
	 * 用户认证是否过期
	 */
	@Column(name = "credentialsNonExpired",  nullable = false)
	private Boolean credentialsNonExpired ;
	
	/**
	 * 用户账户是否锁定
	 */
	@Column(name = "accountNonLocked",  nullable = false)
	private Boolean accountNonLocked;
	
	/**
	 * 多对多  关联角色
	 */
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="rbac_user_role", joinColumns = { 
        @JoinColumn(name="userId", nullable=false, updatable=false) }, 
        inverseJoinColumns = { @JoinColumn(name="roleId", nullable=false, updatable=false) })
	private Set<RbacRole> rbacUserRole = new HashSet<RbacRole>(0);
	
	/**
	 * 外键--关联组
	 */
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="groupId", nullable=false)
	private RbacGroup rbacGroup;
	
//----------------------默认角色---zht修改0426
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "defalutRoleId")
	private RbacRole defaultRbacRole;
	
	
	private Date perBirthday;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "perBirthday", length = 10)
	public Date getPerBirthday() {
		return this.perBirthday;
	}

	public void setPerBirthday(Date perBirthday) {
		this.perBirthday = perBirthday;
	}
	public RbacRole getDefaultRbacRole() {
		return defaultRbacRole;
	}

	public void setDefaultRbacRole(RbacRole defaultRbacRole) {
		this.defaultRbacRole = defaultRbacRole;
	}
	
	public RbacGroup getRbacGroup() {
		return rbacGroup;
	}
	public void setRbacGroup(RbacGroup rbacGroup) {
		this.rbacGroup = rbacGroup;
	}
	public Set<RbacRole> getRbacUserRole() {
		return rbacUserRole;
	}
	public void setRbacUserRole(Set<RbacRole> rbacUserRole) {
		this.rbacUserRole = rbacUserRole;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
