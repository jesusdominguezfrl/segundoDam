/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisComponentes.JPodometro;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author usuario
 */
public class JPodometro extends javax.swing.JPanel {

    /**
     * Creates new form JPodometro
     */
    //<editor-fold defaultstate="collapsed" desc="Modo Enum">
    private enum Modo {
        DistanciaRecorrida("Distancia Recorrida en km."),
        DistanciaAviso("Distancia Aviso"),
        TiempoDesdeInicio("Tiempo desde Inicio"),
        TamañoPaso("Tamaño del Paso (cm).");

        private String nombre;

        private Modo() {
            this.nombre = super.toString();
        }

        private Modo(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return this.nombre;
        }
    }
//</editor-fold>

    private Modo modoActivo = Modo.TamañoPaso;
    private double tamañoPaso = 0.55;
    private double distanciaAviso = 0.5;
    private String nombreUsuario;
    private double distanciaRecorrida = 0;
    private double tiempoDesdeInicio = 0;

    private long tiempoInicio;
    private static int controlModoActivo = -1;
    private boolean seLanzoFin = false;
    private PropertyChangeSupport myPCS;

    public double getTamañoPaso() {
        return tamañoPaso;
    }

    public void setTamañoPaso(double tamañoPaso) {
        myPCS.firePropertyChange("tamañoPaso", this.tamañoPaso, this.tamañoPaso = tamañoPaso);
        this.tamañoPaso = tamañoPaso;
        muestraVisor();
    }

    public double getDistanciaAviso() {
        return distanciaAviso;
    }

    public void setDistanciaAviso(double distanciaAviso) {
        if (this.distanciaAviso < distanciaAviso) seLanzoFin = false;
        this.distanciaAviso = distanciaAviso;
        muestraVisor();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        jLabelNombre.setText(nombreUsuario);
    }

    public JPodometro() {
        initComponents();
        iniciarValoresPorDefecto();
        myPCS = new PropertyChangeSupport(this);
    }

    private void iniciarValoresPorDefecto() {
        ponerHora();
        ponerModoActivo();
        muestraVisor();
    }

    private void iniciarPodometro() {
        distanciaRecorrida = 0;
        modoActivo = Modo.values()[controlModoActivo = 0];
        tiempoInicio = Calendar.getInstance().getTimeInMillis();
        ponerHora();
        ponerModoActivo();
        muestraVisor();
    }

    public void paso() {
        avanzaPaso(tamañoPaso);
    }

    public void paso(int numeroPasos) {
        avanzaPaso(tamañoPaso * numeroPasos);
    }

    private void avanzaPaso(double distanciaPasos) {
        if (tiempoInicio != 0) {
            distanciaRecorrida += distanciaPasos / 1000;
            muestraVisor();
            System.out.printf("distancia recorrida → %02.3f ", distanciaRecorrida);
            System.out.println("tiempo desde inicio → " + tiempoDesdeInicio);
            if (distanciaRecorrida >= distanciaAviso && !seLanzoFin) {
                firePodometroMeta();
                seLanzoFin = true;
            }
        }
    }

    private void ponerHora() {
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
        jLabelReloj.setText(formato.format(new Date()));
    }

    private void ponerModoActivo() {
        jLabelModo.setText(modoActivo.toString());
    }

    private void muestraVisor() {
//        jLabelVisor.setText(String.valueOf((controlModoActivo == 0) ? String.format("%02.3f", distanciaRecorrida) : (controlModoActivo == 1) ? String.format("%02.3f", distanciaAviso) : (controlModoActivo == 2) ? tiempoDesdeInicio : tamañoPaso));
        tiempoDesdeInicio = (Calendar.getInstance().getTimeInMillis() - tiempoInicio) / 1000;
        String texto = "";
        switch (modoActivo) {
            case DistanciaAviso:
                texto = String.valueOf(String.format("%02.3f", distanciaAviso));
                break;
            case DistanciaRecorrida:
                texto = String.valueOf(String.format("%02.3f", distanciaRecorrida));
                break;
            case TamañoPaso:
                texto = String.valueOf(tamañoPaso);
                break;
            case TiempoDesdeInicio:
                texto = String.valueOf(tiempoDesdeInicio);
                break;
        }
        jLabelVisor.setText(texto);
    }

    private ArrayList<PodometroListener> listeners = new ArrayList();

    public void addPodometroListener(PodometroListener l) {
        listeners.add(l);
    }

    public void removePodometroListener(PodometroListener l) {
        listeners.remove(l);
    }

    protected void firePodometroSalida() {
        PodometroEvent evt = new PodometroEvent(this);
        for (PodometroListener l : listeners) {
            l.podometroSalida(evt);
        }
        System.out.println("Fire Salida");

    }

    protected void firePodometroMeta() {
        PodometroEvent evt = new PodometroEvent(this, distanciaRecorrida, tiempoDesdeInicio);
        for (PodometroListener l : listeners) {
            l.podometroMeta(evt);
        }
        System.out.println("Fire Meta");

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        if (myPCS == null) {
            return;
        }
        this.myPCS.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.myPCS.removePropertyChangeListener(listener);
    }

//    protected void fireCambio() {
//        PodometroEvent evt = new PodometroEvent(this);
//        for (PodometroListener l : listeners) {
//            l.cambio(evt);
//        }
//        System.out.println("Fire cambio");
//
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNombre = new javax.swing.JLabel();
        jLabelReloj = new javax.swing.JLabel();
        jLabelModo = new javax.swing.JLabel();
        jLabelVisor = new javax.swing.JLabel();
        jButtonModo = new javax.swing.JButton();
        jButtonReiniciar = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(255, 255, 0));
        jLabelNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre.setText("Nombre");

        jLabelReloj.setBackground(new java.awt.Color(0, 0, 0));
        jLabelReloj.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabelReloj.setForeground(new java.awt.Color(0, 204, 204));
        jLabelReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelReloj.setText("hora");
        jLabelReloj.setOpaque(true);

        jLabelModo.setBackground(new java.awt.Color(0, 0, 0));
        jLabelModo.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabelModo.setForeground(new java.awt.Color(0, 204, 204));
        jLabelModo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelModo.setText("modo");
        jLabelModo.setOpaque(true);

        jLabelVisor.setBackground(new java.awt.Color(0, 0, 0));
        jLabelVisor.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabelVisor.setForeground(new java.awt.Color(0, 204, 204));
        jLabelVisor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVisor.setText("visor");
        jLabelVisor.setOpaque(true);
        jLabelVisor.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jLabelVisorComponentResized(evt);
            }
        });

        jButtonModo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonModo.setForeground(new java.awt.Color(0, 0, 102));
        jButtonModo.setText("Modo");
        jButtonModo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModoActionPerformed(evt);
            }
        });

        jButtonReiniciar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonReiniciar.setForeground(new java.awt.Color(0, 0, 102));
        jButtonReiniciar.setText("Reiniciar");
        jButtonReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReiniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelModo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabelVisor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButtonModo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButtonReiniciar, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jLabelModo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelVisor, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonReiniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabelModo, jLabelReloj});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonModo, jButtonReiniciar});

    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReiniciarActionPerformed
        iniciarPodometro();
        firePodometroSalida();
    }//GEN-LAST:event_jButtonReiniciarActionPerformed

    private void jButtonModoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModoActionPerformed
        modoActivo = Modo.values()[(++controlModoActivo < Modo.values().length) ? controlModoActivo : (controlModoActivo = 0)];
        ponerModoActivo();
        muestraVisor();
    }//GEN-LAST:event_jButtonModoActionPerformed

    private void jLabelVisorComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabelVisorComponentResized
        jLabelVisor.setFont(jLabelVisor.getFont().deriveFont((float) jLabelVisor.getHeight() * 2 / 3));
    }//GEN-LAST:event_jLabelVisorComponentResized


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonModo;
    private javax.swing.JButton jButtonReiniciar;
    private javax.swing.JLabel jLabelModo;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelReloj;
    private javax.swing.JLabel jLabelVisor;
    // End of variables declaration//GEN-END:variables
}
