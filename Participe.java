/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecp;

/**
 *
 * @author DREAM INFO
 */
public class Participe {
    String Username;
    String Id_Competition;
    
    public Participe(String user, String Id_comp){
        Username = user;
        Id_Competition = Id_comp;
    }

    public String getUsername() {
        return Username;
    }

    public String getId_Competition() {
        return Id_Competition;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setId_Competition(String Id_Competition) {
        this.Id_Competition = Id_Competition;
    }
    
}
