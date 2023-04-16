/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accesodatos.jsfjdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionMysqlSingleton {

	static Connection conexion = null;
	static String DRIVER = "com.mysql.cj.jdbc.Driver";
	static String URLDB = "jdbc:mysql://localhost/curso_jsf";
	static String USUARIO = "root";
	static String CLAVE = "root";

	public ConexionMysqlSingleton() {
	}

	// obtener la conexion aplicando el patr�n Singleton
	public static Connection getConexion() {
		if (conexion == null) {
			try {
				//la siguiente instrucción sirve para que la conexión se cierre si la aplicación se para
				Runtime.getRuntime().addShutdownHook(new GetClose());
				
				Class.forName(DRIVER); // Cargar el driver
				conexion = DriverManager.getConnection(URLDB, USUARIO, CLAVE);
				System.out.println("Nueva conexión creada.");
			} catch (SQLException ex) {
				System.out.printf("HA OCURRIDO UNA EXCEPCIÓN:%n");
				System.out.printf("Mensaje   : %s %n", ex.getMessage());
				System.out.printf("SQL estado: %s %n", ex.getSQLState());
				System.out.printf("Cód error : %s %n", ex.getErrorCode());
			} catch (ClassNotFoundException e) {
				// Logger.getLogger(ConexionMysqlSingleton.class.getName()).log(Level.SEVERE,
				// null, e);
				e.printStackTrace();
			}
		} else {
			System.out.println("Reutilizamos conexión");
		}
		return conexion;
	}

	static class GetClose extends Thread {
		@Override
    	public void run() {
    		try {
    			ConexionMysqlSingleton.getConexion().close();
    			System.out.println("Cerramos conexión JDBC");
    		}catch(SQLException e) {
    			e.printStackTrace();
    		}
    	}
	}

}
