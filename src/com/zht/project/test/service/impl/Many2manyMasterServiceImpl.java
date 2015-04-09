package com.zht.project.test.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.zht.project.test.service.IMany2manyMasterService;
import org.zht.framework.service.impl.BaseServiceImpl;
import com.zht.project.test.dao.IMany2manyMasterDao;
import com.zht.project.test.model.Many2manyMaster;

@Service
@Transactional(rollbackFor=Exception.class)
public class Many2manyMasterServiceImpl extends BaseServiceImpl<Many2manyMaster> implements IMany2manyMasterService{
 	@Autowired
	private IMany2manyMasterDao many2manyMasterDao;
	
 
}