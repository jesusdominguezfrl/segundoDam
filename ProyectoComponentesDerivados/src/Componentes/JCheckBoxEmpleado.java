/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import Empleados.Empleado;
import javax.swing.JCheckBox;

/**
 *
 * @author usuario
 */
public final class JCheckBoxEmpleado extends JCheckBox{
    
    private Empleados.Empleado empleado;

    public JCheckBoxEmpleado(Empleado empleado){
        setEmpleado(empleado);
    }

    public JCheckBoxEmpleado() {
    }
    
    
    
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        if(this.empleado==null){
            this.empleado = empleado;
            super.setText(empleado.toString());
        }
    }
    
    @Override
    public void setText(String texto){
    }
    
    
    
}
