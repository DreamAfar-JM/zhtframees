package com.zht.project.test.model;

@javax.persistence.Entity()
@javax.persistence.Table(name = "many2manyMaster")

public class Many2manyMaster extends org.zht.framework.zhtdao.identity.PKBaseEntity{

	private static final long serialVersionUID = 1L;
	
	public Many2manyMaster() {}
	
	@org.hibernate.validator.constraints.NotBlank
	private java.lang.String name;
	
	@javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY)
	private java.util.Set<com.zht.project.test.model.Many2manySlaver> mmslavers;
	
	//<-------------------------------------------->
	public void setName(java.lang.String name){
		this.name=name;
	}
	public java.lang.String getName(){
		return this.name;
	}
	
	public void setMmslavers(java.util.Set<com.zht.project.test.model.Many2manySlaver> mmslavers){
		this.mmslavers=mmslavers;
	}
	public java.util.Set<com.zht.project.test.model.Many2manySlaver> getMmslavers(){
		return this.mmslavers;
	}
	
	

}