/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1conexionaservidor;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import primero.Departamentos;
import primero.Empleados;
import primero.SessionFactoryUtil;

/**
 *
 * @author usuario
 */
public class Ej1ConexionAServidor {

    /**
     * @param args the command line arguments
     */
    private static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        SessionFactory sesion = SessionFactoryUtil.getSessionFactory();

        menu(sesion);

    }

    private static void menu(SessionFactory sesion) {
        String opcion;

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
                    introducirDatos(sesion, subMenuEmplDept());
                    break;
                case "2":
                    modificarDatos(sesion, subMenuEmplDept());
                    break;
                case "3":
                    borrarDatos(sesion, subMenuEmplDept());
                    break;
                case "0":
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
                    + "\n\t1-Introducir Empleado."
                    + "\n\t2-Modificar Departamento."
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

    private static void introducirDatos(SessionFactory sesion, String tabla) {
        if (tabla == null) {
            return;
        }
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        if ("empleados".equals(tabla)) {
            System.out.println("Inserción de un empleado en el departamento 10");
            Empleados em = new Empleados();
            
            
            
            em.SetEmpNo((short) 1234);
            em.SetApellido("Alonso");
            em.setDir((short) 4567);
            em.setOficio("Programador");
            em.setSalario(2500);
            em.setComision(15);
            
            Departamentos depart = new Departamentos();
            
            depart.setDeptNo((byte) 10);
            em.setDepartamentos(depart);
            java.util.Date hoy = new java.util.Date();
            java.sql.Date fecha = new java.sql.Date(hoy.getTime());
            em.setFechaAlt(fecha);
            session.save(em);
            tx.commit();
            session.close();

        } else {

        }
    }

    private static void modificarDatos(SessionFactory sesion, String tabla) {

    }

    private static void borrarDatos(SessionFactory sesion, String tabla) {

    }

}
