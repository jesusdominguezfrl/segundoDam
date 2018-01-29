/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author usuario
 */
public class JFrameTest extends javax.swing.JFrame {

    /**
     * Creates new form JFrameTest
     */
    public JFrameTest() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelZonaJardin = new javax.swing.JPanel();
        jLabelJardin = new javax.swing.JLabel();
        jPanelZonaVivienda = new javax.swing.JPanel();
        jLabelVivienda = new javax.swing.JLabel();
        jComponenteAlarma1 = new MisComponentes.ComponenteAlarma.JComponenteAlarma();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListSucesos = new javax.swing.JList<>();
        jLabelRegistroSucesos = new javax.swing.JLabel();
        jLabelErrorDesactivavion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelZonaJardin.setBackground(new java.awt.Color(0, 204, 0));
        jPanelZonaJardin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelJardin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelJardin.setForeground(new java.awt.Color(255, 0, 0));
        jLabelJardin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelJardin.setText("Zona 1: Jardin");

        jPanelZonaVivienda.setBackground(new java.awt.Color(255, 0, 0));
        jPanelZonaVivienda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelVivienda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelVivienda.setForeground(new java.awt.Color(0, 204, 0));
        jLabelVivienda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVivienda.setText("Zona 2: Vivienda");

        javax.swing.GroupLayout jPanelZonaViviendaLayout = new javax.swing.GroupLayout(jPanelZonaVivienda);
        jPanelZonaVivienda.setLayout(jPanelZonaViviendaLayout);
        jPanelZonaViviendaLayout.setHorizontalGroup(
            jPanelZonaViviendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelZonaViviendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelVivienda, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelZonaViviendaLayout.setVerticalGroup(
            jPanelZonaViviendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelZonaViviendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelVivienda)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelZonaJardinLayout = new javax.swing.GroupLayout(jPanelZonaJardin);
        jPanelZonaJardin.setLayout(jPanelZonaJardinLayout);
        jPanelZonaJardinLayout.setHorizontalGroup(
            jPanelZonaJardinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelZonaJardinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelJardin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelZonaJardinLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jPanelZonaVivienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(66, 66, 66))
        );
        jPanelZonaJardinLayout.setVerticalGroup(
            jPanelZonaJardinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelZonaJardinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelJardin)
                .addGap(18, 18, 18)
                .addComponent(jPanelZonaVivienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(58, 58, 58))
        );

        jScrollPane1.setViewportView(jListSucesos);

        jLabelRegistroSucesos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelRegistroSucesos.setText("Registro de Sucesos.");

        jLabelErrorDesactivavion.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabelErrorDesactivavion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelErrorDesactivavion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComponenteAlarma1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelZonaJardin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelRegistroSucesos, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelZonaJardin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComponenteAlarma1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelErrorDesactivavion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRegistroSucesos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(JFrameTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private MisComponentes.ComponenteAlarma.JComponenteAlarma jComponenteAlarma1;
    private javax.swing.JLabel jLabelErrorDesactivavion;
    private javax.swing.JLabel jLabelJardin;
    private javax.swing.JLabel jLabelRegistroSucesos;
    private javax.swing.JLabel jLabelVivienda;
    private javax.swing.JList<String> jListSucesos;
    private javax.swing.JPanel jPanelZonaJardin;
    private javax.swing.JPanel jPanelZonaVivienda;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
