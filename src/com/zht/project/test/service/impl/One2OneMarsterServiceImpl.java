package com.zht.project.test.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.zht.project.test.service.IOne2OneMarsterService;
import org.zht.framework.service.impl.BaseServiceImpl;
import com.zht.project.test.dao.IOne2OneMarsterDao;
import com.zht.project.test.model.One2OneMarster;

@Service
@Transactional(rollbackFor=Exception.class)
public class One2OneMarsterServiceImpl extends BaseServiceImpl<One2OneMarster> implements IOne2OneMarsterService{
 	@Autowired
	private IOne2OneMarsterDao one2OneMarsterDao;
	
 
}