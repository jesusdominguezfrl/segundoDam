/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisComponentes.JBombilla;

import java.util.EventListener;

/**
 *
 * @author usuario
 */
public interface JBombillaListener extends EventListener{
    
    public void bombillaEncendida(JBombillaEvent evt);
    
    public void bombillaAgotada(JBombillaEvent evt);
    
}
