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
    
    public tratamientoSax(){
        this.empleadosXMLSAX= new File("EmpleadosXMLSAX.xml");
    }

    public File getEmpleadosXMLSAX() {
        return empleadosXMLSAX;
    }

    public void setEmpleadosXMLSAX(File empleadosXMLSAX) {
        this.empleadosXMLSAX = empleadosXMLSAX;
    }
    
    public void importarXMLSAX(File f, Modelo m){
        //m.getEmpleados().clear();
         try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new GestionContenido(m));
            reader.parse(new InputSource(new FileInputStream(/*empleadosXMLSAX.getName()*/f)));
            
        } catch (Exception e) {
            System.out.println("Excepcion en lectura sax" + e.getMessage());
           
        }
    }
    
    public void exportarXMLSAX(File f, Modelo m){
        System.out.println(m.getEmpleados().size());
        XMLReader datosLectura= new DatosReader(m);
        InputSource datosSource = m;
        try {
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
