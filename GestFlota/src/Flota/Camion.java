package Flota;

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
        return toString()+", Tara: " + Tara;
    }

}
