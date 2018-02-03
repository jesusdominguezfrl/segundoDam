/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Modelo.ModeloHibernate;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class VistaHiberante {
    ModeloHibernate m= new ModeloHibernate();
    
    public void modificarDatos(String tabla){
        if (tabla == null) return;
        if ("empleados".equals(tabla)) {
            m.modificarEmpleado();
        } else {
            m.modificarDepartamento();
        }
    }
    
    public void insertarDatos(String tabla){
        if (tabla == null) return;
        if ("empleados".equals(tabla)) {
            m.insertarEmpleado();
        } else {
            m.insertarDepartamento();
        }
    }
    
    public void borraDatos(String tabla){
        if (tabla == null) return;
        if ("empleados".equals(tabla))m.borrarEmpleado();
        else m.borrarDepartamento();
        
    }
    
    public void listarDatos(String tabla){
        if(tabla==null)return;
        if("empleados".equals(tabla)) m.listaEmpleados();
        else if("departamentos".equals(tabla)) m.listaDepartamentos();
        else{
            System.out.print("Indique el numero del departamento del cual quiere listar los empleados: ");
            m.listaEmpleadosDepto((new Scanner (System.in)).nextLine());
        }
    }
    
    public void consultarDatos(String info){
        if(info==null)return;
        if("infoDepartamentos".equals(info)){
            System.out.print("Introduzca el numero de departamento del que quieres consultar la informacion: ");
            m.consultaInfoDepartamento((new Scanner (System.in)).nextLine());
        }else
            m.consultaInfoEmpresa();
    }
    
}
