/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisComponentes.ComponenteMetronomoVisual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author usuario
 */
public class JMetronomoVisual extends javax.swing.JPanel{

    
    private int pulsos=15;
    private int maximoPulsos=5000;
    private int pulsosPorMinuto=60;
    private int maximoPulsosMinuto=600;
    private int pulsoActual;
    private boolean cuentaAtras;
    private Timer temporizador;

    
    /**
     * Creates new form JMetronomoVisual
     */
    
    public JMetronomoVisual(){
        initComponents();
        setPulsos(pulsos);
        cuentaAtras=jCheckBoxCuentaAtras.isSelected();
        jSliderNumeroPulsos.setMaximum(maximoPulsos);
        jSliderPulsosMinuto.setMaximum(maximoPulsosMinuto);
        jButtonIniciar.addActionListener(new gestorIniciar());
//        consistencia();
    }
  
    public void setPulsos(int pulsos) {
        if (pulsos>maximoPulsos){
            this.pulsos = pulsos;
            pulsoActual=this.pulsos;
            jLabelVisorPulsos.setText(String.valueOf(cuentaAtras?this.pulsos:0));
        }
    }

    public void setPulsosPorMinuto(int pulsosPorMinuto) {
        if(pulsosPorMinuto>maximoPulsosMinuto){
            this.pulsosPorMinuto = pulsosPorMinuto;
            
        }
    }

    public int getPulsoActual() {
        return pulsoActual;
    }
    
    private void consistencia(){
        System.out.println("Hacer consistencia...........");
    }

    
    public void iniciar(){
        if(!temporizador.isRunning()){
            temporizador.start();
            jLabelVisorPulsos.setText(String.valueOf(pulsoActual));
        }else{
            temporizador.stop();
        }
    }
    
    private class gestorIniciar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            iniciar();
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabelVisorPulsos = new javax.swing.JLabel();
        jSliderNumeroPulsos = new javax.swing.JSlider();
        jSliderPulsosMinuto = new javax.swing.JSlider();
        jButtonIniciar = new javax.swing.JButton();
        jButtonPuestaCero = new javax.swing.JButton();
        jCheckBoxCuentaAtras = new javax.swing.JCheckBox();
        jTextFieldNumeroPulsos = new javax.swing.JTextField();
        jTextFieldPulsosMinuto = new javax.swing.JTextField();

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelVisorPulsos.setBackground(new java.awt.Color(0, 0, 51));
        jLabelVisorPulsos.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabelVisorPulsos.setForeground(new java.awt.Color(0, 255, 0));
        jLabelVisorPulsos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelVisorPulsos.setText("0");
        jLabelVisorPulsos.setOpaque(true);

        jButtonIniciar.setText("INICIAR");

        jButtonPuestaCero.setText("Puesta a 0");

        jCheckBoxCuentaAtras.setText("Cuenta Atras");

        jTextFieldNumeroPulsos.setBackground(new java.awt.Color(0, 51, 51));
        jTextFieldNumeroPulsos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldNumeroPulsos.setForeground(new java.awt.Color(0, 204, 0));
        jTextFieldNumeroPulsos.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jSliderNumeroPulsos, org.jdesktop.beansbinding.ELProperty.create("${value}"), jTextFieldNumeroPulsos, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextFieldPulsosMinuto.setBackground(new java.awt.Color(0, 51, 51));
        jTextFieldPulsosMinuto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldPulsosMinuto.setForeground(new java.awt.Color(0, 204, 0));
        jTextFieldPulsosMinuto.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jSliderPulsosMinuto, org.jdesktop.beansbinding.ELProperty.create("${value}"), jTextFieldPulsosMinuto, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelVisorPulsos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNumeroPulsos, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(jSliderNumeroPulsos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSliderPulsosMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jTextFieldPulsosMinuto, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxCuentaAtras, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonPuestaCero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(2, 2, 2)))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11)
                        .addComponent(jButtonPuestaCero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabelVisorPulsos, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNumeroPulsos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPulsosMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSliderNumeroPulsos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSliderPulsosMinuto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jCheckBoxCuentaAtras)))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JButton jButtonPuestaCero;
    private javax.swing.JCheckBox jCheckBoxCuentaAtras;
    private javax.swing.JLabel jLabelVisorPulsos;
    private javax.swing.JSlider jSliderNumeroPulsos;
    private javax.swing.JSlider jSliderPulsosMinuto;
    private javax.swing.JTextField jTextFieldNumeroPulsos;
    private javax.swing.JTextField jTextFieldPulsosMinuto;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
