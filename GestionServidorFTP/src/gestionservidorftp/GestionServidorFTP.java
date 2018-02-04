/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionservidorftp;

import Server.ServidorFTP;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class GestionServidorFTP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String opcion;
        System.out.print("Indique la direccion de un servidor: ");
        String servidorFTP=leer.nextLine();
        ServidorFTP server= new ServidorFTP(servidorFTP);
        System.out.println("**********Gestion Servidor FTP**********");
        do {
            System.out.println("Escoja una opcion del siguiente menu: "
                    + "\n\t1-Conectar de forma anonima."
                    + "\n\t2-Conectar con autentificacion."
                    + "\n\t3-Listar contenido del directorio actual."
                    + "\n\t4-Cambiar de directorio."
                    + "\n\t5-Crear nuevo directorio."
                    + "\n\t6-Mostrar directorio actual."
                    + "\n\t7-Subir fichero."
                    + "\n\t8-Descargar fichero."
                    + "\n\t9-Renombrar fichero."
                    + "\n\t10-Borrar fichero."
                    + "\n\t0-Salir.");
            System.out.print("→");
            opcion = leer.nextLine();

            switch (opcion) {
                case "1":
                    server.conexionAnonima();
                    break;
                case "2":
                    server.conexionAutentificada();
                    break;
                case "3":
                    server.listaDirectorio();
                    break;
                case "4":
                    server.cambiaDirectorio();
                    break;
                case "5":
                    server.creaDirectorio();
                    break;
                case "6":
                    server.directorioActual();
                    break;
                case "7":
                    server.subeFichero();
                    break;
                case "8":
                    server.descargaFichero();
                    break;
                case "9":
                    server.renombrarFichero();
                    break;
                case "10":
                    server.borrarFichero();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        } while (!"0".equals(opcion));
        System.out.println("Cerrando conexion.....");
        server.cerrarConexion();
    }
    
}
