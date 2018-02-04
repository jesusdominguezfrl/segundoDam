/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
 *
 * @author Jesus
 */
public class ServidorFTP {

    String servidorFTP;
    FTPClient cliente = new FTPClient();
    Scanner leer = new Scanner(System.in);

    public ServidorFTP(String servidorFTP) {
        this.servidorFTP = servidorFTP;
    }

    
    public void cerrarConexion(){
        try {
            cliente.logout();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        
        }
    }
    
    public void conexionAnonima() {
        try {
            cliente.connect(servidorFTP);
            cliente.setFileType(FTP.BINARY_FILE_TYPE);
            System.out.println("Conexion realizada con exito");
        } catch (Exception e) {
            System.out.println("No se pudo establecer una conexion con el servidor");
            System.out.println(e.getMessage());
        }
    }

    public void conexionAutentificada() {
        try {
            System.out.print("Introduce el nombre de usuario: ");
            String username = leer.nextLine();
            System.out.print("Introduce la contraseña: ");
            String password = leer.nextLine();
            cliente.connect(servidorFTP);
            cliente.login(username, password);
            cliente.setFileType(FTP.BINARY_FILE_TYPE);
            System.out.println("Conexion realizada con exito");
        } catch (Exception e) {
            System.out.println("No se pudo establecer una conexion con el servidor");
            System.out.println(e.getMessage());
        }
    }

    public void listaDirectorio() {
        directorioActual();
        try {
            cliente.enterLocalPassiveMode();
            System.out.println("\n\t*****Contenido del directorio*****");
            System.out.printf("%-40s%-10s\n", "Nombre", "Tamaño");
            for (FTPFile f : cliente.listFiles()) {
                System.out.printf("%-40s%-10s\n", f.getName(), f.getSize());
            }

        } catch (Exception e) {
            System.out.println("No se pudo mostrar el contenido del directorio");
            System.out.println(e.getMessage());
        }
    }

    public void cambiaDirectorio() {
        try {
            cliente.enterLocalPassiveMode();
            System.out.print("Indica el directorio al que quieres acceder (desde el actual, use un . para ir al directorio anterior): ");
            String directorio = leer.nextLine();
            if (".".equals(directorio)) cliente.changeToParentDirectory();
            else cliente.changeWorkingDirectory(cliente.printWorkingDirectory() +"/"+ directorio);
            directorioActual();
        } catch (Exception e) {
            System.out.println("No se ha podido cambiar de directorio");
        }
    }

    public void creaDirectorio() {
        try {
            directorioActual();
            cliente.enterLocalActiveMode();
            System.out.print("Indica el nombre dle directorio que quieres crear (se creara en el directorio Actual): ");
            cliente.makeDirectory(leer.nextLine());
            listaDirectorio();
        } catch (Exception e) {
            System.out.println("No se ha podido crear el directorio");
        }
    }

    public void subeFichero(){
        try {
            directorioActual();
            cliente.enterLocalActiveMode();
            System.out.print("Indica la ruta donde se encuentra el fichero (acabdo en / o \\): ");
            String archivoLocal = leer.nextLine();
            System.out.print("Indica el nombre del fichero: ");
            String nombreFichero = leer.nextLine();
            BufferedInputStream buffIn = new BufferedInputStream(new FileInputStream(archivoLocal+nombreFichero));
            cliente.storeFile(cliente.printWorkingDirectory() +"/"+ nombreFichero, buffIn);
            System.out.println("Fichero subido correctamente.");
            listaDirectorio();
        } catch (Exception e) {
            System.out.println("No se ha podido subir el fichero");
        }
    }

    public void descargaFichero() {
        try {
            directorioActual();
            cliente.enterLocalActiveMode();
            System.out.print("Indica el nombre del fichero: ");
            String nombreFichero = leer.nextLine();
            System.out.print("Indica la ruta donde quiere descargar el fichero (acabdo en / o \\): ");
            String descargaLocal = leer.nextLine();
            BufferedOutputStream buffOut = new BufferedOutputStream(new FileOutputStream(descargaLocal + nombreFichero));
            if (cliente.retrieveFile(nombreFichero, buffOut)) {
                System.out.println("Descarga realizada con exito");
                buffOut.close();
            }
        } catch (Exception e) {
            System.out.println("No se ha podido descargar el fichero");
        }
    }

    public void renombrarFichero() {
        try {
            directorioActual();
            cliente.enterLocalActiveMode();
            System.out.print("Indica el nombre actual del fichero: ");
            String nombreActual = leer.nextLine();
            System.out.print("Indica el nombre nuevo del fichero: ");
            String nombreNuevo = leer.nextLine();
            cliente.rename(nombreActual, nombreNuevo);
            System.out.println("Fichero renombrado con exito");
            listaDirectorio();
        } catch (Exception e) {
            System.out.println("No se ha podido renombrar el fichero");
        }
    }

    public void borrarFichero() {
        try {
            directorioActual();
            cliente.enterLocalActiveMode();
            System.out.print("Indica el nombre del fichero que quiere borrar: ");
            String nombreFichero = leer.nextLine();
            cliente.dele(nombreFichero);
            listaDirectorio();
        } catch (Exception e) {
            System.out.println("No se ha podido borrar el fichero");
        }
    }

    public void directorioActual() {
        try {
            System.out.println("Directorio Actual → " + cliente.printWorkingDirectory());
        } catch (IOException ex) {
        }
    }

}
