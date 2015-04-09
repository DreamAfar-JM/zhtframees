package com.zht.project.test.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.zht.project.test.service.IDemoTreeService;
import org.zht.framework.service.impl.BaseServiceImpl;
import com.zht.project.test.dao.IDemoTreeDao;
import com.zht.project.test.model.DemoTree;

@Service
@Transactional(rollbackFor=Exception.class)
public class DemoTreeServiceImpl extends BaseServiceImpl<DemoTree> implements IDemoTreeService{
 	@Autowired
	private IDemoTreeDao demoTreeDao;
	
 
}