/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestioPeliculasWin;

import Peliculas.Pelicula;
import Peliculas.Pelicula.Genero;
import static Peliculas.Pelicula.peliculas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

/**
 *
 * @author usuario
 */
public class JFrameGestorPeliculas extends javax.swing.JFrame {

    /**
     * Creates new form JFrameGestorPeliculas
     */
    public JFrameGestorPeliculas() {
        initComponents();
        this.setMinimumSize(new Dimension(900, (Genero.values().length * 35) + 150));
        iniciarMisComponentes();
//        addComponentListener(new java.awt.event.ComponentAdapter() {
//            public void componentResized(java.awt.event.ComponentEvent evt) {
//                 resizing();
//            }
//        });
    }

    //<editor-fold defaultstate="collapsed" desc="Mis variables">
    ButtonGroup botonesGrupo = new ButtonGroup();
    DefaultListModel salidaPantalla = new DefaultListModel();

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodos">
    
    private void resizing(){
        int huequecito= ((Genero.values().length*9)/7)-Genero.values().length;
        Component [] radioButtons=jPanelGeneros.getComponents();
        for (int i=0; i< radioButtons.length; i++) {
            radioButtons[i].setPreferredSize(new Dimension(200,(jPanelGeneros.getHeight()-(Genero.values().length*huequecito))/Genero.values().length));
        }
        System.out.println(huequecito);
    }
    
    private void iniciarMisComponentes() {
        cargarPeliculas();
        cargarRadioButtons();
        cargarLista();
        jButtonBuscarPelicula.setEnabled(false);
        jListListado.addMouseListener(new gestorLista());
        jButtonAñadirPelicula.addActionListener(new gestorAñadirPelicula());
    }

    private void cargarRadioButtons() {
//        jPanelGeneros.setPreferredSize(new Dimension(300, this.getHeight() - 150));
//        jPanelGeneros.setMinimumSize(new Dimension(300, this.getHeight() - 150));
        for (int i = 0; i < Genero.values().length; i++) {
            JRadioButton rBT = new JRadioButton();
            rBT.setEnabled(false);
            rBT.setText(Genero.values()[i].toString());
            rBT.addActionListener(new gestorRadioButtons());
            rBT.setPreferredSize(new Dimension(200, 30/*(this.getHeight()-173)/Genero.values().length*/));
            for (int j = 0; j < peliculas.size(); j++) {
                if (peliculas.get(j).getGenero() == Genero.values()[i]) {
                    rBT.setEnabled(true);
                    break;
                }
            }
            rBT.setBorder(new LineBorder(Color.BLACK, 1));
            rBT.setBorderPainted(true);
            jPanelGeneros.add(rBT);
            botonesGrupo.add(rBT);
        }

    }

    private void cargarLista() {
        if (!Pelicula.peliculas.isEmpty()/* && salidaPantalla.isEmpty()*/) {
            salidaPantalla.clear();
            for (int i = 0; i < Pelicula.peliculas.size(); i++) {
                Pelicula p = (Pelicula) Pelicula.peliculas.get(i);
                salidaPantalla.addElement(p);
            }
            jListListado.setModel(salidaPantalla);
        }
    }

    private void cargarPeliculas() {
        new Pelicula("House of the Witch", "Director", Pelicula.Genero.TERROR, 2017, 18);
        new Pelicula("Django", "Director", Pelicula.Genero.NOVELA, 2012, 18);
        new Pelicula("Plan de escape", "Director", Pelicula.Genero.THRILLER, 2013, 18);
        new Pelicula("El hilo Rojo", "Director", Pelicula.Genero.ROMANTICA, 2017, 18);
        new Pelicula("The last Days", "Director", Pelicula.Genero.ACCION, 2013, 13);
        new Pelicula("Pandemic", "Director", Pelicula.Genero.ACCION, 2017, 12);
        new Pelicula("Worry Dolls", "Director", Pelicula.Genero.TERROR, 2016, 18);
//        new Pelicula("Nacida para ganar", "Director", Pelicula.Genero.COMEDIA, 2016, 10);
        new Pelicula("Happy Death Day", "Director", Pelicula.Genero.INTRIGA, 2011, 18);
        new Pelicula("Amar", "Director", Pelicula.Genero.ROMANTICA, 2017, 18);
        new Pelicula("El duelo", "Director", Pelicula.Genero.NOVELA, 2016, 18);
        new Pelicula("Numb", "Director", Pelicula.Genero.INTRIGA, 2017, 15);
//        new Pelicula("Despido Procedente", "Director", Pelicula.Genero.COMEDIA, 2017, 18);
        new Pelicula("Worry Dolss", "Director", Pelicula.Genero.THRILLER, 2016, 18);
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Clases Listener">
    private class gestorLista implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            //Pelicula p = (Pelicula)jListListado.get;
            if (jListListado.getSelectedIndex() != -1) {
                for (int i = 0; i < Pelicula.peliculas.size(); i++) {
                    Pelicula p = Pelicula.peliculas.get(i);
                    if (salidaPantalla.get(jListListado.getSelectedIndex()).toString().equals(p.toString())) {
                        JOptionPane.showMessageDialog(rootPane, p.verDatos(), p.toString(), JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }
                jListListado.clearSelection();
            }
        }

        //<editor-fold defaultstate="collapsed" desc="Metodos No Usados">
        @Override
        public void mousePressed(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        //</editor-fold>

    }

    private class gestorBotonBuscar implements ActionListener {

        private ActionEvent eventoRadioButton;

        private gestorBotonBuscar(ActionEvent e) {
            this.eventoRadioButton = e;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            salidaPantalla.clear();

            for (int i = 0; i < Pelicula.peliculas.size(); i++) {
                Pelicula p = (Pelicula) Pelicula.peliculas.get(i);
                if (p.getGenero().toString().equals(eventoRadioButton.getActionCommand())) {
                    salidaPantalla.addElement(p);
                }
            }
            jListListado.setEnabled(true);
            jButtonBuscarPelicula.removeActionListener(this);
            jButtonBuscarPelicula.setEnabled(false);
        }

    }

    private class gestorRadioButtons implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jListListado.setEnabled(false);
            jListListado.clearSelection();
            jButtonBuscarPelicula.addActionListener(new gestorBotonBuscar(e));
            jButtonBuscarPelicula.setEnabled(true);

        }
    }

    private class gestorAñadirPelicula implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JDialogAñadirPelicula añadirPelicula = new JDialogAñadirPelicula(null, true);
            añadirPelicula.setVisible(true);

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jListListado = new javax.swing.JList<>();
        jButtonBuscarPelicula = new javax.swing.JButton();
        jPanelGeneros = new javax.swing.JPanel();
        jButtonAñadirPelicula = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jListListado);

        jButtonBuscarPelicula.setText("Buscar Peliculas");

        jPanelGeneros.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Genero", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 36))); // NOI18N

        jButtonAñadirPelicula.setText("Añadir Peliculas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonAñadirPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBuscarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelGeneros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonBuscarPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(jButtonAñadirPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
            java.util.logging.Logger.getLogger(JFrameGestorPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameGestorPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameGestorPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameGestorPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameGestorPeliculas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAñadirPelicula;
    private javax.swing.JButton jButtonBuscarPelicula;
    private javax.swing.JList<String> jListListado;
    private javax.swing.JPanel jPanelGeneros;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
