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
import java.util.Arrays;

/**
 *
 * @author usuario
 */
public class Ejercicio1SocketMulticatsCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int PUERTO = 6000;
        MulticastSocket ms = new MulticastSocket(PUERTO);
        InetAddress grupo = InetAddress.getByName("224.0.0.99");
        ms.joinGroup(grupo);
        byte[] buf = new byte[1000];
        DatagramPacket paquete = new DatagramPacket(buf, buf.length);
        ms.receive(paquete);
        ms.leaveGroup(grupo);
        System.out.println(Arrays.toString(paquete.getData()));
        ms.close();

    }

}
