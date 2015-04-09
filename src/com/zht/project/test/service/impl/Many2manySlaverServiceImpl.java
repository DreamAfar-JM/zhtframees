package com.zht.project.test.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.zht.project.test.service.IMany2manySlaverService;
import org.zht.framework.service.impl.BaseServiceImpl;
import com.zht.project.test.dao.IMany2manySlaverDao;
import com.zht.project.test.model.Many2manySlaver;

@Service
@Transactional(rollbackFor=Exception.class)
public class Many2manySlaverServiceImpl extends BaseServiceImpl<Many2manySlaver> implements IMany2manySlaverService{
 	@Autowired
	private IMany2manySlaverDao many2manySlaverDao;
	
 
}