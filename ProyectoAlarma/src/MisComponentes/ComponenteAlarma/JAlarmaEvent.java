/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisComponentes.ComponenteAlarma;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventObject;

/**
 *
 * @author Jesus
 */
public class JAlarmaEvent extends EventObject {
    
    private enum AccionesEvento{
        ALARMA_ACTIVADA ("¡ALARMA  ACTIVADA!"),
        ALARMA_DESACTIVADA_OK("ALARMA DESACTIVADA CON EXITO"),
        ALARMA_DESACTIVADA_ERROR("ERROR AL DESACTIVAR ALARMA"),
        ALARMA_DISPARADA("ALARMA DISPARADA");
        
        private String texto;
        
        private AccionesEvento(String texto){
            this.texto=texto;
        }
        
        @Override
        public String toString(){
            return this.texto;
        }
    }
    
    private AccionesEvento accionEvento;
    private String zona=null;
    private int intendosDesbloqueoFallidos=-1;
    private String fecha=null;
    
    
    public JAlarmaEvent(Object source, String zona) {
        super(source);
        this.zona=zona;
        fecha= new Date().toString();
        if(((JComponenteAlarma)this.source).isSensorZona1() ||((JComponenteAlarma)this.source).isSensorZona2())
            accionEvento=AccionesEvento.ALARMA_DISPARADA;
        else
            accionEvento=AccionesEvento.ALARMA_ACTIVADA;
        
    }
    
    public JAlarmaEvent(Object source, String zona, int intendosDesbloqueoFallidos) {
        super(source);
        this.zona=zona;
        this.intendosDesbloqueoFallidos=intendosDesbloqueoFallidos;
        fecha= new Date().toString();
        if(this.intendosDesbloqueoFallidos==0)accionEvento=AccionesEvento.ALARMA_DESACTIVADA_OK;
        else accionEvento=AccionesEvento.ALARMA_DESACTIVADA_ERROR;
    }

    public AccionesEvento getAccionEvento() {
        return accionEvento;
    }

    public String getZona() {
        return zona;
    }

    public int getIntendosDesbloqueoFallidos() {
        return intendosDesbloqueoFallidos;
    }

    public String getFecha() {
        return fecha;
    }
    
    @Override
    public String toString(){
        return this.accionEvento+" "+((accionEvento==AccionesEvento.ALARMA_DESACTIVADA_ERROR)?"Intento: "+this.intendosDesbloqueoFallidos+" de 3":this.zona);
    }
    
    
    
}
