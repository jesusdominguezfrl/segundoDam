/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionEmpleadosExamen;

import javax.swing.JRadioButton;


/**
 *
 * @author usuario
 */
public class JRadioButtonTipoEmpleado extends JRadioButton{
    
    private Empleado.tipoEmpleado tipoAsociado;
    
    public JRadioButtonTipoEmpleado (Empleado.tipoEmpleado tipoEmpleado){
        setTipoAsociado(tipoEmpleado);
    }
    
    public void setTipoAsociado(Empleado.tipoEmpleado tipo){
        this.tipoAsociado=tipo;
        super.setText(tipo.toString());
    }
    
    @Override
    public void setText(String text){}

    public Empleado.tipoEmpleado getTipoAsociado() {
        return tipoAsociado;
    }
    
    
}
