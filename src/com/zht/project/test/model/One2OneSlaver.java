package com.zht.project.test.model;

@javax.persistence.Entity()
@javax.persistence.Table(name = "one2OneSlaver")

public class One2OneSlaver extends org.zht.framework.zhtdao.identity.PKBaseEntity{

	private static final long serialVersionUID = 1L;
	
	public One2OneSlaver() {}
	
	@org.hibernate.validator.constraints.NotBlank	@org.hibernate.validator.constraints.Length(min=12,max=0)	@javax.persistence.Column(name = "name",unique = false,nullable = true,length = 12)
	private java.lang.String name;
	
	@javax.persistence.OneToOne(cascade=javax.persistence.CascadeType.ALL)	@javax.persistence.JoinColumn(name="marster_id")
	private com.zht.project.test.model.One2OneMarster marster;
	
	//<-------------------------------------------->
	public void setName(java.lang.String name){
		this.name=name;
	}
	public java.lang.String getName(){
		return this.name;
	}
	
	public void setMarster(com.zht.project.test.model.One2OneMarster marster){
		this.marster=marster;
	}
	public com.zht.project.test.model.One2OneMarster getMarster(){
		return this.marster;
	}
	
	

}
