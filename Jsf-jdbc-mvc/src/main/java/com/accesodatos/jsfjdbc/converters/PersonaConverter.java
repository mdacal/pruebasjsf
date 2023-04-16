package com.accesodatos.jsfjdbc.converters;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.accesodatos.jsfjdbc.dao.PersonaDao;
import com.accesodatos.jsfjdbc.dominio.Persona;

@ManagedBean(name="personaConverter")
@RequestScoped
public class PersonaConverter implements Converter{

	private PersonaDao personaDao=new PersonaDao();
	
	public PersonaConverter() {
		System.out.println("Converter creado");
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            Long id = Long.valueOf(value);
            return personaDao.get(id).get();
        } catch (NumberFormatException e) {
            throw new ConverterException("The value is not a valid Person ID: " + value, e);
        }
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		 if (value == null) {
	            return "";
	        }

	        if (value instanceof Persona) {
	            Integer id = ((Persona) value).getId();
	            return (id != null) ? String.valueOf(id) : null;
	        } else {
	            throw new ConverterException("The value is not a valid Person instance: " + value);
	        }
	}

}
