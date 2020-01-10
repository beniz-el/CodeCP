/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecp;

/**
 *
 * @author Amal
 */
public class probleme {
    String Id_Probleme;
    String Id_Solution;
    String DescriptionPb;
    String Level;
    String Titre;

    public probleme(String Id_Probleme, String Id_Solution, String DescriptionPb, String Level, String Titre) {
        this.Id_Probleme = Id_Probleme;
        this.Id_Solution = Id_Solution;
        this.DescriptionPb = DescriptionPb;
        this.Level = Level;
        this.Titre = Titre;
    }

    public String getId_Solution() {
        return Id_Solution;
    }

    public void setId_Solution(String Id_Solution) {
        this.Id_Solution = Id_Solution;
    }

    
    
   
    
   
    public String getIdProbleme(){
        return Id_Probleme;
    }
    public String getDescription(){
        return DescriptionPb;
    }
    public void setDescription(String descrp){
        DescriptionPb = descrp;
    }
    public String getLevel(){
        return Level;
    }
    public void setLevel(String lev){
        Level = lev;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }
    
}
