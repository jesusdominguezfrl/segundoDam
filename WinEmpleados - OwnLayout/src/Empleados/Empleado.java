/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleados;

import javax.swing.DefaultListModel;

/**
 *
 * @author enrique
 */
public abstract  class Empleado {
    public static DefaultListModel<Empleado> listaEmpleados=new DefaultListModel<>();
    protected String nombre;
    protected String apellidos;
    public Empleado(String nombre, String apellidos){
        this.nombre=nombre;
        this.apellidos=apellidos;
        listaEmpleados.addElement(this);
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    
    @Override
    public  String toString(){
        return getApellidos() + ", " +  getNombre(); 
    }
    public abstract  double salario();
}
