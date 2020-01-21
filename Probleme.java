/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecp;

import java.sql.SQLException;
import java.util.logging.Logger;

public class Probleme {
    String Id_Probleme;
    String Id_Solution;
    String pathPb;
    String Titre;
    Level Level;
    String pathTest;
    
    
    public Probleme(String Id_sol, String pathProb, String titre, Level lev, String pathtest){
        Integer id=0;
        try {
            id=daoProbleme.getCount();
        } catch (SQLException ex) {
            Logger.getLogger(Probleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        this.Id_Probleme="P"+id.toString();
        this.Id_Solution= Id_sol;
        this.Level = lev;
        this.Titre=titre;
        this.pathPb=pathProb;
        this.pathTest=pathtest;
    }

    public String getId_Probleme() {
        return Id_Probleme;
    }

    public String getId_Solution() {
        return Id_Solution;
    }

    public String getPathPb() {
        return pathPb;
    }

    public String getTitre() {
        return Titre;
    }

    public Level getLevel() {
        return Level;
    }

    public String getPathTest() {
        return pathTest;
    }

    public void setId_Solution(String Id_Solution) {
        this.Id_Solution = Id_Solution;
    }

    public void setPathPb(String pathPb) {
        this.pathPb = pathPb;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public void setLevel(Level Level) {
        this.Level = Level;
    }

    public void setPathTest(String pathTest) {
        this.pathTest = pathTest;
    }
    
}
