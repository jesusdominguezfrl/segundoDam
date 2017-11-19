/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flota;

import javax.swing.DefaultListModel;

/**
 *
 * @author Jesus
 */
public abstract class Vehiculo {

    private final String Matricula;
    private final String NumeroBastidor;
    private final int AñoMatricula;
    private Boolean ITVPasada;
    private static DefaultListModel vehiculosFlota = new DefaultListModel();
    public Vehiculo(String Matricula, String NumeroBastidor, int AñoMatricula) {
        this.Matricula = Matricula;
        this.NumeroBastidor = NumeroBastidor;
        this.AñoMatricula = AñoMatricula;
        ITVPasada=false;
        vehiculosFlota.addElement(this);
    }

    @Override
    public String toString() {
        return Matricula;
    }

    public void pasaITV(){
        ITVPasada=true;
    }

    public Boolean getITVPasada() {
        return ITVPasada;
    }
    
    public String muestraDatos(){
        return "Matricula: "+ toString()+ "\nNumero Bastidor: "+NumeroBastidor+"\nAño Matriculacion: "+AñoMatricula;
    }

    public abstract String verDatosParticulares();
    
    
     public static DefaultListModel vehiculosFlota(){
        DefaultListModel lista = new DefaultListModel();
        Object [] objetos= new Object[vehiculosFlota.size()];
        vehiculosFlota.copyInto(objetos);
        for (Object o: objetos) {
            Vehiculo v = (Vehiculo) o;
            lista.addElement(v);
        }
        
        return lista;
    }

    
}

