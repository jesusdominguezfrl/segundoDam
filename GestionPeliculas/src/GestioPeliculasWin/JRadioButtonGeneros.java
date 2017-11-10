/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestioPeliculasWin;

import Peliculas.Pelicula;
import javax.swing.JRadioButton;

/**
 *
 * @author usuario
 */
class JRadioButtonGeneros extends JRadioButton {

    public JRadioButtonGeneros(){
        super("JRadioButtonGenero");
    }
    
    public JRadioButtonGeneros(String text) {
        super(text);
    }
    private Peliculas.Pelicula.Genero genero;

    public Pelicula.Genero getGenero() {
        return genero;
    }

    public void setGenero(Pelicula.Genero genero) {
        this.setText(genero.toString());
        this.genero = genero;
    }
    public JRadioButtonGeneros(String text, Pelicula.Genero genero){
        super(text);
        this.genero=genero;
    }
}
