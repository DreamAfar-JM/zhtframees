/**
 * Copyright (c) 2015 https://github.com/zhaohuatai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.zht.common.rabc.easyui.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 
* @ClassName :ResourcePermissionView     
* @Description :   
* @createTime :2015年4月3日  下午4:16:54   
* @author ：zhaohuatai   
* @version :1.0
 */
public class ResourcePermissionView implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 ** M:菜单，menu
	 *  P：内部链接或按钮：process
	 *  R:资源：Resource（不会出现在Permission表中）
	 */
	private String type;
	
	private String text;
	private String code;
	private String description;
	private String url;
	private String enabled;
	private String icon;
	private Integer disIndex;
//	private Integer levelIndex;
	private Boolean selected;//	
	private List<ResourcePermissionView> children;
	
	public void add(ResourcePermissionView node){
		if(children==null) children=new ArrayList<ResourcePermissionView>();
		children.add(node);
	}
	
	public void remove(ResourcePermissionView node){
		if(children!=null){
			children.remove(node);
			if(children.size()==0){
				children=null;
			}
		}
	}
	
	public void remove(){
		if(children!=null){
			children.remove(children.size()-1);
			if(children.size()==0){
				children=null;
			}
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public List<ResourcePermissionView> getChildren() {
		return children;
	}

	public void setChildren(List<ResourcePermissionView> children) {
		this.children = children;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getDisIndex() {
		return disIndex;
	}

	public void setDisIndex(Integer disIndex) {
		this.disIndex = disIndex;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "ResourcePermissionView [id=" + id + ", type=" + type
				+ ", text=" + text + ", code=" + code + ", description="
				+ description + ", url=" + url + ", enabled=" + enabled
				+ ", icon=" + icon + ", disIndex=" + disIndex + ", selected="
				+ selected + ", children=" + children + "]";
	}

//	public Integer getLevelIndex() {
//		return levelIndex;
//	}
//
//	public void setLevelIndex(Integer levelIndex) {
//		this.levelIndex = levelIndex;
//	}

	
	
}
