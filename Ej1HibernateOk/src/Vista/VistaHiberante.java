/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Modelo.ModeloHibernate;

/**
 *
 * @author usuario
 */
public class VistaHiberante {
    ModeloHibernate m= new ModeloHibernate();
    
    public void modificarDatos(String tabla){
        if (tabla == null) return;
        if ("empleados".equals(tabla)) {
            m.modificarEmpleado();
        } else {
            m.modificarDepartamento();
        }
    }
    
    public void insertarDatos(String tabla){
        if (tabla == null) return;
        if ("empleados".equals(tabla)) {
            m.insertarEmpleado();
        } else {
            m.insertarDepartamento();
        }
    }
    
    public void borraDatos(String tabla){
        if (tabla == null) return;
        if ("empleados".equals(tabla)) {
            m.borrarEmpleado();
        } else {
            m.borrarDepartamento();
        }
    }
    
    
    
}
