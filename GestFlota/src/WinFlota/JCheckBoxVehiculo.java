/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WinFlota;

import Flota.Vehiculo;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
        this.addMouseListener(new gestorColor());
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
    public void setText(String texto) {
    }

    private class gestorColor implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            JCheckBoxVehiculo jcbVehiculo = (JCheckBoxVehiculo) e.getComponent();
            if (jcbVehiculo.isSelected()) {
                jcbVehiculo.setForeground(Color.red);
            } else {
                jcbVehiculo.setForeground(null);

            }
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
