/**
 * Copyright (c) 2015 https://github.com/zhaohuatai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.zht.common.rabc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zht.framework.data.DataSet;
import org.zht.framework.data.POType;
import org.zht.framework.data.ParamObject;
import org.zht.framework.service.impl.BaseServiceImpl;
import com.zht.common.rabc.dao.IRbacMenuDao;
import com.zht.common.rabc.dao.IRbacModuleDao;
import com.zht.common.rabc.model.RbacMenu;
import com.zht.common.rabc.service.IRbacMenuService;
import com.zht.common.rabc.view.AccordtionView;
import com.zht.common.rabc.view.LinkbuttonView;

@Service
@Transactional(rollbackFor=Exception.class)
public class RbacMenuServiceImpl extends BaseServiceImpl<RbacMenu> implements IRbacMenuService{

	@Autowired
	private IRbacModuleDao  rbacMenuModuleDao;
	@Autowired
	private IRbacMenuDao  rbacMenuDao;
	@Override
	public StringBuffer loadMenuByModuleId(String moduleId) {
		
		return null;
	}
	
	private void fillContent(AccordtionView view,List<Map<String,Object>> data){
		List<LinkbuttonView> linkbuttonViewList=new ArrayList<LinkbuttonView>(); 
		for (Map<String,Object> map : data) {
			Long pid = (Long) map.get("pid");
			if(view.getId().equals(pid)){
				LinkbuttonView btnView=new LinkbuttonView();
				btnView.setDisplay((String) map.get("display"));
				btnView.setIconCls((String) map.get("iconCls"));
				btnView.setUrl((String) map.get("url"));
				btnView.setId((Long) map.get("id"));
				linkbuttonViewList.add(btnView);
			}
		}
		view.setLinkbuttonViewList(linkbuttonViewList);
	}
	
	@Override
	public List<AccordtionView> findMenuListByModuleId(Long moduleId) {
//		if(moduleId==null){
//			return null;
//		}
		ParamObject paramObject=new ParamObject(POType.H_NO_NC);
		String hql=" select "
				+ "mm.id as id, "
				+ "mm.parentRbacMenu.id as pid, "
				+ "mm.display as display, "
				+ "mm.iconCls as iconCls, "
				+ "mm.type as type, "
				+ "p.url as url "
				+ "@from RbacMenu mm left outer join  mm.rbacPermission p ";
				if(moduleId!=null){
					hql +="where mm.rbacModule.id=:rbacModuleId ";
					paramObject.addParam("rbacModuleId", moduleId);
				}
				
		DataSet dataSet=rbacMenuDao.loadDataSet(hql,paramObject);
		
		
		if (dataSet != null && dataSet.getRows() != null) {
			List<AccordtionView> groupList = new ArrayList<AccordtionView>();
			List<Map<String,Object>>   data = dataSet.getRows();
			for (Map<String,Object> map : data) {
				String type = (String) map.get("type");
				if (RbacMenu.TYPE_G.equals(type)) {
					AccordtionView view = new AccordtionView();
					view.setTitle((String) map.get("display"));
					view.setIconCls((String) map.get("iconCls"));
					view.setId((Long) map.get("id"));
					fillContent(view, data);
					groupList.add(view);
				}
			}
			return groupList;
		}
		return null;
	}
 
}