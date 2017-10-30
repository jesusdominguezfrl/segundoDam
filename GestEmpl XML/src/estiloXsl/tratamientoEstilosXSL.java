/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estiloXsl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.scene.transform.Transform;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Jesus
 */
public class tratamientoEstilosXSL {
    private File PaginaHTML;

    public tratamientoEstilosXSL() {
        this.PaginaHTML = new File("empleados.html");
    }
    
    

    public File getPaginaHTML() {
        return PaginaHTML;
    }

    public void setPaginaHTML(File PaginaHTML) {
        this.PaginaHTML = PaginaHTML;
    }
    

    public void crearFicheroHTML(File f) throws FileNotFoundException, TransformerConfigurationException, TransformerException, IOException {
        FileOutputStream fos = new FileOutputStream(f);
        Source estilos = new StreamSource("plantilla.xsl");
        Source datos= new StreamSource("empleados.xml");
        Result resultado = new StreamResult(fos);
        Transformer transformer= TransformerFactory.newInstance().newTransformer(estilos);
        transformer.transform(datos,resultado);
        fos.close();
        
    }
}
