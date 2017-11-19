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
public class Motocicleta extends Vehiculo {

    private int cilindrada;

    public Motocicleta(String Matricula, String NumeroBastidor, int AñoMatricula, int cilindrada) {
        super(Matricula, NumeroBastidor,AñoMatricula );
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "Motocicleta: "+super.toString();
    }

    @Override
    public String verDatosParticulares() {
        return muestraDatos()+"\n Cilindrada: " + cilindrada;
    }

}
