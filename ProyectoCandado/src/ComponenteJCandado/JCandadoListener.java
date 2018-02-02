/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteJCandado;

import java.util.EventListener;

/**
 *
 * @author usuario
 */
public interface JCandadoListener extends EventListener{
    
    public void bloqueado(JCandadoEvent evt);
    
    public void seleccionado(JCandadoEvent evt);
    
}
