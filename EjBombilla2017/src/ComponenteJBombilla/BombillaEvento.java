/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteJBombilla;

import java.util.EventObject;

/**
 *
 * @author Jesus
 */
public class BombillaEvento extends EventObject{
    
    private int numeroEncendidos=-1;
    
    public BombillaEvento(Object source, int numeroEncendidos) {
        super(source);
        this.numeroEncendidos=numeroEncendidos;
    }
    
    public BombillaEvento(Object source) {
        super(source);
    }

    public int getNumeroEncendidos() {
        return numeroEncendidos;
    }
    
}
