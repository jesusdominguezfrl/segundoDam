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
public class Turismo extends Vehiculo {

    private int numeroPlazas;

    public Turismo(String Matricula, String NumeroBastidor, int AñoMatricula, int numeroPlazas) {
        super(Matricula, NumeroBastidor,AñoMatricula );
        this.numeroPlazas = numeroPlazas;
    }

    @Override
    public String toString() {
        return "Turismo: "+super.toString();
    }

    @Override
    public String verDatosParticulares() {
        return muestraDatos()+"\nnº plazas: " + numeroPlazas;
    }

}
