/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisComponentes.ComponenteCuentaAtras;

import java.util.EventListener;

/**
 *
 * @author usuario
 */
public interface CuentaAtrasListener extends EventListener{
    
    public void boom(CuentaAtrasEvent evt);
    
}
