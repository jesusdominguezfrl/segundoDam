package Flota;


public class Autocar extends Vehiculo {

    private int numeroPasajeros;

    public Autocar(String Matricula, String NumeroBastidor, int AñoMatricula, int numeroPasajeros) {
        super(Matricula, NumeroBastidor, AñoMatricula);
        this.numeroPasajeros = numeroPasajeros;
    }


    @Override
    public String toString() {
        return "Autocar: "+super.toString();
    }

    @Override
    public String verDatosParticulares() {
        return toString()+", Nº Pasajeros: " + numeroPasajeros;
    }
}
