package com.zht.project.test.model;

@javax.persistence.Entity()
@javax.persistence.Table(name = "demo")

public class Demo extends org.zht.framework.zhtdao.identity.PKBaseEntity{

	private static final long serialVersionUID = 1L;
	
	public Demo() {}
	
	@org.hibernate.validator.constraints.NotBlank
	private java.lang.String name;
	
	@javax.validation.constraints.Min(0) 
	private java.lang.Integer ZInteger;
	
	@javax.validation.constraints.Min(-128) 
	private java.lang.Byte zByte;
	
	@javax.validation.constraints.DecimalMin("-20.0") 
	private java.lang.Double zDouble;
	
	@javax.validation.constraints.DecimalMin("1.0") 
	private java.math.BigDecimal ZBigDecimal;
	
	@javax.persistence.Column(name = "z_boolean",nullable = true )
	private java.lang.Boolean zBoolean;
	
	@javax.validation.constraints.Future
	private java.util.Date zDate;
	
	@javax.validation.constraints.Past
	private java.util.Date zDateTime;
	
	@org.zht.framework.annos.CurrentTimeStamp
	private java.util.Date zTimeStamp;
	
	@javax.validation.constraints.NotNull 
	private java.lang.Byte[] zbytes;
	
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade=javax.persistence.CascadeType.ALL, mappedBy="Demo")
	private java.util.Set<com.zht.project.test.model.Demomany> oneTomany;
	
	//<-------------------------------------------->
	public void setName(java.lang.String name){
		this.name=name;
	}
	public java.lang.String getName(){
		return this.name;
	}
	
	public void setZInteger(java.lang.Integer ZInteger){
		this.ZInteger=ZInteger;
	}
	public java.lang.Integer getZInteger(){
		return this.ZInteger;
	}
	
	public void setZByte(java.lang.Byte zByte){
		this.zByte=zByte;
	}
	public java.lang.Byte getZByte(){
		return this.zByte;
	}
	
	public void setZDouble(java.lang.Double zDouble){
		this.zDouble=zDouble;
	}
	public java.lang.Double getZDouble(){
		return this.zDouble;
	}
	
	public void setZBigDecimal(java.math.BigDecimal ZBigDecimal){
		this.ZBigDecimal=ZBigDecimal;
	}
	public java.math.BigDecimal getZBigDecimal(){
		return this.ZBigDecimal;
	}
	
	public void setZBoolean(java.lang.Boolean zBoolean){
		this.zBoolean=zBoolean;
	}
	public java.lang.Boolean getZBoolean(){
		return this.zBoolean;
	}
	
	public void setZDate(java.util.Date zDate){
		this.zDate=zDate;
	}
	public java.util.Date getZDate(){
		return this.zDate;
	}
	
	public void setZDateTime(java.util.Date zDateTime){
		this.zDateTime=zDateTime;
	}
	public java.util.Date getZDateTime(){
		return this.zDateTime;
	}
	
	public void setZTimeStamp(java.util.Date zTimeStamp){
		this.zTimeStamp=zTimeStamp;
	}
	public java.util.Date getZTimeStamp(){
		return this.zTimeStamp;
	}
	
	public void setZbytes(java.lang.Byte[] zbytes){
		this.zbytes=zbytes;
	}
	public java.lang.Byte[] getZbytes(){
		return this.zbytes;
	}
	
	public void setOneTomany(java.util.Set<com.zht.project.test.model.Demomany> oneTomany){
		this.oneTomany=oneTomany;
	}
	public java.util.Set<com.zht.project.test.model.Demomany> getOneTomany(){
		return this.oneTomany;
	}
	
	

}