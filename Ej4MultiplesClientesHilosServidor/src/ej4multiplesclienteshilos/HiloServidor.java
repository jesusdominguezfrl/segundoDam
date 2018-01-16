/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej4multiplesclienteshilos;

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
class HiloServidor extends Thread {

    private Socket cliente;
    private InputStream entrada;
    private DataInputStream flujoEntrada;
    private OutputStream salida;
    private DataOutputStream flujoSalida;

    public HiloServidor(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        String mensaje = "";
        try {
            do {
                entrada = this.cliente.getInputStream();
                flujoEntrada = new DataInputStream(entrada);
                mensaje = flujoEntrada.readUTF().toUpperCase();
                salida = this.cliente.getOutputStream();
                flujoSalida = new DataOutputStream(salida);
                flujoSalida.writeUTF(mensaje);

            } while (!"*".equals(mensaje));

            entrada.close();
            flujoEntrada.close();
            salida.close();
            flujoSalida.close();
            this.cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
