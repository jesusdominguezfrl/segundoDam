/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WinFlota;

import Flota.Vehiculo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;

/**
 *
 * @author Jesus
 */
public class JCheckBoxVehiculo extends JCheckBox {

    private Vehiculo vehiculo;
    //private Boolean itvPasada;

    public JCheckBoxVehiculo() {
    }

    public JCheckBoxVehiculo(Vehiculo vehiculo) {
        setVehiculo(vehiculo);
       // setItvPasada(itvPasada);
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        if (this.vehiculo == null) {
            this.vehiculo = vehiculo;
            super.setText(vehiculo.toString());
            super.setEnabled(!this.vehiculo.getITVPasada());
            super.setSelected(this.vehiculo.getITVPasada());
        }
    }

    
    @Override
    public void setText(String texto){}
    
    @Override
    public void setEnabled(boolean b){}
    
    @Override
    public void setSelected(boolean b){}

    
}
