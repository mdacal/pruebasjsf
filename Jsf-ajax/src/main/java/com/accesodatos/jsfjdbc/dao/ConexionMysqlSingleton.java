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

	// obtener la conexion aplicando el patr髇 Singleton
	public static Connection getConexion() {
		if (conexion == null) {
			try {
				//la siguiente instrucci贸n sirve para que la conexi贸n se cierre si la aplicaci贸n se para
				Runtime.getRuntime().addShutdownHook(new GetClose());
				
				Class.forName(DRIVER); // Cargar el driver
				conexion = DriverManager.getConnection(URLDB, USUARIO, CLAVE);
				System.out.println("Nueva conexi贸n creada.");
			} catch (SQLException ex) {
				System.out.printf("HA OCURRIDO UNA EXCEPCI脫N:%n");
				System.out.printf("Mensaje   : %s %n", ex.getMessage());
				System.out.printf("SQL estado: %s %n", ex.getSQLState());
				System.out.printf("C贸d error : %s %n", ex.getErrorCode());
			} catch (ClassNotFoundException e) {
				// Logger.getLogger(ConexionMysqlSingleton.class.getName()).log(Level.SEVERE,
				// null, e);
				e.printStackTrace();
			}
		} else {
			System.out.println("Reutilizamos conexi贸n");
		}
		return conexion;
	}

	static class GetClose extends Thread {
		@Override
    	public void run() {
    		try {
    			ConexionMysqlSingleton.getConexion().close();
    			System.out.println("Cerramos conexi贸n JDBC");
    		}catch(SQLException e) {
    			e.printStackTrace();
    		}
    	}
	}

}
