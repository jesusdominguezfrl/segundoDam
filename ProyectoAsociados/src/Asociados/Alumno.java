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
public class Alumno extends Asociado {

    //Definicion de los miembros particulares de la clase.
    
    public enum Curso{ESO1, ESO2, ESO3, ESO4, BACH1,BACH2, FP1, FP2}
    private Curso nombreCurso;
    private boolean familiaNumerosa;
    private double cuotaAlumno;
 
    //<editor-fold defaultstate="collapsed" desc="Constructores"> 
    //Constructores
    
    public Alumno (String nombre, String apellidos, String NIF, boolean familiaNumerosa,Curso cursoAlumno/* String name */) {
        super(nombre,apellidos,NIF);
        this.familiaNumerosa = familiaNumerosa;
        this.nombreCurso= cursoAlumno;
        /* nombreCurso = Curso.valueOf(name);*/  //Error cuando el String no coincide con algun tipo enumerado
        
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="AccesoMiembros"> 
    //Acceso a miembros privados.
    
    public boolean isFamiliaNumerosa() {
        return familiaNumerosa;
    }

    public void setFamiliaNumerosa(boolean familiaNumerosa) {
        this.familiaNumerosa = familiaNumerosa;
    }
    public Curso getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(Curso nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="MetodosClase"> 
    //MetodosClase
    
    //mail sobreescribe a la clase base (Asociado) por ser difenente en este tipo de asociado
    @Override
    public String email(){
       return getNIF()+"@"+getNombreCurso().name()+"."+"asociados.com";
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="SobreescrituraMAbstractos"> 
    //Metodos abstractos declarados en la clase base (Asociado)
    
    @Override
    public String verDatos() {
        if(isFamiliaNumerosa()) return "Alumno: "+super.toString()+getNombreCurso()+" Familia numerosa";
        else return "Alumno: "+super.toString()+getNombreCurso();
    }

    @Override
    public double verCuota() {
        cuotaAlumno=getCuota()*0.75;
        if(this.isFamiliaNumerosa())
            cuotaAlumno=cuotaAlumno/2;
        return cuotaAlumno;
                    
    }
    //</editor-fold>
    
}
