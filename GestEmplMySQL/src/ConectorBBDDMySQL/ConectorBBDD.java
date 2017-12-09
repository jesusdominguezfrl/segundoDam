/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConectorBBDDMySQL;

import entidades.Empleado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Modelo;

/**
 *
 * @author Jesus
 */
public class ConectorBBDD {
    
    
    public ConectorBBDD(){
        
    }
    
    
    public void exportarDatosBBDD(Modelo m){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "123456")){
                Statement sentencia = conexion.createStatement();
                System.out.println("Exportando datos a la BBDD");
                sentencia.execute("TRUNCATE TABLE proyectoempleados.empleadoscoleccion");
                for (Empleado e : m.getEmpleados()) {
                    //INSERT INTO empleados VALUES (1, 'López', 'contable', 345, '1987-10-23', 23400.32, 5.34, 10);
                    sentencia.execute("INSERT INTO proyectoempleados.empleadoscoleccion VALUES"+"("+e.getId()+",'"+e.getNombre()+"','"+e.getApell1()+"','"+e.getApell2()+"',"+e.getSalario()+");");
                }
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        
        
    }//fin exportar a BBDD
    
    public void importarDatosBBDD(Modelo m){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "123456")){
                Statement sentencia = conexion.createStatement();
                ResultSet resul=sentencia.executeQuery("SELECT * FROM proyectoempleados.empleadoscoleccion");
                while(resul.next()){
                    m.getEmpleados().add(new Empleado(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4), resul.getFloat(5)));
                    //System.out.println(resul.getInt(1)+","+ resul.getString(2)+","+ resul.getString(3)+","+ resul.getString(4)+","+ resul.getFloat(5));
                }
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        
        
    }//fin exportar a BBDD
    
}
