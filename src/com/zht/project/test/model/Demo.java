package com.zht.project.test.model;

@javax.persistence.Entity()
@javax.persistence.Table(name = "demo")

public class Demo extends org.zht.framework.zhtdao.identity.PKBaseEntity{

	private static final long serialVersionUID = 1L;
	
	public Demo() {}
	
	@org.hibernate.validator.constraints.NotBlank	@org.hibernate.validator.constraints.Length(min=100,max=0)	@javax.validation.constraints.NotNull 	@javax.persistence.Column(name = "name",unique = false,nullable = false,length = 100)
	private java.lang.String name;
	
	@javax.validation.constraints.Min(0) 	@javax.validation.constraints.Max(100) 	@javax.validation.constraints.NotNull 	@javax.persistence.Column(name = "z_integer",unique = true,nullable = false)
	private java.lang.Integer ZInteger;
	
	@javax.validation.constraints.Min(-128) 	@javax.validation.constraints.Max(127) 	@javax.persistence.Column(name = "z_byte",unique = false,nullable = true)
	private java.lang.Byte zByte;
	
	@javax.validation.constraints.DecimalMin("-20.0") 	@javax.validation.constraints.DecimalMax("100.0") 	@javax.persistence.Column(name = "z_double",precision = 20,scale = 10,unique = false,nullable = true)
	private java.lang.Double zDouble;
	
	@javax.validation.constraints.DecimalMin("1.0") 	@javax.validation.constraints.DecimalMax("100.0") 	@javax.persistence.Column(name = "Z_bigDecimal",precision = 20,scale = 10,unique = false,nullable = true)
	private java.math.BigDecimal ZBigDecimal;
	
	@javax.persistence.Column(name = "z_boolean",nullable = true )
	private java.lang.Boolean zBoolean;
	
	@javax.validation.constraints.Future	@org.springframework.format.annotation.DateTimeFormat(pattern = "yyyy-MM-dd")	@javax.persistence.Temporal(javax.persistence.TemporalType.DATE)	@javax.persistence.Column(name = "z_date")
	private java.util.Date zDate;
	
	@javax.validation.constraints.Past	@org.springframework.format.annotation.DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")	@javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)	@javax.persistence.Column(name = "z_dateTime")
	private java.util.Date zDateTime;
	
	@org.zht.framework.annos.CurrentTimeStamp		@javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)	@javax.persistence.Column(name = "z_timeStamp")
	private java.util.Date zTimeStamp;
	
	@javax.validation.constraints.NotNull 	@javax.persistence.Column(name = "z_bytes",nullable = false )
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
