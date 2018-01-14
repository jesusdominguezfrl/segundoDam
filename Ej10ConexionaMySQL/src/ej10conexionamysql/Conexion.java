/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej10conexionamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class Conexion {

    private Connection conexion;

    public Conexion() throws ClassNotFoundException, SQLException {
        System.out.println("Estableciendo conexion...");
        Class.forName("com.mysql.jdbc.Driver");
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?allowMultiQueris=true", "root", "123456");

    }

    public Connection getConexion() {
        return conexion;
    }

}
