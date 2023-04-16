package com.accesodatos.jsfjdbc.beans;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="user")
@SessionScoped
public class UserBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name="";
	private String password;
	
	public UserBean() {
		super();
	}
	public UserBean(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
//	public String login() {
//		String result="index";
//		if(name.length()>0 && password.length()>0) {
//			result="welcome";
//		}
//		return result;
//	}
	
	
}

