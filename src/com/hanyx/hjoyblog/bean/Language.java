package com.hanyx.hjoyblog.bean;

import org.springframework.data.annotation.Id;

/**
 * ������֧�����ñ�
 * @author ��Ԫ��
 */
public class Language {

	@Id
	private String id;
	
	/** ���Ա��� */
	private String code;
	/** ��������ö�� */
	private String lang;
	/** �������� */
	private String value;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
