package com.zht.framework.hibernate.example.one2one.fkdouble;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.zht.framework.core.uuid.UUIDType;

@Entity
@Table(name="wifeFkDouble")
public class WifeFkDouble {
    
    private String id;
    private String name;
    private HusbandFkDouble husbandFkDouble;
    
    
    public WifeFkDouble() {
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
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="husband_id")
	public HusbandFkDouble getHusbandFkDouble() {
		return husbandFkDouble;
	}
	public void setHusbandFkDouble(HusbandFkDouble husbandFkDouble) {
		this.husbandFkDouble = husbandFkDouble;
	}

}