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
public class Profesor  extends Asociado{
    
    //Definicion de miembros de la clase
    
    private String especialidad;

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    //Constructores
    
    public Profesor(String nombre, String apellidos, String NIF, String especialidad) {
        super(nombre, apellidos, NIF);
        this.especialidad=especialidad;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="AccesoMiembros">
    //Acceso a miembros privados de la clase 

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="SobreescrituraMAbstractos"> 
    //Sobreescritura de metodos abstractos de la clase base (Asociado)
    
    @Override
    public String verDatos() {
        return "Profesor: "+super.toString()+getEspecialidad();
    }

    @Override
    public double verCuota() {
        return getCuota();
    }

    //</editor-fold>
    
    
}
