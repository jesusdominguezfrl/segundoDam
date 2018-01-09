/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisComponentes.JMetronomoVisual2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author usuario
 */
public class JMetronomoVisual extends javax.swing.JPanel implements ActionListener {

    private int pulsos = 15;
    private int pulsosPorMinuto = 60;
    private int pulsoActual;
    private final int maximoPulsos = 600;
    private final int maximoPulsosMinuto = 600;
    private boolean cuentaAtras;
    private Timer temporizador;
    private PropertyChangeSupport myPCS=new PropertyChangeSupport(this);;

    /**
     * Creates new form JMetronomoVisual
     */
    public JMetronomoVisual() {
        initComponents();
        iniciaMisComponentes();
    }

    public void setPulsos(int pulsos) {
//        if(pulsos>maximoPulsos)  new Exception("Numero de pulsos mayor al permitido");

        if (temporizador == null && pulsos > 0) {
            this.pulsos = pulsos;
            jSliderNumeroPulsos.setValue(pulsos);
        }
    }
    
    
    //Solo funciona hasta detener a pesar de que el valor viejo y el nuevo son distintos
    private void setPulsoActual(int pulsoActual){
        System.out.println("viejo"+ this.pulsoActual);
        myPCS.firePropertyChange("pulsoActual",this.pulsoActual, this.pulsoActual=pulsoActual);
        System.out.println("nuevo"+ this.pulsoActual);
    }

    public void setPulsosPorMinuto(int pulsosPorMinuto) {
        //maximo pulsos por minuto consistente con pulsos por minuto 
        if (temporizador == null && pulsosPorMinuto > 0) {
            this.pulsosPorMinuto = pulsosPorMinuto;
            jSliderPulsosMinuto.setValue(pulsosPorMinuto);
        }
    }

    public boolean isCuentaAtras() {
        return cuentaAtras;
    }

    public void setCuentaAtras(boolean cuentaAtras) {
        if (temporizador == null) {
            jCheckBoxCuentaAtras.setSelected(cuentaAtras/*!jCheckBoxCuentaAtras.isSelected()*/);
            this.cuentaAtras=jCheckBoxCuentaAtras.isSelected();
        }
        muestraVisor();
    }

    public int getPulsoActual() {
        return pulsoActual;
    }

    public void detener() {
        if (temporizador != null && temporizador.isRunning()) {
            temporizador.stop();
        }
        consistencia();
    }

    public void iniciar() {
        if (temporizador == null) {
            temporizador = new Timer(60000 / pulsosPorMinuto, this);
        }
        temporizador.start();
        consistencia();
    }

    public void puestaCero() {
        if(temporizador!=null&&!temporizador.isRunning()){
            iniciaMisComponentes();
            muestraVisor();
        }
        consistencia();
    }

    private void muestraVisor() {
        jLabelVisorPulsos.setText(String.valueOf((cuentaAtras) ? pulsos - pulsoActual : pulsoActual));
    }

    private void iniciaMisComponentes() {
        
        jSliderNumeroPulsos.setValue(pulsos);
        jSliderPulsosMinuto.setValue(pulsosPorMinuto);
        muestraVisor();
        //pulsoActual=0;
        setPulsoActual(0);
        System.out.println("PULSO ACTUAL"+ pulsoActual);
        jSliderNumeroPulsos.setMaximum(maximoPulsos);
        jSliderPulsosMinuto.setMaximum(maximoPulsosMinuto);
        consistencia();
        temporizador = null;
    }

     private void consistencia() {
        if (temporizador != null) {
            jButtonIniciar.setText((temporizador.isRunning()) ? "DETENER" : "INICIAR");
            jButtonPuestaCero.setEnabled(!temporizador.isRunning());
            jCheckBoxCuentaAtras.setEnabled(!temporizador.isRunning() && pulsoActual == 0);
            jSliderPulsosMinuto.setEnabled(!temporizador.isRunning() && pulsoActual == 0);
            jSliderNumeroPulsos.setEnabled(!temporizador.isRunning() && pulsoActual == 0);

        }
    }

    private ArrayList<JMetronomoVisualListener> listeners = new ArrayList<>();

    public void addJMetronomoVisualListener(JMetronomoVisualListener l) {
        listeners.add(l);
    }

    public void removeJMetronomoVisualListener(JMetronomoVisualListener l) {
        listeners.remove(l);
    }
    
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener){
        if(myPCS==null)return;
        this.myPCS.addPropertyChangeListener(listener);
    }
    
    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener){
        this.myPCS.removePropertyChangeListener(listener);
    }

    protected void fireMetronomoPulso() {
        JMetronomoVisualEvent evt = new JMetronomoVisualEvent(this);
        for (JMetronomoVisualListener l : listeners) {
            l.metronomoPulso(evt);
        }
        System.out.println("FIRE PULSO");
    }

    protected void fireMetronomoFin() {
        JMetronomoVisualEvent evt = new JMetronomoVisualEvent(this);
        for (JMetronomoVisualListener l : listeners) {
            l.metronomoFin(evt);
        }
        System.out.println("FIRE FIN");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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

        jSliderNumeroPulsos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderNumeroPulsosStateChanged(evt);
            }
        });

        jSliderPulsosMinuto.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderPulsosMinutoStateChanged(evt);
            }
        });

        jButtonIniciar.setText("INICIAR");
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });

        jButtonPuestaCero.setText("Puesta a 0");
        jButtonPuestaCero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPuestaCeroActionPerformed(evt);
            }
        });

        jCheckBoxCuentaAtras.setText("Cuenta Atras");
        jCheckBoxCuentaAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCuentaAtrasActionPerformed(evt);
            }
        });

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
    }// </editor-fold>                        

    private void jButtonPuestaCeroActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        puestaCero();
    }                                                 

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {                                               
        if (temporizador != null && temporizador.isRunning()) {
            detener();
        } else {
            iniciar();
        }
        consistencia();
    }                                              

    private void jCheckBoxCuentaAtrasActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        cuentaAtras = jCheckBoxCuentaAtras.isSelected();
        muestraVisor();
    }                                                    

    private void jSliderNumeroPulsosStateChanged(javax.swing.event.ChangeEvent evt) {                                                 
        setPulsos(jSliderNumeroPulsos.getValue());
        muestraVisor();
    }                                                

    private void jSliderPulsosMinutoStateChanged(javax.swing.event.ChangeEvent evt) {                                                 
        setPulsosPorMinuto(jSliderPulsosMinuto.getValue());
    }                                                


    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JButton jButtonPuestaCero;
    private javax.swing.JCheckBox jCheckBoxCuentaAtras;
    private javax.swing.JLabel jLabelVisorPulsos;
    private javax.swing.JSlider jSliderNumeroPulsos;
    private javax.swing.JSlider jSliderPulsosMinuto;
    private javax.swing.JTextField jTextFieldNumeroPulsos;
    private javax.swing.JTextField jTextFieldPulsosMinuto;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration                   

    @Override
    public void actionPerformed(ActionEvent e) {
        if (pulsoActual < pulsos) {
//            pulsoActual++;
            setPulsoActual(pulsoActual+1);
            muestraVisor();
            fireMetronomoPulso();
        } else {
            detener();
            iniciaMisComponentes();
            fireMetronomoFin();
        }
    }
}

