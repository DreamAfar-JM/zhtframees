package com.zht.project.test.model;

@javax.persistence.Entity()
@javax.persistence.Table(name = "many2manyMaster")

public class Many2manyMaster extends org.zht.framework.zhtdao.identity.PKBaseEntity{

	private static final long serialVersionUID = 1L;
	
	public Many2manyMaster() {}
	
	@org.hibernate.validator.constraints.NotBlank	@org.hibernate.validator.constraints.Length(min=122,max=0)	@javax.persistence.Column(name = "name",unique = false,nullable = true,length = 122)
	private java.lang.String name;
	
	@javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY)	@javax.persistence.JoinTable(name="m-m", joinColumns = {		@javax.persistence.JoinColumn(name="m-m-marster_id", nullable=false, updatable=false) },		inverseJoinColumns = { @javax.persistence.JoinColumn(name="m-m-slaver_id", nullable=false, updatable=false) })
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
