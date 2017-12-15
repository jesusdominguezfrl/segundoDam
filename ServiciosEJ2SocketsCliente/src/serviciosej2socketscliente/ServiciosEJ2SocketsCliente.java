/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosej2socketscliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author usuario
 */
public class ServiciosEJ2SocketsCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
      String HOST = "localhost";
        int PUERTO = 50000;
        try{
            System.out.println("PROGRAMA CLIENTE INICIADO");
            Socket Cliente = new Socket(HOST, PUERTO);
            InputStream entrada = Cliente.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);
            System.out.println("Recibiendo del SERVIDOR:\n\t" + flujoEntrada.readUTF());
            OutputStream salida = Cliente.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);
            flujoSalida.writeUTF(flujoEntrada.readUTF());

            entrada.close();
            flujoEntrada.close();
            salida.close();
            flujoSalida.close();
            Cliente.close();
            
        }catch(Exception e){
            System.out.println("Excepcion: "+e.getMessage());
        }
    }//MAIN
    
}
