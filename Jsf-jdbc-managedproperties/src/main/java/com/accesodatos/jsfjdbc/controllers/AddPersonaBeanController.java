package com.accesodatos.jsfjdbc.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.accesodatos.jsfjdbc.beans.PersonaBean;
import com.accesodatos.jsfjdbc.dao.PersonaDao;

@ManagedBean(name = "addPersonaController")
@ViewScoped
public class AddPersonaBeanController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//@ManagedProperty(value = "#{persona}")
	private PersonaBean persona=new PersonaBean();
	
	public AddPersonaBeanController() {
		super();
	}
	
	public AddPersonaBeanController(PersonaBean persona) {
		this.persona=persona;
	}

	public PersonaBean getPersona() {
		return persona;
	}

	public void setPersona(PersonaBean persona) {
		this.persona = persona;
	}
	
	public void addPersonaDB() {
		PersonaDao personaDao=new PersonaDao();
		personaDao.save(persona);
	}


}
