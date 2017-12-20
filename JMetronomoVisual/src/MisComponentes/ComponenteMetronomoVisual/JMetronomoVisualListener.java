/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisComponentes.ComponenteMetronomoVisual;

import java.util.EventListener;

/**
 *
 * @author usuario
 */
public interface JMetronomoVisualListener extends EventListener {
    public void metronomoPulso(JMetronomoVisualEvent evt);
    
    public void metronomoFin(JMetronomoVisualEvent evt);
}
