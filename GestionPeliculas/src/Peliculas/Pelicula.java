/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peliculas;

import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;
import javax.swing.DefaultListModel;

/**
 *
 * @author usuario
 */
public class Pelicula {
    
    public enum Genero{
        ACCION,
        INTRIGA,
        TERROR,
        COMEDIA,
        COMEDIA1 ("Comedia Española"),
        COMEDIA2 ("Comedia Italiana"),
        COMEDIA3 ("Comedia Latina"),
        COMEDIA4 ("Comedia USA"),
        NOVELA,
        THRILLER,
        ROMANTICA;
        
        private String texto;
        private Genero(){
            this.texto=super.toString();
        }
        private Genero(String tx){
            this.texto=tx;
        }
        @Override
        public String toString(){
            return texto;
        }
    }
    private String titulo;
    private String director;
    private Genero genero;
    private int año;
    private int edadRecomendada;
    public static DefaultListModel<Pelicula> peliculas = new DefaultListModel<>();

    public Pelicula(String titulo, String director, Genero genero, int año, int edadRecomendada) {
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.año = año;
        this.edadRecomendada = edadRecomendada;
        peliculas.addElement(this);
    }

    public Genero getGenero() {
        return genero;
    }
    
    @Override
    public String toString(){
        return titulo;
    }
    
    public String verDatos() {
        return "Director: "+ director+ "\nGenero: "+ genero+ "\nAño: "+ año+ "\nEdad Recomendada: "+edadRecomendada;
    }
    
    
    
    
}
