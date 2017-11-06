/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestioPeliculasWin;

import Peliculas.Pelicula;
import Peliculas.Pelicula.Genero;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.Enum;
import javax.swing.JTextField;

/**
 *
 * @author Jesus
 */
public class JDialogAñadirPelicula extends javax.swing.JDialog {

    /**
     * Creates new form JDialogAñadirPelicula
     */
    public JDialogAñadirPelicula(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarMisComponentes();
        cargarComboBox();
    }

    private void cargarMisComponentes() {
        Component[] componentes = jPanelAñadirPelicula.getComponents();
        for (Component c : componentes) {
            if (c instanceof JTextField) {
                ((JTextField) c).addKeyListener(new gestionContenido());
            }
        }
        jButtonGuardarySalir.setEnabled(false);
        jButtonGuardaryNuevo.setEnabled(false);
        jButtonGuardarySalir.addActionListener(new guardarPelicula());
        jButtonGuardaryNuevo.addActionListener(new guardarPelicula());
        jButtonSalir.addActionListener(new gestorSalir());
    }

    private void cargarComboBox() {
        for (int i = 0; i < Genero.values().length; i++) {
            jComboBoxGeneros.addItem(Genero.values()[i].toString());
        }
    }

    private class gestionContenido implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            jButtonGuardarySalir.setEnabled(jTextFieldTitulo.getText().length() != 0 && jTextFieldDirector.getText().length() != 0 && jTextFieldAño.getText().matches("^[\\d]{4}") && jTextFieldEdadRecomendada.getText().matches("^[\\d]|^[\\d]{2}"));
            jButtonGuardaryNuevo.setEnabled(jTextFieldTitulo.getText().length() != 0 && jTextFieldDirector.getText().length() != 0 && jTextFieldAño.getText().matches("^[\\d]{4}") && jTextFieldEdadRecomendada.getText().matches("^[\\d]|^[\\d]{2}"));
            if (jTextFieldAño.getText().length()!=0 && jTextFieldAño.getText().matches("^[\\d]{4}")) {
                jTextFieldAño.setForeground(Color.BLACK);
            } else {
                jTextFieldAño.setForeground(Color.red);
            }
            if (jTextFieldEdadRecomendada.getText().length()!=0 &&jTextFieldEdadRecomendada.getText().matches("^[\\d]|^[\\d]{2}")) {
                jTextFieldEdadRecomendada.setForeground(Color.BLACK);
            } else {
                jTextFieldEdadRecomendada.setForeground(Color.red);
            }

        }

    }

    private class guardarPelicula implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Class<Genero> Genero = Pelicula.Genero.class;
            Component[] componentes = jPanelAñadirPelicula.getComponents();

            Pelicula p = new Pelicula(jTextFieldTitulo.getText(), jTextFieldDirector.getText(), Enum.valueOf(Genero, jComboBoxGeneros.getSelectedItem().toString()), Integer.valueOf(jTextFieldAño.getText()), Integer.valueOf(jTextFieldEdadRecomendada.getText()));
            if (!e.getActionCommand().equals(jButtonGuardaryNuevo.getActionCommand())) {
                dispose();
            } else {
                for (Component c : componentes) {
                    if (c instanceof JTextField) {
                        ((JTextField) c).setText("");
                    }
                }
            }
        }

    }

    private class gestorSalir implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
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

        jPanelAñadirPelicula = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jTextFieldDirector = new javax.swing.JTextField();
        jComboBoxGeneros = new javax.swing.JComboBox<>();
        jTextFieldAño = new javax.swing.JTextField();
        jTextFieldEdadRecomendada = new javax.swing.JTextField();
        jButtonSalir = new javax.swing.JButton();
        jButtonGuardarySalir = new javax.swing.JButton();
        jButtonGuardaryNuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelAñadirPelicula.setBorder(javax.swing.BorderFactory.createTitledBorder("Nueva pelicula"));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Titulo:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Genero:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Director:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Edad Recomendada:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Año:");

        javax.swing.GroupLayout jPanelAñadirPeliculaLayout = new javax.swing.GroupLayout(jPanelAñadirPelicula);
        jPanelAñadirPelicula.setLayout(jPanelAñadirPeliculaLayout);
        jPanelAñadirPeliculaLayout.setHorizontalGroup(
            jPanelAñadirPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAñadirPeliculaLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanelAñadirPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelAñadirPeliculaLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldTitulo))
                    .addGroup(jPanelAñadirPeliculaLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldEdadRecomendada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAñadirPeliculaLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAñadirPeliculaLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAñadirPeliculaLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanelAñadirPeliculaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxGeneros, jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jTextFieldAño, jTextFieldEdadRecomendada});

        jPanelAñadirPeliculaLayout.setVerticalGroup(
            jPanelAñadirPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAñadirPeliculaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAñadirPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAñadirPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAñadirPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAñadirPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAñadirPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEdadRecomendada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        jPanelAñadirPeliculaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBoxGeneros, jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jTextFieldAño, jTextFieldDirector, jTextFieldEdadRecomendada, jTextFieldTitulo});

        jButtonSalir.setText("Salir");

        jButtonGuardarySalir.setText("Guardar y Salir");

        jButtonGuardaryNuevo.setText("Guardar y Añadir Nueva");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGuardarySalir, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGuardaryNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelAñadirPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelAñadirPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 265, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardaryNuevo)
                    .addComponent(jButtonGuardarySalir)
                    .addComponent(jButtonSalir))
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
            java.util.logging.Logger.getLogger(JDialogAñadirPelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogAñadirPelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogAñadirPelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogAñadirPelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogAñadirPelicula dialog = new JDialogAñadirPelicula(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGuardaryNuevo;
    private javax.swing.JButton jButtonGuardarySalir;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboBoxGeneros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanelAñadirPelicula;
    private javax.swing.JTextField jTextFieldAño;
    private javax.swing.JTextField jTextFieldDirector;
    private javax.swing.JTextField jTextFieldEdadRecomendada;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables
}
