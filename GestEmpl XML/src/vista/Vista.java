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
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import XStream.tratamientoXStreams;
import estiloXsl.tratamientoEstilosXSL;
import java.io.FileNotFoundException;
import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import modelo.Modelo;
import org.xml.sax.SAXException;

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
     * @param td (tratamientoDom) Objedo que da acceso a la clase de escritura lectura con tenologia DOM.
     * @param ts (tratamientoSax) Objeto que da acceso a la clase de escritura lectura con tecnologia SAX.
     * @param tXS (tratamientoXStream) Objeto que da acceso a la clase de escritura lectura con tecnologia XStream.
     * @param teXSL (trataamientoEstilosXSL) Objeto que da acceso a la clase de creacion de un fichero HTML a partir de una hoja de estilo XSL.
     * @param tJAXB (tratamientoJAXB) Objeto que da acceso a la clase de escritura lectura con la tecnologia JAXB
     */
    public Vista(Modelo m, tratamientoDom td, tratamientoSax ts, tratamientoXStreams tXS, tratamientoEstilosXSL teXSL, tratamientoJAXB tJAXB) {
        this.m = m;
        this.td = td;
        this.ts = ts;
        this.tXS = tXS;
        this.teXSL = teXSL;
        this.tJAXB = tJAXB;
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

     /**
     * Hace la llamada al metodo importar del fichero XML DOM de la clase tratamientoDOM
     */
    public void importarDOM() throws ParserConfigurationException, SAXException, IOException {
        td.importarXMLDOM(td.getEmpleadosXMLDOM(), m);
    }

     /**
     *Comprueba si hay empleados en la coleccion para escribir en el fichero XML DOM, 
     * si hay llama al metodo de la clase tratamiendoDOM de escritura, 
     * si no muestra un mensaje al usuario. 
     */
    public void exportarDOM(){
        if (!m.getEmpleados().isEmpty()) {
            td.exportarXMLDOM(td.getEmpleadosXMLDOM(), m);
        } else {
            System.out.println("No hay empleados para escribir en el fichero");
        }
    }

     /**
     * Hace la llamada al metodo importar del fichero XML SAX de la clase tratamientoSAX
     */
    public void importarSAX() {
        ts.importarXMLSAX(ts.getEmpleadosXMLSAX(), m);
    }

    
     /**
     *Comprueba si hay empleados en la coleccion para escribir en el fichero XML SAX, 
     * si hay llama al metodo de la clase tratamientoSAX de escritura, 
     * si no muestra un mensaje al usuario. 
     */
    public void exportarSAX() {
        if (!m.getEmpleados().isEmpty()) {
            ts.exportarXMLSAX(ts.getEmpleadosXMLSAX(), m);
        } else {
            System.out.println("No hay empleados para escribir en el fichero");
        }
    }

    /**
     * Hace la llamada al metodo importar del fichero XML XStream de la clase tratamientoXStream
     */
    public void importarXStream() {
        tXS.importarXMLXStream(tXS.getEmpleadosXMLXStream(), m);
    }

     /**
     *Comprueba si hay empleados en la coleccion para escribir en el fichero XML XStream, 
     * si hay llama al metodo de la clase tratamientoXStream de escritura, 
     * si no muestra un mensaje al usuario. 
     */
    public void exportarXStream() {
        if (!m.getEmpleados().isEmpty()) {
            tXS.exportarXMLXStream(tXS.getEmpleadosXMLXStream(), m);
        } else {
            System.out.println("No hay empleados para escribir en el fichero");
        }
    }

     /**
     *Comprueba si hay empleados en la coleccion para generar el fichero HTML, 
     * si hay llama al metodo de la clase tratamiendoEstilosXSL de escritura, 
     * si no muestra un mensaje al usuario. 
     */
    public void crearFHTML(){
        if (!m.getEmpleados().isEmpty()) {
            teXSL.crearFicheroHTML(teXSL.getPaginaHTML());
        } else {
            System.out.println("No hay empleados para crear pagina HTML");
        }
    }

    /**
     * Hace la llamada al metodo importar del fichero XML JAXB de la clase tratamientoJAXB
     */
    public void importarJAXB() {
        tJAXB.importarFicheroJAXB(tJAXB.getEmpleadosXMLXJAXB(), m);
    }

     /**
     *Comprueba si hay empleados en la coleccion para escribir en el fichero XML JAXB, 
     * si hay llama al metodo de la clase tratamientoJAXB de escritura, 
     * si no muestra un mensaje al usuario. 
     */
    public void exportarJAXB() {
        if (!m.getEmpleados().isEmpty()) {
            tJAXB.exportarFicheroJAXB(tJAXB.getEmpleadosXMLXJAXB(), m);
        } else {
            System.out.println("No hay empleados para escribir en el fichero");
        }
    }

    //</editor-fold>
    
} // fin clase Vista

