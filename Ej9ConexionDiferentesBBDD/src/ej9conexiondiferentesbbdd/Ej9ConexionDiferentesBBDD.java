/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej9conexiondiferentesbbdd;

import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Ej9ConexionDiferentesBBDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String opcion;
        do {
            System.out.println("**********CONEXION DIFERENTES BBDD**********");
            System.out.println("Elige la BBDD a la que te quieres conectar:\n\t1-SQLite\n\t2-Derby\n\t3-HSQLDB\n\t4-H2\n\t0-Salir");
            System.out.print("Introduce una opcion: ");
            opcion = leer.nextLine();
            switch(opcion){
                case "1":
                    
                    break;
                case "2":
                    
                    break;
                case "3":
                    
                    break;
                case "4":
                    
                    break;
            }
            
        } while (!"0".equals(opcion));

        }
    

    
    }
