/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XStream;

import com.thoughtworks.xstream.XStream;
import entidades.Empleado;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import modelo.Modelo;

/**
 *
 * @author usuario
 */
public class tratamientoXStreams {
    private File empleadosXMLXStream;
    
    public tratamientoXStreams(){
        this.empleadosXMLXStream= new File("EmpleadosXMLXStream.xml");
    }

    public File getEmpleadosXMLXStream() {
        return empleadosXMLXStream;
    }

    public void setEmpleadosXMLXStream(File f) {
        this.empleadosXMLXStream = f;
    }

    public void importarXMLXStream(File f, Modelo m) throws FileNotFoundException {
        XStream xstream = new XStream();
        xstream.alias("empleados", List.class);
        xstream.alias("empleado", Empleado.class);
        System.out.println("shbalñkjf");
        xstream.addImplicitCollection(Modelo.class,"empleados");
        System.out.println("No llego");
        m.setEmpleados((ArrayList<Empleado>)xstream.fromXML(new FileInputStream(f)));
        
    }

    public void exportarXMLXStream(File f, Modelo m) throws FileNotFoundException {
        if(!m.getEmpleados().isEmpty()){
            XStream xstream = new XStream();
            xstream.alias("empleados", List.class);
            xstream.alias("empleado", Empleado.class);
            //xstream.addImplicitCollection(Modelo.class, "empleados");
            xstream.toXML(m.getEmpleados(), new FileOutputStream(f));
        }else{
            System.out.println("\nNo hay empleados para guardar");
        }
    }

    
}
