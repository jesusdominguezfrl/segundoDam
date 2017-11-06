/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOM;

import entidades.Empleado;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import modelo.Modelo;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author Jesus
 */
public class tratamientoDom {
    
    private final File empleadosXMLDOM;
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    
    /**
     * Constructor sin parametros, inicializa el fichero utilizado para tratamiento DOM.
     */
    public tratamientoDom(){
        this.empleadosXMLDOM= new File("EmpleadosXMLDOM.xml");
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getter">

    /**
     * 
     * @return empleadosXMLJAXB fichero tratamiento JAXB
     */
    public File getEmpleadosXMLDOM() {
        return empleadosXMLDOM;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Importar/Exportar Tecnologia _DOM">
    
    /**
     * Crea objetos a partir de un archivo XML y los añade a la coleccion de empleados
     * @param f (File) fichero que contiene los datos
     * @param m (Modelo) Objeto que permite el acceso a la coleccion de empleados
     * @throws JAXBException 
     */
    public void importarXMLDOM(File f, Modelo m)  {
        try{
            m.getEmpleados().clear();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = /*(Document)*/ builder.parse(f);
            document.getDocumentElement().normalize();
            NodeList listaempleados = document.getElementsByTagName("empleado");
            for (int i = 0; i < listaempleados.getLength(); i++) {
                Node empleado = listaempleados.item(i);
                if (empleado.getNodeType() == Node.ELEMENT_NODE) {
                    ////Element elemento = (Element) empleado;
                    //Modelo.empleados.add(new Empleado((Element) empleado));
                    m.getEmpleados().add(new Empleado((Element) empleado));
                }
            }
        } catch (IOException | SAXException|ParserConfigurationException ex) {
            System.err.println("No fue posible leer " + f.getName() + ", saliendo.");
            System.err.println(ex.toString());
            System.exit(1);
        }
            
    }
    
     /**
     * Crea un fichero XML con tecnologia DOM a partir de una coleccion de objetos
     * @param f (File) fichero que se generara
     * @param m (Modelo) Objeto que permite el acceso a la coleccion de empleados 
     */
    public void exportarXMLDOM(File f, Modelo m) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "empleados", null);
            document.setXmlVersion("1.0");
        //    for (Empleado e : Modelo.empleados) {
            for (Empleado e : m.getEmpleados()) {
                //Empleado
                Element raiz = document.createElement("empleado");
                document.getDocumentElement().appendChild(raiz);
                
                    //ID
                    Element id = document.createElement("id");
                    Text textoid = document.createTextNode(Integer.toString(e.getId()));
                    raiz.appendChild(id);
                    id.appendChild(textoid);
                    
                    //Nombre
                    Element nombre = document.createElement("nombre");
                    Text textonombre = document.createTextNode(e.getNombre());
                    raiz.appendChild(nombre);
                    nombre.appendChild(textonombre);

                    //Apellido1
                    Element apell1 = document.createElement("apell1");
                    Text textoapell1 = document.createTextNode(e.getApell1());
                    raiz.appendChild(apell1);
                    apell1.appendChild(textoapell1);

                    //Apellido2
                    Element apell2 = document.createElement("apell2");
                    Text textoapell2 = document.createTextNode(e.getApell2());
                    raiz.appendChild(apell2);
                    apell2.appendChild(textoapell2);

                    //Salario
                    Element salario = document.createElement("salario");
                    Text textosalario = document.createTextNode(String.valueOf(e.getSalario()));
                    raiz.appendChild(salario);
                    salario.appendChild(textosalario);
                
                Source source = new DOMSource(document);
                Result result = new StreamResult(f);
                Transformer transformer = TransformerFactory.newInstance().newTransformer();

                transformer.transform(source, result);
            }
        } catch (DOMException | TransformerException | ParserConfigurationException ex) {
            System.err.println("No fue posible escribir el archivo " + f.getName());
            System.err.println(ex.toString());
        }
    }
        
   //</editor-fold> 
              
}
