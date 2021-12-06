/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserPanel.java
 *
 * Created on Dec 28, 2009, 5:57:44 PM
 */
package com.asc.presentation;

import asctokentool.GUI.TokenToolMainPanel;
import asctokentool.GUI.testJFrame;
import com.asc.bean.Key;

import com.asc.singlton.SoftlockSinglton;
import com.asc.factory_singlton_pattern.TMAPISinglton;
import com.asc.factory_singlton_pattern.TokenFactory;
import com.asc.keyEngine.DataCoding;
import com.asc.keyEngine.KeyPair;
import com.asc.keyEngine.TMAPI;
import h3m.H3MAPI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;
import sun.security.pkcs11.wrapper.PKCS11Exception;

/**
 *
 * @author ASC 0
 */
public class UserPanel extends javax.swing.JPanel {

    /** Creates new form UserPanel */
    public UserPanel() {
        initComponents();
        try {

            updateFileTable("keys.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateFileTable(String filePath) throws FileNotFoundException, IOException, ClassNotFoundException {
        List<Key> listKeys = api.retreiveKeysFromFile(filePath);
        DefaultTableModel model = new DefaultTableModel();

        fileKeysTable.setModel(model);

        model.addColumn("id");
        model.addColumn("Alias");
        model.addColumn("Description");
        model.addColumn("Tage");
        model.addColumn("Date");


        for (int i = 0; i < listKeys.size(); i++) {
            model.insertRow(i, new Object[]{
                        new String(listKeys.get(i).getId() + ""),
                        new String(DataCoding.decodeData(listKeys.get(i).getAlias())),
                        new String(DataCoding.decodeData(listKeys.get(i).getDescription())),
                        new String(DataCoding.decodeData(listKeys.get(i).getTag())),
                        new String(listKeys.get(i).getDate() + "")});
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        fileKeysTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/asc/resources/private_key.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("configuration/bundle"); // NOI18N
        jButton1.setText(bundle.getString("import")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        fileKeysTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(fileKeysTable);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/asc/resources/logo small.jpg"))); // NOI18N

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/asc/resources/save.gif"))); // NOI18N
        jButton3.setText("Save tokens SN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/asc/resources/find.gif"))); // NOI18N
        jButton2.setText(bundle.getString("change_token_lib")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/asc/resources/config.png"))); // NOI18N
        jButton8.setText(bundle.getString("tool")); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton8))
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TMAPI myAPI = new TMAPI();
        JPasswordField pinpass = new JPasswordField();
        int res = JOptionPane.showConfirmDialog(null, pinpass, bundle.getString("PINRequest"), JOptionPane.OK_CANCEL_OPTION);
        try {
            if (res == JOptionPane.OK_OPTION) {
                if (myAPI.logIn(pinpass.getPassword())) {
                    int[] rows = fileKeysTable.getSelectedRows();
                    if (rows.length == 0) {
                        JOptionPane.showMessageDialog(null, bundle.getString("keyRequestFromTable"));
                    } else {
                        KeyPair newKeyPair = new KeyPair();
                        int id = 0;
                        List<KeyPair> listKeyPair = new ArrayList<KeyPair>();
                        for (int i = 0; i < rows.length; i++) {
                            id = Integer.parseInt(fileKeysTable.getValueAt(rows[i], 0) + "");
                            newKeyPair = myAPI.selectKeyPairFromFile("keys.txt", id);
                            listKeyPair.add(newKeyPair);
                        }
                        List<Key> keys = myAPI.retreiveKeysFromFile("keys.txt");
                        myAPI.importKeyPair(listKeyPair, keys, pinpass.toString());
                        JOptionPane.showMessageDialog(null, bundle.getString("keysImportedSeccess"));
                    }
                    myAPI.logOut();
                    myAPI.disConnect();
                } else {
                    JOptionPane.showMessageDialog(null, bundle.getString("wrongPIN"), bundle.getString("wrongPIN"), JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PKCS11Exception ex) {
//            JOptionPane.showMessageDialog(null, "PKCS11 exception");
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            H3MAPI myAPI = TokenFactory.getToken();
            long[] slots = myAPI.getSlots();
            String managerSN = "Manager Serial Number: ";
            String employeeSN = "Employee Serial Number: ";
            for (int i = 0; i < slots.length; i++) {
                long l = slots[i];
                if (myAPI.getTokenLabel(l).contains("manager")) {
                    managerSN += myAPI.getTokenSerialNumber(l);
                } else if (myAPI.getTokenLabel(l).contains("employee")) {
                    employeeSN += myAPI.getTokenSerialNumber(l);
                }

                PrintWriter out = new PrintWriter(new File("TokensSN.txt"));
                out.println(managerSN);
                out.println(employeeSN);
                out.close();
            }
            JOptionPane.showMessageDialog(null, "Serial number saved in file");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Please insert your tokens");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ManufacturerLibraryFrame mfLib = new ManufacturerLibraryFrame();
        mfLib.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mfLib.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String lib = TokenFactory.getLib();
        TokenToolMainPanel.setLib(lib);
        testJFrame frame = new testJFrame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
}//GEN-LAST:event_jButton8ActionPerformed
    private TMAPI api = new TMAPI();
    private ResourceBundle bundle =
            ResourceBundle.getBundle("configuration/bundle");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable fileKeysTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}