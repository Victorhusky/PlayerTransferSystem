/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ClubContract;

import System.EcoSystem;
import System.Enterprise.Enterprise;
import System.Network.Network;
import System.Organization.Organization;
import System.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author liufulai
 */
public class ClubContractWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form ClubContractWorkArea
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private Network network;
    private Enterprise enterprise;  
    private Organization organization;
    private UserAccount account;
    
    public ClubContractWorkArea(JPanel userProcessContainer, EcoSystem business, Network network, Enterprise enterprise, Organization organization, UserAccount account) {
    
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.network = network;
        this.organization = organization;
        this.business = business;
        this.account =account;
        initComponents();
        config1();
        config2();
        config3();
    }
    
    public void config1(){
        CardLayout blackboardLayout = (CardLayout) BlackboardContainer.getLayout();
        ClubContracBlackboard panel = new ClubContracBlackboard(BlackboardContainer,business,network,enterprise,organization,account);
        BlackboardContainer.add("workArea",panel);
        blackboardLayout.next(this.BlackboardContainer);
    }
    
    public void config2(){
        CardLayout playerTransferLayout = (CardLayout) PlayerTransferContainer.getLayout();
        ClubContractTransactionJPanel panel1 = new ClubContractTransactionJPanel(PlayerTransferContainer,business,network,enterprise,organization,account);
        PlayerTransferContainer.add("workArea",panel1);
        playerTransferLayout.next(this.PlayerTransferContainer);
    }
    
    public void config3(){
        CardLayout evaLayout = (CardLayout) EvaluationRequestContainer.getLayout();
        ClubContractEvaluationJPanel panel2 = new ClubContractEvaluationJPanel(EvaluationRequestContainer,business,network,enterprise,organization,account);
        EvaluationRequestContainer.add("workArea",panel2);
        evaLayout.next(this.EvaluationRequestContainer);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        BlackboardContainer = new javax.swing.JPanel();
        PlayerTransferContainer = new javax.swing.JPanel();
        EvaluationRequestContainer = new javax.swing.JPanel();

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(650, 500));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseEntered(evt);
            }
        });

        BlackboardContainer.setLayout(new java.awt.CardLayout());
        jTabbedPane1.addTab("Black Board", BlackboardContainer);

        PlayerTransferContainer.setLayout(new java.awt.CardLayout());
        jTabbedPane1.addTab("Player Transfer", PlayerTransferContainer);

        EvaluationRequestContainer.setLayout(new java.awt.CardLayout());
        jTabbedPane1.addTab("Evaluation Request", EvaluationRequestContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void jTabbedPane1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseEntered
        // TODO add your handling code here:
        /**
        CardLayout playerTransferLayout = (CardLayout) PlayerTransferContainer.getLayout();
        ClubContractTransactionJPanel panel1 = new ClubContractTransactionJPanel(PlayerTransferContainer,business,network,enterprise,organization,account);
        PlayerTransferContainer.add("workArea",panel1);
        playerTransferLayout.next(this.PlayerTransferContainer);**/
    }//GEN-LAST:event_jTabbedPane1MouseEntered

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        CardLayout playerTransferLayout = (CardLayout) PlayerTransferContainer.getLayout();
        ClubContractTransactionJPanel panel1 = new ClubContractTransactionJPanel(PlayerTransferContainer,business,network,enterprise,organization,account);
        PlayerTransferContainer.add("workArea",panel1);
        playerTransferLayout.next(this.PlayerTransferContainer);
    }//GEN-LAST:event_jTabbedPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BlackboardContainer;
    private javax.swing.JPanel EvaluationRequestContainer;
    private javax.swing.JPanel PlayerTransferContainer;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
