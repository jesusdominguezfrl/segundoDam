/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1servidorftpconexion;

import java.io.IOException;
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
        String servFTP = "ftp..es"; 
        FTPClient cliente = new FTPClient();
        try {
            cliente.connect(servFTP);
            System.out.print(cliente.getReplyString());
            respuesta = cliente.getReplyCode();
            if (!FTPReply.isPositiveCompletion(respuesta)) {
                cliente.disconnect();
            }
            
        } catch (Exception e) {
                cliente.disconnect();
        }

    }
}
