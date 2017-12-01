/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleados;

/**
 *
 * @author enrique
 */
public class EmpleadoComision extends Empleado {
    double salarioBase;
    int numeroPiezas;
    double comisionPieza;
    public EmpleadoComision(String nombre, String apellidos,double salarioBase, int numeroPiezasVendidas, double comisionPieza){
        super(nombre,apellidos);
        numeroPiezas=numeroPiezasVendidas;
        this.comisionPieza=comisionPieza;
        this.salarioBase=salarioBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getNumeroPiezas() {
        return numeroPiezas;
    }

    public void setNumeroPiezas(int numeroPiezas) {
        this.numeroPiezas = numeroPiezas;
    }

    public double getComisionPieza() {
        return comisionPieza;
    }

    public void setComisionPieza(double comisionPieza) {
        this.comisionPieza = comisionPieza;
    }
    
    @Override
    public double salario(){
        return getComisionPieza() * getNumeroPiezas() + getSalarioBase();
    }
    @Override
    public String toString(){
        return "Empleado a comisión: " + super.toString();
    }
}
 