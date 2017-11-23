/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_conectoresv3.pkg6;

import com.db4o.*;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class bbddObjetos {

    private static String BDEmpl = "ejemplo.yep";
    private static Scanner leer = new Scanner(System.in);
    private static ObjectContainer bd;

    protected static void crearBaseDatos() {
        bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDEmpl);

        Departamento dpto1 = new Departamento(10, "Contabilidad", "Sevilla");
        Departamento dpto2 = new Departamento(20, "Investigacion", "Madrid");
        Departamento dpto3 = new Departamento(30, "Ventas", "Barcelona");
        Departamento dpto4 = new Departamento(40, "Produccion", "Bilbao");

        bd.store(dpto1);
        bd.store(dpto2);
        bd.store(dpto3);
        bd.store(dpto4);

        Empleado p1 = new Empleado(1, "López", "contable", 345, "1987-10-23", 23400.32f, 5.34f, 10);
        Empleado p2 = new Empleado(2, "Santana", "contable", 345, "1980-09-23", 33670.20f, 8.84f, 10);
        Empleado p3 = new Empleado(3, "Santana", "contable", 345, "1980-09-23", 33670.20f, 8.84f, 10);
        Empleado p4 = new Empleado(4, "Gil", "investigad", 245, "1987-01-23", 23400.32f, 5.34f, 20);
        Empleado p5 = new Empleado(5, "Lorenzo", "investigad", 246, "1992-12-23", 20400.32f, 3.34f, 20);
        Empleado p6 = new Empleado(6, "Manteca", "investigad", 245, "2000-10-23", 33670.20f, 8.84f, 20);
        Empleado p7 = new Empleado(7, "Tocino", "vendedor", 445, "2003-05-23", 23400.32f, 5.34f, 30);
        Empleado p8 = new Empleado(8, "Malo", "vendedor", 446, "1994-06-23", 20400.32f, 3.34f, 30);
        Empleado p9 = new Empleado(9, "Salamanca", "vendedor", 445, "2004-08-23", 33670.20f, 8.84f, 30);
        Empleado p10 = new Empleado(10, "Iglesias", "productor", 145, "1987-01-23", 33400.32f, 15.34f, 40);
        Empleado p11 = new Empleado(11, "Martín", "productor", 146, "2004-12-23", 28400.32f, 13.34f, 40);
        Empleado p12 = new Empleado(12, "Soroya", "productor", 145, "1980-10-23", 43670.20f, 18.84f, 40);

        bd.store(p1);
        bd.store(p2);
        bd.store(p3);
        bd.store(p4);
        bd.store(p5);
        bd.store(p6);
        bd.store(p7);
        bd.store(p8);
        bd.store(p9);
        bd.store(p10);
        bd.store(p11);
        bd.store(p12);

        bd.close();
    }

    public void mostrarEmpleados() {
        bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDEmpl);
        Empleado emp = new Empleado(0, null, null, 0, null, 0, 0, 0);
        ObjectSet<Empleado> todosEmpleados = bd.queryByExample(emp);
        if (todosEmpleados.isEmpty()) {
            System.out.println("No existen registros de Empleados.");
        } else {
            System.out.printf("Hay %1 registros.", todosEmpleados.size());
            while (todosEmpleados.hasNext()) {
                Empleado e = todosEmpleados.next();
                System.out.printf("Empleado: %1\nApellido: %2\nOficio: %3\ndir: %4\nFecha de alta: %5\nSalario: %6\nComisión: %7\nNúmero de departamento: %8",
                        e.getnEM(), e.getApell(), e.getOficio(), e.getDir(), e.getFecha(), e.getSalario(), e.getComision(), e.getnDep());
            }
        }
        bd.close();
    }

    public void nuevoEmpleado() {
        int nEM, dir, nDep;
        float salario, comision;
        String apellido, oficio, fecha;
        System.out.print("Introduce número de empleado: ");
        nEM = leer.nextInt();
        System.out.print("Introduce apellido de empleado: ");
        apellido = leer.next();
        System.out.print("Introduce oficio de empleado: ");
        oficio = leer.next();
        System.out.println("Introduce dir de empleado: ");
        dir = leer.nextInt();
        System.out.println("Introduce fecha de alta de empleado (aaaa-mm-dd): ");
        fecha = leer.next();
        System.out.println("Introduce salario de empleado");
        salario = leer.nextFloat();
        System.out.println("Introduce comision de empleado: ");
        comision = leer.nextFloat();
        System.out.println("Introduce número de departamento de empleado: ");
        nDep = leer.nextInt();

        bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDEmpl);
        Empleado nuevo = new Empleado(nEM, apellido, oficio, dir, fecha, salario, comision, nDep);
        bd.store(nuevo);
        bd.close();
    }

    public void mostrarDepartamentos() {
        bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDEmpl);
        Departamento dpto = new Departamento(0, null, null);
        ObjectSet<Departamento> todosDepartamentos = bd.queryByExample(dpto);
        if (todosDepartamentos.isEmpty()) {
            System.out.println("No existen Departamentos.");
        } else {
            System.out.printf("Hay %1 departamentos.", todosDepartamentos.size());
            while (todosDepartamentos.hasNext()) {
                Departamento dp = todosDepartamentos.next();
                System.out.printf("Departamento No: %3d \nNombre: %20s \nLocalizacion: %20s", dp.getDept_no(), dp.getNombre(), dp.getNombre());

            }
        }
        bd.close();
    }

    public void consultas() {
        int opcion;
        Departamento dpto;
        ObjectSet<Departamento> todosDepartamentos;
        bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDEmpl);
        Empleado emp;
        ObjectSet<Empleado> todosEmpleados = bd.queryByExample(emp);
        do {            
            System.out.println("Consultas:\n\t 1-Apellido de todos los empleados del departamento de VENTAS\n\t2- Apellido de todos los empleados contratados entre 1980 y 1990\n\t3-Nombre de departamento y la suma de sus salarios\n\t0-Salir\n\nIntroduce una opcion: ");
            opcion=leer.nextInt();
            switch(opcion){
                case 1:
                    //Empleados departamento ventas.
                    dpto = new Departamento(0, "Ventas", null);
                    todosDepartamentos = bd.queryByExample(dpto);
                    emp= new Empleado(0, null, null, 0, null, 0, 0, todosDepartamentos);
                    break;
                case 2:
                    //Apellidos de todos -- 1800-1900
                    
                    break;
                case 3:
                    //Nombre dpto y suma de salario 
                    
                    break;
            }
        } while (opcion!=0);
        bd.close();

    }

    public void modificarEmpleado() {
        System.out.println("Indica el numero de empleado que quiere modificar:");
        int nEM = leer.nextInt();
        bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDEmpl);
        Empleado emp = new Empleado(nEM, null, null, 0, null, 0, 0, 0);
        
        System.out.print("Introduce número de empleado: ");
        emp.setnEM(leer.nextInt());
        System.out.print("Introduce apellido de empleado: ");
        emp.setApell(leer.next());
        System.out.print("Introduce oficio de empleado: ");
        emp.setOficio(leer.next());
        System.out.println("Introduce dir de empleado: ");
        emp.setDir(leer.nextInt());
        System.out.println("Introduce fecha de alta de empleado (aaaa-mm-dd): ");
        emp.setFecha(leer.next());
        System.out.println("Introduce salario de empleado");
        emp.setSalario(leer.nextFloat());
        System.out.println("Introduce comision de empleado: ");
        emp.setComision(leer.nextFloat());
        System.out.println("Introduce número de departamento de empleado: ");
        emp.setnDep(leer.nextInt());

        bd.close();
    }

    public void borrarEmpleado() {
        System.out.println("Indica el numero de empleado que quiere borrar:");
        int nEM = leer.nextInt();
        bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDEmpl);
        Empleado emp = new Empleado(nEM, null, null, 0, null, 0, 0, 0);
        bd.delete(emp);
        bd.close();
    }
}
