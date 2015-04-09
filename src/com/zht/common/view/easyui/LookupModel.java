package com.zht.common.view.easyui;

import java.io.Serializable;

public class LookupModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hiddenName;
	private String hiddenValue;
	private String displayName;
	private String displayValue;
	public LookupModel() {
	}
	
	public LookupModel(String hiddenName, String hiddenValue,
			String displayName, String displayValue) {
		super();
		this.hiddenName = hiddenName;
		this.hiddenValue = hiddenValue;
		this.displayName = displayName;
		this.displayValue = displayValue;
	}

	public String getHiddenName() {
		return hiddenName;
	}
	public void setHiddenName(String hiddenName) {
		this.hiddenName = hiddenName;
	}
	public String getHiddenValue() {
		return hiddenValue;
	}
	public void setHiddenValue(String hiddenValue) {
		this.hiddenValue = hiddenValue;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getDisplayValue() {
		return displayValue;
	}
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
	
	
	
}
