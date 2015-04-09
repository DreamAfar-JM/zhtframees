package com.zht.project.test.model;

@javax.persistence.Entity()
@javax.persistence.Table(name = "one2OneMarster")

public class One2OneMarster extends org.zht.framework.zhtdao.identity.PKBaseEntity{

	private static final long serialVersionUID = 1L;
	
	public One2OneMarster() {}
	
	
	private java.lang.String name;
	
	@javax.persistence.OneToOne(mappedBy="marster")
	private com.zht.project.test.model.One2OneSlaver slaver;
	
	//<-------------------------------------------->
	public void setName(java.lang.String name){
		this.name=name;
	}
	public java.lang.String getName(){
		return this.name;
	}
	
	public void setSlaver(com.zht.project.test.model.One2OneSlaver slaver){
		this.slaver=slaver;
	}
	public com.zht.project.test.model.One2OneSlaver getSlaver(){
		return this.slaver;
	}
	
	

}
