/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisComponentes.ComponenteMetronomo;

import java.util.EventListener;

/**
 *
 * @author usuario
 */
public interface MetronomoListener extends EventListener {
    
    public void metronomoPulso(MetronomoEvent evt);
    
    public void metronomoFin(MetronomoEvent evt);
}
