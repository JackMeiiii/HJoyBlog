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
	/*�Զ���URL*/
	private String catalogPath;
	/*Ȩ��*/
	private short permission;
	/*״̬*/
	private short state;
	/*����*/
	private String createDate;

	public String getCatalogPath() {
		return catalogPath;
	}

	public void setCatalogPath(String catalogPath) {
		this.catalogPath = catalogPath;
	}

	public short getPermission() {
		return permission;
	}

	public void setPermission(short permission) {
		this.permission = permission;
	}
	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	public short getState() {
		return state;
	}

	public void setState(short state) {
		this.state = state;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
