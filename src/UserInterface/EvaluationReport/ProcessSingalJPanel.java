/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.EvaluationReport;

import Socket.Client;
import System.ClubOrganization.ClubContract;
import System.EcoSystem;
import System.Enterprise.Club;
import System.Enterprise.Enterprise;
import static System.Enterprise.Enterprise.EnterpriseType.Club;
import System.EvaluationReport.PlayerEvalutionReport;
import System.EvaluationReport.Report;
import System.Network.Network;
import System.Organization.Organization;
import System.UserAccount.UserAccount;
import System.WorkRequest.EvaluateAPlayerRequest;
import System.WorkRequest.WorkRequest;
import UserInterface.BGPanel;
import UserInterface.EvaPanel;
import UserInterface.MainJFrame;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sun.management.Agent;

/**
 *
 * @author victor
 */
public class ProcessSingalJPanel extends EvaPanel {

    /**
     * Creates new form ProcessSingalJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private Network network;
    private Enterprise enterprise;  
    private Organization organization;
    private UserAccount account;
    private EvaluateAPlayerRequest workRequest;
    
    ProcessSingalJPanel(JPanel userProcessContainer, EcoSystem business, Network network, Enterprise enterprise, Organization organization, UserAccount account, WorkRequest work) {
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.network = network;
        this.organization = organization;
        this.business = business;
        this.account =account;
        this.workRequest = (EvaluateAPlayerRequest)work;
       
        
        initComponents();
        ShowInfo();
        
    }

      public void ShowInfo(){
        labNetwork.setText(network.getName());
        labEnterprise.setText(enterprise.getName());
        labOrganization.setText(this.organization.getName());
        labUserAccount.setText(account.getUsername());
        labSender.setText(workRequest.getSender().getUsername());
        Enterprise ent = null;
        for(Network n :this.business.getNetworkList()){
            for(Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()){
                for(Organization org : e.getOrganizationDirectory().getOrganizationList()){
                    for(UserAccount ua : org.getUserAccountDirectory().getUserAccountList()){
                        if(ua.getUsername().equals(workRequest.getSender().getUsername())){
                            ent = e;
                        }
                    }
                }
            }
        }
        labClub.setText(ent.getName());       
        labPlayer.setText(workRequest.getPlayer().getName());
        labPrice.setText(String.valueOf(100));
        
        //此处计算Evaluation Report价格的方法需要商议
        //String p = Double.toString(((workRequest.getPlayer().getOverallScore())*100));
        //labPrice.setText(p);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        labOrganization = new javax.swing.JLabel();
        labUserAccount = new javax.swing.JLabel();
        labNetwork = new javax.swing.JLabel();
        labEnterprise = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labClub = new javax.swing.JLabel();
        labSender = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        labPlayer = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        labPrice = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnSend = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("NetWork:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("UserAccount:");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("Organization:");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setText("Enterprise:");

        jLabel1.setText("Sender Club :");

        jLabel6.setText("Sender Account :");

        labClub.setText("<Club>");

        labSender.setText("<Account>");

        jLabel10.setText("Player Name:");

        labPlayer.setText("<Player>");

        jLabel13.setText("Report Price:");

        labPrice.setText("<Price>");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(191, 191, 191)
                                .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(48, 48, 48)
                                .addComponent(labNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5)
                                .addGap(26, 26, 26)
                                .addComponent(labEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel10))
                                        .addGap(8, 8, 8)))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(labOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel3))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(labClub, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel6)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(labUserAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(labSender, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(labPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(labNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(labEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(labOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(labUserAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labClub, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(labSender, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(labPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(129, 129, 129)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component [] componentArray = userProcessContainer.getComponents();
        Component c = componentArray[componentArray.length-1];
        ReporterChooseRequestJPanel sap = (ReporterChooseRequestJPanel) c;
        sap.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        PlayerEvalutionReport report = (PlayerEvalutionReport)workRequest.getReport();
        report.setDenfence(workRequest.getPlayer().getDenfence());
        report.setCalmness(workRequest.getPlayer().getCalmness());
        report.setApperence(workRequest.getPlayer().getApperence());
        report.setPotential(workRequest.getPlayer().getPotential());
        report.setStatus(workRequest.getPlayer().getStatus());
        report.setOverallScore(workRequest.getPlayer().getOverallScore());
        report.setPlayerName(workRequest.getPlayer().getName());
        report.setId(workRequest.getPlayer().getId());
        report.setPlayerType(workRequest.getPlayer().getPlayerType());
        report.setAge(workRequest.getPlayer().getAge());
        report.setHeight(workRequest.getPlayer().getHeight());
        report.setWeight(workRequest.getPlayer().getWeight());
        report.setStrengh(workRequest.getPlayer().getStrengh());
        report.setSpeed(workRequest.getPlayer().getSpeed());
        report.setSkill(workRequest.getPlayer().getSkill());
        report.setShootAccuracy(workRequest.getPlayer().getShootAccuracy());
        report.setReactionSpeed(workRequest.getPlayer().getReactionSpeed());
        report.setBallControl(workRequest.getPlayer().getBallControl());
        report.setPassAccuracy(workRequest.getPlayer().getPassAccuracy());
        report.setPotential(workRequest.getPlayer().getPotential());
        report.setOverallScore(workRequest.getPlayer().getOverallScore());
        UserAccount ua = workRequest.getPlayer().getAgent();
        report.setAgent(ua);
        report.setIdealPrice((int)workRequest.getPlayer().getOverallScore()*100);
        
        workRequest.setTotalprice(Integer.parseInt(this.labPrice.getText()));
       
        workRequest.setTotalprice(100);
        workRequest.setStatus("finish");
        Date date = new Date();
        workRequest.setResolveDate(date);
        
        
        JOptionPane.showMessageDialog(null, "Report Send successfully!");
        
    }//GEN-LAST:event_btnSendActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSend;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel labClub;
    private javax.swing.JLabel labEnterprise;
    private javax.swing.JLabel labNetwork;
    private javax.swing.JLabel labOrganization;
    private javax.swing.JLabel labPlayer;
    private javax.swing.JLabel labPrice;
    private javax.swing.JLabel labSender;
    private javax.swing.JLabel labUserAccount;
    // End of variables declaration//GEN-END:variables
}
