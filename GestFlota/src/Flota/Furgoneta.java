/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flota;

/**
 *
 * @author Jesus
 */
public class Furgoneta extends Vehiculo {

    public enum TiposFurgoneta{PASAJEROS, CARGA}
    private TiposFurgoneta tipoFurgoneta;

    public Furgoneta(String Matricula, String NumeroBastidor, int AñoMatricula, TiposFurgoneta TipoFurgoneta) {
        super(Matricula, NumeroBastidor, AñoMatricula);
        this.tipoFurgoneta = TipoFurgoneta;
    }

    @Override
    public String toString() {
        return "Furgoneta: "+super.toString();
    }
    
    @Override
    public String verDatosParticulares() {
        return muestraDatos()+ "\nTipo: " + tipoFurgoneta;
    }

}
