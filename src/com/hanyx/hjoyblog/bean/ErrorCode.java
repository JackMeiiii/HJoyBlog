package com.hanyx.hjoyblog.bean;

import org.springframework.data.annotation.Id;

/**
 * ������־��
 * @author ÷����
 */
public class ErrorCode {
	/*���Ա���*/
	private Short code;
	@Id
	private String id;
	/*������Ϣ*/
	private String message;

	public Short getCode() {
		return code;
	}

	public void setCode(Short code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
