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
public class Compose {
    String Id_Probleme;
    String Id_Competition;
    
    public Compose(String Id_prob, String Id_comp){
        Id_Probleme = Id_prob;
        Id_Competition = Id_comp;
    }

    public String getId_Probleme() {
        return Id_Probleme;
    }

    public String getId_Competition() {
        return Id_Competition;
    }

    public void setId_Probleme(String Id_Probleme) {
        this.Id_Probleme = Id_Probleme;
    }

    public void setId_Competition(String Id_Competition) {
        this.Id_Competition = Id_Competition;
    }
    
    
}
