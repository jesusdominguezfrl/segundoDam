/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asociados;

import javax.swing.DefaultListModel;

/**
 *
 * @author Jesus
 */
public abstract class Asociado {
    
    //Declaracion de variables y miembros comunes de la estructura de clases.
    
    public static DefaultListModel listaAsociados= new DefaultListModel();
    private String nombre;
    private String apellidos;
    private String NIF;
    private final int cuota=100;

    //Constructores.<editor-fold defaultstate="collapsed" desc="Constructores"> 
    
    public Asociado(String nombre, String apellidos, String NIF) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.NIF = NIF;
        listaAsociados.addElement(this);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="AccesoMiembros"> 
    //Acceso a los miembros privados de la clase asociada Miembros SOLO LECTURA.
    
    //Permitir solo el acceso a clases derivadas de esta "protected".
    protected int getCuota() {
        return cuota;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNIF() {
        return NIF;
    }
    //</editor-fold>
   
    //<editor-fold defaultstate="collapsed" desc="MetodosClase"> 
//Metodos de clase compartidos por todas las clases derivadas.
    
    //Sobreescritura del metodo toString predefinido en java.
    @Override
    public String toString(){
        return getApellidos()+", "+getNombre()+". NIF: "+getNIF()+" ";
    }
    
    public String email(){
        return "email: " +getNIF()+"@asociados.com";
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="MetodosAbstractos (definicion)"> 
    //Definicion de metodos abstractos que seran sobreescritos en las clases derivadas.
              
    public abstract String verDatos();
    public abstract double verCuota();
    
    //</editor-fold>
    
}
