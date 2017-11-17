package Flota;

import javax.swing.DefaultListModel;


public abstract class Vehiculo {

    private final String Matricula;
    private final String NumeroBastidor;
    private final int AñoMatricula;
    private Boolean ITVPasada;
    private static DefaultListModel<Vehiculo> vehiculosFlota;
    public Vehiculo(String Matricula, String NumeroBastidor, int AñoMatricula) {
        this.Matricula = Matricula;
        this.NumeroBastidor = NumeroBastidor;
        this.AñoMatricula = AñoMatricula;
        ITVPasada=false;
        vehiculosFlota.addElement(this);
    }

    @Override
    public String toString() {
        return Matricula;
    }

    public void pasaITV(){
        ITVPasada=true;
    }

    public Boolean getITVPasada() {
        return ITVPasada;
    }

    public static DefaultListModel<Vehiculo> vehiculosFlota(){
        DefaultListModel<Vehiculo> lista = new DefaultListModel();
        Object [] objetos=null;
        vehiculosFlota.copyInto(objetos);
        for (Object o: objetos) {
            Vehiculo v = (Vehiculo) o;
            lista.addElement(v);
        }
        
        return lista;
    }
    
    public abstract String verDatosParticulares();

       
}
