/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accesodatos.jsfjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.accesodatos.jsfjdbc.beans.PersonaBean;

public class PersonaDao implements Dao<PersonaBean> {

	private Connection conexion;
	private final String NOM_TABLA="persona";
	public PersonaDao() {
		conexion = ConexionMysqlSingleton.getConexion();
	}

	@Override
	public void save(PersonaBean persona) {
		String sql = "INSERT INTO "+NOM_TABLA+" VALUES(null, ?, ?, ?, ?)";
		PreparedStatement sentencia;
		try {
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, persona.getNombre());
			sentencia.setString(2, persona.getApellidos());
			sentencia.setDate(3, persona.getFechaNacimiento());
			sentencia.setString(4, persona.getObservaciones());
			int filas = sentencia.executeUpdate();
			// System.out.printf("Filas insertadas: %d%n", filas);
			if (filas > 0) {
				System.out.println("Persona "+persona.getNombre()+" insertada" );
			}
			sentencia.close();

		} catch (SQLException e) {
			mensajeExcepcion(e);
		}

	}

	@Override
	public void update(PersonaBean persona) {
		String sql = "UPDATE "+NOM_TABLA+" SET nombre= ?, apellidos = ?,f_nacimiento=?, observaciones=?  WHERE id = ? ";
		PreparedStatement sentencia;
		try {
			sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(5, persona.getId());
			sentencia.setString(1, persona.getNombre());
			sentencia.setString(2, persona.getApellidos());
			sentencia.setDate(3, persona.getFechaNacimiento());
			sentencia.setString(4, persona.getObservaciones());
			int filas = sentencia.executeUpdate();
			// System.out.printf("Filas modificadas: %d%n", filas);
			if (filas > 0) {
				System.out.println("Persona "+persona.getNombre()+" modificada");
			}
			sentencia.close();
		} catch (SQLException e) {
			mensajeExcepcion(e);
		}

	}

	@Override
	public void delete(PersonaBean persona) {
		String sql = "DELETE FROM "+NOM_TABLA+" WHERE id = ? ";
		PreparedStatement sentencia;
		try {
			sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, persona.getId());
			int filas = sentencia.executeUpdate();
			// System.out.printf("Filas eliminadas: %d%n", filas);
			if (filas > 0) {
				System.out.println("Persona "+persona.getNombre()+" eliminada");
			}
			sentencia.close();
		} catch (SQLException e) {
			mensajeExcepcion(e);
		}

	}
	
	@Override
	public Optional<PersonaBean> get(long id) {
		Optional<PersonaBean> optPersonaBean=null;
		String sql = "SELECT * FROM "+NOM_TABLA+" WHERE id = ? ";
		PreparedStatement sentencia;
		try {
			sentencia = conexion.prepareStatement(sql);
			sentencia.setLong(1, id );
			ResultSet rs = sentencia.executeQuery();
			if(rs.next()) {
				optPersonaBean=Optional.of(new PersonaBean(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"), rs.getDate("f_nacimiento"), rs.getString("observaciones")));
			}
			sentencia.close();
		} catch (SQLException e) {
			mensajeExcepcion(e);
		}
		return optPersonaBean;
	}

	@Override
	public List<PersonaBean> getAll() {
		List<PersonaBean> listaPersonas= new ArrayList<PersonaBean>();
		String sql = "SELECT * FROM "+NOM_TABLA;
		PreparedStatement sentencia;
		try {
			sentencia = conexion.prepareStatement(sql);
			ResultSet rs = sentencia.executeQuery();
			while(rs.next()) {
				listaPersonas.add(new PersonaBean(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"), rs.getDate("f_nacimiento"), rs.getString("observaciones")));
			}
			sentencia.close();
		} catch (SQLException e) {
			mensajeExcepcion(e);
		}
		return listaPersonas;
	}

	private void mensajeExcepcion(SQLException e) {
		System.out.printf("HA OCURRIDO UNA EXCEPCIÓN:%n");
		System.out.printf("Mensaje   : %s %n", e.getMessage());
		System.out.printf("SQL estado: %s %n", e.getSQLState());
		System.out.printf("Cód error : %s %n", e.getErrorCode());
	}




}
