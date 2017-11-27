/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_conectoresv3.pkg6;

import java.time.LocalDate;


/**
 *
 * @author usuario
 */
public class Empleado {

    private int nEM;
    private String apell;
    private String oficio;
    private int dir;
    private LocalDate fecha;
    private float salario;
    private float comision;
    private int nDep;


    Empleado(int nEM, String apell, String oficio, int dir, LocalDate fecha, float salario, float comision, int nDep) {
        this.nEM = nEM;
        this.apell = apell;
        this.oficio = oficio;
        this.dir = dir;
        this.fecha = fecha;
        this.salario = salario;
        this.comision = comision;
        this.nDep = nDep;
    }
    
    
   

    public int getnEM() {
        return nEM;
    }

    public void setnEM(int nEM) {
        this.nEM = nEM;
    }

    public String getApell() {
        return apell;
    }

    public void setApell(String apell) {
        this.apell = apell;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public int getnDep() {
        return nDep;
    }

    public void setnDep(int nDep) {
        this.nDep = nDep;
    }

    
}
