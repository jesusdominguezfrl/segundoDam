/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej10conexionamysql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Ej10ConexionaMySQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String opcion;
        Scanner leer = new Scanner(System.in);
        Connection conexion = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?allowMultiQueris=true", "root", "123456");
            do {
                System.out.println("Elige una opcion:\n\t1-Mostrar informacion de la BBDD\n\t2-Mostrar informacion sobre las tablas\n\t3-"
                        + "Info sobre columnas\n\t4-Consultas descripcion de datos\n\t5-Consulta definicion de datos\n\t0-Salir.");
                System.out.print("Introduce una opcion: ");
                opcion = leer.nextLine();
                bbddDatos(opcion, conexion);
            } while (!"0".equals(opcion));
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Se produjo una excepcion: " + e.getMessage());
        }

    }

    private static void bbddDatos(String opcionSubMenu, Connection conexion) {
        Scanner leer = new Scanner(System.in);
        DatabaseMetaData dbmd = null;
        try {
            dbmd = conexion.getMetaData();
        } catch (SQLException ex) {
            System.out.println("No se ha podido obtener los metadatos");
        }
        if (dbmd != null) {
            ResultSet result = null;
            switch (opcionSubMenu) {
                case "1":
                    System.out.println("**********Metadatos**********");

                    try {
                        System.out.println("Nombre: " + dbmd.getDatabaseProductName());
                        System.out.println("Driver: " + dbmd.getDriverName());
                        System.out.println("URL: " + dbmd.getURL());
                        System.out.println("User: " + dbmd.getUserName());
                    } catch (Exception e) {
                        System.out.println("Excepcion: " + e.getMessage());
                    }

                    break;
                case "2":
                    System.out.println("**********INFORMACION TABLAS**********");

                    try {
                        result = dbmd.getTables(null, "ejemplo", null, null);
                        while (result.next()) {
                            System.out.print(result.getString(4) + " - Catálogo: " + result.getString(1) + ", Esquema: " + result.getString(2) + ", Nombre: " + result.getString(3));
                        }
                    } catch (SQLException ex) {
                        System.out.println("Excepcion al buscar las tablas.");
                    }

                    break;
                case "3":
                    System.out.println("**********INFORMACION COLUMNAS**********");
                    ResultSet columnas = null;
                    try {
                        columnas = dbmd.getColumns(null, null, null, null);
                        while (columnas.next()) {
                            System.out.println("Tabla: " + columnas.getString(3) + " Columna: " + columnas.getString("COLUMN_NAME") + ", Tipo: " + columnas.getString("TYPE_NAME") + ", Tamaño: " + columnas.getString("COLUMN_SIZE") + ", ¿Es nula?: " + columnas.getString("IS_NULLABLE"));
                        }
                    } catch (SQLException ex) {
                        System.out.println("Excepcion al buscar las columnas.");
                    }

                    break;
                case "4":
                    System.out.println("Introduce una consulta: ");
                    String consulta = leer.nextLine();
                    realizarConsulta(consulta, conexion);
                    break;
                case "5":
                    System.out.println("*******Sentencias de definic"
                            + "ion de datos.***********");
                    System.out.print("Escribe una consulta de definicion de datos:");
                    try {
                        String consultaDefinicion = leer.nextLine();
                        Statement sentencia = conexion.createStatement();
                        int filas = sentencia.executeUpdate(consultaDefinicion);
                        sentencia.close();
                        conexion.close();
                    } catch (Exception e) {
                        
                    }
                    break;
                case "0":
                    System.out.println("saliendo...");
                    break;
                default:
                    System.out.println("");
                    break;
            }
        }

    }

    private static void realizarConsulta(String consulta, Connection conexion) {
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet resul = sentencia.executeQuery(consulta);
            ResultSetMetaData rSMD = resul.getMetaData();

            while (resul.next()) {
                //System.out.println(resul.getInt(1)+","+ resul.getString(2)+","+ resul.getString(3)+","+ resul.getString(4)+","+ resul.getFloat(5));
                for (int i = 1; i < rSMD.getColumnCount() + 1; i++) {
                    System.out.printf("%-20s", resul.getString(i));

                }
                System.out.println("");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
