/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1socketsudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author usuario
 */
public class Ejercicio1SocketsUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        try {
            DatagramSocket socketUDP = new DatagramSocket();
            InetAddress destino = InetAddress.getByName("localhost");
            int puerto = 12345;
            byte[] mensaje = new byte[1024];
            String saludo = "Enviando slaudo";
            mensaje = saludo.getBytes();
            DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length,destino, puerto);

            System.out.println("Enviando Datagrama de longitud:  " + mensaje.length);
            System.out.println("Host destino:  " + destino.getHostName());
            System.out.println("IP destino:  " + destino.getHostAddress());
            System.out.println("Puerto local del socket:  " + socketUDP.getLocalPort());
            System.out.println("Puerto al que envio:  " + envio.getPort());
            
            socketUDP.send(envio);
            
            socketUDP.close();
            
        } catch (SocketException e) {
            System.out.println("Socket: "+ e.getMessage());
        } catch (IOException e){
            System.out.println("IO: " +e.getMessage() );
        }
    }

}
