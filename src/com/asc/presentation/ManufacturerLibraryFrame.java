/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ManufacturerLibraryFrame.java
 *
 * Created on Jan 27, 2010, 11:55:36 AM
 */
package com.asc.presentation;


import com.asc.singlton.SoftlockSinglton;
import com.asc.factory_singlton_pattern.ManifacturerLibrary;
import com.asc.factory_singlton_pattern.TokenFactory;
import h3m.H3MAPI;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author pc3-asc
 */
public class ManufacturerLibraryFrame extends javax.swing.JFrame {

    /** Creates new form ManufacturerLibraryFrame */
    public ManufacturerLibraryFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/asc/resources/logo small.jpg"))); // NOI18N

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Softlock");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("St3");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("SNS");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/asc/resources/accepted_48.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("configuration/bundle"); // NOI18N
        jButton1.setText(bundle.getString("select_manufacturer_btn")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton3))
                        .addContainerGap(49, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        if (jRadioButton1.isSelected()) {
            TokenFactory.setLib(ManifacturerLibrary.SOFTLOCK_LIB);
            String s = TokenFactory.lib;
            this.dispose();
            if (LogInFrameSinglton.frame == null) {
                LogInFrameSinglton.getInstance().setVisible(true);
                this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        } else if (jRadioButton2.isSelected()) {
            TokenFactory.setLib(ManifacturerLibrary.ST3_LIB);
            this.dispose();
            if (LogInFrameSinglton.frame == null) {
                LogInFrameSinglton.getInstance().setVisible(true);
                this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        } else if (jRadioButton3.isSelected()) {
            TokenFactory.setLib(ManifacturerLibrary.SNS_LIB);
            this.dispose();
            if (LogInFrameSinglton.frame == null) {
                LogInFrameSinglton.getInstance().setVisible(true);
                this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        } else {
            int result = JOptionPane.showConfirmDialog(null, BUNDLE.getString("select_manufacturer_JOptionPane"), BUNDLE.getString("confirm_user"), JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
            } else if (result == JOptionPane.CANCEL_OPTION) {
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed
    private static ResourceBundle BUNDLE = ResourceBundle.getBundle("configuration/bundle");

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ManufacturerLibraryFrame().setVisible(true);
            }
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

}
