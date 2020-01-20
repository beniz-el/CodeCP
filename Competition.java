/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecp;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dream Info
 */
public class Competition {
    String Id_Competition;
    String Level_Comp;
    boolean Statut;
    Date Date_debut;
    Date Date_fin;
    String Titre;

    public Competition(String Level_Comp, boolean Statut, String titre) {
         Integer id=0;
        
        try {
            id=DaoCompetition.getCount();
        } catch (SQLException ex) {
            Logger.getLogger(Competition.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         this.Id_Competition = "C"+id.toString();
        this.Level_Comp = Level_Comp;
        this.Statut = Statut;
        this.Date_debut = new Date();
        this.Date_fin = new Date();
        this.Titre = titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getTitre() {
        return Titre;
    }
    
  
    public String getIdCompetition() {
        return Id_Competition;
    }

    public String getLevelComp() {
        return Level_Comp;
    }

    public boolean getStatut() {
        return Statut;
    }

    public Date getDatedebut() {
        return Date_debut;
    }

    public Date getDatefin() {
        return Date_fin;
    }

    public void setLevelComp(String Level_Comp) {
        this.Level_Comp = Level_Comp;
    }

    public void setStatut(boolean Statut) {
        this.Statut = Statut;
    }

    public void setDatedebut(Date Date_debut) {
        this.Date_debut = Date_debut;
    }

    public void setDatefin(Date Date_fin) {
        this.Date_fin = Date_fin;
    }
}
