/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisComponentes.JPodometro;

import java.util.EventObject;

/**
 *
 * @author usuario
 */
public class JPodometroEvent extends EventObject{
    
    private double distanciaRecorrida;
    private int tiempoTranscurrido;
    
    public JPodometroEvent(Object source) {
        super(source);
    }
    
    public JPodometroEvent(Object source, double distaciaRecorrida, int tiempoTranscurrido){
        super(source);
        this.distanciaRecorrida=distaciaRecorrida;
        this.tiempoTranscurrido=tiempoTranscurrido;
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }


    public int getTiempoTranscurrido() {
        return tiempoTranscurrido;
    }
    
}
