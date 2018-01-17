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

        try {
            Conexion conexion = new Conexion();
            Funcionalidades funcion = new Funcionalidades(conexion.getConexion());
            String opcionMenu;

            Scanner leer = new Scanner(System.in);
            do {
                System.out.println("Elige una opcion:\n\t1-Mostrar informacion de la BBDD\n\t2-Mostrar informacion sobre las tablas\n\t3-"
                        + "Info sobre columnas\n\t4-Consultas descripcion de datos\n\t5-Consulta definicion de datos.\n\t6-Consulta modificacion de datos\n\t7-Subir salario por departamento\n\t8-Crear infomres\n\t0-Salir.");
                System.out.print("Introduce una opcion: ");
                opcionMenu = leer.nextLine();
                switch(opcionMenu){
                    case "1":
                        funcion.informacionBBDD();
                        break;
                    case "2":
                        funcion.informacionBBDDTablas();
                        break;
                    case "3":
                        funcion.informacionBBDDColumnas();
                        break;
                    case "4":
                        funcion.consultasDescripcionDatos();
                        break;
                    case "5":
                        funcion.consultasDefinicionDatos();
                        break;
                    case "6":
                        funcion.consultasModificacionDatos();
                        break;
                    case "7":
                        funcion.subirSalarioProcedimiento();
                        break;
                    case "8":
                        funcion.crearInformes();
                        break;
                    case "0":
                        break;
                    default:
                        System.out.println("Opción incorrecta.");
                }
            } while (!"0".equals(opcionMenu));
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("\n\tSe produjo una excepcion: " + e.getMessage());
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
