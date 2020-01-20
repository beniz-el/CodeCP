/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecp;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Message_Perso extends Message{
    String Id_Msg;
    String Username_rece;
    String Username_eme;
    
    public Message_Perso(String user1, String user2, String cont, String obj){
        super(cont,obj);
        Integer id = 0;
        try {
            id = daoMessagePerso.getCount();
        } catch (SQLException ex) {
            Logger.getLogger(Message_Perso.class.getName()).log(Level.SEVERE, null, ex);
        }
        Id_Msg = "M"+(id++).toString();
        Username_rece = user1;
        Username_eme = user2;
    }

    public void setUsername_rece(String Username_rece) {
        this.Username_rece = Username_rece;
    }

    public void setUsername_eme(String Username_eme) {
        this.Username_eme = Username_eme;
    }

    public String getId_Msg() {
        return Id_Msg;
    }

    public String getUsername_rece() {
        return Username_rece;
    }

    public String getUsername_eme() {
        return Username_eme;
    }
    
    
}
