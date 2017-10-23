/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asociados;

/**
 *
 * @author Jesus
 */
public class Test {
    public static void main (String[]args){
       new Alumno("Alumno","ApellidoAlumno","12345678A", true, Alumno.Curso.ESO1);
       new Profesor("Profesor","ApellidoProfesor","87654321B", "informatica");
       new PadreMadre("Padre","PadreApellido","98765412C");
       new PersonaNoDocente("Persona No Docente", "Apellido PND","36985214D","jardinero");
       
        for (int i=0; i<Asociado.listaAsociados.getSize();i++) {
            System.out.println("***************************************");
            Asociado nuevo =(Asociado) Asociado.listaAsociados.elementAt(i);
            System.out.println(nuevo.verDatos());
            System.out.println(nuevo.email());
            System.out.println(nuevo.verCuota());
        }
        
    }
}
