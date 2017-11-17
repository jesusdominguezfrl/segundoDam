package Flota;


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
        return this.toString()+", nº plazas: " + numeroPlazas;
    }

}
