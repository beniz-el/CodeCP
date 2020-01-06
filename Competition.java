/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecp;

import java.util.Date;


public class Competition {
    String Id_Competition;
    String Level_Comp;
    boolean Statut;
    Date Date_debut;
    Date Date_fin;
    
    public Competition(){
        
    }
    
    public void AddProbleme(){
        
    }
    public void deleteProbleme(){
        
    }
    public void AffcherListeProbleme(){
        
    }
    public void AddUser(){
        
    }
    public void DeleteUser(){
        
    }
    public void showUser(){
        
    }
    
   public int CalculerLevel(){
       return 0;
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
