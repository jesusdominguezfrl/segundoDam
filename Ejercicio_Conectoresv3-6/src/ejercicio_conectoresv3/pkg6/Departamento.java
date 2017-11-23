/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_conectoresv3.pkg6;

/**
 *
 * @author usuario
 */
public class Departamento {
    
    private int dept_no;
    private String nombre;
    private String loc;
    
    public Departamento(int dept_no, String nomre, String loc){
        this.dept_no=dept_no;
        this.nombre=nomre;
        this.loc=loc;
    }

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
    
    
}
