/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XStream;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import entidades.Empleado;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Modelo;

/**
 *
 * @author usuario
 */
public class tratamientoXStreams {
    
    private final File empleadosXMLXStream;
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Constructor que inicializa el fichero empleadosXMLXStream.
     */
    public tratamientoXStreams(){
        this.empleadosXMLXStream= new File("EmpleadosXMLXStream.xml");
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getter">
 

    /**
     * 
     * @return empleadoXMLXStream (File) Fichero XML
     */
    public File getEmpleadosXMLXStream() {
        return empleadosXMLXStream;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Importar/Exportar Tecnologia XStreams">
    
    /**
     * Carga los datos existentes en un fichero XML a la coleccion de objetos empleados
     * @param f (File) Fichero que contine los datos
     * @param m (Modelo) Objeto que permite el acceso a la coleccion de objetos. 
     */
    public void importarXMLXStream(File f, Modelo m)  {
        try {
            XStream xstream = new XStream();
            xstream.addPermission(NoTypePermission.NONE);
            xstream.allowTypeHierarchy(Empleado.class);
            xstream.allowTypeHierarchy(List.class);
            xstream.alias("empleados", List.class);
            xstream.alias("empleado", Empleado.class);
            xstream.addImplicitCollection(Modelo.class, "empleados");
            m.setEmpleados((ArrayList<Empleado>) xstream.fromXML(new FileInputStream(f)));
        } catch (IOException ex) {
            System.err.println("No fue posible leer " + f.getName() + ", saliendo.");
            System.err.println(ex.toString());
            System.exit(1);
        }
    }

    /**
     * Crea un fichero XML a partir de los datos que contiene la coleccion de objetos
     * @param f (File) Fichero XML que se generara.
     * @param m (Modelo) Objeto necesario para acceder a la coleccion.
     */
    public void exportarXMLXStream(File f, Modelo m) {
        try {
            XStream xstream = new XStream();
            xstream.alias("empleados", List.class);
            xstream.alias("empleado", Empleado.class);
            xstream.addImplicitCollection(Modelo.class, "empleados");
            xstream.toXML(m.getEmpleados(), new FileOutputStream(f));
        } catch (IOException ex) {
            System.err.println("No fue posible escribir el archivo " + f.getName());
            System.err.println(ex.toString());
        }
    }
    
    //</editor-fold>

}
