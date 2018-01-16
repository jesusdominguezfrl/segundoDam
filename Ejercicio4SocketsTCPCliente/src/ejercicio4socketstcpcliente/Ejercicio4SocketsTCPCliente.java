/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4socketstcpcliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class Ejercicio4SocketsTCPCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final String HOST = "localhost";
        final int PUERTO = 6000;
        Scanner leer = new Scanner(System.in);
        String cadenaLeida;

        System.out.println("Cliente iniciado");
        try {
            Socket cliente = new Socket(HOST, PUERTO);

            OutputStream osSalida = cliente.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(osSalida);

            InputStream isEntrada;
            DataInputStream flujoEntrada;

            do {
                System.out.println("Introduce una cadena para enviar al servidor('*' para termminar):");
                cadenaLeida = leer.nextLine();
                flujoSalida.writeUTF(cadenaLeida);
                isEntrada = cliente.getInputStream();
                flujoEntrada = new DataInputStream(isEntrada);
                System.out.println(flujoEntrada.readUTF());
            } while (!"*".equals(cadenaLeida));
        } catch (IOException e) {
            System.out.println("Terminando cliente");
        }
    }
}
