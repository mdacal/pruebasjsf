package com.accesodatos.jsfjdbc.beans;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean(name="usuario")
@RequestScoped
public class UsuarioBean implements Serializable{
	private String nombre;
    private String password;
    private int edad;
    private String mensajeErrorNombre;
    private String mensajeErrorPassword;

    /**
     * Creates a new instance of Usuario
     */

    public UsuarioBean() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getMensajeErrorPassword() {
        return mensajeErrorPassword;
    }

    public void setMensajeErrorPassword(String mensajeErrorPassword) {
        this.mensajeErrorPassword = mensajeErrorPassword;
    }

    public String getMensajeErrorNombre() {
        return mensajeErrorNombre;
    }

    public void setMensajeErrorNombre(String mensajeErrorNombre) {
        this.mensajeErrorNombre = mensajeErrorNombre;
    }
    
    /**
     * Comprueba que la longitud del nombre este en el rango correcto
     * 
     * @param evento 
     */

    public void validarNombre(AjaxBehaviorEvent evento) {
        if (nombre.length() < 4) {
            mensajeErrorNombre = "El nombre tiene que tener como minimo 4 caracteres";
        } else {
            if (nombre.length() > 10) {
                mensajeErrorNombre = "El nombre puede tener como maximo 10 caracteres";
            } else {
                mensajeErrorNombre = "";
            }
        }
    }
    
    /**
     * Comprueba que la longitud de la password este en el rango correcto
     * 
     * @param evento 
     */

    public void validarPassword(AjaxBehaviorEvent evento) {
        if (password.length() < 6) {
            mensajeErrorPassword = "La contraseña tiene que tener como minimo 6 caracteres";
        } else {
            if (password.length() > 15) {
                mensajeErrorPassword = "La contraseña puede tener como maximo 15 caracteres";
            } else {
                mensajeErrorPassword = "";
            }
        }
    }
}