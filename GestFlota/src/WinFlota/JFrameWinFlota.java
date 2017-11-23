/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WinFlota;

import Flota.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author usuario
 */
public class JFrameWinFlota extends javax.swing.JFrame {

    /**
     * Creates new form JFrameWinFlota
     */
    public JFrameWinFlota() {
        initComponents();
        dataTest();
        initMyComponents();
    }

    //<editor-fold defaultstate="collapsed" desc="Test Data">
    private void dataTest() {
        new Autocar("2589 AAA", "123456abc", 1995, 56);
        new Autocar("3698 BBB", "789012qwe", 2000, 32);
        new Autocar("2589 CCC", "456321zxc", 2002, 20);
        new Motocicleta("1478 DDD", "987456rty", 2003, 125);
        new Motocicleta("8526 FFF", "963214ooo", 2004, 100);
        new Motocicleta("8963 GGG", "258963ghj", 2009, 50);
        new Camion("1372 LFC", "456832frv", 2005, 5500);
        new Camion("4563 MKO", "85236klñ", 2002, 9000);
        new Camion("6892 HFG", "123546asd", 2009, 6500);
        new Furgoneta("8569 GFL", "859631nji", 2014, Furgoneta.TiposFurgoneta.CARGA);
        new Furgoneta("8361 LND", "384354sdf", 2012, Furgoneta.TiposFurgoneta.PASAJEROS);
        new Furgoneta("4567 GHJ", "345678los", 1999, Furgoneta.TiposFurgoneta.CARGA);
        new Turismo("2013 LOS", "365412pod", 2001, 5);
        new Turismo("9875 DLS", "987832vbn", 2003, 2);
        new Turismo("0563 JJJ", "254623mlk", 2016, 4);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    
    private void consistencia(){
        int vSeleccionados = jListListadoVehiculos.getSelectedIndices().length;
        Vehiculo v;
        Component[] componentesPanel = jPanelVehiculosITV.getComponents();
        JCheckBoxVehiculo jCBVehiculo;
        jButtonAddPanel.setEnabled(false);
        jButtonPasarITV.setEnabled(false);
        jButtonLimpiarPasados.setEnabled(false);
        jButtonQuitarTodos.setEnabled(componentesPanel.length>0);
        if (jListListadoVehiculos.getSelectedIndex() != -1) {
            v = (Vehiculo) Vehiculo.vehiculosFlota().getElementAt(jListListadoVehiculos.getSelectedIndex());
            jButtonAddPanel.setEnabled(vSeleccionados < 2 && vSeleccionados > 0 && !estaEnElPanel(v));
        }
        for (int i = 0; i < componentesPanel.length; i++) {
            jCBVehiculo = (JCheckBoxVehiculo) componentesPanel[i];
            if (jCBVehiculo.isSelected()) {
                jButtonPasarITV.setEnabled(true);
                break;
            }
        }
        for (int i = 0; i < componentesPanel.length; i++) {
            jCBVehiculo = (JCheckBoxVehiculo) componentesPanel[i];
            if (jCBVehiculo.getVehiculo().getITVPasada()) {
                jButtonLimpiarPasados.setEnabled(true);
                break;
            }
        }
        
    }  
    
   
    
    private void initMyComponents() {
        jListListadoVehiculos.setModel(Vehiculo.vehiculosFlota());
        jListListadoVehiculos.addListSelectionListener(new gestorListSelection());
        jButtonAddPanel.addActionListener(new gestorBotonAñadirVehiculo());
        jButtonQuitarTodos.addActionListener(new gestorEliminarTodo());
        jButtonPasarITV.addActionListener(new gestorPasarITV());
        jButtonLimpiarPasados.addActionListener(new gestorLimpiarITVPasada());
        consistencia();
    }

    private void añadeComponente(Vehiculo vehiculo) {
        if (!estaEnElPanel(vehiculo)) {
            JCheckBoxVehiculo jCBVehiculo = new JCheckBoxVehiculo(vehiculo);
            jCBVehiculo.addActionListener(new gestorChecBox());
            jCBVehiculo.setPreferredSize(new Dimension((jPanelVehiculosITV.getWidth()/2)-10, 30));
            jPanelVehiculosITV.add(jCBVehiculo);
            jPanelVehiculosITV.repaint();
            jPanelVehiculosITV.revalidate();
        }
        consistencia();
    }

    private Boolean estaEnElPanel(Vehiculo v) {
        Boolean esta = false;
        Component[] componentesPanel = jPanelVehiculosITV.getComponents();
        for (Component c : componentesPanel) {
            JCheckBoxVehiculo jCBPanel = (JCheckBoxVehiculo) c;
            if (jCBPanel.getVehiculo() == v) {
                esta = true;
            }
        }
        return esta;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Clases Listenner">
    private class gestorListSelection implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (jListListadoVehiculos.getSelectedIndex() != -1 && jListListadoVehiculos.getSelectedIndices().length < 2) {
                Vehiculo v = (Vehiculo) Vehiculo.vehiculosFlota().get(jListListadoVehiculos.getSelectedIndex());
                jTextAreaDatosVehiculos.setText(v.verDatosParticulares());
            } else {
                jTextAreaDatosVehiculos.setText("");
            }
            consistencia();
        }
    }

    private class gestorBotonAñadirVehiculo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            añadeComponente((Vehiculo) Vehiculo.vehiculosFlota().get(jListListadoVehiculos.getSelectedIndex()));
        }

    }

    private class gestorEliminarTodo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jPanelVehiculosITV.removeAll();
            jPanelVehiculosITV.repaint();
            jPanelVehiculosITV.revalidate();
            consistencia();
        }
    }

    private class gestorPasarITV implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("asdasfad");
            Component[] componentesPanel = jPanelVehiculosITV.getComponents();
            for (Component c : componentesPanel) {
                JCheckBoxVehiculo jCBPanel = (JCheckBoxVehiculo) c;
                if (jCBPanel.isSelected())jCBPanel.pasarITV();
            }
            consistencia();
        }
    }

    private class gestorLimpiarITVPasada implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Component[] componentesPanel = jPanelVehiculosITV.getComponents();
            for (Component c : componentesPanel) {
                JCheckBoxVehiculo jCBPanel = (JCheckBoxVehiculo) c;
                if (jCBPanel.getVehiculo().getITVPasada()) {
                    jPanelVehiculosITV.remove(jCBPanel);
                    jPanelVehiculosITV.repaint();
                    jPanelVehiculosITV.revalidate();
                }
            }
            consistencia();
        }
    }
    
     private class gestorChecBox implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
              consistencia();
        }
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

        jLabelVFlota = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListListadoVehiculos = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDatosVehiculos = new javax.swing.JTextArea();
        jButtonPasarITV = new javax.swing.JButton();
        jPanelVehiculosITV = new javax.swing.JPanel();
        jButtonAddPanel = new javax.swing.JButton();
        jButtonLimpiarPasados = new javax.swing.JButton();
        jButtonQuitarTodos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelVFlota.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelVFlota.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVFlota.setText("Vehiculos de la Flota");

        jScrollPane1.setViewportView(jListListadoVehiculos);

        jTextAreaDatosVehiculos.setColumns(20);
        jTextAreaDatosVehiculos.setRows(5);
        jScrollPane2.setViewportView(jTextAreaDatosVehiculos);

        jButtonPasarITV.setText("Pasar ITV Marcados");

        jPanelVehiculosITV.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Vehiculos para ITV"));
        jPanelVehiculosITV.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jButtonAddPanel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonAddPanel.setText("Añadir al Panel");

        jButtonLimpiarPasados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonLimpiarPasados.setText("Limpiar ITV Pasada");

        jButtonQuitarTodos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonQuitarTodos.setText("Quitar Todos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonAddPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabelVFlota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelVehiculosITV, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPasarITV, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonLimpiarPasados, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButtonQuitarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelVFlota, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPasarITV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelVehiculosITV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAddPanel)
                            .addComponent(jButtonLimpiarPasados))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonQuitarTodos)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameWinFlota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameWinFlota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameWinFlota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameWinFlota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameWinFlota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddPanel;
    private javax.swing.JButton jButtonLimpiarPasados;
    private javax.swing.JButton jButtonPasarITV;
    private javax.swing.JButton jButtonQuitarTodos;
    private javax.swing.JLabel jLabelVFlota;
    private javax.swing.JList<String> jListListadoVehiculos;
    private javax.swing.JPanel jPanelVehiculosITV;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaDatosVehiculos;
    // End of variables declaration//GEN-END:variables

}
