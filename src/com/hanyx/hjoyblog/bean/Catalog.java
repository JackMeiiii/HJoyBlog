package com.hanyx.hjoyblog.bean;

import org.springframework.data.annotation.Id;

/**
 * Ŀ¼��
 * @author ÷����
 *
 */
public class Catalog {
	/*Ŀ¼��*/
	@Id
	private String catalogId;
	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	/*�Զ���URL*/
	private String URL;
	/*Ȩ��*/
	private short permission;
	/*״̬*/
	private short state;
	/*����*/
	private String create_date;

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public short getPermission() {
		return permission;
	}

	public void setPermission(short permission) {
		this.permission = permission;
	}

	public short getState() {
		return state;
	}

	public void setState(short state) {
		this.state = state;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
}
