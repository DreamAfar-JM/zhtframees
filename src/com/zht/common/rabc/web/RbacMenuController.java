/**
 * Copyright (c) 2015 https://github.com/zhaohuatai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.zht.common.rabc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zht.framework.web.controller.BaseController;
import org.zht.framework.web.utils.FastjsonUtil;

import com.zht.common.rabc.service.IRbacMenuService;
import com.zht.common.rabc.view.AccordtionView;
/**
 * 
* @ClassName :RbacMenuController     
* @Description :   
* @createTime :2015年4月3日  下午4:17:17   
* @author ：zhaohuatai   
* @version :1.0
 */
@Controller
@RequestMapping("/rbac/menu")
public class RbacMenuController extends BaseController{
	@Autowired
    private IRbacMenuService rbacMenuService;
    @RequestMapping(value="/loadMenus")
    @ResponseBody 
    public Object loadMenus(Long moduleId,Boolean useModule,Model model){
    	List<AccordtionView> rbacMenuList=rbacMenuService.findMenuListByModuleId(moduleId);
        return FastjsonUtil.convert(rbacMenuList);
    }
}
