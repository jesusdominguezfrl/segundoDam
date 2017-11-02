/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JAXB;

import entidades.Empleado;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import modelo.Modelo;

/**
 *
 * @author usuario
 */
public class tratamientoJAXB {
    
   Modelo m;
    
    private File empleadosXMLXJAXB;
    
    public tratamientoJAXB(){
        this.empleadosXMLXJAXB= new File("EmpleadosXMLJAXB.xml");
    }

    public File getEmpleadosXMLXJAXB() {
        return empleadosXMLXJAXB;
    }

    public void importarFicheroJAXB(File f, Modelo m) throws JAXBException {
                JAXBContext jaxbContext= JAXBContext.newInstance(Modelo.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
               Modelo  mol = (Modelo) unmarshaller.unmarshal(f);
               m.setEmpleados(mol.getEmpleados());
                
    }

    public void exportarFicheroJAXB(File f, Modelo m) throws JAXBException {
        JAXBContext jaxbContext= JAXBContext.newInstance(Modelo.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        jaxbMarshaller.marshal(m, f);
   
    
    }
    
    
}
