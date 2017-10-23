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
public class PersonaNoDocente extends Asociado{
    
    //Definicion de los miembros de la clase
    private String puestoTrabajo;

    //<editor-fold defaultstate="collapsed" desc="Constructores"> 
    //Constructores.
    
    public PersonaNoDocente(String nombre, String apellidos, String NIF, String puestotrabajo) {
        super(nombre, apellidos, NIF);
        this.puestoTrabajo=puestotrabajo;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="AccesoMiembros"> 
    //Acceso a los miembros privados de la clase Lectura-Escritura.
    
    public String getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="SobreescrituraMAbstracto"> 
    // Sobreescritura de metodos abstractos de la clase base (Asociado)
    
    @Override
    public String verDatos() {
        return "Persona no docente: "+super.toString()+getPuestoTrabajo();
    }

    @Override
    public double verCuota() {
        return getCuota()*75/100;
    }
    //</editor-fold>
}
