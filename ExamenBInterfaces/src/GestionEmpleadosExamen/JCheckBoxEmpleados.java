/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionEmpleadosExamen;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;

/**
 *
 * @author usuario
 */
public class JCheckBoxEmpleados extends JCheckBox{
    
    private Empleado empleado;
    
    public JCheckBoxEmpleados(Empleado empleado){
        setEmpleado(empleado);
        this.addActionListener(new gestorFuente());
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
    
    public void removeEmpleado(){
        Empleado.coleccionEmpleado.remove(this.getEmpleado());
    }
    //derive font (bold) font.plain
    
    private class gestorFuente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JCheckBoxEmpleados jcbEmpleado=(JCheckBoxEmpleados)e.getSource();
            if(jcbEmpleado.isSelected()){
                jcbEmpleado.setFont(jcbEmpleado.getFont().deriveFont(Font.BOLD));
            }else{
                jcbEmpleado.setFont(jcbEmpleado.getFont().deriveFont(Font.PLAIN));
            }
        }
        
    }
    
}
