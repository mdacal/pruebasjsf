package com.accesodatos.jsfjdbc.controllers;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.accesodatos.jsfjdbc.beans.Persona;
import com.accesodatos.jsfjdbc.dao.PersonaDao;

@ManagedBean(name = "editPersonaController")
@ViewScoped
public class EditPersonaBeanController implements Serializable {

	private static final long serialVersionUID = 1L;
	
//	@ManagedProperty(value = "#{tablaPersonas.personaSeleccionada.id}")
//	private Long id; //+getters y setters
//	
//	@ManagedProperty(value = "#{tablaPersonas.personaSeleccionada}")
	private Persona persona; 
	
	public EditPersonaBeanController() {
		super();
		//PersonaDao personaDao=new PersonaDao();
		//this.persona=personaDao.get(id).isPresent()?personaDao.get(id).get():null;
	}
	
	public EditPersonaBeanController(Persona persona) {
		this.persona=persona;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public void modifyPersonaDB() {
		PersonaDao personaDao=new PersonaDao();
		personaDao.update(persona);
	}


}
