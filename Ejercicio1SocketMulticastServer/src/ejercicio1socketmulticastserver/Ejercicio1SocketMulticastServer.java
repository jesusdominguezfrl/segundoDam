/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1socketmulticastserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

/**
 *
 * @author Jesus Dominguez
 */
public class Ejercicio1SocketMulticastServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        MulticastSocket ms = new MulticastSocket();
        InetAddress grupo = InetAddress.getByName("224.0.0.99");

        int PUERTO = 6000;
        String mensaje;
        do {
            System.out.println("Escribe un mensaje");
            mensaje = new Scanner(System.in).nextLine();
            DatagramPacket paquete = new DatagramPacket(mensaje.getBytes(), mensaje.length(), grupo, PUERTO);
            ms.send(paquete);

        } while (!"*".equals(mensaje));
        ms.close();
    
    }

}
