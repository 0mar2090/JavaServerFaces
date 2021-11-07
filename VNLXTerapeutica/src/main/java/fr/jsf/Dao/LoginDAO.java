/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsf.Dao;

import fr.jsf.Assets.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class LoginDAO {
    public static boolean ValidarLogin(String user, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement("Select * from user where usuario = ? and Pass = ?");
			ps.setString(1, user);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Error de Conexion -->" + ex.getMessage());
			return false;
		} finally {
			Conexion.close(con);
		}
		return false;
	}

}
