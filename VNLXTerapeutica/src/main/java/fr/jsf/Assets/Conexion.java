/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsf.Assets;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HP
 */
public class Conexion {
    public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/terapeutica", "root", "");
			return con;
		} catch (Exception ex) {
			System.out.println("Erreur : Database.getConnection()  -->"
					+ ex.getMessage());
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}
