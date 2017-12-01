/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleados;

/**
 *
 * @author enrique
 */
public class EmpleadoHoras extends Empleado {
    int numeroHoras;
    double salarioHora;
    public EmpleadoHoras(String nombre, String apellidos,int numeroHorasTrabajadas, double salarioHora){
        super(nombre,apellidos);
        numeroHoras=numeroHorasTrabajadas;
        this.salarioHora=salarioHora;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(double salarioHora) {
        this.salarioHora = salarioHora;
    }
    
    @Override
    public double salario(){
        return getSalarioHora() * getNumeroHoras();
    }
    @Override
    public String toString(){
        return "Empleado por horas: " + super.toString();
    }
}
