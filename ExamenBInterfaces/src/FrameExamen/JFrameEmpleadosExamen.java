package FrameExamen;

import GestionEmpleadosExamen.Empleado;
import GestionEmpleadosExamen.JCheckBoxEmpleados;
import GestionEmpleadosExamen.JRadioButtonTipoEmpleado;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
//********8,1********
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author usuario
 */
public class JFrameEmpleadosExamen extends javax.swing.JFrame {

    /**
     * Creates new form JFrameEmpleadosExamen
     */
    public JFrameEmpleadosExamen() {
        initComponents();
        dataTest();
        initMyComponents();
        this.setMinimumSize(new Dimension(jPanelCheckboxEmpleados.getWidth()+jPanelRButtonsTiposEmpleados.getWidth()+30, (Empleado.tipoEmpleado.values().length*35)+100));
    }

    //<editor-fold defaultstate="collapsed" desc="Datos Prueba">
    private void dataTest() {
        new Empleado("Montador", "Montador", "12345678L", Empleado.tipoEmpleado.Montador);
        new Empleado("Montador1", "Montador1", "12345678L", Empleado.tipoEmpleado.Montador);
        new Empleado("Montador2", "Montador2", "12345678L", Empleado.tipoEmpleado.Montador);
        new Empleado("Vendedor", "Vendedor", "12345678L", Empleado.tipoEmpleado.Vendedor);
        new Empleado("Vendedor1", "Vendedor1", "12345678L", Empleado.tipoEmpleado.Vendedor);
        new Empleado("Vendedor2", "Vendedor2", "12345678L", Empleado.tipoEmpleado.Vendedor);
        new Empleado("Almacenista", "Almacenista", "12345678L", Empleado.tipoEmpleado.Almacenista);
        new Empleado("Almacenista1", "Almacenista1", "12345678L", Empleado.tipoEmpleado.Almacenista);
        new Empleado("Almacenista2", "Almacenista2", "12345678L", Empleado.tipoEmpleado.Almacenista);
        new Empleado("Jefe", "Jefe", "12345678L", Empleado.tipoEmpleado.Jefe);
        new Empleado("Jefe1", "Jefe1", "12345678L", Empleado.tipoEmpleado.Jefe);
        new Empleado("Jefe2", "Jefe2", "12345678L", Empleado.tipoEmpleado.Jefe);
        new Empleado("Repartidor", "Repartidor", "12345678L", Empleado.tipoEmpleado.Repartidor);
        new Empleado("Repartidor1", "Repartidor1", "12345678L", Empleado.tipoEmpleado.Repartidor);
        new Empleado("Repartidor2", "Repartidor2", "12345678L", Empleado.tipoEmpleado.Repartidor);
        new Empleado("Adminisstrativo", "Administrativo", "12345678L", Empleado.tipoEmpleado.Administrativo);
        new Empleado("Adminisstrativo1", "Administrativo2", "12345678L", Empleado.tipoEmpleado.Administrativo);
        new Empleado("Adminisstrativo1", "Administrativo2", "12345678L", Empleado.tipoEmpleado.Administrativo);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="metodos">
    private void initMyComponents() {
        generaRadioButtons();
        consistencia();
        //jPanelRButtonsTiposEmpleados.setPreferredSize(new Dimension(jPanelRButtonsTiposEmpleados.getWidth(),(Empleado.tipoEmpleado.values().length)*35));
        jButtonEliminar.addActionListener(new gestorEliminar());
    }

    private void generaRadioButtons() {
        ButtonGroup grupoRadioButtons = new ButtonGroup();
        for(int i=0; i<Empleado.tipoEmpleado.values().length; i++){
            JRadioButtonTipoEmpleado rbtTipoEmpleado = new JRadioButtonTipoEmpleado(Empleado.tipoEmpleado.values()[i]);
            rbtTipoEmpleado.addActionListener(new gestorRadioButtons());
            rbtTipoEmpleado.setPreferredSize(new Dimension(jPanelRButtonsTiposEmpleados.getWidth()-30, 30));
            grupoRadioButtons.add(rbtTipoEmpleado);
            jPanelRButtonsTiposEmpleados.add(rbtTipoEmpleado);
        }
        jPanelRButtonsTiposEmpleados.repaint();
        jPanelRButtonsTiposEmpleados.revalidate();
    }
    
    private void consistencia(){
        jButtonEliminar.setEnabled(false);
        jPanelCheckboxEmpleados.repaint();
        jPanelCheckboxEmpleados.revalidate();
        for(Component c: jPanelCheckboxEmpleados.getComponents()){
            if(((JCheckBoxEmpleados)c).isSelected()){
                jButtonEliminar.setEnabled(true);
                break;
            }
        }
    }
    
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Clases Listenner">
    
    private class gestorRadioButtons implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            jPanelCheckboxEmpleados.removeAll();
            JRadioButtonTipoEmpleado rbt;
            for(Empleado empleado: Empleado.coleccionEmpleado){
                rbt = (JRadioButtonTipoEmpleado)e.getSource();
                if(empleado.getTypeEmpleado()== rbt.getTipoAsociado()){
                    JCheckBoxEmpleados jCBEmpleado= new JCheckBoxEmpleados(empleado);
                    jCBEmpleado.addActionListener(new gestorCheckBox());
                    jCBEmpleado.setPreferredSize(new Dimension((jPanelCheckboxEmpleados.getWidth())-15, 30));
                    jPanelCheckboxEmpleados.add(jCBEmpleado);
                }
            }
            consistencia();
        }
    }
    
    private class gestorEliminar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Component[] checkboxEnPanel = jPanelCheckboxEmpleados.getComponents();
            for (Component c: checkboxEnPanel){
                if(c instanceof JCheckBoxEmpleados && ((JCheckBoxEmpleados)c).isSelected()){
                    ((JCheckBoxEmpleados)c).removeEmpleado();
                    jPanelCheckboxEmpleados.remove(c);
                }
            }
            consistencia();
        }
    }
    
    private class gestorCheckBox implements ActionListener{

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

        jPanelCheckboxEmpleados = new javax.swing.JPanel();
        jPanelRButtonsTiposEmpleados = new javax.swing.JPanel();
        jButtonEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelCheckboxEmpleados.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Empleados del tipo seleccionado."));
        jPanelCheckboxEmpleados.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanelRButtonsTiposEmpleados.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tipos EMPLEADOS"));

        jButtonEliminar.setText("Eliminar empleados Seleccionados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelCheckboxEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(jButtonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelRButtonsTiposEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelRButtonsTiposEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelCheckboxEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEliminar)
                        .addGap(9, 9, 9)))
                .addContainerGap())
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
            java.util.logging.Logger.getLogger(JFrameEmpleadosExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameEmpleadosExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameEmpleadosExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameEmpleadosExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameEmpleadosExamen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JPanel jPanelCheckboxEmpleados;
    private javax.swing.JPanel jPanelRButtonsTiposEmpleados;
    // End of variables declaration//GEN-END:variables

    

}
