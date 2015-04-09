///**
// * Copyright (c) 2015 https://github.com/zhaohuatai
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// */
//package com.zht.common.generator.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import org.zht.framework.zhtdao.identity.PKBaseEntity;
//
////@Entity()
////@Table(name = "zht_entity_property")
//public class GenEntityProperty extends PKBaseEntity{
//	private static final long serialVersionUID = 1L;
////	public Boolean insertable = true;
////	public Boolean updatable = true;
////	public String  defaultValue;
//	public GenEntityProperty() {}
//
//	@ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="genEntity_id")
//	private GenEntity genEntity;
//	
//	@Column(name = "propertyName", length = 40)
//	private String propertyName;
//	
//	@Column(name = "propertyType", length = 200)
//	public String propertyType;
//	
//	@Column(name = "columnName", length = 30)
//	private String columnName;
//	
//	//property,onetomany ,manytoone,manytomany,onetoone;
//	@Column(name = "relationType", length = 30)
//	public String relationType;//关系类型
//	
//	@Column(name = "display_z", length = 30)
//	private String display;//页面显示
//	
//	
////----------------display----S---------------------------------
//	
//	@Column(name = "isList")
//	private Boolean isList;//是否列表显示
//	
//	@Column(name = "columnWidth")
//	private Integer columnWidth;
//	
//	//if(){reurn ...}  (condition)-(value), 例如  if(true==value)return "启用"-->(true==value)-(启用)
//	//{true==value-是}{false==value-否}
//	@Column(name = "simpleFormat", length = 1000)
//	public String simpleFormat;//
//	
//	@Column(name = "isSorter")
//	private Boolean isSorter;//是否排序
//	
////-----------display----E------------------------------	
////-----------query------S------------------------------	
//	
//	@Column(name = "isQueryCondtion")
//	private Boolean isQueryCondtion;//是否查询条件
////	 data:[{valuez:'=',displayz:'='},
////	       {valuez:'<>',displayz:'<>'},
////	       {valuez:'>',displayz:'>'},
////	       {valuez:'>=',displayz:'>='},
////	       {valuez:'<',displayz:'<'},
////	       {valuez:'<=',displayz:'<='},
////	       {valuez:'LIKE',displayz:'LIKE'},
////	       {valuez:'NOTLIKE',displayz:'NOT LIKE'},
////	       {valuez:'IN',displayz:'IN'},
////	       {valuez:'NOTIN',displayz:'NOT IN'},
////	       ],
//	@Column(name = "queryType", length = 30)
//	private String queryType;//查询类型 = <>等
//	
////-----------display----E------------------------------	
//	@Column(name = "unique_z")
//	public Boolean unique ;
//	
//	@Column(name = "nullable_z")
//	public Boolean nullable;
//	
////	 data:[{valuez:'text',displayz:'text'},
////    {valuez:'textarea',displayz:'textarea'},
////    {valuez:'password',displayz:'password'},
////    {valuez:'combox',displayz:'combox'},
////    {valuez:'checkbox',displayz:'checkbox'},
////    {valuez:'combotree',displayz:'combotree'},
////    {valuez:'file',displayz:'file'},
////    {valuez:'lookup',displayz:'lookup'},
////    {valuez:'date',displayz:'date'},
////    {valuez:'datetime',displayz:'datetime'},
//
//@Column(name = "editType", length = 30)
//private String editType; //编辑类型
////data:[{valuez:'text',displayz:'text'},
////      {valuez:'email',displayz:'email'},
////      {valuez:'url',displayz:'url'},
////      {valuez:'phone',displayz:'phone'},
////      {valuez:'mobile',displayz:'mobile'},
////      {valuez:'ZipCode',displayz:'ZipCode'},
////      {valuez:'ip',displayz:'ip'},
////      {valuez:'idcard',displayz:'idcard'},
////      {valuez:'intOrFloat',displayz:'intOrFloat'},
////      {valuez:'account',displayz:'account'},
////      ],
//@Column(name = "validateType", length = 30)
//private String validateType;//
//
//
///**
// *  <label><input name="Fruit" type="checkbox" value="" />苹果 </label> 
//	<label><input name="Fruit" type="checkbox" value="" />桃子 </label> 
//	<label><input name="Fruit" type="checkbox" value="" />香蕉 </label> 
//	<label><input name="Fruit" type="checkbox" value="" />梨 </label>
// *	
// * checkbox:{true-是}{false-否},
// * 
// * select:{true-是}{false-否},
// * combox:url:{url,valueField,textField}
// * 
// * combotree:url:{url:,valueField:sdasds,textField:dsfds}
// * 
// * lookup url: 
// * 	
// */
//	@Column(name = "editContent", length = 100)
//	private String	editContent;//
////---------------------------------------------------------	
//	@Column(name = "length_z")
//	public Integer length;
//	
//	@Column(name = "precision_z")
//	public Integer precision;
//	
//	@Column(name = "scale_z")
//	public Integer scale;
//	
//	
//	@Column(name = "isTreeProperty")
//	public Boolean isTreeProperty;//是否树形结构  父属性
//	
//
//	@Column(name = "lookUpType", length = 30)
//	public String lookUpType;//下拉框  查找带回  手填
//	
////	@Column(name = "M2O_O2O_DisplayField", length = 60)
////	public String mTOOTOField;//多对一，一对一时，列表显示
//	
//	@Column(name = "isLookUpDisplay")
//	private Boolean isLookUpDisplay;//
//	
//	
//	//"文本", "密码",       "长文本",   "下拉框",   "多选框",    "单选框", "文件" , "查找带回","日期",  "日期时间"
//	
//	//文本/长文本：   nullable:必填,:unique:唯一值，minlength:最小长度，maxlength:最大长度，
//	//textType:文本类型("text:普通文本","email:邮箱","phone:电话","password:密码","digits:整数","number:浮点数","creditcard:信用卡","alphanumeric: 字母、数字、下划线","lettersonly:字母","url:网址")
//	
//	//密码:        必填，最小长度，最大长度，
//	//日期/"日期时间"：必填，最小日期，最大日期
//	//查找带回:      必填，url 返回List<LookupModel>
//	//下拉框:url(返回List<EditModel>)
//	@Deprecated
//	@Column(name = "validateContent", length = 30)
//	private String validateContent;//
//	@Deprecated
//	@Column(name = "editFinalContentStr", length = 300)
//	private String editFinalContentStr; //
//	
//	//{field:'name',title:'实体类名',width:330,sortable:true},
//	@Column(name = "generatedListDisplayOfPropertyStr", length = 1000)
//	private String generatedListDisplayOfPropertyStr;
//	
//	@Column(name = "generatedQueryOfPropertyStr", length = 1000)
//	private String generatedQueryOfPropertyStr;
//	
//	@Column(name = "generatedEditOfPropertyStr", length = 1000)
//	private String generatedEditOfPropertyStr;
//	
//	@Column(name = "generatedHibernateModelOfPropertyStr", length = 1000)
//	private String generatedHibernateModelOfPropertyStr;
//	
//	@Column(name = "max_length")
//	private Integer maxLength;
//	
//	@Column(name = "min_length")
//	private Integer minLength;
//	
//	@Column(name = "min_value")
//	private Double minValue;
//	
//	@Column(name = "max_value")
//	private Double maxValue;
//	
//
//	@Column(name = "isDateFutrue")
//	private Boolean isDateFutrue;//
//	
//	
//	@Column(name = "isDatePost")
//	private Boolean isDatePost;//
//	
//	@Column(name = "manyToOneDisplayField")
//	private String manyToOneDisplayField;
//	
//	@Column(name = "oneTomanyMappedBy")
//	private String oneTomanyMappedBy;
//	
//	
//	@Column(name = "isManytoManyMasterControl")
//	private Boolean isManytoManyMasterControl;//
//	
//	@Column(name = "manytomanyJoinTable")
//	private String manytomanyJoinTable;
//	
//	@Column(name = "manytomanyJoinColumnSelf")
//	private String manytomanyJoinColumnSelf;
//	
//	@Column(name = "manytomanyJoinColumnOpposite")
//	private String manytomanyJoinColumnOpposite;
//	
//	@Column(name = "manytomanyMappedBy")
//	private String manytomanyMappedBy;
//	
//	
//	
//	public Boolean getUnique() {
//		return unique;
//	}
//	public void setUnique(Boolean unique) {
//		this.unique = unique;
//	}
//	public Boolean getNullable() {
//		return nullable;
//	}
//	public void setNullable(Boolean nullable) {
//		this.nullable = nullable;
//	}
//	public Integer getLength() {
//		return length;
//	}
//	public void setLength(Integer length) {
//		this.length = length;
//	}
//	public Integer getPrecision() {
//		return precision;
//	}
//	public void setPrecision(Integer precision) {
//		this.precision = precision;
//	}
//	public Integer getScale() {
//		return scale;
//	}
//	public void setScale(Integer scale) {
//		this.scale = scale;
//	}
//	public String getPropertyType() {
//		return propertyType;
//	}
//	public void setPropertyType(String propertyType) {
//		this.propertyType = propertyType;
//	}
//	public String getRelationType() {
//		return relationType;
//	}
//	public void setRelationType(String relationType) {
//		this.relationType = relationType;
//	}
//	public String getLookUpType() {
//		return lookUpType;
//	}
//	public void setLookUpType(String lookUpType) {
//		this.lookUpType = lookUpType;
//	}
//	public String getDisplay() {
//		return display;
//	}
//	public void setDisplay(String display) {
//		this.display = display;
//	}
//	public Boolean getIsList() {
//		return isList;
//	}
//	public void setIsList(Boolean isList) {
//		this.isList = isList;
//	}
//	public Boolean getIsSorter() {
//		return isSorter;
//	}
//	public void setIsSorter(Boolean isSorter) {
//		this.isSorter = isSorter;
//	}
//	public Boolean getIsQueryCondtion() {
//		return isQueryCondtion;
//	}
//	public void setIsQueryCondtion(Boolean isQueryCondtion) {
//		this.isQueryCondtion = isQueryCondtion;
//	}
//	public String getQueryType() {
//		return queryType;
//	}
//	public void setQueryType(String queryType) {
//		this.queryType = queryType;
//	}
//	public String getEditType() {
//		return editType;
//	}
//	public void setEditType(String editType) {
//		this.editType = editType;
//	}
//	public String getValidateContent() {
//		return validateContent;
//	}
//	public void setValidateContent(String validateContent) {
//		this.validateContent = validateContent;
//	}
//	public String getColumnName() {
//		return columnName;
//	}
//	public void setColumnName(String columnName) {
//		this.columnName = columnName;
//	}
//	public String getPropertyName() {
//		return propertyName;
//	}
//	public void setPropertyName(String propertyName) {
//		this.propertyName = propertyName;
//	}
//	public GenEntity getGenEntity() {
//		return genEntity;
//	}
//	public void setGenEntity(GenEntity genEntity) {
//		this.genEntity = genEntity;
//	}
//	public Boolean getIsLookUpDisplay() {
//		return isLookUpDisplay;
//	}
//	public void setIsLookUpDisplay(Boolean isLookUpDisplay) {
//		this.isLookUpDisplay = isLookUpDisplay;
//	}
//	public Boolean getIsTreeProperty() {
//		return isTreeProperty;
//	}
//	public void setIsTreeProperty(Boolean isTreeProperty) {
//		this.isTreeProperty = isTreeProperty;
//	}
////	public String getmTOOTOField() {
////		return mTOOTOField;
////	}
////	public void setmTOOTOField(String mTOOTOField) {
////		this.mTOOTOField = mTOOTOField;
////	}
//	public String getSimpleFormat() {
//		return simpleFormat;
//	}
//	public void setSimpleFormat(String simpleFormat) {
//		this.simpleFormat = simpleFormat;
//	}
//	public Integer getColumnWidth() {
//		return columnWidth;
//	}
//	public void setColumnWidth(Integer columnWidth) {
//		this.columnWidth = columnWidth;
//	}
//	public String getEditContent() {
//		return editContent;
//	}
//	public void setEditContent(String editContent) {
//		this.editContent = editContent;
//	}
//	public String getEditFinalContentStr() {
//		return editFinalContentStr;
//	}
//	public void setEditFinalContentStr(String editFinalContentStr) {
//		this.editFinalContentStr = editFinalContentStr;
//	}
//	public String getValidateType() {
//		return validateType;
//	}
//	public void setValidateType(String validateType) {
//		this.validateType = validateType;
//	}
//	public String getGeneratedListDisplayOfPropertyStr() {
//		return generatedListDisplayOfPropertyStr;
//	}
//	public void setGeneratedListDisplayOfPropertyStr(
//			String generatedListDisplayOfPropertyStr) {
//		this.generatedListDisplayOfPropertyStr = generatedListDisplayOfPropertyStr;
//	}
//	public String getGeneratedQueryOfPropertyStr() {
//		return generatedQueryOfPropertyStr;
//	}
//	public void setGeneratedQueryOfPropertyStr(String generatedQueryOfPropertyStr) {
//		this.generatedQueryOfPropertyStr = generatedQueryOfPropertyStr;
//	}
//	public String getGeneratedEditOfPropertyStr() {
//		return generatedEditOfPropertyStr;
//	}
//	public void setGeneratedEditOfPropertyStr(String generatedEditOfPropertyStr) {
//		this.generatedEditOfPropertyStr = generatedEditOfPropertyStr;
//	}
//	public String getGeneratedHibernateModelOfPropertyStr() {
//		return generatedHibernateModelOfPropertyStr;
//	}
//	public void setGeneratedHibernateModelOfPropertyStr(
//			String generatedHibernateModelOfPropertyStr) {
//		this.generatedHibernateModelOfPropertyStr = generatedHibernateModelOfPropertyStr;
//	}
//	public Integer getMaxLength() {
//		return maxLength;
//	}
//	public void setMaxLength(Integer maxLength) {
//		this.maxLength = maxLength;
//	}
//	public Integer getMinLength() {
//		return minLength;
//	}
//	public void setMinLength(Integer minLength) {
//		this.minLength = minLength;
//	}
//	public Double getMinValue() {
//		return minValue;
//	}
//	public void setMinValue(Double minValue) {
//		this.minValue = minValue;
//	}
//	public Double getMaxValue() {
//		return maxValue;
//	}
//	public void setMaxValue(Double maxValue) {
//		this.maxValue = maxValue;
//	}
//	public Boolean getIsDateFutrue() {
//		return isDateFutrue;
//	}
//	public void setIsDateFutrue(Boolean isDateFutrue) {
//		this.isDateFutrue = isDateFutrue;
//	}
//	public Boolean getIsDatePost() {
//		return isDatePost;
//	}
//	public void setIsDatePost(Boolean isDatePost) {
//		this.isDatePost = isDatePost;
//	}
//	public String getManyToOneDisplayField() {
//		return manyToOneDisplayField;
//	}
//	public void setManyToOneDisplayField(String manyToOneDisplayField) {
//		this.manyToOneDisplayField = manyToOneDisplayField;
//	}
//	public String getOneTomanyMappedBy() {
//		return oneTomanyMappedBy;
//	}
//	public void setOneTomanyMappedBy(String oneTomanyMappedBy) {
//		this.oneTomanyMappedBy = oneTomanyMappedBy;
//	}
//	public Boolean getIsManytoManyMasterControl() {
//		return isManytoManyMasterControl;
//	}
//	public void setIsManytoManyMasterControl(Boolean isManytoManyMasterControl) {
//		this.isManytoManyMasterControl = isManytoManyMasterControl;
//	}
//	public String getManytomanyJoinTable() {
//		return manytomanyJoinTable;
//	}
//	public void setManytomanyJoinTable(String manytomanyJoinTable) {
//		this.manytomanyJoinTable = manytomanyJoinTable;
//	}
//	public String getManytomanyJoinColumnSelf() {
//		return manytomanyJoinColumnSelf;
//	}
//	public void setManytomanyJoinColumnSelf(String manytomanyJoinColumnSelf) {
//		this.manytomanyJoinColumnSelf = manytomanyJoinColumnSelf;
//	}
//	public String getManytomanyJoinColumnOpposite() {
//		return manytomanyJoinColumnOpposite;
//	}
//	public void setManytomanyJoinColumnOpposite(String manytomanyJoinColumnOpposite) {
//		this.manytomanyJoinColumnOpposite = manytomanyJoinColumnOpposite;
//	}
//	public String getManytomanyMappedBy() {
//		return manytomanyMappedBy;
//	}
//	public void setManytomanyMappedBy(String manytomanyMappedBy) {
//		this.manytomanyMappedBy = manytomanyMappedBy;
//	}
//	
//}
