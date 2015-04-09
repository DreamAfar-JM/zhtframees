package com.zht.framework.hibernate.example.one2one.pkdouble;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="wifePkDouble")
public class WifePkDouble {
 
    private String id;  
    private String name;  
    private HusbandPkDouble husbandPkDouble;  
    public WifePkDouble() {
  		super();
  	}
   
    @Id
    @GeneratedValue(generator="pkGenerator") 
    @GenericGenerator(name ="pkGenerator",
    				  strategy="foreign" ,
    				  parameters={@Parameter(name="property",value="husbandPkDouble")}) 
    @Column(name = "id",nullable=false,length=32) 
    public String getId() {  
        return id;  
    } 
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,optional = false )
    @PrimaryKeyJoinColumn 
    public HusbandPkDouble getHusbandPkDouble() {
		return husbandPkDouble;
	}

	public void setHusbandPkDouble(HusbandPkDouble husbandPkDouble) {
		this.husbandPkDouble = husbandPkDouble;
	}

	public String getName() {  
        return name;  
    }  
    public void setId(String id) {  
        this.id = id;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
}