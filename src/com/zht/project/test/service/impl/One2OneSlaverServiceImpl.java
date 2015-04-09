package com.zht.project.test.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.zht.project.test.service.IOne2OneSlaverService;
import org.zht.framework.service.impl.BaseServiceImpl;
import com.zht.project.test.dao.IOne2OneSlaverDao;
import com.zht.project.test.model.One2OneSlaver;

@Service
@Transactional(rollbackFor=Exception.class)
public class One2OneSlaverServiceImpl extends BaseServiceImpl<One2OneSlaver> implements IOne2OneSlaverService{
 	@Autowired
	private IOne2OneSlaverDao one2OneSlaverDao;
	
 
}