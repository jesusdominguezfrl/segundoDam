/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej9conexiondiferentesbbdd;

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
public class Ej9ConexionDiferentesBBDD {

    /**
     * @param args the command line arguments
     */
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        String opcion;
        String opcionSubMenu;
        Connection conexion=null;
        do {
            System.out.println("**********CONEXION DIFERENTES BBDD**********");
            System.out.println("Elige la BBDD a la que te quieres conectar:\n\t1-SQLite\n\t2-Derby\n\t3-HSQLDB\n\t4-H2\n\t0-Salir");
            System.out.print("Introduce una opcion: ");
            opcion = leer.nextLine();
            switch (opcion) {
                case "1":
                    try {
                        Class.forName("org.sqlite.JDBC");
                        conexion = DriverManager.getConnection("jdbc:sqlite:ejemplo.db");
                        do {
                            opcionSubMenu = subMenuOpciones();
                            bbddDatos(opcionSubMenu, conexion);
                        } while (!"0".equals(opcionSubMenu));
                    } catch (Exception e) {
                        System.out.println("Se produjo una excepcion: " + e.getMessage());
                    }
                    break;
                case "2":       
                    try {
                        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                        conexion =DriverManager.getConnection("jdbc:derby:ejemplo");
                        do {
                            opcionSubMenu = subMenuOpciones();
                            bbddDatos(opcionSubMenu, conexion);
                        } while (!"0".equals(opcionSubMenu));
                    } catch (Exception e) {
                        System.out.println("Se produjo una excepcion: " + e.getMessage());
                    }
                    break;
                case "3":
                    try {
                        Class.forName("org.hsqldb.jdbcDriver");
                        conexion =DriverManager.getConnection("jdbc:hsqldb:file:ejemploHSQL");
                        do {
                            opcionSubMenu = subMenuOpciones();
                            bbddDatos(opcionSubMenu, conexion);
                        } while (!"0".equals(opcionSubMenu));
                    } catch (Exception e) {
                        System.out.println("Se produjo una excepcion: " + e.getMessage());
                    }
                    break;
                case "4":
                    try {
                        Class.forName("org.h2.Driver");
                        conexion =DriverManager.getConnection("jdbc:h2:./ejemploH2/ejemplo");
                        do {
                            opcionSubMenu = subMenuOpciones();
                            bbddDatos(opcionSubMenu, conexion);
                        } while (!"0".equals(opcionSubMenu));
                    } catch (Exception e) {
                        System.out.println("Se produjo una excepcion: " + e.getMessage());
                    }
                    break;                    
            }
            try {
                conexion.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } while (!"0".equals(opcion));

    }

    static String subMenuOpciones() {
        String opcion;
        System.out.println("***********Trabajando en una base concreta***********");
        System.out.println("Elige una opcion:\n\t1-Mostrar informacion de la BBDD\n\t2-Mostrar informacion sobre las tablas\n\t3-"
                + "Info sobre columnas\n\t4-Consultas\n\t0-Salir.");
        System.out.print("Introduce una opcion: ");
        opcion = leer.nextLine();
        return opcion;
    }

    private static void bbddDatos(String opcionSubMenu, Connection conexion) {
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
                    System.out.println("**********INFORMACION BBDD**********");

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
                    String consulta= leer.nextLine();
                    realizarConsulta(consulta, conexion);
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
    
    private static void realizarConsulta(String consulta, Connection conexion){
       try {
                Statement sentencia = conexion.createStatement();
                ResultSet resul=sentencia.executeQuery(consulta);
                ResultSetMetaData rSMD= resul.getMetaData();
                String tipoColumna[]= new String[rSMD.getColumnCount()];
                for (int i = 1; i < tipoColumna.length+1; i++) {
                    System.out.println(rSMD.getColumnTypeName(i));
                }
                
                while(resul.next()){
                    //System.out.println(resul.getInt(1)+","+ resul.getString(2)+","+ resul.getString(3)+","+ resul.getString(4)+","+ resul.getFloat(5));
                    for (int i = 1; i < rSMD.getColumnCount()+1; i++) {
                        System.out.print(resul.getString(i)+",");
                        
                    }
                    System.out.println("");
                }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        } 
    }

}
