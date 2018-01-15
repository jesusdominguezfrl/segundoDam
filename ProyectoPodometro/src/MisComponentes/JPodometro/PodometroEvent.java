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
public class PodometroEvent extends EventObject{
    
    private double distanciaRecorrida=-1;
    private double tiempoTranscurrido=-1;
    
    public PodometroEvent(Object source) {
        super(source);
    }
    
    public PodometroEvent(Object source, double distaciaRecorrida, double tiempoTranscurrido){
        super(source);
        this.distanciaRecorrida=distaciaRecorrida;
        this.tiempoTranscurrido=tiempoTranscurrido;
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }


    public double getTiempoTranscurrido() {
        return tiempoTranscurrido;
    }
    
    
}
