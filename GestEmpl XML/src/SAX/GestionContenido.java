/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAX;

import entidades.Empleado;
import java.util.ArrayList;
import modelo.Modelo;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Jesus
 */
public class GestionContenido extends DefaultHandler {

    private Modelo m;
    private String nombreEtiqueta;
    private String valores;
    Empleado empl;
    
    public GestionContenido(){
        m=new Modelo();
    }
    
    @Override
    public void startDocument() throws SAXException {
        System.out.println("\nPrincipio del documento XML\n\n\tLeyendo contenido.... ");
        
//        Modelo.empleados.clear();

    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("\nFin del documento XML");
    }

    //Detecta el inicio de una etiqueta (con la etiqueta empleado se crea un empleado nuevo
    @Override
    public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
        nombreEtiqueta=localName;
        if("empleado".equals(nombreEtiqueta)){
            empl= new Empleado();
        }
    }

    //Lee el contenido de la etiqueta con las etiquetas de atributos se le asigna cada valor a cada objeto
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

    //Detecta el cierre de la etiqueta. Con la etiqueta empleado de cierre tendriamos el objeto completo
    @Override
    public void endElement(String uri, String localName, String name) throws SAXException {
        if("empleado".equals(localName)){
            //m.getEmpleados().add(empl);
            m.getEmpleados().add(empl);
        }
    }
}
