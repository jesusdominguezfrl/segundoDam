/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAX;

import entidades.Empleado;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Modelo;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;

/**
 *
 * @author Jesus
 */
class DatosReader implements XMLReader {

    private ContentHandler handler;

    private final AttributesImpl atts = new AttributesImpl();

    public DatosReader() {

    }
    //métodos para el transformer

    @Override
    public void parse(InputSource input) throws IOException, SAXException {

        try {

            //Modelo source = (Modelo) input;
           //List<Empleado> empleadosaqui = source.getEmpleados();

            //Guardado de datos.
            handler.startDocument();
            handler.startElement("", "empleados", "empleados", atts);
            for (Empleado empl : Modelo.empleados) {
                handler.startElement("", "empleado", "empleado", atts);

                handler.startElement("", "id", "id", atts);
                char[] id = String.valueOf(empl.getId()).toCharArray();
                handler.characters(id, 0, id.length);
                
                handler.endElement("", "id", "id");

                handler.startElement("", "nombre", "nombre", atts);
                char[] nombre = empl.getNombre().toCharArray();
                handler.characters(nombre, 0, nombre.length);
                handler.endElement("", "nombre", "nombre");

                handler.startElement("", "apell1", "apell1", atts);
                char[] apell1 = empl.getApell1().toCharArray();
                handler.characters(apell1, 0, apell1.length);
                handler.endElement("", "apell1", "apell1");

                handler.startElement("", "apell2", "apell2", atts);
                char[] apell2 = empl.getApell2().toCharArray();
                handler.characters(apell2, 0, apell2.length);
                handler.endElement("", "apell2", "apell2");

                handler.startElement("", "salario", "salario", atts);
                char[] salario = String.valueOf(empl.getSalario()).toCharArray();
                handler.characters(salario, 0, salario.length);
                handler.endElement("", "salario", "salario");

                handler.endElement("", "empleado", "empleado");
            }
            handler.endElement("", "empleados", "empleados");
            handler.endDocument();
        } catch (SAXException excepcionHandler) {
            System.out.println("El handler es nulo");
        }

    }

    @Override
    public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getProperty(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        return null;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setProperty(String name, Object value) throws SAXNotRecognizedException, SAXNotSupportedException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEntityResolver(EntityResolver resolver) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntityResolver getEntityResolver() {
        return null;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDTDHandler(DTDHandler handler) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DTDHandler getDTDHandler() {
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setContentHandler(ContentHandler handler) {
        this.handler = handler;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ContentHandler getContentHandler() {
        return handler;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setErrorHandler(ErrorHandler handler) {

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ErrorHandler getErrorHandler() {
        return null;
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void parse(String systemId) throws IOException, SAXException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
