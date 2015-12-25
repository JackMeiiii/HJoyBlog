package com.hanyx.hjoyblog.bean;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

/**
 * �û���
 * @author ��Ԫ��
 */
public class User {
	@Id
	private String id;
	/** ��¼�� */
	private String loginName;
	/** ��¼���� */
	private String loginPwd;
	/** �ǳ� */
	private String nickName;
	/** �ʼ� */
	private String email;
	/** �ֻ��� */
	private String tel;
	/** ��ɫ 0 - Adminstrator ; 1 - Guest */
	private short role;
	/** �������� */
	private Date createDate;
	/** ����¼���� */
	private Date lastLoginDate;
	/** ��¼IP���� */
	private List<String> loginIPs;
	/** ����״̬ 0 - Del ; 1 - Used */
	private short isUsed;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public short getRole() {
		return role;
	}
	public void setRole(short role) {
		this.role = role;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public List<String> getLoginIPs() {
		return loginIPs;
	}
	public void setLoginIPs(List<String> loginIPs) {
		this.loginIPs = loginIPs;
	}
	public short getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(short isUsed) {
		this.isUsed = isUsed;
	}
}
