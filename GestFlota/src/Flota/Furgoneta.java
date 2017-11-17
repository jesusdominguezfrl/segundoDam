package Flota;


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
        return toString()+ ", Tipo: " + tipoFurgoneta;
    }

}
