/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej10conexionamysql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesus
 */
public class Funcionalidades {

    private static Connection conexion;
    private static DatabaseMetaData dbmd;
    static Scanner leer = new Scanner(System.in);

    public Funcionalidades(Connection conexion) throws SQLException {
        this.conexion = conexion;
        this.dbmd = conexion.getMetaData();
    }

    public void consultasDefinicionDatos() {
        //drop create alter
        String opcionMenu;
        do {
            System.out.println("Elige una opcion:\n\t1-Crear tabla.\n\t2-Borrar tabla.\n\t0-Salir:");
            opcionMenu = leer.nextLine();
            switch (opcionMenu) {
                case "1":
                    creaTabla();
                    break;
                case "2":
                    borrarTabla();
                    break;
                case "0":
                    System.out.println("Saliendo.....");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (!"0".equals(opcionMenu));
    }

    private static void creaTabla() {
        String columna;
        System.out.println("****Creacion tabla****");
        String consulta = "CREATE TABLE";
        System.out.println("Introduce un nombre para la tabla");
        String nombreTabla = leer.nextLine();
        consulta += nombreTabla + "(";
        boolean correcto = true;
        int numeroColumnas = 0;
        do {
            System.out.println("Numero de columnas que tendra la tabla:");
            try {
                numeroColumnas = Integer.parseInt(leer.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numero no valido");
                correcto = false;
            }
        } while (!correcto);
        do {
            System.out.println("Introduce el nombre de la columna seguido de el tipo de datos que almacenara (name datatype)");
            columna = leer.nextLine();
            numeroColumnas--;
            if (numeroColumnas <= 0) {
                consulta += columna + ",";
            }
        } while (numeroColumnas <= 0);
        consulta += columna + ");";
        System.out.println("Consulta que se ejecutara: " + consulta);
        try {
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(consulta);
            sentencia.close();
            System.out.println("Tabla creada con exito");
        } catch (SQLException ex) {
            System.out.println("No se pudo crear la tabla." + ex.getMessage());
        }

    }

    private static void borrarTabla() {
        System.out.println("****Borrar tabla****");
        String consulta = "DROP TABLE";
        System.out.println("Introduce el nombre de la tabla");
        String nombreTabla = leer.nextLine();
        consulta += nombreTabla + ";";
        try {
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(consulta);
            sentencia.close();
            System.out.println("Tabla borrada con exito");
        } catch (SQLException ex) {
            System.out.println("No se pudo borrar la tabla." + ex.getMessage());
        }

    }

    
    private static void altas(){
        System.out.println("*****ALTA DE REGISTROS*****");
        String consulta="INSERT INTO";
        System.out.println("Introduce nombre de la tabla a la que añadir registros: ");
        String nombreTabla= leer.nextLine();
//        Statement sentencia= conexion.createStatement("SELECT * FROM "+nombreTabla+";");
//        ResultSet infoTabla= conexion.createStatement("SELECT * FROM "+nombreTabla+";");
        try {
            
        } catch (Exception e) {
        }
    }

    private static void bajas(){
        
    }
    
    private static void modificarTabla() {

    }
    
    public void consultasModificacionDatos() {
        String opcion= leer.nextLine();
        do {            
            System.out.println("Elige una opcion:\n\t1-Altas\n\t2-Bajas\n\t3-Modificaciones");
            switch(opcion){
                case "1":
                    altas();
                    break;
                case "2":
                    bajas();
                    break;
                case "3":
                    modificarTabla();
                    break;
                default:
                    System.out.println("Opcion incorrexta");
            }
        } while (!"0".equals(opcion));
    }

    public void informacionBBDD() {
        System.out.println("**********Metadatos**********");
        try {
            System.out.println("Nombre: " + dbmd.getDatabaseProductName());
            System.out.println("Driver: " + dbmd.getDriverName());
            System.out.println("URL: " + dbmd.getURL());
            System.out.println("User: " + dbmd.getUserName());
        } catch (SQLException e) {
            System.out.println("Excepcion: " + e.getMessage());
        }
    }

    public void informacionBBDDColumnas() {
        System.out.println("**********INFORMACION COLUMNAS**********");
        ResultSet infoColumnas;
        try {
            infoColumnas = dbmd.getColumns(null, null, null, null);
            while (infoColumnas.next()) {
                System.out.println("Tabla: " + infoColumnas.getString(3) + " Columna: " + infoColumnas.getString("COLUMN_NAME") + ", Tipo: " + infoColumnas.getString("TYPE_NAME") + ", Tamaño: " + infoColumnas.getString("COLUMN_SIZE") + ", ¿Es nula?: " + infoColumnas.getString("IS_NULLABLE"));
            }
        } catch (SQLException ex) {
            System.out.println("Excepcion al buscar las infoColumnas.");
        }
    }

    public void informacionBBDDTablas() {
        System.out.println("**********INFORMACION TABLAS**********");
        try {
            ResultSet infoTablas;
            infoTablas = dbmd.getTables(null, "ejemplo", null, null);
            while (infoTablas.next()) {
                System.out.print(infoTablas.getString(4) + " - Catálogo: " + infoTablas.getString(1) + ", Esquema: " + infoTablas.getString(2) + ", Nombre: " + infoTablas.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println("Excepcion al buscar las tablas.");
        }
    }

    public void consultasDescripcionDatos() {
        try {
            Statement sentencia = conexion.createStatement();
            System.out.println("Introduce una consulta:");
            String consulta = leer.nextLine();
            ResultSet resul = sentencia.executeQuery(consulta);
            ResultSetMetaData rSMD = resul.getMetaData();

            while (resul.next()) {
                for (int i = 1; i < rSMD.getColumnCount() + 1; i++) {
                    System.out.printf("%-20s", resul.getString(i));

                }
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
