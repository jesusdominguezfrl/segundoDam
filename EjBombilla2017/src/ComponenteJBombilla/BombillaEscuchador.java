/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteJBombilla;

import java.util.EventListener;

/**
 *
 * @author Jesus
 */
public interface BombillaEscuchador extends EventListener{
    
    public void encendida(BombillaEvento evt);
    
    public void agotada(BombillaEvento evt);
    
}
