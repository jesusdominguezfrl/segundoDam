/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author jc
 *
 * Empleado: Clase que contiene todos los atributos necesarios para la gestion
 * de empleados 
 *          id: numero identificador del empleado ( Generado automaticamente) 
 *         nombre: (String) Nombre del empleado 
 *         apell1: (String)  Apellido 1 del empleado  
 *         apell2: (String) Apellido 2 del empleado
 *         salario: (Float) Almacena el salario de un empleado.
 *
 */
@XmlType(propOrder = {"id", "nombre", "apell1", "apell2", "salario"})  //Anotacion para tratamiento JAXB(Orden de los atributos en el XML)
public class Empleado implements Serializable {

    private int id;
    private String nombre;
    private String apell1;
    private String apell2;
    private float salario;
    private static int identif = 0;
    private static final String[] nombres = {"Juan", "Ricardo", "Rosa", "Ana", "Sandra", "Laura", "Mario", "José", "Gael", "Clara", "Carlos", "Paz"};
    private static final String[] apellidos = {"Wayne", "García", "Castro", "Lane", "Cano", "Pérez", "Martín", "Gil", "Iglesias", "Sánchez"};
    private static final float[] salarios = {900, 1200, 1600, 1800, 2000, 2200, 3000};

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Empleado() {
        this.id = identif++;
    }
/**
 * Constructor con parametros para crear un objeto con todos los datos pasados como argumentos
 * @param id (int) Numero identificador de empleado
 * @param nombre (String) Cadena con el nombre del empleado
 * @param apell1 (String) Cadena con el Apellido 1 del empleado
 * @param apell2 (String) Cadena con el Apellido 2 del empleado
 * @param salario (Float) Valor del salario del empleado
 */
    public Empleado(int id, String nombre, String apell1, String apell2, float salario) {
        this.id = id;
        this.nombre = nombre;
        this.apell1 = apell1;
        this.apell2 = apell2;
        this.salario = salario;
    }
    /**
     * Constructor que genera un objeto de tipo empleado obtenido a partir de la lectura de la lectura DOM  
     * @param empleado Elemento que contiene toda la informacion de los atributos de cada empleado 
     */
    public Empleado(Element empleado) {
        this.id = Integer.parseInt(getNodo("id", empleado));
        this.nombre = getNodo("nombre", empleado);
        this.apell1 = getNodo("apell1", empleado);
        this.apell2 = getNodo("apell2", empleado);
        this.salario = Float.parseFloat(getNodo("salario", empleado));
    }

/**
 * Constructor que genera un objeto de tipo empleado a partir de la cadena pasada leida de un fichero delimitado
 * @param linea cadena String con una linea del fichero que contiene la informacion de los atributos del objeto 
 * @param delim cadena String con el caracter o caracteres del delimitador 
 */
    public Empleado(String linea, String delim) {            // Se fragmente la línea en campos con split. El primero es (delimitadores)
        String variables[];
        variables = linea.split(delim);
        setId(Integer.valueOf(variables[0]));
        setNombre(variables[1]);
        setApell1(variables[2]);
        setApell2(variables[3]);
        setSalario(Float.valueOf(variables[4]));

    }
    /**
     * Constructor que genera un objeto de tipo empleado a partir de la cadena pasada leida de un fichero encolumnado
     * @param s cadena String con una linea del fichero que contiene la informacion de los atributos del objeto
     * @param longis Array que contiene el valor de cada columna, en cada columna se encuantra almacenado el valor de un atributo
     */
    public Empleado(String s, int longis[]) {             //Se recomienda subString(longitud inicial longitud final)  Numero de columnas dado en longis
        setId(Integer.valueOf(s.substring(0, longis[0]).trim()));
        setNombre(s.substring(longis[0], longis[0] + longis[1] - 1));
        setApell1(s.substring(longis[0] + longis[1], longis[0] + longis[1] + longis[2] - 1));
        setApell2(s.substring(longis[0] + longis[1] + longis[2], longis[0] + longis[1] + longis[2] + longis[3] - 1));
        setSalario(Float.valueOf(s.substring(longis[0] + longis[1] + longis[2] + longis[3], longis[0] + longis[1] + longis[2] + longis[3] + longis[4] - 1).trim().replaceAll(",", ".")));
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodos para crear empleados">
    
    /**
     * Genera un empleado aleatorio
     */
    public void emp_aleatorio() {
        Random r = new Random();
        setNombre(nombres[r.nextInt(nombres.length)]);
        setApell1(apellidos[r.nextInt(apellidos.length)]);
        setApell2(apellidos[r.nextInt(apellidos.length)]);
        setSalario(salarios[r.nextInt(salarios.length)]);
    }

    /**
     * Pide los atributos al usuario para insertar un empleado nuevo a la coleccion
     */
    public void emp_teclado() {
        Scanner sc = new Scanner(System.in, System.getProperty("os.name").contains("Windows") ? "iso-8859-1" : "UTF-8");
        System.out.println("Nombre: ");
        setNombre(sc.nextLine());
        System.out.println("Apellido 1: ");
        setApell1(sc.nextLine());
        System.out.println("Apellido 2: ");
        setApell2(sc.nextLine());
        setSalario(readFloat("Salario: "));
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters y Setters">
    
    /**
     * @return the id
     */
    @XmlElement(name = "id") //Anotacion para tratamiento JAXB (Da nombre al tag XML que contiene el "id")
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    @XmlElement(name = "nombre")//Anotacion para tratamiento JAXB (Da nombre al tag XML que contiene el "nombre")
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apell1
     */
    @XmlElement(name = "apell1")//Anotacion para tratamiento JAXB (Da nombre al tag XML que contiene el "apell1")
    public String getApell1() {
        return apell1;
    }

    /**
     * @param apell1 the apell1 to set
     */
    public void setApell1(String apell1) {
        this.apell1 = apell1;
    }

    /**
     * @return the apell2
     */
    @XmlElement(name = "apell2")//Anotacion para tratamiento JAXB (Da nombre al tag XML que contiene el "apell2")
    public String getApell2() {
        return apell2;
    }

    /**
     * @param apell2 the apell2 to set
     */
    public void setApell2(String apell2) {
        this.apell2 = apell2;
    }

    /**
     * @return the salario
     */
    @XmlElement(name = "salario")//Anotacion para tratamiento JAXB (Da nombre al tag XML que contiene el "salario")
    public float getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Formato de Salida para los empleados" > 

    /**
     * 
     * @return String que contiene el valor de los atributos de un empleado.
     */
    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apell1=" + apell1 + ", apell2=" + apell2 + ", salario=" + salario + '}';
    }

    /**
     * 
     * @return String que contiene los atributos de un empleado para mostrarlos de forma encolumnada
     */
    public String toEncFormat() {
        String temp = String.format("%4d  %-20s%-20s%-20s%10.2f", id, nombre, apell1, apell2, salario);
        return temp;
    }
    

/**
 * Crea una linea con los datos del empleado usando delimitadores para separar atributos del empleado
 * @param delim contiene el caracter delimitador que se ha de usar a la hora de crear una linea del fichero
 * @return String -->Linea  en formato delimitado 
 */
    public String toDelimitedString(String delim) {
        StringBuilder s = new StringBuilder();
        s.append(getId());
        s.append(delim);
        s.append(getNombre());
        s.append(delim);
        s.append(getApell1());
        s.append(delim);
        s.append(getApell2());
        s.append(delim);
        s.append(getSalario());
        s.append(delim);
        //completar 
        //Crear linea con el delimitador recibido como parametro

        return s.toString();
    }

    /**
     * Crea una linea con los datos del empleado encolumnando para separar atributos del empleado
     * @param longis array que contiene la longitud de la columna del fichero 
     * @return String --> Linea  en formato encolumnado
     */
    public String toColumnadoString(int longis[]) {
        String s = "%-" + longis[0] + "d";
        s += "%-" + longis[1] + "s";
        s += "%-" + longis[2] + "s";
        s += "%-" + longis[3] + "s";
        s += "%" + longis[4] + ".2f";
        //completar
        //Crea una linea apartir del vector de longitudes(columnas)

        return String.format(s, this.id, this.nombre, this.apell1, this.apell2, this.salario);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Otros metodos">
    
/**
 *  Separa el valor de un determinado atributo dentro de un objeto
 * @param etiqueta nombre de la etiqueta de la cual queremos extraer el valor del atributto
 * @param elemento contiene el objeto con todos sus atributos
 * @return 
 */
    private String getNodo(String etiqueta, Element elemento) {
        NodeList nodo = elemento.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valorNodo = (Node) nodo.item(0);
        return valorNodo.getNodeValue();
    }
    
    /**
     * Validacion de un numero tipo Float
     * @param prompt
     * @return 
     */
    static public float readFloat(String prompt) {
        Scanner sc = new Scanner(System.in,
                System.getProperty("os.name").contains("Windows") ? "iso-8859-1" : "UTF-8");
        float tempNumber = 0;
        String temp;
        boolean numberOkay;
        do {
            numberOkay = false;
            do {
                System.out.printf("%s ", prompt);
                temp = sc.nextLine();
            } while (temp.isEmpty());
            try {
                tempNumber = Float.parseFloat(temp);
                numberOkay = true;
            } catch (Exception e) {
                System.out.printf("%nEse número no es correcto. Pruebe de nuevo.%n");
                numberOkay = false;
            }
        } while (!numberOkay);
        return tempNumber;
    }
    
    //</editor-fold>
    
}
