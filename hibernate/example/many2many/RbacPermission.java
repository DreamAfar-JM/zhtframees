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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;

import com.zht.framework.hibernate.example.one2many.RbacResource;

/**
 *RBAC 许可资源 POJO实体类 
 * @author zhaoht
 * @version v 1.0
 * @modify 2012-12-07-17
 * 
 */
//@Entity()
@Table(name = "rbac_permission", uniqueConstraints = { @UniqueConstraint(columnNames = "code") })
@org.hibernate.annotations.Table(appliesTo = "rbac_permission",comment="许可")
public class RbacPermission implements Serializable {
	private static final long serialVersionUID = 1L;
		

	/**
	 * 主键--ID
	 */	
	@Id()
    @Column(name = "id")
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	/**
	 * 许可代码
	 */
	@Column(name = "code", length = 100, nullable = false)
	private String code;	

	/**
	 * 许可名称
	 */
	@Column(name = "name", length = 100, nullable = false)
	private String name;

	/**
	 * 链接地址
	 */
	@Column(name = "url", length = 255, nullable = false)
	private String url;

	/**
	 *描述、备注
	 */	
	@Column(name = "description", length = 255, nullable = true)
	private String description;	

	/**
	 * 访问许可  范围
	 */
	@Column(name="anonymous", nullable=false, length=8)
	private String anonymous;

	/**
	 * 是否禁用
	 */
	@Column(name="enabled", nullable=false)
    private Boolean enabled;

	/**
	 * 许可类型
	 */
	@Column(name="type", nullable=false, length=6)
	private String type;

	/**
	 * 外键--所属资源组
	 */
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="resourceId")
	private RbacResource rbacResource;

	/**
	 * 多对多---角色
	 */
 //被维护端---中间表由rbacRole维护**
	@ManyToMany(cascade=CascadeType.REFRESH,mappedBy="rbacRolePermission") 
	private Set<RbacRole> rbacRoles = new HashSet<RbacRole>(0);
		

	public RbacPermission() {
        super();
	}
	
	public String getAnonymous() {
		return anonymous;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setAnonymous(String anonymous) {
		this.anonymous = anonymous;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public RbacResource getRbacResource() {
		return rbacResource;
	}
	public void setRbacResource(RbacResource rbacResource) {
		this.rbacResource = rbacResource;
	}
	
	/**
	 * @return the rbacRoles
	 */
	public Set<RbacRole> getRbacRoles() {
		return rbacRoles;
	}

	/**
	 * @param rbacRoles the rbacRoles to set
	 */
	public void setRbacRoles(Set<RbacRole> rbacRoles) {
		this.rbacRoles = rbacRoles;
	}

	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return id+":"+name;
	}
}
