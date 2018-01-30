/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1servidorftpconexion;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author usuario
 */
public class Ej1ServidorFTPConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int respuesta;
//        String servFTP = "ftp.rediris.es"; 
//        String servFTP = "ftp.usal.es"; 
//        String servFTP = "ftp.cdrom.com"; 
//        String servFTP = "ftp.unavarra.com"; 
//        String servFTP = "ftp.jcyl.es"; 
        String servFTP = "10.1.4.208"; 
        FTPClient cliente = new FTPClient();
        
        try {
            cliente.connect(servFTP);
            cliente.login("usuario","123456");
            System.out.print(cliente.getReplyString());
            System.out.println("");
//            cliente.changeWorkingDirectory("/Subir");//Cambiar directorio de trabajo
            System.out.println("Se cambió satisfactoriamente el directorio");
            //Activar que se envie cualquier tipo de archivo
            
            cliente.setFileType(FTP.BINARY_FILE_TYPE);
            BufferedInputStream buffIn = null;
            buffIn = new BufferedInputStream(new FileInputStream("C://prueba/hola.txt"));//Ruta del archivo para enviar
            cliente.enterLocalActiveMode();
            cliente.storeFile("hola.txt", buffIn);//Ruta completa de alojamiento en el FTP
//            cliente.completePendingCommand();
            buffIn.close(); //Cerrar envio de arcivos al FTP
            cliente.logout(); //Cerrar sesión
            respuesta = cliente.getReplyCode();
            if (!FTPReply.isPositiveCompletion(respuesta)) {
                cliente.disconnect();
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
                cliente.disconnect();
        }

    }
}
