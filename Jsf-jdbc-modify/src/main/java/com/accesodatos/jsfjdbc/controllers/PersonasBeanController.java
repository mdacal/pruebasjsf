package com.accesodatos.jsfjdbc.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import com.accesodatos.jsfjdbc.beans.Persona;
import com.accesodatos.jsfjdbc.dao.PersonaDao;

@ManagedBean(name = "tablaPersonas")
@ViewScoped
public class PersonasBeanController implements Serializable {

	private static final long serialVersionUID = 1L;

	private String stabla = "";

	private List<Persona> listaPersonas = new ArrayList<>();
	
	//private Persona personaSeleccionada;
	
//    @PostConstruct
//    public void init() {
//    	PersonaDao personaDao = new PersonaDao();
//		listaPersonas = personaDao.getAll();
//    }
    
	public PersonasBeanController() {
		super();
	}

	public List<Persona> getListaPersonas() {
		return listaPersonas;
	}

	public String getStabla() {
		return stabla;
	}

	public void addPersona(Persona p) {
		this.listaPersonas.add(p);
	}

	public void removePersona(Persona p) {
		this.listaPersonas.remove(p);
	}

	public void removePersonaDB(Persona p) {
		System.out.println("entra en borrado");
		PersonaDao personaDao = new PersonaDao();
		personaDao.delete(p);
		removePersona(p);
	}
	
	public void borraPersonaDB(Persona p) {
		System.out.println("entra en borrado de ruben");
		PersonaDao personaDao = new PersonaDao();
		personaDao.delete(p);
		removePersona(p);
	}

//	public String modificarPersona(Persona p) {
//		this.personaSeleccionada=p;
//		return "modificarPersona";
//	}

	
	public void cargarDatosPersonas() {
		PersonaDao personaDao = new PersonaDao();
		listaPersonas = personaDao.getAll();
		for (Persona p : listaPersonas) {
			stabla += p + "<br>";
		}
	}

}
