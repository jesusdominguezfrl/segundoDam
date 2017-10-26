/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import DOM.tratamientoDom;
import SAX.tratamientoSax;
import entidades.Empleado;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;

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

    public Vista(Modelo m, tratamientoDom td, tratamientoSax ts) {
        this.m = m;
        this.td= td;
        this.ts=ts;
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

    

   
} // fin class Vista

