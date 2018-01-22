/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisComponentes.JBombilla;

import java.util.EventObject;

/**
 *
 * @author usuario
 */
public class JBombillaEvent extends EventObject{
    
    private int numeroEncendidos=-1;
    private int segundosEncendida=-1;

    public JBombillaEvent(Object source) {
        super(source);
    }
    
    public JBombillaEvent(Object source, int numeroEncendidos, int segundosEncendida) {
        super(source);
        this.numeroEncendidos=numeroEncendidos;
        this.segundosEncendida=segundosEncendida;
    }
    
    /**
     * Numero de veces que la bombilla ha sido encendida
     * @return -1 cuando se lanza el evento Agotada 0 cuando se lanza el evento Repuesta
     */
    public int getNumeroEncendidos() {
        return numeroEncendidos;
    }

    /**
     * Valor de segundos que la bombilla lleva encendida
     * @return -1 cuando se lanza el evento Agotada 0 cuando se lanza el evento Repuesta
     */
    public int getSegundosEncendida() {
        return segundosEncendida;
    }
    
    
}
