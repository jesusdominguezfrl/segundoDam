/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAX;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import modelo.Modelo;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Jesus
 */
public class tratamientoSax {
    
    private File empleadosXMLSAX;
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    
    /**
     * Constructor sin parametros, inicializa el fichero utilizado para tratamiento SAX.
     */
    public tratamientoSax(){
        this.empleadosXMLSAX= new File("EmpleadosXMLSAX.xml");
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getter">

    /**
     * 
     * @return empleadosXMLSAX fichero tratamiento SAX
     */
    public File getEmpleadosXMLSAX() {
        return empleadosXMLSAX;
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Importar/Exportar Tecnologia SAX">
    
    /**
     * Crea objetos usando los datos de un fichero XML  y los añade a la coleccion de objetos utilizando tecnologia SAx
     * @param f (File) fichero que contiene los datos.
     * @param m (Modelo) Objeto necesario para acceder a la coleccion de empleados.
     */
    public void importarXMLSAX(File f, Modelo m){
         try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new GestionContenido(m));
            reader.parse(new InputSource(new FileInputStream(/*empleadosXMLSAX.getName()*/f)));
        } catch (IOException | SAXException ex) {
            System.err.println("No fue posible leer " + f.getName() + ", saliendo.");
            System.err.println(ex.toString());
            System.exit(1);
        }
    }
    
    /**
     * Escribe los ficheros de la coleccion en un fichero XML 
     *@param f (File) fichero en el que se escribiran los datos.
     * @param m (Modelo) Objeto necesario para acceder a la coleccion de empleados
     */
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
      } catch (TransformerException ex) {
            System.err.println("No fue posible escribir el archivo " + f.getName());
            System.err.println(ex.toString());
        }
    }
    
  //</editor-fold>
    
}
