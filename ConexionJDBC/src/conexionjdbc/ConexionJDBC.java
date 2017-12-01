/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionjdbc;

import java.sql.*;

/**
 *
 * @author usuario
 */
public class ConexionJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "123456");
                    Statement sentencia = conexion.createStatement();
                    ResultSet resul = sentencia.executeQuery("SELECT * FROM departamentos")) {
                while (resul.next()) {
                    System.out.println(resul.getInt(1)+" "+ resul.getString(2)+" "+ resul.getNString(3));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
