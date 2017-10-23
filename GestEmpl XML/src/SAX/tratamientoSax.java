/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAX;

import java.io.File;
import java.io.FileInputStream;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import modelo.Modelo;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Jesus
 */
public class tratamientoSax {
    
    private File empleadosXMLSAX;
    private Modelo m;
    
    public tratamientoSax(){
        this.empleadosXMLSAX= new File("EmpleadosXMLSAX.xml");
        this.m= new Modelo();
    }

    public File getEmpleadosXMLSAX() {
        return empleadosXMLSAX;
    }

    public void setEmpleadosXMLSAX(File empleadosXMLSAX) {
        this.empleadosXMLSAX = empleadosXMLSAX;
    }
    
    public void importarXMLSAX(File f){
         try {
             System.out.println("llego1");
            XMLReader reader = XMLReaderFactory.createXMLReader();
             System.out.println("llego2");
            reader.setContentHandler(new GestionContenido());
             System.out.println("llego3");
            reader.parse(new InputSource(new FileInputStream(/*empleadosXMLSAX.getName()*/f)));
             System.out.println("llego4");
            
        } catch (Exception e) {
            System.out.println("Excepcion en lectura sax" + e.getMessage());
           
        }
    }
    
    public void exportarXMLSAX(File f){
        XMLReader datosLectura= new DatosReader();
        InputSource datosSource = m;
        try {
            System.out.println("llego");
            Source source = new SAXSource(datosLectura,datosSource);
            Result resultado = new StreamResult(empleadosXMLSAX);
            Transformer transformer =TransformerFactory.newInstance().newTransformer();
            //transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(source, resultado);
        } catch (Exception e) {
            System.out.println("Se produjo una excepcion: "+ e.getMessage() );
        }
    }
    
    
}
