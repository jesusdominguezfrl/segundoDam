package GestionEmpleadosExamen;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Empleado {
    
    private String nombre;
    private String apellidos;
    private String DNI;
    private int codigoEmpleado;
    private tipoEmpleado typeEmpleado;
    public static ArrayList<Empleado> coleccionEmpleado = new ArrayList() ;
    public static enum tipoEmpleado{
        Jefe,
        Montador,
        Repartidor,
        Vendedor,
        Almacenista,
        Administrativo;
    }

    public Empleado(String nombre, String apellidos,String DNI, tipoEmpleado typeEmpleado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI=DNI;
        this.typeEmpleado = typeEmpleado;
        this.codigoEmpleado=coleccionEmpleado.size()+1;
        coleccionEmpleado.add(this);
    }
    
    
    @Override
    public String toString(){
       return apellidos+", "+nombre+"- DNI:"+DNI; 
    }

    public tipoEmpleado getTypeEmpleado() {
        return typeEmpleado;
    }
    
    
    
    
    
    
}
