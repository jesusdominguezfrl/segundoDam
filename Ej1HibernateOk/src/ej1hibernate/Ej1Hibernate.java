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
}
