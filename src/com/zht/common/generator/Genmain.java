/**
 * Copyright (c) 2015 https://github.com/zhaohuatai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.zht.common.generator;

import java.io.IOException;

import com.zht.common.generator.excute.DaoGenerator;
import com.zht.common.generator.excute.ServiceGenerator;
import com.zht.common.generator.excute.impl.DaoGeneratorImpl;
import com.zht.common.generator.excute.impl.ServiceGeneratorImpl;

public class Genmain {
	public static void main(String[] args) throws IOException {
		String path=Genmain.class.getResource("/").getPath();
		System.out.println(path);
		DaoGenerator daoG=new DaoGeneratorImpl();
		ServiceGenerator serG=new ServiceGeneratorImpl();
//		ActionGenerator actionG=new ActionGeneratorImpl();
		daoG.genAll("com.zht.common.rabc.model.RbacRolePermission");
		serG.genAll("com.zht.common.rabc.model.RbacRolePermission");
	}
	
}
