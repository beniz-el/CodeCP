/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecp;

import java.util.Date;

public class Message {
    static int Id=0;
    String Id_Msg;
    String Id_User_emet;
    String Id_User_recept;
    String Contenu;
    Date date;
    boolean Lu;
    
    public Message(String id1, String id2, String cont, boolean lu){
         ++Id;
       Id_Msg = "M"+String.valueOf(Id);
       Id_User_emet = id1;
       Id_User_recept = id2;
       Contenu = cont;
       Lu = lu;
    }

    public void setIdUseremet(String Id_User_emet) {
        this.Id_User_emet = Id_User_emet;
    }

    public void setIdUserrecept(String Id_User_recept) {
        this.Id_User_recept = Id_User_recept;
    }

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLu(boolean Lu) {
        this.Lu = Lu;
    }
   
    public String getIdMsg() {
        return Id_Msg;
    }

    public String getIdUseremet() {
        return Id_User_emet;
    }

    public String getIdUserrecept() {
        return Id_User_recept;
    }

    public String getContenu() {
        return Contenu;
    }

    public Date getDate() {
        return date;
    }

    public boolean getLu() {
        return Lu;
    }
    
    
}
