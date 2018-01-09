/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1bsocketsudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author usuario
 */
public class Ejercicio1BSocketsUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            DatagramSocket socketUDP = new DatagramSocket();
            byte[] bufer = new byte[1024];

            System.out.println("Esperando datagrama");
            DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
            socketUDP.receive(recibo);
            int bytesRec = recibo.getLength();
            String paquete = new String(recibo.getData());

            //VISIUALIZO INFORMACIÓN
            System.out.print("\nDatagrama recibido: " + paquete.trim());
            System.out.print("\nNumero de bytes del Datagrama recibido: " + bytesRec);
            System.out.println("\nDesde el puerto origen: " + recibo.getPort());
            System.out.print("Datagrama recibido del host: " + recibo.getAddress().getHostAddress());
            System.out.println("\nPuerto destino del mensaje: " + socketUDP.getLocalPort());

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }

    }
}
