/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosej2socketsservidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author usuario
 */
public class ServiciosEj2SocketsServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int PUERTO = 50000;
        try {
            ServerSocket Servidor = new ServerSocket(PUERTO);
            System.out.println("Escucho el puerto " + PUERTO);
            System.out.println("Esperando al cliente.... ");
            Socket Clienteconectado = Servidor.accept(); 
            InputStream entrada = Clienteconectado.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);
            OutputStream salida = Clienteconectado.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);
            flujoSalida.writeUTF("Mesaje de envio al cliente");
           // System.out.println("Recibiendo del CLIENTE:\n\t" + flujoEntrada.readUTF());

            entrada.close();
            flujoEntrada.close();
            salida.close();
            flujoSalida.close();
            Clienteconectado.close();
            Servidor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
}
