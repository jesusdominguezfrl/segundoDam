/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisComponentes.ComponenteMetronomo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author usuario
 */
public class JMetronomo implements ActionListener{ //En lugar de crear una clase privada la propia clase implementa en listener
    
    private int pulsosPorMinuto=60;
    private int totalPulsos=10;
    private Timer temporizador;
    
    public int getPulsosPorMinuto() {
        return pulsosPorMinuto;
    }

    public void setPulsosPorMinuto(int pulsosPorMinuto) {
        this.pulsosPorMinuto = pulsosPorMinuto;
    }

    public int getTotalPulsos() {
        return totalPulsos;
    }

    public void setTotalPulsos(int totalPulsos) {
        this.totalPulsos = totalPulsos;
    }
    
    public void iniciar(){
        temporizador= new Timer(60000/pulsosPorMinuto, this);
        if(temporizador.isRunning())return;
        contadorPulsos=0;
        temporizador.start();
    }

    private int contadorPulsos;
    
    @Override
    public void actionPerformed(ActionEvent e) {
            contadorPulsos++;
            System.out.println("pulso"+contadorPulsos);
            fireMetronomoPulso();
            if(contadorPulsos==totalPulsos){
                temporizador.stop();
                fireMetronomoFin();
            }
    }
    
    protected void fireMetronomoPulso(){
        MetronomoEvent e = new MetronomoEvent(this,contadorPulsos);
        for (MetronomoListener l: listeners){
            l.metronomoPulso(e);
        }
    }
    
    protected void fireMetronomoFin(){
        MetronomoEvent e = new MetronomoEvent(this);
        for (MetronomoListener l: listeners){
            l.metronomoFin(e);
        }
        System.out.println("FIN");
    }
    
    
    private ArrayList<MetronomoListener> listeners= new ArrayList<>();
    
    public void addMetronomoListener(MetronomoListener l){
        listeners.add(l);
    }
    
    public void removeMetronomoListener(MetronomoListener l){
        listeners.remove(l);
    }
}
