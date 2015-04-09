/**
 * Copyright (c) 2015 https://github.com/zhaohuatai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.zht.common.rabc.easyui.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 
* @ClassName :SysDepartmentView     
* @Description :   
* @createTime :2015年4月3日  下午4:17:04   
* @author ：zhaohuatai   
* @version :1.0
 */
public class SysDepartmentView  implements Serializable{
	private static final long serialVersionUID = 1L;

	public SysDepartmentView() {}
	private Serializable id;;
	private String name;
	private String text;//显示时替换name
	private String description; //描述
	private Boolean enabled;//可用
	private Date createTime;
	private String creater;
	private List<SysDepartmentView> children=new ArrayList<SysDepartmentView>();
	
	public void add(SysDepartmentView node){
		if(children==null) children=new ArrayList<SysDepartmentView>();
		children.add(node);
	}
	
	public void remove(SysDepartmentView node){
		if(children!=null){
			children.remove(node);
			if(children.size()==0){
				children=null;
			}
		}
	}
	
	public void removeAll(){
		if(children!=null){
			children.clear();
			if(children.size()==0){
				children=null;
			}
		}
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
	
	public List<SysDepartmentView> getChildren() {
		return children;
	}

	public void setChildren(List<SysDepartmentView> children) {
		this.children = children;
	}

	public Serializable getId() {
		return id;
	}
	public void setId(Serializable id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
