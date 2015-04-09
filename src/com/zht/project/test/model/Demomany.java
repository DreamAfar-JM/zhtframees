package com.zht.project.test.model;

@javax.persistence.Entity()
@javax.persistence.Table(name = "demomany")

public class Demomany extends org.zht.framework.zhtdao.identity.PKBaseEntity{

	private static final long serialVersionUID = 1L;
	
	public Demomany() {}
	
	@org.hibernate.validator.constraints.NotBlank
	private java.lang.String name;
	
	@javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY)
	private com.zht.project.test.model.Demo Demo;
	
	//<-------------------------------------------->
	public void setName(java.lang.String name){
		this.name=name;
	}
	public java.lang.String getName(){
		return this.name;
	}
	
	public void setDemo(com.zht.project.test.model.Demo Demo){
		this.Demo=Demo;
	}
	public com.zht.project.test.model.Demo getDemo(){
		return this.Demo;
	}
	
	

}