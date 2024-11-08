/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import server.Server;

/**
 *
 * @author Djapac
 */
public class FrmServer extends javax.swing.JFrame {

    Server server;
    /**
     * Creates new form FrmServer
     */
    public FrmServer() {
        initComponents();
        
        setTitle("Početna forma");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        btnZaustaviServer.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnPokreniServer = new javax.swing.JButton();
        btnZaustaviServer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.default.focusedBackground"));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dobro došli!");

        btnPokreniServer.setBackground(java.awt.Color.green);
        btnPokreniServer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPokreniServer.setText("Pokreni server");
        btnPokreniServer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 51), 1, true));
        btnPokreniServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokreniServerActionPerformed(evt);
            }
        });

        btnZaustaviServer.setBackground(java.awt.Color.red);
        btnZaustaviServer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnZaustaviServer.setText("Zaustavi server");
        btnZaustaviServer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        btnZaustaviServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZaustaviServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(216, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPokreniServer, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnZaustaviServer, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(184, 184, 184))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPokreniServer, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnZaustaviServer, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(220, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPokreniServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokreniServerActionPerformed
        // TODO add your handling code here:
        
        try {
            if (server == null || !server.isAlive()) {
                server = new Server();
                server.start();
                JOptionPane.showMessageDialog(this, "Server je pokrenut");
                btnPokreniServer.setEnabled(false);
                btnZaustaviServer.setEnabled(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_btnPokreniServerActionPerformed

    private void btnZaustaviServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZaustaviServerActionPerformed
        // TODO add your handling code here:
        try {
            server.stopServer();
            JOptionPane.showMessageDialog(this, "Server je zaustavljen");
            this.dispose();
            btnPokreniServer.setEnabled(true);
            btnZaustaviServer.setEnabled(false);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnZaustaviServerActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPokreniServer;
    private javax.swing.JButton btnZaustaviServer;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
