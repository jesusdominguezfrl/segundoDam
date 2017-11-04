/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAX;

import entidades.Empleado;
import modelo.Modelo;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Clase que gestiona el inicio contenido y cierre de las etiquetas XML
 * @author Jesus
 */
public class GestionContenido extends DefaultHandler {

    private Modelo m;
    private String nombreEtiqueta;
    private String valores;
    Empleado empl;
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    
    /**
     * Constructor con un parametro que inicia el Objeto Modelo de la clase a partir del parameto Modelo pasado como argumento
     * @param m (Modelo) Objeto de la clase modelo.
     */
    public GestionContenido(Modelo m){
        this.m=m;
    }
    
    //</editor-fold>
    
   //<editor-fold defaultstate="collapsed" desc="Metodos Abstractos DefaultHandler">

    /**
     * Detecta el inicio del documento XML.
     * @throws SAXException 
     */
    @Override
    public void startDocument() throws SAXException {
        System.out.println("\nPrincipio del documento XML\n\n\tLeyendo contenido.... ");
    }

    /**
     * Detecta el final del documento XML.
     * @throws SAXException 
     */
    @Override
    public void endDocument() throws SAXException {
        System.out.println("\nFin del documento XML");
    }

    /**
     *Detecta el inicio de una etiqueta (con la etiqueta empleado se crea un empleado nuevo
     * @param uri 
     * @param localName (String) Contiene el nombre de la etiqueta
     * @param name 
     * @param attributes 
     * @throws SAXException 
     */
    @Override
    public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
        nombreEtiqueta=localName;
        if("empleado".equals(nombreEtiqueta)){
            empl= new Empleado();
        }
    }

    /**
     * Lee el contenido de la etiqueta con las etiquetas de atributos se le asigna cada valor a cada objeto
     * @param ch 
     * @param start
     * @param length
     * @throws SAXException 
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        valores= String.valueOf(ch,start,length).trim();
        switch (nombreEtiqueta){
            case "id":
                empl.setId(Integer.valueOf(valores));
                break;
            case "nombre":
                empl.setNombre(valores);
                break;
            case "apell1":
                empl.setApell1(valores);
                break;
            case "apell2":
                empl.setApell2(valores);
                break;
            case "salario":
                empl.setSalario(Float.valueOf(valores));
                break;
        }

    }

    /**
     * Detecta el cierre de la etiqueta. Con la etiqueta empleado de cierre tendriamos el objeto completo
     * @param uri
     * @param localName (String) Contiene el nombre de la etiqueta
     * @param name
     * @throws SAXException 
     */
    @Override
    public void endElement(String uri, String localName, String name) throws SAXException {
        if("empleado".equals(localName)){
            m.getEmpleados().add(empl);
        }
    }
    
    //</editor-fold>
    
}
