/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1hibernate;

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
public class Ej1Hibernate {

    /**
     * @param args the command line arguments
     */
    private static final Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {

        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);
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

    private static void introducirDatos(SessionFactory sesion, String tabla) {
        if (tabla == null) {
            return;
        }
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Empleados em = new Empleados();
        Departamentos depart = new Departamentos();
        if ("empleados".equals(tabla)) {
            try {
                System.out.print("Introduce un Numero de empleado: ");
                em.setEmpNo(Short.parseShort(leer.nextLine()));
                System.out.print("Introduce un apellido: ");
                em.setApellido(leer.nextLine());
                System.out.print("Introduce un dir: ");
                em.setDir(Integer.parseInt(leer.nextLine()));
                System.out.print("Introduce un oficio: ");
                em.setOficio(leer.nextLine());
                System.out.print("Introduce un salario: ");
                em.setSalario(Float.parseFloat(leer.nextLine()));
                System.out.print("Introduce una comision: ");
                em.setSalario(Float.parseFloat(leer.nextLine()));
                System.out.print("Introduce un numero de departamento: ");
                depart.setDeptNo(Byte.parseByte(leer.nextLine()));
                em.setDepartamentos(depart);
                java.util.Date hoy = new java.util.Date();
                java.sql.Date fecha = new java.sql.Date(hoy.getTime());
                em.setFechaAlta(fecha);
                session.save(em);
                tx.commit();
            } catch (NumberFormatException e) {
                System.out.println("Algun dao de los introducidos no es correcto.");
            }
        } else {
            try {
                System.out.print("Introduce un Numero de departamento: ");
                depart.setDeptNo(Byte.parseByte(leer.nextLine()));
                System.out.print("Introduce un nombre: ");
                depart.setDnombre(leer.nextLine());
                System.out.print("Introduce una localizacion: ");
                depart.setLoc(leer.nextLine());
                session.save(depart);
                tx.commit();
            } catch (NumberFormatException e) {
                System.out.println("Algun dao de los introducidos no es correcto.");
            }
        }
        session.close();
    }

    private static void modificarDatos(SessionFactory sesion, String tabla) {
        if (tabla == null) {
            return;
        }
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        if ("empleados".equals(tabla)) {
            Empleados em = new Empleados();
            System.out.print("Indique el numero del empleado que quiere modificar: ");
            em = (Empleados) session.load(Empleados.class, Short.parseShort(leer.nextLine()));
            System.out.println("Datos actuales: " + em);
            try {
                System.out.print("Introduce un apellido: ");
                em.setApellido(leer.nextLine());
                System.out.print("Introduce un dir: ");
                em.setDir(Integer.parseInt(leer.nextLine()));
                System.out.print("Introduce un oficio: ");
                em.setOficio(leer.nextLine());
                System.out.print("Introduce un salario: ");
                em.setSalario(Float.parseFloat(leer.nextLine()));
                System.out.print("Introduce una comision: ");
                em.setSalario(Float.parseFloat(leer.nextLine()));
                System.out.print("Introduce un numero de departamento: ");
                Departamentos depart = new Departamentos();
                depart.setDeptNo(Byte.parseByte(leer.nextLine()));
                em.setDepartamentos(depart);
                session.update(em);
                tx.commit();
            } catch (NumberFormatException e) {
                System.out.println("Algun dato de los introducidos no es correcto.");
            }
        } else {
            Departamentos depart = new Departamentos();
            System.out.print("Introduce el numero del departamento que quieres modificar: ");
            depart = (Departamentos) session.load(Departamentos.class, Byte.parseByte(leer.nextLine()));
            System.out.println("Datos actuales: " + depart);
            try {
                System.out.print("Introduce un nombre: ");
                depart.setDnombre(leer.nextLine());
                System.out.print("Introduce una localizacion: ");
                depart.setLoc(leer.nextLine());
                session.update(depart);
                tx.commit();
            } catch (NumberFormatException e) {
                System.out.println("Algun dato de los introducidos no es correcto.");
            }
        }
        session.close();
    }

    private static void borrarDatos(SessionFactory sesion, String tabla) {
        if (tabla == null) {
            return;
        }
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        if ("empleados".equals(tabla)) {
            Empleados em = new Empleados();
            System.out.print("Indique el numero del empleado que quiere modificar: ");
            em = (Empleados) session.load(Empleados.class, Short.parseShort(leer.nextLine()));
            System.out.println("Datos actuales: " + em);
            String opcion;
            do {
                System.out.print("Esta seguro que quiere borrar el registro ¿? \n\t1-Si\n\t2-No");
                switch (opcion = leer.nextLine()) {
                    case "1":
                        session.delete(em);
                        tx.commit();
                        break;
                    case "2":
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                }
            } while (!"1".equals(opcion) || !"2".equals(opcion));
        } else {
            Departamentos depart = new Departamentos();
            System.out.print("Introduce el numero del departamento que quieres modificar: ");
            depart = (Departamentos) session.load(Departamentos.class, Byte.parseByte(leer.nextLine()));
            System.out.println("Datos actuales: " + depart);
            String opcion;
            do {
                System.out.print("Esta seguro que quiere borrar el registro ¿? \n\t1-Si\n\t2-No");
                switch (opcion = leer.nextLine()) {
                    case "1":
                        session.delete(depart);
                        tx.commit();
                        break;
                    case "2":
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                }
            } while (!"1".equals(opcion) || !"2".equals(opcion));

        }

    }

}
