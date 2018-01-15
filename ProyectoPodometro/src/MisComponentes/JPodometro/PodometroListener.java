/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisComponentes.JPodometro;

import java.util.EventListener;


/**
 *
 * @author usuario
 */
public interface PodometroListener extends EventListener{
    
    public void podometroSalida(PodometroEvent evt);
    
    public void podometroMeta (PodometroEvent evt);
    
}
