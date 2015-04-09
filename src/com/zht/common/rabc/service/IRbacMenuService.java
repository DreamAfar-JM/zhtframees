/**
 * Copyright (c) 2015 https://github.com/zhaohuatai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.zht.common.rabc.service;

import java.util.List;

import org.zht.framework.service.IBaseService;

import com.zht.common.rabc.model.RbacMenu;
import com.zht.common.rabc.view.AccordtionView;

public interface IRbacMenuService extends IBaseService<RbacMenu>{
	public StringBuffer loadMenuByModuleId(String moduleId);
	public List<AccordtionView> findMenuListByModuleId(Long moduleId);
}