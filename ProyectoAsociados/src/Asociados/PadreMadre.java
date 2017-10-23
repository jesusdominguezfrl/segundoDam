/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asociados;

/**
 *
 * @author Jesus
 */
public class PadreMadre  extends Asociado{

    //<editor-fold defaultstate="collapsed" desc="Constructores"> 
    //Constructores.
        
    public PadreMadre(String nombre, String apellidos, String NIF) {
        super(nombre, apellidos, NIF);
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="SobreescrituraMAbstractos"> 
    //Sobreescritura de los metodos abstractos de la clase base (Asociado).
    
    @Override
    public String verDatos() {
        return "Padre o madre: "+super.toString();
    }

    @Override
    public double verCuota() {
        return getCuota()*50/100;
    }
    //</editor-fold>
    
}
