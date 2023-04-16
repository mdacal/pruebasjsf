package com.accesodatos.jsfjdbc.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.accesodatos.jsfjdbc.dao.PersonaDao;
import com.accesodatos.jsfjdbc.dominio.Persona;

@ManagedBean(name = "tablaPersonas")
@SessionScoped
public class PersonasBeanController implements Serializable {

	private static final long serialVersionUID = 1L;

	private String stabla = "";

	private List<Persona> listaPersonas = new ArrayList<>();

	private Persona personaSeleccionada=new Persona();
	
    @PostConstruct
    public void init() {
    	PersonaDao personaDao = new PersonaDao();
		listaPersonas = personaDao.getAll();
    }

    
	public PersonasBeanController() {
		super();
	}

	public Persona getPersonaSeleccionada() {
		return personaSeleccionada;
	}

	public void setPersonaSeleccionada(Persona personaSeleccionada) {
		this.personaSeleccionada = personaSeleccionada;
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
		PersonaDao personaDao = new PersonaDao();
		personaDao.delete(p);
		removePersona(p);
	}

	public String modificarPersona(Persona p) {
		this.personaSeleccionada=p;
		return "modificarPersona";
	}

	
	public void cargarDatosPersonas() {
		PersonaDao personaDao = new PersonaDao();
		listaPersonas = personaDao.getAll();
		for (Persona p : listaPersonas) {
			stabla += p + "<br>";
		}
	}

}
