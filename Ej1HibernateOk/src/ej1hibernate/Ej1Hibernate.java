/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1hibernate;

import Vista.VistaHiberante;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Ej1Hibernate {

    /**
     * @param args the command line arguments
     */
    private static final Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {

        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);

        menu();

    }

    private static void menu() {
        String opcion;
        VistaHiberante v= new VistaHiberante();
        do {
            System.out.println("Introduce una opcion:"
                    + "\n\t1-Introducir datos."
                    + "\n\t2-Modificar datos."
                    + "\n\t3-Borrar datos."
                    + "\n\t4-Listados."
                    + "\n\t5-Consultas."
                    + "\n\t6-Cargar Datos."
                    + "\n\t0-Salir.");
            System.out.print("Introduce: ");
            opcion = leer.nextLine();
            switch (opcion) {
                case "1":
                    v.insertarDatos(subMenuEmplDept());
                    break;
                case "2":
                    v.modificarDatos(subMenuEmplDept());
                    break;
                case "3":
                    v.borraDatos(subMenuEmplDept());
                    break;
                case "4":
                    v.listarDatos(subMenuListados());
                    break;
                case "5":
                    v.consultarDatos(subMenuConsultas());
                    break;
                case "6":
                    v.cargarDatos(subMenuEmplDept());
                    break;
                case "0":
//                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        } while (!"0".equals(opcion));
    }

    private static String subMenuEmplDept() {
        String opcion;
        do {
            System.out.println("Introduce una opcion:"
                    + "\n\t1-Empleado."
                    + "\n\t2-Departamento."
                    + "\n\t0-Salir.");
            System.out.print("Introduce: ");
            opcion = leer.nextLine();
            switch (opcion) {
                case "1":
                    return "empleados";
                case "2":
                    return "departamentos";
                case "0":
                    return null;
                default:
                    System.out.println("Opcion incorrecta.");

            }
        } while (!"0".equals(opcion));
        return null;
    }
    
    private static String subMenuListados() {
        String opcion;
        do {
            System.out.println("Introduce una opcion:"
                    + "\n\t1-Empleados de un departamento."
                    + "\n\t2-Departamentos."
                    + "\n\t3-Empleados."
                    + "\n\t0-Salir.");
            System.out.print("Introduce: ");
            opcion = leer.nextLine();
            switch (opcion) {
                case "1":
                    return "empleadosDeDepartamento";
                case "2":
                    return "departamentos";
                case "3":
                    return "empleados";
                case "0":
                    return null;
                default:
                    System.out.println("Opcion incorrecta.");

            }
        } while (!"0".equals(opcion));
        return null;
    }
    
    private static String subMenuConsultas() {
        String opcion;
        do {
            System.out.println("Introduce una opcion:"
                    + "\n\t1-Informacion de un departamento\n\tMedia Salario\n\tSalario Maximo\n\tSuma Salarios"
                    + "\n\t2-Informacion de la empresa.\n\tMedia Salario\n\tSalario Maximo\n\tSuma Salarios"
                    + "\n\t0-Salir.");
            System.out.print("Introduce: ");
            opcion = leer.nextLine();
            switch (opcion) {
                case "1":
                    return "infoDepartamentos";
                case "2":
                    return "infoEmpresa";
                case "0":
                    return null;
                default:
                    System.out.println("Opcion incorrecta.");

            }
        } while (!"0".equals(opcion));
        return null;
    }
}
