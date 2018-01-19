/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej4multiplesclienteshilos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author usuario
 */
public class Ej4MultiplesClientesHilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int PUERTO = 6000;

        ServerSocket servidor = new ServerSocket(PUERTO);
        System.out.println("Servidor iniciado....");
        while (true) {
            Socket cliente = new Socket();
            cliente = servidor.accept();// esperando al cliente
            HiloServidor hilo = new HiloServidor(cliente);
            hilo.start();
        }
    }

}
