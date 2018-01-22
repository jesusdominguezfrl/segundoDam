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
    //<editor-fold defaultstate="collapsed" desc="Tipo Enumerado Ubicaciones">
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

        /**
         * Sobrecarga del constructor.
         *
         * @param habitaculo (String) Nombre del habitaculo o Ubicacion.
         */
        private Ubicaciones(String habitaculo) {
            this.habitaculo = habitaculo;
        }

        /**
         * Sobre escritura del método toString()
         *
         * @return
         */
        @Override
        public String toString() {
            return this.habitaculo;
        }
    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Tipo Enumerado Estados Del Componente">
    private enum Estado {
        ENCENDIDA,
        APAGADA,
        FUNDIDA;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Propiedades Privadas del Componente">
    private static ArrayList<JBombilla> coleccionBombillas = new ArrayList();
    private Bombilla bombilla;
    private int idBombilla;
    private Ubicaciones ubicacion;
    private Estado estado = Estado.APAGADA;
    private int numeroMaximoEncendidos = 5;
    private int tiempoMaximoEncendido = 15;

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructores">
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
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Miembros publicos de la clase">
    /**
     * Devuelve una copia de la coleccion de bombillas
     *
     * @return
     */
    public static ArrayList<JBombilla> getColeccionBombillas() {
        return (ArrayList< JBombilla>) coleccionBombillas.clone();
    }

    /**
     * Devuelve la ubicacion de la bombilla.
     *
     * @return (Ubicaciones) ubicacion del componente.
     */
    public Ubicaciones getUbicacion() {
        return this.ubicacion;
    }

    /**
     * Enciende la bombilla.
     */
    public void encender() {
        if (estado == Estado.ENCENDIDA || estado == Estado.FUNDIDA) {
            return;
        }
        estado = Estado.ENCENDIDA;
        System.out.println(bombilla.getNumeroEncendidos() + " →→→→→→→→→ " + bombilla.getTiempoEncendida());
        comprobarVidaUtil();
    }

    /**
     * Apaga la bombilla.
     */
    public void apagar() {
        if (estado == Estado.APAGADA || estado == Estado.FUNDIDA) {
            return;
        }
        estado = Estado.APAGADA;
        comprobarVidaUtil();
    }

    /**
     * Repone una bombilla Agotada/Fundida por una nueva.
     */
    public void reponer() {
        bombilla = new Bombilla();
        estado = Estado.APAGADA;
        fireBombillaRepuesta();
        consistencia();
    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Miembros privados de la clase">
    /**
     * Asigna la ubicacion al componente indicandolo en el mismo.
     *
     * @param ubicacion Lugar donde se encuentra el componente.
     */
    private void setUbicacion(Ubicaciones ubicacion) {
        jLabelUbicacion.setText((this.ubicacion = ubicacion).toString());
        jLabelNumeroBombillaHabitaculo.setText(String.valueOf(idBombilla = numeroBombilla(this.ubicacion)));
    }

    /**
     * Inicia los parametros necesarios para conseguir que funcione el
     * componente
     */
    private void iniciaMisPropiedades() {
        bombilla = new Bombilla();
        jLabelReponer.setVisible(false);
        coleccionBombillas.add(this);
        consistencia();
    }

    /**
     * Contador de bombillas existente para asignar a cada bombilla un id unico.
     *
     * @param ubicacion Lugar donde se encuentra la bombilla
     * @return (int) Numero id que se le asignara a la nueva bombilla.
     */
    private int numeroBombilla(Ubicaciones ubicacion) {
        int numeroBombillas = 0;
        for (JBombilla jBom : coleccionBombillas) {
            if (jBom.getUbicacion() == ubicacion) {
                numeroBombillas++;
            }
        }
        return numeroBombillas;
    }

    /**
     * Control de las acciones de la bombilla en funcion del estado en el que se
     * encuentre.
     */
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

    /**
     * Controla la consistencia del componente.
     */
    private void consistencia() {
        jLabelBombilla.setIcon(new ImageIcon(getClass().getResource((estado == Estado.ENCENDIDA) ? "/Recursos/encendida.png" : "/Recursos/apagada.png")));
        jButtonEncendidoApagado.setText((estado == Estado.APAGADA || estado == Estado.FUNDIDA) ? "ON" : "OFF");
        jButtonEncendidoApagado.setEnabled(estado != Estado.FUNDIDA);
        jLabelReponer.setVisible(estado == Estado.FUNDIDA);
    }

    /**
     * Comprueba los parametros de "vida" de la bombilla.
     */
    private void comprobarVidaUtil() {
        if (bombilla.getNumeroEncendidos() >= numeroMaximoEncendidos/*|| (int) bombilla.getTiempoEncendida() > tiempoMaximoEncendido*/) {
            estado = Estado.FUNDIDA;
        }
        controlBombilla();
    }

//</editor-fold>
    /**
     * Devuelve un String con informacion sobre el componente indicando su
     * ubicacion, su identificador y su estado.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Bombilla " + this.idBombilla + " en " + this.getUbicacion().toString() + " " + estado;
    }

    //<editor-fold defaultstate="collapsed" desc="Gestion de Eventos">
    private ArrayList<JBombillaListener> listeners = new ArrayList();

    /**
     * Añade el listener al componente
     *
     * @param l Listenner que sera añadido a la lista de listeners
     */
    public void addJBombillaListener(JBombillaListener l) {
        listeners.add(l);
    }

    /**
     * Elimina el listener al componente.
     *
     * @param l Listenner que sera eliminado de la lista de listeners.
     */
    public void removeJBombillaListener(JBombillaListener l) {
        listeners.remove(l);
    }

    /**
     * Lanza el listener que indica que la bombilla ha sido encendida.
     */
    protected void fireBombillaEncendida() {
        System.out.println("FIRE ENCENDIDA");
        JBombillaEvent evt = new JBombillaEvent(this, bombilla.getNumeroEncendidos(), (int) bombilla.getTiempoEncendida());
        for (JBombillaListener l : listeners) {
            l.bombillaEncendida(evt);
        }
    }

    /**
     * Lanza el listener que indica que la bombilla se ha estropeado.
     */
    protected void fireBombillaAgotada() {
        System.out.println("FIRE AGOTADA");
        JBombillaEvent evt = new JBombillaEvent(this);
        for (JBombillaListener l : listeners) {
            l.bombillaAgotada(evt);
        }
    }

    /**
     * Lanza el listener que indica que la bombilla ha sido repuesta.
     */
    protected void fireBombillaRepuesta() {
        JBombillaEvent evt = new JBombillaEvent(this, 0, 0);
        for (JBombillaListener l : listeners) {
            l.bombillaRepuesta(evt);
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Clase Bombilla">
    private class Bombilla {

        //<editor-fold defaultstate="collapsed" desc="Propiedades Privadas">
        private int numeroEncendidos;
        private int tiempoEncendida;
//        private long inicioTiempoEncendida;
        private hiloTemporizador hilo = new hiloTemporizador();
        //</editor-fold>

        public Bombilla() {
            numeroEncendidos = 0;
            tiempoEncendida = 0;
//            inicioTiempoEncendida = 0;
        }

        //<editor-fold defaultstate="collapsed" desc="Acceso publico a la gestion del objeto">
        /**
         * Activa el hilo que cuenta el tiempo encendido de la bombilla y
         * aumenta el contador de veces que se ha encendido.
         */
        public void setEncendida() {
            this.numeroEncendidos++;
            new hiloTemporizador().start();
//            inicioTiempoEncendida = Calendar.getInstance().getTimeInMillis();
        }

//        public void setApagada() {
//            tiempoEncendida += Calendar.getInstance().getTimeInMillis() - inicioTiempoEncendida;
//        }
        /**
         * Devuelve el numero de veces que se ha encendido la bombilla
         *
         * @return (int) Numero de encendidos.
         */
        public int getNumeroEncendidos() {
            return numeroEncendidos;
        }

        /**
         * Devuelve el tiempo que la bombilla lleva encendida en segundos.
         *
         * @return (int) Total segundos que ha estado la bombilla encendida
         */
        public int getTiempoEncendida() {
            return tiempoEncendida;
        }
//</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Hilo">
        private class hiloTemporizador extends Thread {

            @Override
            public void run() {
                while (estado == Estado.ENCENDIDA) {
                    tiempoEncendida++;
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
//</editor-fold>

    }
//</editor-fold>

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
