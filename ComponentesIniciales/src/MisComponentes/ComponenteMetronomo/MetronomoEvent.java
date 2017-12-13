/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisComponentes.ComponenteMetronomo;

import java.util.EventObject;

/**
 *
 * @author usuario
 */
public class MetronomoEvent extends EventObject {
    
    private int pulsoActual= -1;
    
    public MetronomoEvent(JMetronomo source, int pulsoActual) {
        super(source);
        this.pulsoActual=pulsoActual;
    }

    public MetronomoEvent(JMetronomo source) {
        super(source);
    }
    public int getPulsoActual() {
        return pulsoActual;
    }

    public void setPulsoActual(int pulsoActual) {
        this.pulsoActual = pulsoActual;
    }

    
    
    
    
}
