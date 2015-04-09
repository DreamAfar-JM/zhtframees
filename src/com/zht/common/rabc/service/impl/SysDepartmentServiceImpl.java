/**
 * Copyright (c) 2015 https://github.com/zhaohuatai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.zht.common.rabc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.zht.framework.data.DataSet;
import org.zht.framework.data.POType;
import org.zht.framework.data.ParamObject;
import org.zht.framework.exception.ServiceLogicalException;
import org.zht.framework.service.impl.BaseServiceImpl;
import com.zht.common.rabc.dao.ISysDepartmentDao;
import com.zht.common.rabc.model.SysDepartment;
import com.zht.common.rabc.service.ISysDepartmentService;
import com.zht.common.rabc.util.SysDepartmentUtil;
/**
 * 
* @ClassName :SysDepartmentServiceImpl     
* @Description :   
* @createTime :2015年4月3日  下午4:27:52   
* @author ：zhaohuatai   
* @version :1.0
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Service
@Transactional(rollbackFor=Exception.class)
public class SysDepartmentServiceImpl extends BaseServiceImpl<SysDepartment> implements ISysDepartmentService{
	@Autowired
	private ISysDepartmentDao  rbacDepartmentDao;
	

	@Override
	public DataSet loadSysDepartmentTreeGrid() {
	  String hql=" select "
						 + "g.id as id ,"
				         + "g.parentSysDepartment.id as _parentId ,"
				         + "g.name as name ,"
				         + "g.enabled as enabled,"
				         + "g.createTime as createTime,"
				         + "g.creater as creater "
				         + "@from SysDepartment g ";
		DataSet dataSet=baseDaoImpl.loadDataSet(hql,new ParamObject(POType.H_NO_NC));
		return dataSet;
	}

	@Override
	public List<Map> loadSysDepartmentCombotree() {
		List<Long> rootIdList=(List<Long>) baseDaoImpl.findJustList("select id from SysDepartment g where g.parentSysDepartment.id is null ", new ParamObject(POType.H_NO_NC));
		if(rootIdList==null||rootIdList.size()==0){
			throw new ServiceLogicalException("未发现数据根节点，请检查数据 ");
		}
		if(rootIdList.size()>1){
			throw new ServiceLogicalException("发现多个根节点数据，请检查数据 ");
		}
		String hql=" select "
						 + "g.id as id ,"
				         + "g.parentSysDepartment.id as _parentId ,"
				         + "g.name as text "
				         + "@from SysDepartment g ";
		DataSet dataSet=baseDaoImpl.loadDataSet(hql,new ParamObject(POType.H_NO_NC));
		Map root=dataSet.getRows().get(0);
		SysDepartmentUtil.traverse(root,dataSet.getRows());
		List<Map> mapList=new ArrayList<Map>();
		mapList.add(root);
		return mapList;
	}
	

	@Override
	public void deleteSysDepartment(Long id) {}

	@Override
	public List<Long> findDepartmentIdsByUserId(Long userId) {
		if(userId==null){
			return null;
		}
		String hql=" select du.sysDepartment.id from SysDepartmentUser  du where du.rbacUser.id=:userId ";
		List<Long> groupIdList=(List<Long>) baseDaoImpl.findJustList(hql, new ParamObject(POType.H_NO_NC).addAllowNull("userId", userId));
		return groupIdList;
	}
	@Override
	public List<Long> findDepartmentIdsByRoleId(Long roleId) {
		if(roleId==null){
			return null;
		}
		String hql=" select dr.sysDepartment.id from SysDepartmentRole  dr where dr.rbacRole.id=:roleId ";
		List<Long> groupIdList=(List<Long>) baseDaoImpl.findJustList(hql, new ParamObject(POType.H_NO_NC).addAllowNull("roleId", roleId));
		return groupIdList;
	}
 
}