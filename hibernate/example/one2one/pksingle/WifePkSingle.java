package com.zht.framework.hibernate.example.one2one.pksingle;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="wifePkSingle")
public class WifePkSingle {
    
    private String id;
    private String name;  
    private HusbandPkSingle  husbandPkSingle;
    public WifePkSingle() {
 		super();
 	}
    @Id
    @GeneratedValue(generator="pkGenerator") 
    @GenericGenerator(name ="pkGenerator",
    				  strategy="foreign" ,
    				  parameters={@Parameter(name="property",value="husbandPkSingle")})
    public String getId() {  
        return id;  
    }  
    public void setId(String id) {  
        this.id = id;  
    }  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }
    @OneToOne(cascade = CascadeType.ALL,optional = false)    
    @PrimaryKeyJoinColumn  
	public HusbandPkSingle getHusbandPkSingle() {
		return husbandPkSingle;
	}
	public void setHusbandPkSingle(HusbandPkSingle husbandPkSingle) {
		this.husbandPkSingle = husbandPkSingle;
	}  
}