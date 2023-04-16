package com.accesodatos.jsfjdbc.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.accesodatos.jsfjdbc.beans.PersonaBean;
import com.accesodatos.jsfjdbc.dao.PersonaDao;

@ManagedBean(name = "tablaPersonas")
@ViewScoped
public class PersonasBeanController implements Serializable {

	private static final long serialVersionUID = 1L;

	private String stabla = "";

	private List<PersonaBean> listaPersonas = new ArrayList<>();

	public PersonasBeanController() {
		super();
	}

	public List<PersonaBean> getListaPersonas() {
		return listaPersonas;
	}

	public String getStabla() {
		return stabla;
	}

	public void addPersona(PersonaBean p) {
		this.listaPersonas.add(p);
	}

	public void removePersona(PersonaBean p) {
		this.listaPersonas.remove(p);
	}

	public void removePersonaDB(PersonaBean p) {
		PersonaDao personaDao = new PersonaDao();
		personaDao.delete(p);
		removePersona(p);
	}

	public String modifyPersonaDB(PersonaBean p) {
		
		//return "/views/modificarPersona.xhtml?faces-redirect=true&id="+p.getId();
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.getRequestMap().put("persona", p);
		return "modificarPersona";
	}

//	public void cargarDatosPersonas(ActionEvent ae) {
//		PersonaDao personaDao = new PersonaDao();
//		listaPersonas = personaDao.getAll();
//		for (PersonaBean p : listaPersonas) {
//			stabla += p + "<br>";
//		}
//	}
	
	public void cargarDatosPersonas() {
		PersonaDao personaDao = new PersonaDao();
		listaPersonas = personaDao.getAll();
		for (PersonaBean p : listaPersonas) {
			stabla += p + "<br>";
		}
	}

}
