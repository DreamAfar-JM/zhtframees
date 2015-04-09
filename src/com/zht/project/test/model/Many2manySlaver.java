package com.zht.project.test.model;

@javax.persistence.Entity()
@javax.persistence.Table(name = "many2manySlaver")

public class Many2manySlaver extends org.zht.framework.zhtdao.identity.PKBaseEntity{

	private static final long serialVersionUID = 1L;
	
	public Many2manySlaver() {}
	
	@org.hibernate.validator.constraints.NotBlank	@org.hibernate.validator.constraints.Length(min=23,max=0)	@javax.persistence.Column(name = "name",unique = false,nullable = true,length = 23)
	private java.lang.String name;
	
	@javax.persistence.ManyToMany(cascade=javax.persistence.CascadeType.ALL,mappedBy="mmslavers")
	private java.util.Set<com.zht.project.test.model.Many2manyMaster> mmmarster;
	
	//<-------------------------------------------->
	public void setName(java.lang.String name){
		this.name=name;
	}
	public java.lang.String getName(){
		return this.name;
	}
	
	public void setMmmarster(java.util.Set<com.zht.project.test.model.Many2manyMaster> mmmarster){
		this.mmmarster=mmmarster;
	}
	public java.util.Set<com.zht.project.test.model.Many2manyMaster> getMmmarster(){
		return this.mmmarster;
	}
	
	

}
