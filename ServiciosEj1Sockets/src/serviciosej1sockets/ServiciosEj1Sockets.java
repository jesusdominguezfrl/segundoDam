/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosej1sockets;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author usuario
 */
public class ServiciosEj1Sockets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /***Servidor***/
        ServerSocket servidor=null;
        Socket conexionCliente=null;
        InputStream isEntradaCliente=null;
        try{
            servidor= new ServerSocket(50000);
            conexionCliente= servidor.accept(); //Espera una conexion
            isEntradaCliente=conexionCliente.getInputStream();
            DataInputStream disFlujoEntrada= new DataInputStream(isEntradaCliente);
            String mensaje = disFlujoEntrada.readLine();
            while (mensaje!= null){
                System.out.println(mensaje);
                mensaje= disFlujoEntrada.readLine();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }
    
}
