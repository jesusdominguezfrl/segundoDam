/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estiloXsl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Jesus
 */
public class tratamientoEstilosXSL {
    private final File paginaHTML;

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Constructor sin parametros que inicializa el fichero en el que se creara escribira la PagHTML.
     */
    public tratamientoEstilosXSL() {
        this.paginaHTML = new File("empleados.html");
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getter">

    /**
     * 
     * @return  paginaHTML (File) Fichero html que contendra la pagina.
     */
    public File getPaginaHTML() {
        return paginaHTML;
    }
    //</editor-fold>

    /**
     * Crea una pagina HTML a partir de una plantilla xsl y un fichero xml con los datos que se quieren mostrar
     * @param f (File) Fichero en el que se creara la pagina HTML
     */
    public void crearFicheroHTML(File f) {
        try {
            FileOutputStream fos = new FileOutputStream(f);
            Source estilos = new StreamSource("plantilla.xsl");
            Source datos = new StreamSource("empleados.xml");
            Result resultado = new StreamResult(fos);
            Transformer transformer = TransformerFactory.newInstance().newTransformer(estilos);
            transformer.transform(datos, resultado);
            fos.close();
        } catch (IOException | TransformerException ex) {
            System.err.println("No fue posible leer " + f.getName() + ", saliendo.");
            System.err.println(ex.toString());
            System.exit(1);
        }

    }
}
