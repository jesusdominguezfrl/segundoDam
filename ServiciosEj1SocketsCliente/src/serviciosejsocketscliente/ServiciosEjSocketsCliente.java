/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosejsocketscliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class ServiciosEjSocketsCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String HOST = "localhost";
        int PUERTO = 6000;
        System.out.println("PROGRAMA CLIENTE INICIADO");
        Socket Cliente;
        try {
            Cliente = new Socket(HOST, PUERTO);
            //Entrada
            InputStream entrada = Cliente.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);
            
            String mensajeServidor= flujoEntrada.readUTF();
            System.out.println("Recibiendo del SERVIDOR:\n\t" + mensajeServidor);
            
            //Salida
            OutputStream salida = Cliente.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);
            flujoSalida.writeUTF(mensajeServidor+"Devuelto por cliente");

            entrada.close();
            flujoEntrada.close();
            salida.close();
            flujoSalida.close();
            Cliente.close();
        } catch (Exception e) {
            System.out.println("Excepcion: "+ e.getMessage());
        }
    }//MAIN

}
