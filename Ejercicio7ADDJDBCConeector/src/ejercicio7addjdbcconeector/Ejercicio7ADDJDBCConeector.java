/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7addjdbcconeector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Ejercicio7ADDJDBCConeector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion;
        Scanner leer= new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "123456");
                    Statement sentencia = conexion.createStatement();
                    ResultSet resul = sentencia.executeQuery("SELECT * FROM departamentos")) {
                while (resul.next()) {
                    System.out.println(resul.getInt(1) + " " + resul.getString(2) + " " + resul.getNString(3));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        do {            
            System.out.println("Elige una consulta:\n\t1-Apellidos de los empleados del departamento Ventas.\n\t2-Apellidos de todos los empleados contratados entre 1980-1990\n\t3-Nombre de departamento y suma de los salarios\n\t0-Salir");
            System.out.println("Introduzca una opcion: ");
            opcion= Integer.parseInt(leer.nextLine());
            
        } while (true);
        
        
        
        
        

    }

}
