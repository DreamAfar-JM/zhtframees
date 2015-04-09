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
* @ClassName :AccordionMenuView     
* @Description :   
* @createTime :2015年4月3日  下午4:16:47   
* @author ：zhaohuatai   
* @version :1.0
 */
public class AccordionMenuView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String display;
	private String iconCls;//
    private String description;
    private Long disIndex;
	private String tabTitle;//显示的navitab 的 title
	private String url;
	private List<AccordionMenuView> chldList=new ArrayList<AccordionMenuView>();
	
	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getDisIndex() {
		return disIndex;
	}

	public void setDisIndex(Long disIndex) {
		this.disIndex = disIndex;
	}

	public String getTabTitle() {
		return tabTitle;
	}

	public void setTabTitle(String tabTitle) {
		this.tabTitle = tabTitle;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<AccordionMenuView> getChldList() {
		return chldList;
	}

	public void setChldList(List<AccordionMenuView> chldList) {
		this.chldList = chldList;
	}

	

}
