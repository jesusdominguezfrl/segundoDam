/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JAXB;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import modelo.Modelo;

/**
 * Lectura Escritura de archivos XML con tecnologia JAXB
 * @author usuario
 */
public class tratamientoJAXB {
    
    private final File empleadosXMLXJAXB;
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    
    /**
     * Constructor sin parametros, inicializa el fichero utilizado para tratamiento JAXB.
     */
    public tratamientoJAXB(){
        this.empleadosXMLXJAXB= new File("EmpleadosXMLJAXB.xml");
    }

    //</editor-fold>
    
      //<editor-fold defaultstate="collapsed" desc="Getter">

    /**
     * 
     * @return empleadosXMLJAXB fichero tratamiento JAXB
     */
    public File getEmpleadosXMLXJAXB() {
        return empleadosXMLXJAXB;
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Importar/Exportar Tecnologia JAXB">
    
    /**
     * Crea objetos a partir de un archivo XML y los añade a la coleccion de empleados
     * @param f (File) fichero que contiene los datos
     * @param m (Modelo) Objeto que permite el acceso a la coleccion de empleados
     * @throws JAXBException 
     */
    public void importarFicheroJAXB(File f, Modelo m)  {
       try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Modelo.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Modelo mol = (Modelo) unmarshaller.unmarshal(f);
            m.setEmpleados(mol.getEmpleados());
        } catch (JAXBException ex) {
            System.err.println("No fue posible leer " + f.getName() + ", saliendo.");
            System.err.println(ex.toString());
            System.exit(1);
        }
                
    }

    /**
     * Crea un fichero XML con tecnologia JAXB a partir de una coleccion de objetos
     * @param f (File) fichero que se generara
     * @param m (Modelo) Objeto que permite el acceso a la coleccion de empleados
     * @throws JAXBException 
     */
    public void exportarFicheroJAXB(File f, Modelo m) {
        try{
            JAXBContext jaxbContext= JAXBContext.newInstance(Modelo.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            jaxbMarshaller.marshal(m, f);
        } catch (JAXBException ex) {
            System.err.println("No fue posible escribir el archivo " + f.getName());
            System.err.println(ex.toString());
        }
    }
    
    //</editor-fold>
    
}
