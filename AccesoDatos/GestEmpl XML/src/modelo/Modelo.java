package modelo;

import entidades.Empleado;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.InputSource;

/**
 *
 * @author Jc
 */
public class Modelo extends InputSource implements Serializable  {

    public static  ArrayList<Empleado> empleados;
    private File empleadosDelimitado;
    private File empleadosEncolumnado;
    private File empleadosBinario;
    private File empleadosObjeto;

    public Modelo() {
        this.empleadosDelimitado = new File("empleados.del");
        this.empleadosEncolumnado = new File("empleados.encol");
        this.empleadosBinario = new File("empleados.bin");
        this.empleadosObjeto = new File("empleados.obj");
        empleados = new ArrayList<>();
    }

    public void mostrarEmpleados() {
        for (Empleado e: empleados){
            System.out.println(e.toEncFormat());
        }
        // Fácil usando el método de Empleado toEncFormat()
       
    }

    public void generarAleatorios(int n) {
        Empleado nuevoaleatorio;
        for (int i = 0; i < n; i++) {
           nuevoaleatorio= new Empleado();
           nuevoaleatorio.emp_aleatorio();
            empleados.add(nuevoaleatorio);
        }
        // Fácil usando el método de Empleado emp_aleatorio()
        
    }
    

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public File getEmpleadosDelimitado() {
        return empleadosDelimitado;
    }

    public File getEmpleadosEncolumnado() {
        return empleadosEncolumnado;
    }

    public File getEmpleadosObjeto() {
        return empleadosObjeto;
    }

    public void setEmpleadosObjeto(File empleadosObjeto) {
        this.empleadosObjeto = empleadosObjeto;
    }
   
    public void setEmpleadosEncolumnado(File empleadosEncolumnado) {
        this.empleadosEncolumnado = empleadosEncolumnado;
    }

    public File getEmpleadosBinario() {
        return empleadosBinario;
    }

    public void setEmpleadosBinario(File empleadosBinario) {
        this.empleadosBinario = empleadosBinario;
    }

    public void setEmpleadosDelimitado(File empleadosDelimitado) {
        this.empleadosDelimitado = empleadosDelimitado;
    }

    @Override
    public String toString() {
        return "Modelo{" + "empleados=" + empleados + '}';
    }

    public void exportDelTo(File f, String delim) {
        List<String> lista = new ArrayList<>();
        try {
            for(Empleado e: empleados){
                lista.add(e.toDelimitedString(delim));
            }
            Files.write(f.toPath(), lista, Charset.forName("UTF-8"));
        } catch (Exception e) {
            System.out.println("Error al exportar a fichero Delimitado");
        }
        
        //Completar usando toDelimitedString() de Empleado
        // y Files.write()
        
    }

    public void importDelFrom(File f, String delim) throws IOException {
        List<String> empleadosEnDelimitado = null;
        try {
            empleadosEnDelimitado=Files.readAllLines(f.toPath());
            for (int i = 0; i <empleadosEnDelimitado.size(); i++) {
                empleados.add(new Empleado (empleadosEnDelimitado.get(i),delim));
            }
        } catch (Exception e) {
            System.out.println("Error al importar desde Delimitado");
        }
        //COMPLETAROK
        //Completar usando empleadosEnDelimitado() de Empleado
        // y Files.readAllLines()
       
    }

    public void exportEncTo(File f, int longis[]) {
        ArrayList<String> lineas = new ArrayList<>();
        List<String> lista = new ArrayList<>();
        try {
            for(Empleado e: empleados){
                lista.add(e.toColumnadoString(longis));
            }
            Files.write(f.toPath(), lista, Charset.forName("UTF-8"));
        } catch (Exception e) {
            System.out.println("Error al exportar a fichero Encolumnado");
        }
        
        //Completar usando toColumnadodString() de Empleado
        // y Files.write()
        
    }

    public void importarEncFrom(File f, int longis[]) {
        List<String> lista = null;
        try {
            lista= Files.readAllLines(f.toPath());
            for (int i = 0; i < lista.size(); i++) {
                empleados.add(new Empleado(lista.get(i),longis));
            }
          } catch (Exception e) {
              System.out.println("Error al Importar desde encolumnado");
        }
        //COMPLETAROK
        //Completar usando un constructor de Empleado
        // y Files.readAllLines()
        
    }

    public void saveEmpleados(File f) {
        try {
            DataOutputStream dos;
            BufferedOutputStream bos;
            FileOutputStream fos;
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
            System.err.println("No fue posible crear " + f.getName());
        }
    }

    public void readEmpleados(File f) {
        try {
            DataInputStream dis;
            BufferedInputStream bis;
            FileInputStream fis;
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
        } catch (Exception ex) {
            System.err.println("No fue posible leer " + f.getName());
        }
    }

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
}
