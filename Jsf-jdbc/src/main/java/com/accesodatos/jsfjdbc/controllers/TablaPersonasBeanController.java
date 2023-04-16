package com.accesodatos.jsfjdbc.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.accesodatos.jsfjdbc.beans.PersonaBean;
import com.accesodatos.jsfjdbc.dao.PersonaDao;

@ManagedBean(name = "tablaPersonas")
@SessionScoped
public class TablaPersonasBeanController implements Serializable {

	private static final long serialVersionUID = 1L;

	//private String serror; // Se utiliza para pintar el error, si lo hay.
	private String stabla = "";

	private List<PersonaBean> listaPersonas = new ArrayList<>();
	private PersonaBean persona=new PersonaBean();
	
	public TablaPersonasBeanController() {
		super();
	}

	public List<PersonaBean> getListaPersonas() {
		return listaPersonas;
	}

	public String getStabla() {
		return stabla;
	}
	
	public PersonaBean getPersona() {
		return persona;
	}

	public void setPersona(PersonaBean persona) {
		this.persona = persona;
	}

	public void addPersona(PersonaBean p) {
		this.listaPersonas.add(p);
	}
	
	public void removePersona(PersonaBean p) {
		this.listaPersonas.remove(p);
	}
	
	public void addPersonaDB() {
		PersonaDao personaDao=new PersonaDao();
		personaDao.save(persona);
		addPersona(persona);
	}
	
	public void removePersonaDB(PersonaBean p) {
		PersonaDao personaDao=new PersonaDao();
		personaDao.delete(p);
		removePersona(p);
	}
	
	public String modifyPersonaDB(PersonaBean p) {
		return "modificarPersonas";
	}

	public void cargarDatosPersonas(ActionEvent ae) {
		PersonaDao personaDao = new PersonaDao();
		listaPersonas=personaDao.getAll();
		for (PersonaBean p : listaPersonas) {
			stabla += p + "<br>";
		}
	}
	


}
