/**
 * Copyright (c) 2015 https://github.com/zhaohuatai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.zht.framework.zhtdao.identity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
		子类在类头上加 @SequenceGenerator(name="seq", sequenceName="你的sequence名字")
 */
@MappedSuperclass
public abstract class PKOracleIdentityEntity extends AbstractEntity<Long> {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	protected Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

//	public BaseEntity(ID id) {
//		super();
//		this.id = id;
//	}

    
    
}
