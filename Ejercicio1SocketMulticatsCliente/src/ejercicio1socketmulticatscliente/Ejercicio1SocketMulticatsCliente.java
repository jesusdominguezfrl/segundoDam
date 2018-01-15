/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1socketmulticatscliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author usuario
 */
public class Ejercicio1SocketMulticatsCliente {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        int PUERTO = 6000;
        String mensajeRecibido;
        MulticastSocket ms = new MulticastSocket(PUERTO);
        InetAddress grupo = InetAddress.getByName("224.0.0.99");
        do {
            ms.joinGroup(grupo);
            byte[] bufered = new byte[1000];
            DatagramPacket paquete = new DatagramPacket(bufered, bufered.length);
            ms.receive(paquete);
            ms.leaveGroup(grupo);
            mensajeRecibido = new String(paquete.getData());
            System.out.println(mensajeRecibido);
        } while (!"*".equals(mensajeRecibido.trim()));
        ms.close();

    }

}
