/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ClubContract;

import Socket.Client;
import System.EcoSystem;
import System.Enterprise.Club;
import System.Enterprise.Enterprise;
import System.Game.Game;
import System.Message.Message;
import System.Message.MessageDirectory;
import System.Network.Network;
import System.Organization.Organization;
import System.Player.Player;
import System.UserAccount.UserAccount;
import System.WorkRequest.LoanRequest;
import System.WorkRequest.TransferRequest;
import System.WorkRequest.WorkRequest;
import System.WorkRequest.WorkRequest.WorkRequestType;
import UserInterface.BGPanel;
import UserInterface.CalendarPanel.CalendarPanel;
import UserInterface.ClubPanel;
import UserInterface.MainJFrame;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author liufulai
 */
public class StartBuyPlayer extends ClubPanel {

    /**
     * Creates new form StartBuyPlayer
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private Network network;
    private Enterprise enterprise;  
    private Organization organization;
    private UserAccount account;
    private MessageDirectory tepList;
    private WorkRequest workRequst;
    
    StartBuyPlayer(JPanel userProcessContainer, EcoSystem business, Network network, Enterprise enterprise, Organization organization, UserAccount account) {
    //Config jSlider:
    
        
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.network = network;
        this.organization = organization;
        this.business = business;
        this.account =account;
        tepList = new MessageDirectory();
        initComponents();
        ShowInfo();
        ShowCbo();
        workRequst= null;
        ShowTable();
        ConfigDateText();
       
        this.pricejSlider.setMinimum(0);
        int budget = 599;
        this.pricejSlider.setMaximum(budget);
        
    
    }
    
    public void ConfigDateText(){
        CalendarPanel p = new CalendarPanel(this.txtDateStart, "yyyy/MM/dd");
        p.initCalendarPanel();
        JLabel l = new JLabel("日历面板");
        this.add(l);
        this.add(p);
        
        CalendarPanel p1 = new CalendarPanel(this.txtDateFinish, "yyyy/MM/dd");
        p1.initCalendarPanel();
        JLabel l1 = new JLabel("日历面板");
        this.add(l1);
        this.add(p1);
        
    }
    
    
         public void ShowTable(){
        DefaultTableModel model = (DefaultTableModel) this.tblAdditionalItem.getModel();
        
        model.setRowCount(0);
       int i =0;
        for (Message m: this.tepList.getMessageList()){
            Object[] row = new Object[2];
            i++;
            row[0] = i;
            row[1] = m.getMessage();
            
            model.addRow(row);
        }
    }
    
    public void ShowInfo(){
        labNetwork.setText(network.getName());
        labEnterprise.setText(enterprise.getName());
        labOrganization.setText(this.organization.getName());
        labUserAccount1.setText(account.getUsername());
    }
    public void ShowCbo(){
        this.cboNetwork.removeAllItems();
        this.cboClub.removeAllItems();
        this.cboPlayer.removeAllItems();
        this.cboType.removeAllItems();
        this.cboType.addItem(WorkRequest.WorkRequestType.TransferRequest);
        this.cboType.addItem(WorkRequest.WorkRequestType.LoanRequest);
        for(Network nw:business.getNetworkList()){
            cboNetwork.addItem(nw);
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

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labOrganization = new javax.swing.JLabel();
        labNetwork = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labUserAccount1 = new javax.swing.JLabel();
        labEnterprise = new javax.swing.JLabel();
        cboNetwork = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboPlayer = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cboClub = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cboType = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        btnSend = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        pricejSlider = new javax.swing.JSlider();
        txtPrice = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAdditionalItem = new javax.swing.JTable();
        txtItem = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtDateFinish = new javax.swing.JTextField();
        txtDateStart = new javax.swing.JTextField();

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("NetWork:");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("Organization:");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setText("Enterprise:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("UserAccount:");

        cboNetwork.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNetworkActionPerformed(evt);
            }
        });

        jLabel1.setText("Network:");

        jLabel6.setText("Club:");

        cboPlayer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPlayerActionPerformed(evt);
            }
        });

        jLabel7.setText("Player:");

        cboClub.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboClubActionPerformed(evt);
            }
        });

        jLabel8.setText("Transfer Type:");

        cboType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboTypeMouseClicked(evt);
            }
        });
        cboType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTypeActionPerformed(evt);
            }
        });

        jLabel9.setText("Price:");

        jLabel10.setText("Additional Item:");

        jLabel11.setText("Message:");

        txtMessage.setColumns(20);
        txtMessage.setLineWrap(true);
        txtMessage.setRows(5);
        txtMessage.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtMessage);

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        pricejSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pricejSliderStateChanged(evt);
            }
        });

        txtPrice.setText("<Price>");

        tblAdditionalItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Item Content"
            }
        ));
        jScrollPane2.setViewportView(tblAdditionalItem);

        btnAdd.setText("Add an item");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel12.setText("Date Start:");

        jLabel14.setText("Date End:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSend)
                        .addGap(265, 265, 265))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(cboType, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cboClub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnAdd))
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(25, 25, 25)
                                .addComponent(txtDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14)
                                .addGap(31, 31, 31)
                                .addComponent(txtDateFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pricejSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrice))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jLabel2)
                            .addGap(48, 48, 48)
                            .addComponent(labNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jLabel5)
                            .addGap(26, 26, 26)
                            .addComponent(labEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(labOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(11, 11, 11)
                            .addComponent(jLabel3)
                            .addGap(18, 33, Short.MAX_VALUE)
                            .addComponent(labUserAccount1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(labNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(labEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labUserAccount1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cboClub, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDateFinish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pricejSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10))
                    .addComponent(txtPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSend)
                    .addComponent(btnBack))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTypeActionPerformed

    private void pricejSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pricejSliderStateChanged
        // TODO add your handling code here:
        txtPrice.setText(""+pricejSlider.getValue());
    }//GEN-LAST:event_pricejSliderStateChanged

    private void cboNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNetworkActionPerformed
        Network nw = (Network)cboNetwork.getSelectedItem();
        this.cboClub.removeAllItems();
    if (nw != null){
        for (Enterprise e: nw.getEnterpriseDirectory().getEnterpriseList())
        {
            if(e instanceof Club&&!e.equals(enterprise)){
                cboClub.addItem(e);
        }
    }
    }
    
            // TODO add your handling code here:
    }//GEN-LAST:event_cboNetworkActionPerformed

    private void cboClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboClubActionPerformed
        this.cboPlayer.removeAllItems();            
        Club c = (Club)cboClub.getSelectedItem();
        if (c != null){
        for (Player p: c.getPlayerDirectory().getPlayerList())
        { 
                cboPlayer.addItem(p);
    }
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_cboClubActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Message m = new Message();
        m.setMessage(txtItem.getText());
        if(this.txtItem.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "item cannot be empty");
            return;
        }
        this.tepList.getMessageList().add(m);
          
          ShowTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void cboPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPlayerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPlayerActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        Component [] componentArray = userProcessContainer.getComponents();
        Component c = componentArray[componentArray.length-1];
        ClubContractTransactionJPanel clubContractTransactionJPanel = (ClubContractTransactionJPanel) c;
        clubContractTransactionJPanel.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
         
        if(this.txtMessage.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "message cannot be empty");
            return;
        }
        if(cboType.getSelectedItem().equals(WorkRequest.WorkRequestType.TransferRequest)){
            TransferRequest wr = (TransferRequest)this.account.getWorkQueue().CreateWorkRequest((WorkRequestType)cboType.getSelectedItem());            
            Club soldclub =(Club)cboClub.getSelectedItem();
            Message msg = new Message();
            msg.setMessage(this.txtMessage.getText());
            wr.getClubMessageLog().getMessageList().add(msg);
            wr.setSender(account);       
            wr.setStatus("InclubSend");
            wr.setClubAdditionalItem((MessageDirectory)this.tepList);
            wr.setClubPrice(pricejSlider.getValue());
            wr.setPlayer((Player)cboPlayer.getSelectedItem());
            soldclub.getWorkQueue().getWorkRequestList().add(wr);
               
            JOptionPane.showMessageDialog(null, "WorkRequst successfully added!");
        }
        else if(cboType.getSelectedItem().equals(WorkRequest.WorkRequestType.LoanRequest)){
            LoanRequest wr = (LoanRequest)this.account.getWorkQueue().CreateWorkRequest((WorkRequestType)cboType.getSelectedItem());
            Club soldclub =(Club)cboClub.getSelectedItem();
            Message msg = new Message();
            msg.setMessage(this.txtMessage.getText());
            wr.getClubMessageLog().getMessageList().add(msg);
            wr.setSender(account);       
            wr.setStatus("InclubSend");
            wr.setClubAdditionalItem((MessageDirectory)this.tepList);
            wr.setClubPrice(pricejSlider.getValue());
            wr.setLoanStart(String.valueOf(this.txtDateStart.getText()));
            wr.setLoanEnd(String.valueOf(this.txtDateFinish.getText()));
            wr.setPlayer((Player)cboPlayer.getSelectedItem());
            soldclub.getWorkQueue().getWorkRequestList().add(wr);
            
            
            JOptionPane.showMessageDialog(null, "WorkRequst successfully added!");
        }
         
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSendActionPerformed

    private void cboTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboTypeMouseClicked
        // TODO add your handling code here:
        if(this.cboType.getSelectedItem().equals(WorkRequestType.TransferRequest)){
            this.txtDateStart.setEnabled(false);
            this.txtDateFinish.setEnabled(false);
        }
        if(this.cboType.getSelectedItem().equals(WorkRequestType.LoanRequest)){
            this.txtDateStart.setEnabled(true);
            this.txtDateFinish.setEnabled(true);
        }
    }//GEN-LAST:event_cboTypeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSend;
    private javax.swing.JComboBox cboClub;
    private javax.swing.JComboBox cboNetwork;
    private javax.swing.JComboBox cboPlayer;
    private javax.swing.JComboBox cboType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labEnterprise;
    private javax.swing.JLabel labNetwork;
    private javax.swing.JLabel labOrganization;
    private javax.swing.JLabel labUserAccount1;
    private javax.swing.JSlider pricejSlider;
    private javax.swing.JTable tblAdditionalItem;
    private javax.swing.JTextField txtDateFinish;
    private javax.swing.JTextField txtDateStart;
    private javax.swing.JTextField txtItem;
    private javax.swing.JTextArea txtMessage;
    private javax.swing.JLabel txtPrice;
    // End of variables declaration//GEN-END:variables
}
