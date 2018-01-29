/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisComponentes.ComponenteAlarma;

/**
 *
 * @author usuario
 */
public class JComponenteAlarma extends javax.swing.JPanel {

    /**
     * Creates new form JComponenteAlarma
     */
    public JComponenteAlarma() {
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

        jPanelZonas = new javax.swing.JPanel();
        jPanelZona1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelImgAlarmaZona1 = new javax.swing.JLabel();
        jLabelImgAlarmaZona2 = new javax.swing.JLabel();
        jLabelZona2 = new javax.swing.JLabel();
        jPanelZona2 = new javax.swing.JPanel();
        jLabelVisor = new javax.swing.JLabel();
        jButtonValidar = new javax.swing.JButton();
        jButtonA = new javax.swing.JButton();
        jButtonB = new javax.swing.JButton();
        jButtonC = new javax.swing.JButton();
        jButtonD = new javax.swing.JButton();
        jButtonE = new javax.swing.JButton();
        jLabelVisorModo = new javax.swing.JLabel();
        jButtonModo = new javax.swing.JButton();

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel1.setText("Zona 1");

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
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelImgAlarmaZona1)))
                .addContainerGap())
        );

        jLabelVisor.setBackground(new java.awt.Color(0, 102, 102));
        jLabelVisor.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelVisor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVisor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabelVisor.setOpaque(true);

        jButtonValidar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jButtonValidar.setText("OK");

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

        jButtonC.setBackground(new java.awt.Color(255, 255, 255));
        jButtonC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonC.setForeground(new java.awt.Color(0, 153, 0));
        jButtonC.setText("C");
        jButtonC.setOpaque(false);

        jButtonD.setBackground(new java.awt.Color(255, 255, 255));
        jButtonD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonD.setForeground(new java.awt.Color(0, 153, 0));
        jButtonD.setText("D");
        jButtonD.setOpaque(false);

        jButtonE.setBackground(new java.awt.Color(255, 255, 255));
        jButtonE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonE.setForeground(new java.awt.Color(0, 153, 0));
        jButtonE.setText("E");
        jButtonE.setOpaque(false);

        jLabelVisorModo.setBackground(new java.awt.Color(0, 102, 102));
        jLabelVisorModo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelVisorModo.setForeground(new java.awt.Color(204, 204, 0));
        jLabelVisorModo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVisorModo.setOpaque(true);

        jButtonModo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonModo.setText("Modo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelZonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelVisorModo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelVisor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButtonA, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonB, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonC, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                .addGap(1, 1, 1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonD, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonE, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addComponent(jButtonValidar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonModo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelZonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelVisor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelVisorModo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonModo, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonActionPerformedLetras(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonActionPerformedLetras
        if(jButtonA == evt.getSource()){
            
        }
    }//GEN-LAST:event_JButtonActionPerformedLetras


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonA;
    private javax.swing.JButton jButtonB;
    private javax.swing.JButton jButtonC;
    private javax.swing.JButton jButtonD;
    private javax.swing.JButton jButtonE;
    private javax.swing.JButton jButtonModo;
    private javax.swing.JButton jButtonValidar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelImgAlarmaZona1;
    private javax.swing.JLabel jLabelImgAlarmaZona2;
    private javax.swing.JLabel jLabelVisor;
    private javax.swing.JLabel jLabelVisorModo;
    private javax.swing.JLabel jLabelZona2;
    private javax.swing.JPanel jPanelZona1;
    private javax.swing.JPanel jPanelZona2;
    private javax.swing.JPanel jPanelZonas;
    // End of variables declaration//GEN-END:variables
}
