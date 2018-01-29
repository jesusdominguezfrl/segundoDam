/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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
public class ModeloHibernate {

    Scanner leer = new Scanner(System.in);

    public void insertarEmpleado() {
        try {
            SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
            Session session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            Empleados em = new Empleados();
            Departamentos depart = new Departamentos();
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
            em.setComision(Float.parseFloat(leer.nextLine()));
            System.out.print("Introduce un numero de departamento: ");
            depart.setDeptNo(Byte.parseByte(leer.nextLine()));
            em.setDepartamentos(depart);
            java.util.Date hoy = new java.util.Date();
            java.sql.Date fecha = new java.sql.Date(hoy.getTime());
            em.setFechaAlta(fecha);
            session.save(em);
            tx.commit();
            session.close();
            sesion.close();
            System.out.println("**Registro insertado con exito***");
        } catch (NumberFormatException e) {
            System.out.println("No se ha podido introducir el Empleado.");
        }
    }

    public void insertarDepartamento() {
        try {
            SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
            Session session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            Departamentos depart = new Departamentos();
            System.out.print("Introduce un Numero de departamento: ");
            depart.setDeptNo(Byte.parseByte(leer.nextLine()));
            System.out.print("Introduce un nombre: ");
            depart.setDnombre(leer.nextLine());
            System.out.print("Introduce una localizacion: ");
            depart.setLoc(leer.nextLine());
            session.save(depart);
            tx.commit();
            session.close();
            sesion.close();
            System.out.println("**Registro insertado con exito***");
        } catch (NumberFormatException e) {
            System.out.println("No se ha podido introducir el Departamento.");
        }
    }

    public void modificarEmpleado() {
        try {
            SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
            Session session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            Empleados em = new Empleados();
            System.out.print("Indique el numero del empleado que quiere modificar: ");
            em = (Empleados) session.load(Empleados.class, Short.parseShort(leer.nextLine()));
            System.out.println("Datos actuales: " + em);
            System.out.print("Introduce un apellido: ");
            em.setApellido(leer.nextLine());
            System.out.print("Introduce un dir: ");
            em.setDir(Integer.parseInt(leer.nextLine()));
            System.out.print("Introduce un oficio: ");
            em.setOficio(leer.nextLine());
            System.out.print("Introduce un salario: ");
            em.setSalario(Float.parseFloat(leer.nextLine()));
            System.out.print("Introduce una comision: ");
            em.setComision(Float.parseFloat(leer.nextLine()));
            System.out.print("Introduce un numero de departamento: ");
            Departamentos depart = new Departamentos();
            depart.setDeptNo(Byte.parseByte(leer.nextLine()));
            em.setDepartamentos(depart);
            session.update(em);
            tx.commit();
            session.close();
            sesion.close();
            System.out.println("**Registro modificado con exito***");
        } catch (NumberFormatException e) {
            System.out.println("No se ha podido modificar el Empleado.");
        }

    }

    public void modificarDepartamento() {
        try {
            SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
            Session session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            Departamentos depart = new Departamentos();
            System.out.print("Introduce el numero del departamento que quieres modificar: ");
            depart = (Departamentos) session.load(Departamentos.class, Byte.parseByte(leer.nextLine()));
            System.out.println("Datos actuales: " + depart);
            System.out.print("Introduce un nombre: ");
            depart.setDnombre(leer.nextLine());
            System.out.print("Introduce una localizacion: ");
            depart.setLoc(leer.nextLine());
            session.update(depart);
            tx.commit();
            session.close();
            sesion.close();
            System.out.println("**Registro modificado con exito***");
        } catch (NumberFormatException e) {
            System.out.println("No se ha podido modificar el Departamento.");
        }
    }

    public void borrarEmpleado() {
        try {
            SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
            Session session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            Empleados em = new Empleados();
            System.out.print("Indique el numero del empleado que quiere borrar: ");
            em = (Empleados) session.load(Empleados.class, Short.parseShort(leer.nextLine()));
            System.out.println("Datos actuales: " + em);
            if (validaOpcion()) {
                session.delete(em);
                tx.commit();
            }
            session.close();
            sesion.close();
            System.out.println("**Registro borrado con exito***");
        } catch (NumberFormatException e) {
            System.out.println("No se ha podido borrar el Empleado.");
        }
    }

    public void borrarDepartamento() {
        try {
            SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
            Session session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            Departamentos depart = new Departamentos();
            System.out.print("Introduce el numero del departamento que quieres borrar: ");
            depart = (Departamentos) session.load(Departamentos.class, Byte.parseByte(leer.nextLine()));
            System.out.println("Datos actuales: " + depart);
            String opcion;
            if (validaOpcion()) {
                session.delete(depart);
                tx.commit();
            }
            session.close();
            sesion.close();
            System.out.println("**Registro borrado con exito***");
        } catch (NumberFormatException e) {
            System.out.println("No se ha podido borrar el Empleado.");
        }
    }

    private boolean validaOpcion() {
        String opcion;
        do {
            System.out.print("Esta seguro que quiere borrar el registro ¿? \n\t1-Si\n\t2-No\nOpcion: ");
            switch (opcion = leer.nextLine()) {
                case "1":
                    return true;
                case "2":
                    return false;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (!"1".equals(opcion) || !"2".equals(opcion));
        return false;
    }
    
    

}
