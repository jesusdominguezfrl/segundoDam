/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Empleados.Empleado;
import javax.swing.JCheckBox;

/**
 *
 * @author enrique
 */
public class JCheckEmpleado extends JCheckBox{
    private Empleado miEmpleado;
    public JCheckEmpleado() {
        inicializa();
    }

    public JCheckEmpleado(Empleado miEmpleado) {
        this.miEmpleado = miEmpleado;
        inicializa();
    }

    public void setMiEmpleado(Empleado miEmpleado) {
        if (miEmpleado==null){
            this.miEmpleado = miEmpleado;
        }
    }

    public Empleado getMiEmpleado() {
        return miEmpleado;
    }
    private void inicializa(){
        this.setText(miEmpleado.toString());
        this.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        this.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        this.setBorderPainted(true);
        this.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        this.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        this.setIconTextGap(15);              
    }
    
}
