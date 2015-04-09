package com.zht.project.test.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.zht.project.test.service.IDemoService;
import org.zht.framework.service.impl.BaseServiceImpl;
import com.zht.project.test.dao.IDemoDao;
import com.zht.project.test.model.Demo;

@Service
@Transactional(rollbackFor=Exception.class)
public class DemoServiceImpl extends BaseServiceImpl<Demo> implements IDemoService{
 	@Autowired
	private IDemoDao demoDao;
	
 
}