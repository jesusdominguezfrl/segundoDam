/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import java.awt.Color;
import javax.swing.JRadioButton;

/**
 *
 * @author usuario
 */
public class JRadioButtonColor extends JRadioButton{
    
    public enum Colores{
        WHITE("Blanco",255,255,255),
        BLACK("Negro",0,0,0),
        RED("Rojo",255,0,0),
        GREEN("Verde",0,255,0),
        BLUE("Azul",0,0,255),
        MAGENTA(255,0,255),
        YELLOW("Amarillo",255,255,0),
        CYAN("Cyan",0,255,255);
        private int Red;
        private int Green;
        private int Blue;
        private String text;
        private Colores(){}
        Colores(String texto, int Red, int Green, int Blue){
           this.text=texto;
           this.Red=Red;
           this.Green=Green;
           this.Blue=Blue;
        }
        Colores(int Red, int Green, int Blue){
           this.Red=Red;
           this.Green=Green;
           this.Blue=Blue;
           this.text=super.toString(); 
        }
        @Override
        public String toString(){
            return text;
        }
        
        public Color getColor(){
            return new Color(Red, Green, Blue);
        }
    }
    
    private Colores colorAsociado;

    
    
    public Colores getColorAsociado() {
        return colorAsociado;
    }

    public void setColorAsociado(Colores colorAsociado) {
        this.colorAsociado = colorAsociado;
        setText(colorAsociado.toString());
    }
    
    
    
}
