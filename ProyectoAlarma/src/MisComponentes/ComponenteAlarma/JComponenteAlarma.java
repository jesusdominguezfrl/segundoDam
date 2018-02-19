/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisComponentes.ComponenteAlarma;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author usuario
 */
public class JComponenteAlarma extends javax.swing.JPanel {

    /**
     * Creates new form JComponenteAlarma
     */
    //<editor-fold defaultstate="collapsed" desc="Enum→Modo; Enum→Estados">
    private enum Modos {
        ALARMA_TOTAL("ALARMA TOTAL"),
        ALARMA_ZONA1("ALARMA ZONA1"),
        ALARMA_ZONA2("ALARMA ZONA2"),
        ESTABLECER_CODIGO("ESTABLECER CODIGO");

        private String texto;

        Modos() {
            this.texto = super.toString();
        }

        Modos(String texto) {
            this.texto = texto;
        }
        
        @Override
        public String toString() {
            return this.texto;
        }
    }

    private enum Estados {
        ACTIVADA,
        BLOQUEADA,
        DISPARADA,
//        HABILITADA,
        DESACTIVADA;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Propiedades Privadas">
    private int controlModo = 0;

    private Modos modo;
    private Estados estado;
    private int maximoContraseñaIncorrecta=3;
    
    private String contraseña="AAA";
    private int intentosFallidos;
    
    private boolean sensorZona1=false;
    private boolean sensorZona2=false;

    //</editor-fold>
    
    public JComponenteAlarma() {
        initComponents();
        iniciaPropiedades();

    }
    
    public void activar(String clave){
        if(estado==Estados.ACTIVADA || estado==Estados.BLOQUEADA)return;
        if(contraseña.equals(clave)){
            setEstado(Estados.ACTIVADA);
            fireAlarmaActivada();
        }
    }
    
    public void desactivar(String clave){
        if(estado==Estados.DESACTIVADA || estado==Estados.BLOQUEADA)return;
        if(compruebaContraseña(clave)){
            setEstado(Estados.DESACTIVADA);
        }
    }

    public int getMaximoContraseñaIncorrecta() {
        return maximoContraseñaIncorrecta;
    }

    public void setMaximoContraseñaIncorrecta(int maximoContraseñaIncorrecta) {
        if(estado!=Estados.DESACTIVADA)return;
        this.maximoContraseñaIncorrecta = maximoContraseñaIncorrecta;
    }
    
    public void activarSensorZona1() {
        if(estado==Estados.BLOQUEADA){
            sensorZona1=true;
            fireAlarmaDisparada();
            jLabelImgAlarmaZona1.setVisible(true);
            sensorZona1=false;
            return;
        }
        if((modo==Modos.ALARMA_ZONA1 || modo==Modos.ALARMA_TOTAL) && (estado==Estados.ACTIVADA || estado==Estados.DISPARADA)){
            sensorZona1=true;
            jLabelImgAlarmaZona1.setVisible(true);
            setEstado(Estados.DISPARADA);
            fireAlarmaDisparada();
        }
        sensorZona1=false;
    }
    
    @Override
    public void setEnabled(boolean enabled){
        if(estado!=Estados.DESACTIVADA)return;
        
        bloquear(!this.isEnabled());
        super.setEnabled(!this.isEnabled());
        
    }

    public void activarSensorZona2() {
        if(estado==Estados.BLOQUEADA){
            sensorZona2=true;
            jLabelImgAlarmaZona2.setVisible(true);
            fireAlarmaDisparada();
            sensorZona2=false;
            return;
        }
        if((modo==Modos.ALARMA_ZONA2 || modo==Modos.ALARMA_TOTAL) && (estado==Estados.ACTIVADA || estado==Estados.DISPARADA)){
            sensorZona2=true;
            jLabelImgAlarmaZona2.setVisible(true);
            setEstado(Estados.DISPARADA);
            fireAlarmaDisparada();
        }
        sensorZona2=false;
    }

    public boolean isSensorZona1() {
        return sensorZona1;
    }

    public boolean isSensorZona2() {
        return sensorZona2;
    }
    
    public boolean isAlarmaActiva(){
        return estado!=(Estados.DESACTIVADA);
    }
    
    public void cambiarContraseña(String oldPass, String newPass){
        if(estado!=Estados.DESACTIVADA)return;
        setModo(Modos.ESTABLECER_CODIGO);
        if(compruebaContraseña(oldPass)){
            contraseña=newPass;
            System.out.println("kajsdbfjabsd");
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Metodos Privados">
    private void iniciaPropiedades() {
        setEstado(Estados.DESACTIVADA);
        setModo(Modos.ALARMA_TOTAL);
    }
    
    private void consistenciaAlarma(){
        jPanelZona1.setBackground(((modo==Modos.ALARMA_TOTAL || modo==Modos.ALARMA_ZONA1) && (estado==Estados.ACTIVADA ||estado==Estados.DISPARADA||estado==Estados.BLOQUEADA))?Color.RED:Color.GREEN);
        jPanelZona2.setBackground(((modo==Modos.ALARMA_TOTAL || modo==Modos.ALARMA_ZONA2) && (estado==Estados.ACTIVADA ||estado==Estados.DISPARADA||estado==Estados.BLOQUEADA))?Color.RED:Color.GREEN);
        if(modo!=Modos.ESTABLECER_CODIGO)
            jButtonValidar.setText((estado==Estados.ACTIVADA || estado== Estados.DISPARADA)?"Desactivar":"Activar");
    }

    private void setModo(Modos modo) {
        if(estado!=Estados.DESACTIVADA)return;
        jLabelVisor.setText("");
        this.modo = modo;
        switch (modo) {
            case ALARMA_TOTAL:
            case ALARMA_ZONA1:
            case ALARMA_ZONA2:
                break;
            case ESTABLECER_CODIGO:
                jButtonValidar.setText("(OLD) OK");
                break;
        }
        jLabelVisorModo.setText(modo.toString());
        consistenciaAlarma();
    }
    
    private void setEstado(Estados estado){
        this.estado=estado;
        switch(estado){
            case ACTIVADA:
                jButtonValidar.setText("Desactivar");
                break;
            case DESACTIVADA:
                jButtonValidar.setText("Activar");
                jLabelImgAlarmaZona1.setVisible(false);
                jLabelImgAlarmaZona2.setVisible(false);
                break;
            case BLOQUEADA:
                bloquear(false);
                modo=Modos.ALARMA_TOTAL;
                activarSensorZona1();
                activarSensorZona2();
                break;
            case DISPARADA:
                break;
        }

        consistenciaAlarma();
    }
    
    private void bloquear(boolean activo){
        for (Component c: this.getComponents()){
            if(c instanceof JPanel && ((JPanel)c)!=jPanelZonas)
                for(Component com: ((JPanel)c).getComponents())
                    com.setEnabled(activo);
            else
                c.setEnabled(activo);
        }
    }
    
    private boolean compruebaContraseña(String clave){
        if(contraseña.equals(clave)){
            intentosFallidos=0;
            return true;
        }
//        intentosFallidos++;
//        if(modo!=Modos.ESTABLECER_CODIGO && intentosFallidos>=maximoContraseñaIncorrecta)setEstado(Estados.BLOQUEADA);
        return false;       
    }
    
    private ArrayList<JAlarmaListener> listeners= new ArrayList<>();
    
    public void addJAlarmaListener(JAlarmaListener l){
        listeners.add(l);
    }
    
    public void removeJAlarmaListener(JAlarmaListener l){
        listeners.remove(l);
    }
    
    protected void fireAlarmaDisparada(){
        JAlarmaEvent evt = new JAlarmaEvent(this, (sensorZona1)?"Zona1":"Zona2");
        for(JAlarmaListener l : listeners)
            l.alarmaDisparada(evt);
        
    }
    
    protected void fireAlarmaActivada(){
        JAlarmaEvent evt = new JAlarmaEvent(this, (modo==Modos.ALARMA_TOTAL)?"Alarma Total":(modo==Modos.ALARMA_ZONA1)?"Zona1":"Zona2");
        for(JAlarmaListener l : listeners)
            l.alarmaActivada(evt);
        
    }
    
    protected void fireAlarmaDesactivada(){
        JAlarmaEvent evt = new JAlarmaEvent(this, ((modo==Modos.ALARMA_TOTAL)?"Alarma Total":(modo==Modos.ALARMA_ZONA1)?"Zona1":"Zona2"),intentosFallidos);
        for(JAlarmaListener l : listeners)
            l.alarmaDesactivada(evt);
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

        jPanelZonas = new javax.swing.JPanel();
        jPanelZona1 = new javax.swing.JPanel();
        jLabelZona1 = new javax.swing.JLabel();
        jLabelImgAlarmaZona1 = new javax.swing.JLabel();
        jLabelImgAlarmaZona2 = new javax.swing.JLabel();
        jLabelZona2 = new javax.swing.JLabel();
        jPanelZona2 = new javax.swing.JPanel();
        jLabelVisor = new javax.swing.JLabel();
        jButtonValidar = new javax.swing.JButton();
        jLabelVisorModo = new javax.swing.JLabel();
        jButtonModo = new javax.swing.JButton();
        jPanelTeclado = new javax.swing.JPanel();
        jButtonA = new javax.swing.JButton();
        jButtonB = new javax.swing.JButton();
        jButtonC = new javax.swing.JButton();
        jButtonD = new javax.swing.JButton();
        jButtonE = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 102));

        jPanelZonas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 3), "Zonas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanelZonas.setOpaque(false);

        jPanelZona1.setBackground(new java.awt.Color(0, 204, 0));
        jPanelZona1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanelZona1Layout = new javax.swing.GroupLayout(jPanelZona1);
        jPanelZona1.setLayout(jPanelZona1Layout);
        jPanelZona1Layout.setHorizontalGroup(
            jPanelZona1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelZona1Layout.setVerticalGroup(
            jPanelZona1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );

        jLabelZona1.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabelZona1.setText("Zona 1");

        jLabelImgAlarmaZona1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Alarma.gif"))); // NOI18N

        jLabelImgAlarmaZona2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Alarma.gif"))); // NOI18N

        jLabelZona2.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabelZona2.setText("Zona 2");

        jPanelZona2.setBackground(new java.awt.Color(0, 204, 0));
        jPanelZona2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanelZona2Layout = new javax.swing.GroupLayout(jPanelZona2);
        jPanelZona2.setLayout(jPanelZona2Layout);
        jPanelZona2Layout.setHorizontalGroup(
            jPanelZona2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelZona2Layout.setVerticalGroup(
            jPanelZona2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelZonasLayout = new javax.swing.GroupLayout(jPanelZonas);
        jPanelZonas.setLayout(jPanelZonasLayout);
        jPanelZonasLayout.setHorizontalGroup(
            jPanelZonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelZonasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelZonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelZona1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelImgAlarmaZona1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelZona1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addGroup(jPanelZonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelImgAlarmaZona2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelZona2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelZona2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        jPanelZonasLayout.setVerticalGroup(
            jPanelZonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelZonasLayout.createSequentialGroup()
                .addGroup(jPanelZonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelZonasLayout.createSequentialGroup()
                        .addComponent(jLabelZona2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelImgAlarmaZona2))
                    .addComponent(jPanelZona2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelZona1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelZonasLayout.createSequentialGroup()
                        .addComponent(jLabelZona1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelImgAlarmaZona1)))
                .addContainerGap())
        );

        jLabelVisor.setBackground(new java.awt.Color(0, 102, 102));
        jLabelVisor.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelVisor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVisor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabelVisor.setOpaque(true);

        jButtonValidar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButtonValidar.setText("OK");
        jButtonValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValidarActionPerformed(evt);
            }
        });

        jLabelVisorModo.setBackground(new java.awt.Color(0, 102, 102));
        jLabelVisorModo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelVisorModo.setForeground(new java.awt.Color(204, 204, 0));
        jLabelVisorModo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVisorModo.setOpaque(true);

        jButtonModo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonModo.setText("Modo");
        jButtonModo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModoActionPerformed(evt);
            }
        });

        jPanelTeclado.setOpaque(false);

        jButtonA.setBackground(new java.awt.Color(255, 255, 255));
        jButtonA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonA.setForeground(new java.awt.Color(0, 153, 0));
        jButtonA.setText("A");
        jButtonA.setOpaque(false);
        jButtonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonActionPerformedLetras(evt);
            }
        });

        jButtonB.setBackground(new java.awt.Color(255, 255, 255));
        jButtonB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonB.setForeground(new java.awt.Color(0, 153, 0));
        jButtonB.setText("B");
        jButtonB.setOpaque(false);
        jButtonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonActionPerformedLetras(evt);
            }
        });

        jButtonC.setBackground(new java.awt.Color(255, 255, 255));
        jButtonC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonC.setForeground(new java.awt.Color(0, 153, 0));
        jButtonC.setText("C");
        jButtonC.setOpaque(false);
        jButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonActionPerformedLetras(evt);
            }
        });

        jButtonD.setBackground(new java.awt.Color(255, 255, 255));
        jButtonD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonD.setForeground(new java.awt.Color(0, 153, 0));
        jButtonD.setText("D");
        jButtonD.setOpaque(false);
        jButtonD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonActionPerformedLetras(evt);
            }
        });

        jButtonE.setBackground(new java.awt.Color(255, 255, 255));
        jButtonE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonE.setForeground(new java.awt.Color(0, 153, 0));
        jButtonE.setText("E");
        jButtonE.setOpaque(false);
        jButtonE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonActionPerformedLetras(evt);
            }
        });

        javax.swing.GroupLayout jPanelTecladoLayout = new javax.swing.GroupLayout(jPanelTeclado);
        jPanelTeclado.setLayout(jPanelTecladoLayout);
        jPanelTecladoLayout.setHorizontalGroup(
            jPanelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTecladoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonA, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonB, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonC, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonD, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonE, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelTecladoLayout.setVerticalGroup(
            jPanelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTeclado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelZonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelVisor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelVisorModo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonModo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelZonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelVisor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jPanelTeclado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelVisorModo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonModo, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonActionPerformedLetras(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonActionPerformedLetras
        System.out.println(evt.getSource());
        for (Component c : jPanelTeclado.getComponents()) {
            if (((JButton) c) instanceof JButton && ((JButton) c) == evt.getSource()) {
                if (jLabelVisor.getText().length() > 9) return;
                jLabelVisor.setText(jLabelVisor.getText() + ((JButton) evt.getSource()).getText());
            }
        }
    }//GEN-LAST:event_JButtonActionPerformedLetras

    private void jButtonModoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModoActionPerformed
        if(estado!=Estados.DESACTIVADA)return;
        setModo(Modos.values()[(++controlModo < Modos.values().length) ? controlModo : (controlModo = 0)]);
    }//GEN-LAST:event_jButtonModoActionPerformed

    private void jButtonValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValidarActionPerformed
        switch (modo) {
            case ALARMA_TOTAL:
            case ALARMA_ZONA1:
            case ALARMA_ZONA2:
                if("Desactivar".equals(jButtonValidar.getText())/*||compruebaContraseña()*/){
                    if(!compruebaContraseña(jLabelVisor.getText()))intentosFallidos++;
                    else desactivar(jLabelVisor.getText());
                    fireAlarmaDesactivada();
                    if(intentosFallidos>=maximoContraseñaIncorrecta)setEstado(Estados.BLOQUEADA);
                }
                else activar(jLabelVisor.getText());
                break;
            case ESTABLECER_CODIGO:
                if(estado!=Estados.DESACTIVADA)return;
                if(compruebaContraseña(jLabelVisor.getText())) jButtonValidar.setText("(NEW) OK");
                else
                    if("(NEW) OK".equals(jButtonValidar.getText())){
                        contraseña=jLabelVisor.getText();
                        jButtonValidar.setText("(OLD) OK");
                    }
                break;
        }
        jLabelVisor.setText("");
        consistenciaAlarma();
    }//GEN-LAST:event_jButtonValidarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonA;
    private javax.swing.JButton jButtonB;
    private javax.swing.JButton jButtonC;
    private javax.swing.JButton jButtonD;
    private javax.swing.JButton jButtonE;
    private javax.swing.JButton jButtonModo;
    private javax.swing.JButton jButtonValidar;
    private javax.swing.JLabel jLabelImgAlarmaZona1;
    private javax.swing.JLabel jLabelImgAlarmaZona2;
    private javax.swing.JLabel jLabelVisor;
    private javax.swing.JLabel jLabelVisorModo;
    private javax.swing.JLabel jLabelZona1;
    private javax.swing.JLabel jLabelZona2;
    private javax.swing.JPanel jPanelTeclado;
    private javax.swing.JPanel jPanelZona1;
    private javax.swing.JPanel jPanelZona2;
    private javax.swing.JPanel jPanelZonas;
    // End of variables declaration//GEN-END:variables
}
