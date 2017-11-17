package Flota;


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
        return this.toString()+", Cilindrada: " + cilindrada;
    }

}
