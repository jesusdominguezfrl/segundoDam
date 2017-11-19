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
public class Autocar extends Vehiculo {

    private int numeroPasajeros;

    public Autocar(String Matricula, String NumeroBastidor, int AñoMatricula, int numeroPasajeros) {
        super(Matricula, NumeroBastidor, AñoMatricula);
        this.numeroPasajeros = numeroPasajeros;
    }


    @Override
    public String toString() {
        return "Autocar: "+ super.toString();
    }

    @Override
    public String verDatosParticulares() {
        return muestraDatos()+"\nNº Pasajeros: " + numeroPasajeros;
    }
}
