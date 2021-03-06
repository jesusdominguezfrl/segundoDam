package primero;
// Generated 05-feb-2018 11:48:52 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Empleados generated by hbm2java
 */
public class Empleados  implements java.io.Serializable {


     private short empNo;
     private Departamentos departamentos;
     private String apellido;
     private String oficio;
     private Integer dir;
     private Date fechaAlta;
     private Float salario;
     private Float comision;

    public Empleados() {
    }

	
    public Empleados(short empNo) {
        this.empNo = empNo;
    }
    public Empleados(short empNo, Departamentos departamentos, String apellido, String oficio, Integer dir, Date fechaAlta, Float salario, Float comision) {
       this.empNo = empNo;
       this.departamentos = departamentos;
       this.apellido = apellido;
       this.oficio = oficio;
       this.dir = dir;
       this.fechaAlta = fechaAlta;
       this.salario = salario;
       this.comision = comision;
    }
   
    public short getEmpNo() {
        return this.empNo;
    }
    
    public void setEmpNo(short empNo) {
        this.empNo = empNo;
    }
    public Departamentos getDepartamentos() {
        return this.departamentos;
    }
    
    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getOficio() {
        return this.oficio;
    }
    
    public void setOficio(String oficio) {
        this.oficio = oficio;
    }
    public Integer getDir() {
        return this.dir;
    }
    
    public void setDir(Integer dir) {
        this.dir = dir;
    }
    public Date getFechaAlta() {
        return this.fechaAlta;
    }
    
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public Float getSalario() {
        return this.salario;
    }
    
    public void setSalario(Float salario) {
        this.salario = salario;
    }
    public Float getComision() {
        return this.comision;
    }
    
    public void setComision(Float comision) {
        this.comision = comision;
    }

    @Override
    public String toString() {
        return String.format("%-5d%-20s%-20s%-5d%-15s%-10f-10f", empNo, apellido, oficio, dir, (fechaAlta.toString()), salario, comision);
    }


}


