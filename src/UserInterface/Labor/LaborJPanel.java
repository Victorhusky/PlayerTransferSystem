/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Labor;

import Socket.Client;
import System.EcoSystem;
import System.Enterprise.Enterprise;
import System.Network.Network;
import System.Organization.Organization;
import System.UserAccount.UserAccount;
import System.WorkRequest.FreeTransferRequest;
import System.WorkRequest.LoanRequest;
import System.WorkRequest.TransferRequest;
import System.WorkRequest.WorkRequest;
import UserInterface.LaborPanel;
import UserInterface.MainJFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victor
 */
public class LaborJPanel extends LaborPanel {

    /**
     * Creates new form LaborJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private Network network;
    private Enterprise enterprise;  
    private Organization organization;
    private UserAccount account;

    public LaborJPanel(JPanel userProcessContainer, EcoSystem business, Network network, Enterprise enterprise, Organization organization, UserAccount account) {
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.network = network;
        this.organization = organization;
        this.business = business;
        this.account =account;
        initComponents();
        this.labNetwork.setText(network.getName());;
        ShowTable();
        
    }
    public void ShowTable(){
           //populate my work queue
        
        System.out.println(this.organization.name);
        DefaultTableModel model = (DefaultTableModel) this.tblRequest.getModel();        
        model.setRowCount(0);
        
        for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()){
        if(wr instanceof TransferRequest){
          TransferRequest tr = (TransferRequest)wr;
                Object[] row = new Object[4];           
                row[0] = tr;
                row[1] = tr.getSender();
                row[2] = tr.getStatus();
                row[3] = tr.isLaborPermit();
                model.addRow(row);
        }
        
        else if (wr instanceof LoanRequest){
             LoanRequest lr = (LoanRequest)wr;
                Object[] row = new Object[4];           
                row[0] = lr;
                row[1] = lr.getSender();
                row[2] = lr.getStatus();
                row[3] = lr.isLaborPermit();
                model.addRow(row);
        }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequest = new javax.swing.JTable();
        labNetwork = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnDenied = new javax.swing.JButton();
        btnApprove = new javax.swing.JButton();

        tblRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Requst Id", "Sender", "Status", "LaborPermation"
            }
        ));
        jScrollPane1.setViewportView(tblRequest);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("NetWork:");

        btnDenied.setText("Denied");
        btnDenied.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeniedActionPerformed(evt);
            }
        });

        btnApprove.setText(" Approve");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel2)
                        .addGap(48, 48, 48)
                        .addComponent(labNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(114, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnApprove)
                .addGap(98, 98, 98)
                .addComponent(btnDenied)
                .addGap(216, 216, 216))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(labNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDenied)
                    .addComponent(btnApprove))
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
     int selectedRow = tblRequest.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please selete a Work request!");
            return;
        }
        int flag = 0;
        WorkRequest work = (WorkRequest)tblRequest.getValueAt(selectedRow, 0);
        if(work instanceof TransferRequest){
            TransferRequest tr= (TransferRequest)work;
        tr.setLaborPermit(true);
        tr.setStatus("Finished");
        ShowTable();
        }
        
        if(work instanceof LoanRequest){
            LoanRequest lr= (LoanRequest)work;
        lr.setLaborPermit(true);
        lr.setStatus("Finished");
        ShowTable();
        }
  
        
            // TODO add your handling code here:
    }//GEN-LAST:event_btnApproveActionPerformed

    private void btnDeniedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeniedActionPerformed
        int selectedRow = tblRequest.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please selete a Work request!");
            return;
        }
        int flag = 0;
        TransferRequest work = (TransferRequest)tblRequest.getValueAt(selectedRow, 0);
        work.setStatus("LaborDenied");        // TODO add your handling code here:
      
        ShowTable();
        
    }//GEN-LAST:event_btnDeniedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnDenied;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labNetwork;
    private javax.swing.JTable tblRequest;
    // End of variables declaration//GEN-END:variables
}