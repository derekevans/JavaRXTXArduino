/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialtest;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author derekevans
 */
public class GUI extends javax.swing.JFrame {
    Serial serial = new Serial();
    String port;
    int baud;
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        portsList.setModel(serial.listPorts());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        portsList = new javax.swing.JList();
        updatePorts = new javax.swing.JButton();
        connect = new javax.swing.JButton();
        connectStatus = new javax.swing.JLabel();
        baudRate = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        var1 = new javax.swing.JTextField();
        getVariables = new javax.swing.JButton();
        downloadData = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        var2 = new javax.swing.JTextField();
        var3 = new javax.swing.JTextField();
        setVariables = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Port and Baud Rate"));

        portsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        portsList.setSelectedIndex(0);
        jScrollPane1.setViewportView(portsList);

        updatePorts.setText("Update Ports");
        updatePorts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePortsActionPerformed(evt);
            }
        });

        connect.setText("Connect");
        connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectActionPerformed(evt);
            }
        });

        connectStatus.setText("Connect to begin");

        baudRate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "300 baud", "1200 baud", "2400 baud", "4800 baud", "9600 baud", "19200 baud", "38400 buad", "57600 baud", "115200 baud" }));
        baudRate.setSelectedIndex(7);
        baudRate.setToolTipText("");
        baudRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baudRateActionPerformed(evt);
            }
        });

        jLabel1.setText("Available Ports");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(baudRate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(updatePorts, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(connect, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(connectStatus)
                                    .addComponent(jLabel1))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(baudRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updatePorts))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(connect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(connectStatus)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Send/Receive Data"));

        var1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                var1ActionPerformed(evt);
            }
        });

        getVariables.setText("Get Variables");
        getVariables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getVariablesActionPerformed(evt);
            }
        });

        downloadData.setText("Download Data");
        downloadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadDataActionPerformed(evt);
            }
        });

        jLabel2.setText("Variable 1 (String)");

        jLabel3.setText("Variable 2 (Integer)");

        jLabel4.setText("Variable 3 (Float)");

        setVariables.setText("Set Variables");
        setVariables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setVariablesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(downloadData, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(setVariables, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(var1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(var2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(var3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(getVariables, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(var1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(var2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(var3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(getVariables)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setVariables)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(downloadData))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updatePortsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePortsActionPerformed
        // TODO add your handling code here:
        portsList.setModel(serial.listPorts());
    }//GEN-LAST:event_updatePortsActionPerformed

    private void connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectActionPerformed
        // TODO add your handling code here:
       
        //get the selected port and baud rate
        port = portsList.getSelectedValue().toString();
        baud = Integer.parseInt(baudRate.getSelectedItem().toString().split(" ")[0]);
        
        serial.connect(port,baud);
        serial.initIOStream();
            
        //arduino resets when serial connection is made, wait for it to finish
        //place a 10uf electrolytic cap between gnd and reset to prevent this
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
        serial.readLine("><handshake><",false);
        serial.disconnect();
        
        if(serial.in.equals("ArduinoUno")) {
            connectStatus.setText("Arduino Uno found on "+ port);
        }
        System.out.println(serial.in);
    }//GEN-LAST:event_connectActionPerformed

    private void downloadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadDataActionPerformed
        // TODO add your handling code here:
        //get the selected port and baud rate
        port = portsList.getSelectedValue().toString();
        baud = Integer.parseInt(baudRate.getSelectedItem().toString().split(" ")[0]);
        
        //select a file, if null is returned then no file was choosen
        FileChooser fc = new FileChooser();
        String file = fc.chooseFile();
        System.out.println(file);
        if(file != null) {
            serial.connect(port,baud);
            serial.initIOStream();

            //arduino resets when serial connection is made, wait for it to finish
            //place a 10uf electrolytic cap between gnd and reset to prevent this
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
            }
            
            //write data returned from arduino to file
            serial.writeToFile("><read><",false,file);
            serial.disconnect();
        }
        
    }//GEN-LAST:event_downloadDataActionPerformed

    private void baudRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baudRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_baudRateActionPerformed

    private void getVariablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getVariablesActionPerformed
        // TODO add your handling code here:        
        
        //get the port and buad rate
        serial.connect(port,baud);
        serial.initIOStream();
            
        //arduino resets when serial connection is made, wait for it to finish
        //place a 10uf electrolytic cap between gnd and reset to prevent this
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
        
        //send the text input in the text input to Arduino
        serial.readLine("><get><",false);
        serial.disconnect();
        
        if(serial.in != null) {
            String[] variables = serial.in.split(",");
            if(variables.length>=3) {
                var1.setText(variables[0]);
                var2.setText(variables[1]);
                var3.setText(variables[2]);
            }
        } 
        
        System.out.println(serial.in);
    }//GEN-LAST:event_getVariablesActionPerformed

    private void var1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_var1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_var1ActionPerformed

    private void setVariablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setVariablesActionPerformed
        // TODO add your handling code here:
        String variable1 = var1.getText();
        String variable2 = var2.getText();
        String variable3 = var3.getText();
        
        //get the port and buad rate
        serial.connect(port,baud);
        serial.initIOStream();
            
        //arduino resets when serial connection is made, wait for it to finish
        //place a 10uf electrolytic cap between gnd and reset to prevent this
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
        
        //send the text input in the text input to Arduino
        serial.writeLine("><set><\0",false);
        serial.writeLine(variable1+"\0",false);
        serial.writeLine(variable2 + "," + variable3,false);
        serial.disconnect();
        
    }//GEN-LAST:event_setVariablesActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox baudRate;
    private javax.swing.JButton connect;
    private javax.swing.JLabel connectStatus;
    private javax.swing.JButton downloadData;
    private javax.swing.JButton getVariables;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList portsList;
    private javax.swing.JButton setVariables;
    private javax.swing.JButton updatePorts;
    private javax.swing.JTextField var1;
    private javax.swing.JTextField var2;
    private javax.swing.JTextField var3;
    // End of variables declaration//GEN-END:variables
}
