/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import DOM.tratamientoDom;
import SAX.tratamientoSax;
import entidades.Empleado;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import XStream.tratamientoXStreams;
import estiloXsl.tratamientoEstilosXSL;
import java.io.FileNotFoundException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import modelo.Modelo;
import org.xml.sax.SAXException;


/**
 *
 * @author Jc
 */
public class Vista {

    Modelo m;
    tratamientoDom td;
    tratamientoSax ts;
    tratamientoXStreams tXS;
    tratamientoEstilosXSL teXSL;

    public Vista(Modelo m, tratamientoDom td, tratamientoSax ts,tratamientoXStreams tXS, tratamientoEstilosXSL teXSL) {
        this.m = m;
        this.td= td;
        this.ts=ts;
        this.tXS=tXS;
        this.teXSL=teXSL;
    }

    public void cargar_aleatorios() {
        System.out.println("¿Cuántos empleados vas a generar?: ");
        Scanner sc = new Scanner(System.in);
        String ent;
        ent = sc.nextLine();
        m.generarAleatorios(Integer.parseInt(ent));
    }

    public void altaEmpleado() {
        Empleado empl = new Empleado();
        empl.emp_teclado();
        m.getEmpleados().add(empl);
    }

    public void escribirDelimitado() {
        m.exportDelTo(m.getEmpleadosDelimitado(), "#");
    }

    public void leerDelimitado() throws IOException {
        m.importDelFrom(m.getEmpleadosDelimitado(), "#");
    }

    public void escribirEncolumnado() {
        int longis[] = {4, 20, 20, 20, 12};
        m.exportEncTo(m.getEmpleadosEncolumnado(), longis);
    }

    public void leerEncolumnado() {
        int longis[] = {4, 20, 20, 20, 12};
        m.importarEncFrom(m.getEmpleadosEncolumnado(), longis);
    }

    public void exportarBinario() {
        m.saveEmpleados(m.getEmpleadosBinario());
    }

    public void importarBinario() {
        m.readEmpleados(m.getEmpleadosBinario());
    }

    public void exportarObjeto() {
        m.saveEmpleadosAsObject(m.getEmpleadosObjeto());
    }

    public void importarObjeto() {
        m.readAEmpleadosAsObject(m.getEmpleadosObjeto());
    }
    
    public void importarDOM() throws ParserConfigurationException, SAXException, IOException{
        td.importarXMLDOM(td.getEmpleadosXMLDOM(),m);
    }
    
    public void exportarDOM() throws ParserConfigurationException {
        td.exportarXMLDOM(td.getEmpleadosXMLDOM(),m);
    }

    public void importarSAX() {
       ts.importarXMLSAX(ts.getEmpleadosXMLSAX(),m);
    }
    
    public void exportarSAX(){
        ts.exportarXMLSAX(ts.getEmpleadosXMLSAX(), m);
    }

    public void importarXStream() throws FileNotFoundException {
        tXS.importarXMLXStream(tXS.getEmpleadosXMLXStream(), m);
    }

    public void exportarXStream() throws FileNotFoundException {
        tXS.exportarXMLXStream(tXS.getEmpleadosXMLXStream(),m);
    }

    public void crearFHTML() throws FileNotFoundException, TransformerException, TransformerConfigurationException, IOException {
        teXSL.crearFicheroHTML(teXSL.getPaginaHTML());
    }

    

   
} // fin class Vista

