/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisComponentes.ComponenteAlarma;

import java.util.EventListener;

/**
 *
 * @author Jesus
 */
public interface JAlarmaListener extends EventListener{
    
    public void alarmaActivada(JAlarmaEvent evt);
    
    public void alarmaDisparada(JAlarmaEvent evt);
    
    public void alarmaDesactivada(JAlarmaEvent evt);
    
}
