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
public class Camion extends Vehiculo {

    private int Tara;

    public Camion(String Matricula, String NumeroBastidor, int AñoMatricula, int Tara) {
        super(Matricula, NumeroBastidor, AñoMatricula);
        this.Tara = Tara;
    }

    @Override
    public String toString() {
        return "Camión: "+super.toString();
    }

    @Override
    public String verDatosParticulares() {
        return muestraDatos()+"\nTara: " + Tara;
    }

}
