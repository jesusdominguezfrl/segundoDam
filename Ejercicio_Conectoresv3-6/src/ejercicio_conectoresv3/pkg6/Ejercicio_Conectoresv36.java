/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_conectoresv3.pkg6;

import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Ejercicio_Conectoresv36 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        bbddObjetos bd =new bbddObjetos();
        
         Scanner leer = new Scanner(System.in);
        int opcion;
        do {
            System.out.print("\t0- Salir\n\t1- Crear BBDD.\n\t2- Mostrar departamentos.\n\t3- Mostrar datos empleados.\n\t4- Mostrar resultado de Ejercicio 1.\n\t5- Insertar un nuevo empleado.\n\t6- Modificar un empleado.\n\t7- Borrar un empleado.\nIndique una opcion del menu:");
            opcion = leer.nextInt();
            System.out.println();
            switch (opcion) {
                case 1:
                    bd.crearBaseDatos();
                    break;
                case 2:
                    bd.mostrarDepartamentos();//1
                    break;
                case 3:
                    bd.mostrarEmpleados();//
                    break;
                case 4:
                    bd.consultas();
                    break;
                case 5:
                    bd.nuevoEmpleado();//
                    break;
                case 6:
                    bd.modificarEmpleado();
                    break;
                case 7:
                    bd.borrarEmpleado();//
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        } while (true);

    }
    
}
