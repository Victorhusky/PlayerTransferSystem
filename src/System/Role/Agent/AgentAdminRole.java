/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.Role.Agent;

import System.EcoSystem;
import System.Enterprise.Enterprise;
import System.Network.Network;
import System.Organization.Organization;
import System.Role.Role;
import System.UserAccount.UserAccount;
import UserInterface.AgentAdmin.AgentAdminWorkArea;
import UserInterface.ClubAdmin.ClubAdminWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author liufulai
 */
public class AgentAdminRole extends Role implements java.io.Serializable{
    
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new AgentAdminWorkArea(userProcessContainer,account, network, enterprise,business);
    }
}
