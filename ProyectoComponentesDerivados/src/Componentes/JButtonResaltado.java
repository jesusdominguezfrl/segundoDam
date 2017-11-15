/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author usuario
 */
public class JButtonResaltado extends JButton  {
    
    private gestorMouse miGestorRaton= new gestorMouse();
    private Font fuente=null;
    
    public JButtonResaltado() {
        this.addMouseListener(miGestorRaton);
       // this.fuente=super.getFont();
    }
    
    
    private class gestorMouse implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            
            JButtonResaltado boton= (JButtonResaltado) e.getSource();
            boton.setFont((fuente.deriveFont((float)fuente.getSize()*3/4)));
            System.out.println("press");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("soltado");
            
            JButtonResaltado boton= (JButtonResaltado) e.getSource();
            if(boton.contains(e.getPoint())) boton.setFont((fuente.deriveFont((float)fuente.getSize()*4/3)));
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println("entra");
            JButtonResaltado boton= (JButtonResaltado) e.getSource();
            if(fuente==null) fuente=boton.getFont();
            boton.setFont((fuente.deriveFont((float)fuente.getSize()*4/3)));
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButtonResaltado boton= (JButtonResaltado) e.getSource();
            boton.setFont((fuente.deriveFont((float)fuente.getSize())));
            System.out.println("sale");
        }
        
    }
    
}
