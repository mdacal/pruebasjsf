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

@ManagedBean(name = "personaController")
@ViewScoped
public class ModifPersonaBeanController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//@ManagedProperty(value = "#{persona}")
	private PersonaBean persona;//=new PersonaBean();
	
	public ModifPersonaBeanController() {
		super();
	}
	
	
	@PostConstruct
    public void init() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        this.persona = (PersonaBean) ec.getRequestMap().get("persona");
    }
	
	public ModifPersonaBeanController(PersonaBean persona) {
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
	
	public void removePersonaDB(PersonaBean p) {
		PersonaDao personaDao=new PersonaDao();
		personaDao.delete(p);
	}
	
	public void modifyPersonaDB() {
		PersonaDao personaDao=new PersonaDao();
		personaDao.update(persona);
	}


}
