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
            try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "123456"))
                     {
                         do {                             
                            System.out.println("Elige una consulta:\n\t1-Apellidos de los empleados del departamento Ventas.\n\t2-Apellidos de todos los empleados contratados entre 1980-1990\n\t3-Nombre de departamento y suma de los salarios\n\t0-Salir");
                            System.out.println("Introduzca una opcion: ");
                            opcion= Integer.parseInt(leer.nextLine()); 
                            Statement sentencia = conexion.createStatement();
                            ResultSet resul=null;
                            System.out.println("****************************************");
                            switch(opcion){
                                case 1:
                                    System.out.println("Apellidos de los empleados del departamento Ventas.");
                                    resul = sentencia.executeQuery("SELECT apellido from empleados INNER JOIN departamentos ON departamentos.dept_no=empleados.dept_no WHERE departamentos.dnombre='VENTAS' ;");
                                    while(resul.next()){
                                        System.out.println(resul.getString(1));
                                    }
                                    break;
                                case 2:
                                    System.out.println("Apellidos de todos los empleados contratados entre 1980-1990");
                                    //resul = sentencia.executeQuery("SELECT apellido FROM empleados WHERE YEAR(feha_alta)>1979 AND YEAR(feha_alta)<1991;");//Error campo columna
                                    resul = sentencia.executeQuery("SELECT apellido FROM empleados WHERE YEAR(fecha_alta)>1979 AND YEAR(fecha_alta)<1991;");
                                    while(resul.next()){
                                        System.out.println(resul.getString(1));
                                    }
                                    break;
                                case 3:
                                    System.out.println("Nombre de departamento y suma de los salarios");
                                    resul = sentencia.executeQuery("SELECT departamentos.dnombre, SUM(empleados.salario) AS SumaPorDepartamento \n" +
                                                                    "FROM departamentos \n" +
                                                                    "INNER JOIN empleados ON empleados.dept_no=departamentos.dept_no \n" +
                                                                   "GROUP BY departamentos.dnombre;");
                                    while(resul.next()){
                                        System.out.printf("%-20s\t%6.2f\n",resul.getString(1),resul.getFloat(2));
                                    }
                                    break;
                            }
                                System.out.println("****************************************");
                            
                         } while (opcion!=0);
                    }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
