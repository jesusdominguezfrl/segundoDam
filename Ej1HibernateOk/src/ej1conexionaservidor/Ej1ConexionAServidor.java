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
    public static void main(String[] args) {
        SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("Inserción de una fila en la tabla Departamentos.");
        Scanner scr = new Scanner(System.in);
        Departamentos depart = new Departamentos();
        System.out.println("Número departamento: ");
        depart.setDeptNo((byte) Integer.parseInt(scr.nextLine()));
        System.out.println("Nombre departamento: ");
        depart.setDnombre(scr.nextLine());
        System.out.println("Localización: ");
        depart.setLoc(scr.nextLine());//Inserción de un departamento

        session.save(depart);
        tx.commit();
        session.close();
    }

}
