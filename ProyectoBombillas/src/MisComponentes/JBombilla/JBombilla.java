/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisComponentes.JBombilla;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Jesus
 */
public class JBombilla extends javax.swing.JPanel {

    /**
     * Creates new form JBombilla
     */
    public static enum Ubicaciones {
        SIN_DEFINIR("SIN DEFINIR"),
        SALON,
        CUARTO_DE_BAÑO("CUARTO DE BAÑO"),
        DORMITORIO_PRINCIPAL("DORMITORIO PRINCIPAL"),
        DORMITORI_INFANTIL("DORMITORIO INFANTIL"),
        //        asdsad,weqweqew,kmkl,
        COCINA;
        String habitaculo;

        private Ubicaciones() {
            this.habitaculo = super.toString();
        }

        private Ubicaciones(String habitaculo) {
            this.habitaculo = habitaculo;
        }

        @Override
        public String toString() {
            return this.habitaculo;
        }
    }

    private enum Estado {
        ENCENDIDA,
        APAGADA,
        FUNDIDA;
    }

    private static ArrayList<JBombilla> coleccionBombillas = new ArrayList();

    public static ArrayList<JBombilla> getColeccionBombillas() {
        return (ArrayList< JBombilla>) coleccionBombillas.clone();
    }

    private Bombilla bombilla;
    private int idBombilla;
    private Ubicaciones ubicacion;
    private Estado estado = Estado.APAGADA;
    private int numeroMaximoEncendidos = 5;
    private int tiempoMaximoEncendido = 15;

    public JBombilla() {
        initComponents();
        iniciaMisPropiedades();
        setUbicacion(Ubicaciones.SIN_DEFINIR);
    }

    public JBombilla(Ubicaciones ubicacion) {
        initComponents();
        iniciaMisPropiedades();
        setUbicacion(ubicacion);
    }

    public void setUbicacion(Ubicaciones ubicacion) {
        jLabelUbicacion.setText((this.ubicacion = ubicacion).toString());
        jLabelNumeroBombillaHabitaculo.setText(String.valueOf(idBombilla = numeroBombilla(this.ubicacion)));
    }

    public Ubicaciones getUbicacion() {
        return this.ubicacion;
    }

    public int getIdBombilla() {
        return idBombilla;
    }

    private void iniciaMisPropiedades() {
        bombilla = new Bombilla();
        jLabelReponer.setVisible(false);
        coleccionBombillas.add(this);
        consistencia();
    }

    private int numeroBombilla(Ubicaciones ubicacion) {
        int numeroBombillas = 0;
        for (JBombilla jBom : coleccionBombillas) {
            if (jBom.getUbicacion() == ubicacion) {
                numeroBombillas++;
            }
        }
        return numeroBombillas;
    }

    private void controlBombilla() {
        System.out.println("ESTADO→ " + estado);
        switch (estado) {
//            case APAGADA:
//                bombilla.setApagada();
//                break;
            case ENCENDIDA:
                bombilla.setEncendida();
                fireBombillaEncendida();
                break;
            case FUNDIDA:
                fireBombillaAgotada();
                break;
        }
        consistencia();
    }

    private void consistencia() {
        jLabelBombilla.setIcon(new ImageIcon(getClass().getResource((estado == Estado.ENCENDIDA) ? "/Recursos/encendida.png" : "/Recursos/apagada.png")));
        jButtonEncendidoApagado.setText((estado == Estado.APAGADA || estado == Estado.FUNDIDA) ? "ON" : "OFF");
        jButtonEncendidoApagado.setEnabled(estado != Estado.FUNDIDA);
        jLabelReponer.setVisible(estado == Estado.FUNDIDA);
    }

    public void encender() {
        if (estado == Estado.ENCENDIDA || estado == Estado.FUNDIDA) {
            return;
        }
        estado = Estado.ENCENDIDA;
        System.out.println(bombilla.getNumeroEncendidos() + " →→→→→→→→→ " + bombilla.getTiempoEncendida());
        comprobarVidaUtil();
    }

    public void apagar() {
        if (estado == Estado.APAGADA || estado == Estado.FUNDIDA) {
            return;
        }
        estado = Estado.APAGADA;
        comprobarVidaUtil();
    }

    public void reponer() {
        bombilla = new Bombilla();
        estado = Estado.APAGADA;
        fireBombillaRepuesta();
        consistencia();
    }

    @Override
    public String toString() {
        return "Bombilla " + this.getIdBombilla() + " en " + this.getUbicacion().toString() + " agotada.";
    }

    private void comprobarVidaUtil() {
        if (bombilla.getNumeroEncendidos() >= numeroMaximoEncendidos || (int) bombilla.getTiempoEncendida() > tiempoMaximoEncendido) {
            estado = Estado.FUNDIDA;
        }
        controlBombilla();
    }

    private ArrayList<JBombillaListener> listeners = new ArrayList();

    public void addJBombillaListener(JBombillaListener l) {
        listeners.add(l);
    }

    public void removeJBombillaListener(JBombillaListener l) {
        listeners.remove(l);
    }

    protected void fireBombillaEncendida() {
        System.out.println("FIRE ENCENDIDA");
        JBombillaEvent evt = new JBombillaEvent(this, bombilla.getNumeroEncendidos(), (int) bombilla.getTiempoEncendida());
        for (JBombillaListener l : listeners) {
            l.bombillaEncendida(evt);
        }
    }

    protected void fireBombillaAgotada() {
        System.out.println("FIRE AGOTADA");
        JBombillaEvent evt = new JBombillaEvent(this);
        for (JBombillaListener l : listeners) {
            l.bombillaAgotada(evt);
        }
    }

    protected void fireBombillaRepuesta() {
        JBombillaEvent evt = new JBombillaEvent(this, 0, 0);
        for (JBombillaListener l : listeners) {
            l.bombillaRepuesta(evt);
        }
    }

    private class Bombilla {

        private int numeroEncendidos;
        private int tiempoEncendida;
//        private long inicioTiempoEncendida;
        private hiloTemporizador hilo = new hiloTemporizador();

        public Bombilla() {
            numeroEncendidos = 0;
            tiempoEncendida = 0;
//            inicioTiempoEncendida = 0;
        }

        public void setEncendida() {
            this.numeroEncendidos++;
            new hiloTemporizador().start();
//            inicioTiempoEncendida = Calendar.getInstance().getTimeInMillis();
        }

//        public void setApagada() {
//            tiempoEncendida += Calendar.getInstance().getTimeInMillis() - inicioTiempoEncendida;
//        }
        public int getNumeroEncendidos() {
            return numeroEncendidos;
        }

        public int getTiempoEncendida() {
            return tiempoEncendida;
        }

        private class hiloTemporizador extends Thread {

            @Override
            public void run() {
                while (estado == Estado.ENCENDIDA) {
                    System.out.println("HILO" + ubicacion);
                    tiempoEncendida++;
                    System.out.println(bombilla.getTiempoEncendida());
                    if (bombilla.getTiempoEncendida() >= tiempoMaximoEncendido) {
                        estado = Estado.FUNDIDA;
                        controlBombilla();
                    }
                    try {
                        this.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelBombilla = new javax.swing.JLabel();
        jLabelUbicacion = new javax.swing.JLabel();
        jLabelNumeroBombillaHabitaculo = new javax.swing.JLabel();
        jButtonEncendidoApagado = new javax.swing.JButton();
        jLabelReponer = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 255));

        jLabelBombilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/apagada.png"))); // NOI18N

        jLabelUbicacion.setBackground(new java.awt.Color(153, 255, 153));
        jLabelUbicacion.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabelUbicacion.setForeground(new java.awt.Color(255, 255, 0));
        jLabelUbicacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUbicacion.setText("SIN_DEFINIR");

        jLabelNumeroBombillaHabitaculo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelNumeroBombillaHabitaculo.setForeground(new java.awt.Color(255, 0, 51));
        jLabelNumeroBombillaHabitaculo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumeroBombillaHabitaculo.setText("0");
        jLabelNumeroBombillaHabitaculo.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true), null));

        jButtonEncendidoApagado.setFont(new java.awt.Font("Minion Pro SmBd", 0, 24)); // NOI18N
        jButtonEncendidoApagado.setText("ON");
        jButtonEncendidoApagado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncendidoApagadoActionPerformed(evt);
            }
        });

        jLabelReponer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelReponer.setForeground(new java.awt.Color(0, 255, 0));
        jLabelReponer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelReponer.setText("REPONER");
        jLabelReponer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelReponerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelBombilla)
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNumeroBombillaHabitaculo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEncendidoApagado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(jLabelReponer, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabelNumeroBombillaHabitaculo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEncendidoApagado, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelReponer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelBombilla, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEncendidoApagadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEncendidoApagadoActionPerformed
        if (estado == Estado.APAGADA) {
            encender();
        } else {
            apagar();
        }
    }//GEN-LAST:event_jButtonEncendidoApagadoActionPerformed

    private void jLabelReponerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelReponerMouseClicked
        reponer();
    }//GEN-LAST:event_jLabelReponerMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEncendidoApagado;
    private javax.swing.JLabel jLabelBombilla;
    private javax.swing.JLabel jLabelNumeroBombillaHabitaculo;
    private javax.swing.JLabel jLabelReponer;
    private javax.swing.JLabel jLabelUbicacion;
    // End of variables declaration//GEN-END:variables
}
