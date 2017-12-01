/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleados;

/**
 *
 * @author enrique
 */
public class JefeProyecto extends Empleado {
    private final double incentivoPorProyecto=100.00;
    double salarioBase;
    int numeroProyectos;
    public JefeProyecto(String nombre, String apellidos, double salarioBase, int numeroProyectos){
        super(nombre,apellidos);
        this.salarioBase=salarioBase;
        this.numeroProyectos=numeroProyectos;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getNumeroProyectos() {
        return numeroProyectos;
    }

    public void setNumeroProyectos(int numeroProyectos) {
        this.numeroProyectos = numeroProyectos;
    }
    
    @Override
    public double salario(){
        return getSalarioBase()+ incentivoPorProyecto*getNumeroProyectos();
    }
    @Override
    public String toString(){
        return "Jefe de Proyecto: " + super.toString();
    }
}
