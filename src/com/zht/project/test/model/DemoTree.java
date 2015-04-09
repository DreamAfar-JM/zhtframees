package com.zht.project.test.model;
@org.zht.framework.annos.TreeConstruct()
@javax.persistence.Entity()
@javax.persistence.Table(name = "demoTree")
public class DemoTree extends org.zht.framework.zhtdao.identity.PKBaseEntity{

	private static final long serialVersionUID = 1L;
	
	public DemoTree() {}
	
	@org.hibernate.validator.constraints.NotBlank
	private java.lang.String name;
	
	@javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY)
	private com.zht.project.test.model.DemoTree PDemoTree;
	
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade=javax.persistence.CascadeType.ALL, mappedBy="PDemoTree")
	private java.util.Set<com.zht.project.test.model.DemoTree> childDemoTrees;
	
	//<-------------------------------------------->
	public void setName(java.lang.String name){
		this.name=name;
	}
	public java.lang.String getName(){
		return this.name;
	}
	
	public void setPDemoTree(com.zht.project.test.model.DemoTree PDemoTree){
		this.PDemoTree=PDemoTree;
	}
	public com.zht.project.test.model.DemoTree getPDemoTree(){
		return this.PDemoTree;
	}
	
	public void setChildDemoTrees(java.util.Set<com.zht.project.test.model.DemoTree> childDemoTrees){
		this.childDemoTrees=childDemoTrees;
	}
	public java.util.Set<com.zht.project.test.model.DemoTree> getChildDemoTrees(){
		return this.childDemoTrees;
	}
	
	

}