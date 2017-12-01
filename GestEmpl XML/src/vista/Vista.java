/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import DOM.tratamientoDom;
import JAXB.tratamientoJAXB;
import SAX.tratamientoSax;
import entidades.Empleado;
import java.util.Scanner;
import XStream.tratamientoXStreams;
import estiloXsl.tratamientoEstilosXSL;

import modelo.Modelo;

/**
 * Clase intermedia entre datos y usuario (modelo-VISTA-controlador)
 * @author Jc
 */
public class Vista {

    Modelo m;
    tratamientoDom td;
    tratamientoSax ts;
    tratamientoXStreams tXS;
    tratamientoEstilosXSL teXSL;
    tratamientoJAXB tJAXB;

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Constructor que inicializa los objetos necesarios para acceder a las diferentes clases del proyecto.
     * @param m (Modelo) Objeto que permitira la conexion con la clase que contiene la coleccion de datos
     */
    public Vista(Modelo m) {
        this.m = m;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodos de conexion con la claseCorrespondiente ">
   
    /**
     * Pide el numero de empleados que se quieren generar aleatoriamente y hace la llamada al metodo de la clase modelo que loss genera.
     */
    public void cargar_aleatorios() {
        System.out.println("¿Cuántos empleados vas a generar?: ");
        Scanner sc = new Scanner(System.in);
        String ent;
        ent = sc.nextLine();
        m.generarAleatorios(Integer.parseInt(ent));
    }

    /**
     * Crea un empleado con el que llama al metodo de la clase empleado que pide al usuario los datos que quiere asignar a los atributos
     */
    public void altaEmpleado() {
        Empleado empl = new Empleado();
        empl.emp_teclado();
        m.getEmpleados().add(empl);
    }
    
    /**
     *Comprueba si hay empleados en la coleccion para escribir en el fichero Delimitado, 
     * si hay llama al metodo de la clase modelo de escritura, 
     * si no muestra un mensaje al usuario. 
     */
    public void escribirDelimitado() {
        if (!m.getEmpleados().isEmpty()) {
            m.exportDelTo(m.getEmpleadosDelimitado(), "#");
        } else {
            System.out.println("No hay empleados para escribir en el fichero");
        }
    }

    /**
     * Hace la llamada al metodo importar del fichero Delimitado de la clase Modelo
     */
    public void leerDelimitado(){
        m.importDelFrom(m.getEmpleadosDelimitado(), "#");
    }

      /**
     *Comprueba si hay empleados en la coleccion para escribir en el fichero Delimitado, 
     * si hay llama al metodo de la clase modelo de escritura, 
     * si no muestra un mensaje al usuario. 
     */
    public void escribirEncolumnado()  {
        if (!m.getEmpleados().isEmpty()) {
            int longis[] = {4, 20, 20, 20, 12};
            m.exportEncTo(m.getEmpleadosEncolumnado(), longis);
        } else {
            System.out.println("No hay empleados para escribir en el fichero");
        }
    }

    /**
     * Hace la llamada al metodo importar del fichero Encolumnado de la clase Modelo
     */
    public void leerEncolumnado() {
            int longis[] = {4, 20, 20, 20, 12};
            m.importarEncFrom(m.getEmpleadosEncolumnado(), longis);
    }
    
     /**
     *Comprueba si hay empleados en la coleccion para escribir en el fichero Binario, 
     * si hay llama al metodo de la clase modelo de escritura, 
     * si no muestra un mensaje al usuario. 
     */
    public void exportarBinario(){
        if (!m.getEmpleados().isEmpty()) {
            m.saveEmpleados(m.getEmpleadosBinario());
        } else {
            System.out.println("No hay empleados para escribir en el fichero");
        }
    }

     /**
     * Hace la llamada al metodo importar del fichero Binario de la clase Modelo
     */
    public void importarBinario() {
        m.readEmpleados(m.getEmpleadosBinario());
    }

     /**
     *Comprueba si hay empleados en la coleccion para escribir en el fichero de Objetos, 
     * si hay llama al metodo de la clase modelo de escritura, 
     * si no muestra un mensaje al usuario. 
     */
    public void exportarObjeto() {
        if (!m.getEmpleados().isEmpty()) {
            m.saveEmpleadosAsObject(m.getEmpleadosObjeto());
        } else {
            System.out.println("No hay empleados para escribir en el fichero");
        }
    }

     /**
     * Hace la llamada al metodo importar del fichero Objeto de la clase Modelo
     */
    public void importarObjeto() {
        m.readAEmpleadosAsObject(m.getEmpleadosObjeto());
    }

    //</editor-fold>
    
} // fin clase Vista

