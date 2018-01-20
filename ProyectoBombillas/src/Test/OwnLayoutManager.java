/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Point;
import javax.swing.JButton;

/**
 *
 * @author usuario
 */
public class OwnLayoutManager implements LayoutManager{

    Container contenedor;
    private int x=0;
    private int y=0;
    private int anchoComponente=255;
    private int altoComponente=230;
    private int hGap=10;
    private int vGap=15;
    private int margenTop=10;
    private int margenBottom=10;
    private int margenLeft=20;
    private int margenRigth=0;

//    public OwnLayoutManager() {
//        inicializaLayout();
//    }
//    
    
    
    
    @Override
    public void addLayoutComponent(String name, Component comp) {
        colocarUno(comp);
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        colocarTodos();
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return new Dimension(0, 0);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return new Dimension(0, 0);
    }

    @Override
    public void layoutContainer(Container parent) {
        contenedor=parent;
        colocarTodos();
    }
    
    private void inicializaLayout(){
        x=contenedor.getInsets().left+margenLeft;
        y=contenedor.getInsets().top+margenTop;
    }
    
    private void colocarUno(Component c){
        c.setSize(anchoComponente,altoComponente);
        if(x+anchoComponente > contenedor.getWidth()-margenRigth-contenedor.getInsets().right){
            x=contenedor.getInsets().left+margenLeft;
            y+=(altoComponente+vGap);
        }
        c.setLocation(new Point(x, y));
        x+=(anchoComponente+hGap);
    }
    
    public void colocarTodos(){
        inicializaLayout();
        for (Component c: contenedor.getComponents()){
            if(c instanceof JButton)return;
            colocarUno(c);
        }
    }
    
    
    //</editor-fold>
}
