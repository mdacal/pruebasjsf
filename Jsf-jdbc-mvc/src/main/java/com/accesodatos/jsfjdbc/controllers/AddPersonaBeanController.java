package com.accesodatos.jsfjdbc.controllers;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.accesodatos.jsfjdbc.dao.PersonaDao;
import com.accesodatos.jsfjdbc.dominio.Persona;

@ManagedBean(name = "addPersonaController")
@ViewScoped
public class AddPersonaBeanController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Persona persona=new Persona();
	
	public AddPersonaBeanController() {
		super();
	}
	
	public AddPersonaBeanController(Persona persona) {
		this.persona=persona;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public void addPersonaDB() {
		PersonaDao personaDao=new PersonaDao();
		personaDao.save(persona);
	}


}
