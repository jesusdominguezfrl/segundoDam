/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4socketstcpservidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Jesus
 */
public class Ejercicio4SocketsTCPServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final int PUERTO=6000;
        
        try {
            ServerSocket servidor = new ServerSocket(PUERTO); 
            System.out.println("Esperando en puerto "+ PUERTO);
            Socket clienteConexion= servidor.accept(); //se crea el objeto Socket
            
            //Flujo entrada cliente
            InputStream isEntrada= clienteConexion.getInputStream();
            DataInputStream flujoEntrada= new DataInputStream(isEntrada);
            //Objetos flujo salida
            OutputStream osSalida;
            DataOutputStream flujoSalida;
            String lineaDelCliente=flujoEntrada.readUTF();
            while (!"*".equals(lineaDelCliente)){
                osSalida=clienteConexion.getOutputStream();
                flujoSalida=new DataOutputStream(osSalida);
                flujoSalida.writeUTF("Devuleto por servidor: "+lineaDelCliente);
                
                
                isEntrada= clienteConexion.getInputStream();
                flujoEntrada= new DataInputStream(isEntrada);
                lineaDelCliente=flujoEntrada.readUTF();
            }
            System.out.println("Finalizando servidor ☺");
            isEntrada.close();
            flujoEntrada.close();
//            osSalida.close();
//            flujoSalida.close();
            clienteConexion.close();
            servidor.close();
            
        } catch (IOException e) {
        }

    }
    
}
