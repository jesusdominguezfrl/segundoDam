/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisComponentes.JPodometro;

/**
 *
 * @author usuario
 */
public interface JPodometroListener {
    
    public void podometroSalida(JPodometroEvent evt);
    
    public void podometroMeta (JPodometroEvent evt);
    
//    public void cambio(JPodometroEvent evt); 
}
