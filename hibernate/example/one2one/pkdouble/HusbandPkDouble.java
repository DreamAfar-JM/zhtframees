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

import org.hibernate.annotations.GenericGenerator;

import com.zht.framework.core.uuid.UUIDType;

@Entity()
@Table(name="husbandPkDouble")
public class HusbandPkDouble {
	private String id;  
    private String name;  
      
    private WifePkDouble wifePkDouble;  
    public HusbandPkDouble() {
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
    @Column(name="name")
    public String getName() {  
        return name;  
    }  
    @OneToOne(mappedBy="husbandPkDouble",fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @PrimaryKeyJoinColumn
    public WifePkDouble getWifePkDouble() {  
        return wifePkDouble;  
    }  
    public void setId(String id) {  
        this.id = id;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public void setWifePkDouble(WifePkDouble wifePkDouble) {  
        this.wifePkDouble = wifePkDouble;  
    }  
  
 
    
}