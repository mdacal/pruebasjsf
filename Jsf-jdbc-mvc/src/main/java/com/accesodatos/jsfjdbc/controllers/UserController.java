package com.accesodatos.jsfjdbc.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.accesodatos.jsfjdbc.beans.UserBean;

@ManagedBean(name = "userController")
@SessionScoped
public class UserController {
	@ManagedProperty(value = "#{user}")
	private UserBean user;	
	
	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public String login() {
		String result = "index";
		if (user.getName().length() > 0 && user.getPassword().length() > 0) {
			result = "welcome";
		}
		return result;
	}
}
