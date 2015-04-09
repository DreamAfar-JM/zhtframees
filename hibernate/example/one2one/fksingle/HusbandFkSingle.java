package com.zht.framework.hibernate.example.one2one.fksingle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.zht.framework.core.uuid.UUIDType;

@Entity
@Table(name="husbandFkSingle")
public class HusbandFkSingle {
    
    private String id;
    private String name;
    public HusbandFkSingle() {
 		super();
 	}
	@Id
	@GeneratedValue(generator = "base58UuidGenerator")
	@GenericGenerator(name = "base58UuidGenerator", 
		strategy = UUIDType.Base58UuidGenerator)
	@Column(name ="id",nullable=false,length=32)
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Column(name="name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
  
 
    
}