package modelo;

import entidades.Empleado;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;
import org.xml.sax.InputSource;

/**
 * Clase que contiene los datos (MODELO-vista-controlador)
 *
 * @author Jc
 */
@XmlRootElement(name = "empleados") //Anotacionpara tratamiento JAXB (Definicion de la raiz del documento XML)

public class Modelo extends InputSource implements Serializable {

    private ArrayList<Empleado> empleados;  //Coleccion de empleados 
    private File empleadosDelimitado;              //FicheroDelimitado
    private File empleadosEncolumnado;        //FicheroEncolumnado
    private File empleadosBinario;                   //FicheroBinario
    private File empleadosObjeto;                   //FicheroObjetos

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Constructor sin parametros, inicializa los ficheros y el arraylist que
     * contendra la coleccion de empleados
     */
    public Modelo() {
        this.empleadosDelimitado = new File("empleados.del");
        this.empleadosEncolumnado = new File("empleados.encol");
        this.empleadosBinario = new File("empleados.bin");
        this.empleadosObjeto = new File("empleados.obj");
        empleados = new ArrayList<>();
    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodos" >
    /**
     * Muestra los empleados por pantalla de forma organizada y encolumnada.
     */
    public void mostrarEmpleados() {
        for (Empleado e : empleados) {
            System.out.println(e.toEncFormat());
        }
        // Fácil usando el método de Empleado toEncFormat()

    }

    /**
     * Genera empleados aleatorios y los añade a la coleccion.
     *
     * @param n (int) Numero de empleados que se quieren generar pedido al
     * usuario
     */
    public void generarAleatorios(int n) {
        Empleado nuevoaleatorio;
        for (int i = 0; i < n; i++) {
            nuevoaleatorio = new Empleado();
            nuevoaleatorio.emp_aleatorio();
            empleados.add(nuevoaleatorio);
        }
        // Fácil usando el método de Empleado emp_aleatorio()

    }

    @Override
    public String toString() {
        return "Modelo{" + "empleados=" + empleados + '}';
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getter  y Setter">
    /**
     *
     * @return empleados (ArrayList) coleccion de objetos de tipo Empleado
     */
    @XmlElement(name = "empleado")  //Anotacion tratamiento JAXB ( Elemento repetitivo) 
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     *
     * @param empleados
     */
    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
     *
     * @return empleadosDelimitado (File) fichero inicializado de empleados
     * Delimitado
     */
    @XmlTransient  //Anotacion tratamiento JAXB (Evita que el parametro se cargue en el XML.)
    public File getEmpleadosDelimitado() {
        return empleadosDelimitado;
    }

    /**
     *
     * @return empleadosEncolumnado (File) fichero inicializado de empleados
     * Encolumnado.
     */
    @XmlTransient  //Anotacion tratamiento JAXB (Evita que el parametro se cargue en el XML.)
    public File getEmpleadosEncolumnado() {
        return empleadosEncolumnado;
    }

    /**
     *
     * @return empleadosObjeto (File) fichero inicializado de empleados Objeto
     */
    @XmlTransient  //Anotacion tratamiento JAXB (Evita que el parametro se cargue en el XML.)
    public File getEmpleadosObjeto() {
        return empleadosObjeto;
    }

    /**
     *
     * @return empleadosBinario (File) fichero inicializado de empleados Binario
     */
    @XmlTransient  //Anotacion tratamiento JAXB (Evita que el parametro se cargue en el XML.)
    public File getEmpleadosBinario() {
        return empleadosBinario;
    }

    /**
     *
     * @param empleadosObjeto
     */
    public void setEmpleadosObjeto(File empleadosObjeto) {
        this.empleadosObjeto = empleadosObjeto;
    }

    /**
     *
     * @param empleadosEncolumnado
     */
    public void setEmpleadosEncolumnado(File empleadosEncolumnado) {
        this.empleadosEncolumnado = empleadosEncolumnado;
    }

    /**
     *
     * @param empleadosBinario
     */
    public void setEmpleadosBinario(File empleadosBinario) {
        this.empleadosBinario = empleadosBinario;
    }

    /**
     *
     * @param empleadosDelimitado
     */
    public void setEmpleadosDelimitado(File empleadosDelimitado) {
        this.empleadosDelimitado = empleadosDelimitado;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="RW ficheros Delimitados">
    /**
     * Crea un fichero Delimitado a partir de los datos de la coleccion de
     * empleados.
     *
     * @param f (File) Fichero que se quiere formar
     * @param delim (String) Contiene el valor del delimitador que se quiere
     * usar
     */
    public void exportDelTo(File f, String delim) {
        List<String> lista = new ArrayList<>();
        try {
            for (Empleado e : empleados) {
                lista.add(e.toDelimitedString(delim));
            }
            Files.write(f.toPath(), lista, Charset.forName("UTF-8"));
        } catch (Exception ex) {
            System.err.println("No fue posible escribir el archivo " + f.getName());
            System.err.println(ex.toString());
        }
        //Completar usando toDelimitedString() de Empleado
        // y Files.write()
    }

    /**
     * Carga en la coleccion de empleados los datos existentes en un fichero
     * Delimitado
     *
     * @param f (File) Fichero del cual se quieren cargar los datos
     * @param delim (String) Cadena con el caracter o caracteres delimitadores
     * del fichero.
     * @throws IOException
     */
    public void importDelFrom(File f, String delim) {
        List<String> empleadosEnDelimitado = null;
        try {
            empleadosEnDelimitado = Files.readAllLines(f.toPath());
            for (int i = 0; i < empleadosEnDelimitado.size(); i++) {
                empleados.add(new Empleado(empleadosEnDelimitado.get(i), delim));
            }
        } catch (IOException ex) {
                System.err.println("No fue posible leer " + f.getName() + ", saliendo.");
                System.err.println(ex.toString());
                System.exit(1);
            }
        //Completar usando empleadosEnDelimitado() de Empleado
        // y Files.readAllLines()
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="RW ficheros Encolumnados">
    /**
     * Crea un fichero Encolumnado a partir de los datos de la coleccion de
     * empleados.
     *
     * @param f (File) Fichero que se quiere formar.
     * @param longis (int[]) Contiene en las posiciones relativas a las columnas
     * el tamaño de cada una de ellas.
     */
    public void exportEncTo(File f, int longis[]) {
        //ArrayList<String> lineas = new ArrayList<>();
        List<String> lista = new ArrayList<>();
        try {
            for (Empleado e : empleados) {
                lista.add(e.toColumnadoString(longis));
            }
            Files.write(f.toPath(), lista, Charset.forName("UTF-8"));
        } catch (Exception ex) {
            System.err.println("No fue posible escribir el archivo " + f.getName());
            System.err.println(ex.toString());
        }
        //Completar usando toColumnadodString() de Empleado
        // y Files.write()
    }

    /**
     * Carga los datos de un fichero en la coleccion de empleados.
     *
     * @param f (File) Fichero del cual se quieren cargar los datos.
     * @param longis (int[]) longitud de las columnas, coincidencia entre
     * posicion y columna
     */
    public void importarEncFrom(File f, int longis[]) {
        List<String> lista = null;
        try {
            lista = Files.readAllLines(f.toPath());
            for (int i = 0; i < lista.size(); i++) {
                empleados.add(new Empleado(lista.get(i), longis));
            }
        } catch (IOException ex) {
            System.err.println("No fue posible leer " + f.getName() + ", saliendo.");
            System.err.println(ex.toString());
            System.exit(1);
        }
        //Completar usando un constructor de Empleado
        // y Files.readAllLines()
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="RW ficheros Binarios">
    /**
     * Crea un fichero Binario con los empleados cargados en la coleccion.
     *
     * @param f (File) Fichero en el cual se quieren escribir los datos.
     */
    public void saveEmpleados(File f) {
        DataOutputStream dos;
        BufferedOutputStream bos;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(f);
            bos = new BufferedOutputStream(fos);
            dos = new DataOutputStream(bos);
            dos.writeInt(empleados.size());
            for (Empleado empl : empleados) {
                dos.writeInt(empl.getId());
                dos.writeUTF(empl.getNombre());
                dos.writeUTF(empl.getApell1());
                dos.writeUTF(empl.getApell2());
                dos.writeFloat(empl.getSalario());
            }
            dos.close();
        } catch (Exception ex) {
            System.err.println("No fue posible escribir el archivo " + f.getName());
            System.err.println(ex.toString());
        }
    }

    /**
     * Carga los datos almacenados en un fichero Binario en la coleccion de
     * empleados
     *
     * @param f (File) Fichero que contienen los datos que se quieren cagar.
     */
    public void readEmpleados(File f) {
        DataInputStream dis;
        BufferedInputStream bis;
        FileInputStream fis;
        try {
            fis = new FileInputStream(f);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);
            int numEmpleados = dis.readInt();
            for (int i = 0; i < numEmpleados; i++) {
                Empleado empl = new Empleado();
                empl.setId(dis.readInt());
                empl.setNombre(dis.readUTF());
                empl.setApell1(dis.readUTF());
                empl.setApell2(dis.readUTF());
                empl.setSalario(dis.readFloat());
                this.getEmpleados().add(empl);
            }
            dis.close();
        } catch (IOException ex) {
            System.err.println("No fue posible leer " + f.getName() + ", saliendo.");
            System.err.println(ex.toString());
            System.exit(1);
        }
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="RW ficheros Objetos">
    /**
     * Crea un fichero de Objetos a partir de la coleccion de objetos de
     * empleados.
     *
     * @param f (File) Fichero en el que se quieren almacenar los datos.
     */
    public void saveEmpleadosAsObject(File f) {
        try {
            ObjectOutputStream oos;
            BufferedOutputStream bos;
            FileOutputStream fos;
            fos = new FileOutputStream(f);
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this.empleados);
            oos.close();
        } catch (Exception ex) {
            System.err.println("No fue posible escribir el archivo " + f.getName());
            System.err.println(ex.toString());
        }
    }

    /**
     * Carga los datos almacenados en un Fichero de Objetos en la coleccion de
     * empleados.
     *
     * @param f (File) Fichero que contiene los datos que se quieren cargar.
     */
    public void readAEmpleadosAsObject(File f) {
        ObjectInputStream ois;
        BufferedInputStream bis;
        FileInputStream fis;
        if (f.exists()) {
            try {
                fis = new FileInputStream(f);
                bis = new BufferedInputStream(fis);
                ois = new ObjectInputStream(bis);
                this.empleados = (ArrayList<Empleado>) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println("No fue posible leer " + f.getName() + ", saliendo.");
                System.err.println(ex.toString());
                System.exit(1);
            }
        }
    }

    //</editor-fold>
    
}//Fin Class Modelo 
