package com.zht.project.test.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.zht.project.test.service.IDemomanyService;
import org.zht.framework.service.impl.BaseServiceImpl;
import com.zht.project.test.dao.IDemomanyDao;
import com.zht.project.test.model.Demomany;

@Service
@Transactional(rollbackFor=Exception.class)
public class DemomanyServiceImpl extends BaseServiceImpl<Demomany> implements IDemomanyService{
 	@Autowired
	private IDemomanyDao demomanyDao;
	
 
}