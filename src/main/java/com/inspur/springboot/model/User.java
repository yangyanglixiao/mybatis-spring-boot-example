package com.inspur.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * User Bean
 * 
 * @author 框架产品组
 * 
 */
@Table(name = "demo_user")
public class User implements Serializable {

	@Id
	private String id;

	@Column(name = "user_id")
	private String user_id;

	@Column(name = "user_name")
	private String user_name;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	private String nickname;

	private String password;

	@Column(name = "act_status")
	private String status = "N";

	@Transient
	private UserArchive archive;

	public UserArchive getArchive() {
		return archive;
	}

	public void setArchive(UserArchive archive) {
		this.archive = archive;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/*
	 * public UserArchive getArchive() { return archive; }
	 * 
	 * public void setArchive(UserArchive archive) { this.archive = archive; }
	 */

}
