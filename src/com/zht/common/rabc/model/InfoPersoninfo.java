/**
 * Copyright (c) 2015 https://github.com/zhaohuatai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.zht.common.rabc.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 
* @ClassName :InfoPersoninfo     
* @Description :   
* @createTime :2015年4月3日  下午4:12:48   
* @author ：zhaohuatai   
* @version :1.0
 */
@Entity
@Table(name = "info_personinfo")
public class InfoPersoninfo implements Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	/**
	 * 人员ID
	 */
	private Long personId;
	/**
	 * 证件类型代码
	 */
	private String cardTypeCode;
	/**
	 * 电子邮件
	 */
	private String email;
	/**
	 * 家庭邮编
	 */
	private String famPostcalCode;
	/**
	 * 家庭电话
	 */
	private String famTelephone;
	/**
	 * 家庭地址
	 */
	private String famillyAddress;
	/**
	 * 性别码
	 */
	private String genderCode;
	/**
	 * 是否已婚
	 */
	private Integer isMarried;
	/**
	 * 
	 */
	private String mobilePhone;
	/**
	 * 手机
	 */
	private String msn;
	/**
	 * 姓名拼音
	 */
	private String nameSpell;
	/**
	 * 国籍ID
	 */
	private Long nationId;
	/**
	 * 出生市
	 */
	private String nativeCity;
	/**
	 * 出生省份
	 */
	private String nativeProvince;
	/**
	 * 出生镇
	 */
	private String nativeCounty;
	/**
	 * 民族ID
	 */
	private Long peopleId;
	/**
	 * 个人地址
	 */
	private String perAddress;
	/**
	 * 出生日期
	 */
	private Date perBirthday;
	/**
	 * 英文名
	 */
	private String perEnglishName;
	/**
	 * 证件号码
	 */
	private String perIdCard;
	/**
	 * 姓名
	 */
	private String perName;
	
	/**
	 * 编号/学号
	 */
	private String perNum;
	/**
	 * 邮政编码
	 */
	private String perPostalCode;
	/**
	 * 电话
	 */
	private String perTelephone;


	

	
	
	// Constructors

	/** default constructor */
	public InfoPersoninfo() {
	}

	
	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "personId", unique = true, nullable = false)
	public Long getId() {
		// TODO Auto-generated method stub
		return this.personId;
	}

	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.personId = id;
	}

	@Column(name = "cardTypeCode", length = 3)
	public String getCardTypeCode() {
		return this.cardTypeCode;
	}

	public void setCardTypeCode(String cardTypeCode) {
		this.cardTypeCode = cardTypeCode;
	}

	@Column(name = "EMAIL", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "famPostcalCode", length = 6)
	public String getFamPostcalCode() {
		return this.famPostcalCode;
	}

	public void setFamPostcalCode(String famPostcalCode) {
		this.famPostcalCode = famPostcalCode;
	}

	@Column(name = "famTelephone", length = 15)
	public String getFamTelephone() {
		return this.famTelephone;
	}

	public void setFamTelephone(String famTelephone) {
		this.famTelephone = famTelephone;
	}

	@Column(name = "famillyAddress", length = 50)
	public String getFamillyAddress() {
		return this.famillyAddress;
	}

	public void setFamillyAddress(String famillyAddress) {
		this.famillyAddress = famillyAddress;
	}

	@Column(name = "genderCode", length = 5,nullable = false)
	public String getGenderCode() {
		return this.genderCode;
	}

	public void setGenderCode(String genderCode) {
		this.genderCode = genderCode;
	}

	@Column(name = "isMarried")
	public Integer getIsMarried() {
		return this.isMarried;
	}

	public void setIsMarried(Integer isMarried) {
		this.isMarried = isMarried;
	}

	@Column(name = "mobilePhone", length = 15)
	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Column(name = "MSN", length = 50)
	public String getMsn() {
		return this.msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	@Column(name = "nameSpell", length = 60)
	public String getNameSpell() {
		return this.nameSpell;
	}

	public void setNameSpell(String nameSpell) {
		this.nameSpell = nameSpell;
	}

	@Column(name = "nationId")
	public Long getNationId() {
		return this.nationId;
	}

	public void setNationId(Long nationId) {
		this.nationId = nationId;
	}

	@Column(name = "nativeCity", length = 30)
	public String getNativeCity() {
		return this.nativeCity;
	}

	public void setNativeCity(String nativeCity) {
		this.nativeCity = nativeCity;
	}

	@Column(name = "nativeProvince", length = 20)
	public String getNativeProvince() {
		return this.nativeProvince;
	}

	public void setNativeProvince(String nativeProvince) {
		this.nativeProvince = nativeProvince;
	}

	@Column(name = "nativeCounty", length = 30)
	public String getNativeCounty() {
		return this.nativeCounty;
	}

	public void setNativeCounty(String nativeCounty) {
		this.nativeCounty = nativeCounty;
	}

	@Column(name = "peopleId")
	public Long getPeopleId() {
		return this.peopleId;
	}

	public void setPeopleId(Long peopleId) {
		this.peopleId = peopleId;
	}

	@Column(name = "perAddress", length = 50)
	public String getPerAddress() {
		return this.perAddress;
	}

	public void setPerAddress(String perAddress) {
		this.perAddress = perAddress;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "perBirthday", length = 10)
	public Date getPerBirthday() {
		return this.perBirthday;
	}

	public void setPerBirthday(Date perBirthday) {
		this.perBirthday = perBirthday;
	}

	@Column(name = "perEnglishName", length = 60)
	public String getPerEnglishName() {
		return this.perEnglishName;
	}

	public void setPerEnglishName(String perEnglishName) {
		this.perEnglishName = perEnglishName;
	}

	@Column(name = "perIdCard", length = 18)
	public String getPerIdCard() {
		return this.perIdCard;
	}

	public void setPerIdCard(String perIdCard) {
		this.perIdCard = perIdCard;
	}

	@Column(name = "perName", length = 50, nullable = false)
	public String getPerName() {
		return this.perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}


	@Column(name = "perNum", length = 20,nullable = false,unique = true)
	public String getPerNum() {
		return this.perNum;
	}

	public void setPerNum(String perNum) {
		this.perNum = perNum;
	}

	@Column(name = "perPostalCode", length = 6)
	public String getPerPostalCode() {
		return this.perPostalCode;
	}

	public void setPerPostalCode(String perPostalCode) {
		this.perPostalCode = perPostalCode;
	}

	@Column(name = "perTelephone", length = 20)
	public String getPerTelephone() {
		return this.perTelephone;
	}

	public void setPerTelephone(String perTelephone) {
		this.perTelephone = perTelephone;
	}

	



	

}