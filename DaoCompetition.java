/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecp;

import static java.lang.Integer.max;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amal
 */
public class DaoCompetition extends DAO<Competition>{
    Database db ;
    public DaoCompetition(Database db){
        this.db = db;
    }

    @Override
    public ResultSet find(String id) {
         PreparedStatement PS=null;
         ResultSet Rs=null;
        try {
            PS = db.con.prepareStatement("select * from codecp.competition where Id_Competition=?;");
            PS.setObject(1,id); 
            Rs= PS.executeQuery();
            while(Rs.next()){
                System.out.println(Rs.getString(1)+"---->"+Rs.getString(2)+"---->"+Rs.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println("error find");
        }
        return Rs;
    }

    @Override
    public ResultSet all() {
        String req;
            req = "select * from codecp.competition";
            Statement St;
            ResultSet Rs=null;
             try {
                 St=db.con.createStatement();
                 Rs= St.executeQuery(req);
            while(Rs.next()){
                System.out.println(Rs.getString(1)+"---->"+Rs.getString(2)+"---->"+Rs.getString(3));
            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete select");
        }
        return Rs;
    }

    @Override
    public boolean create(Competition obj) {
           PreparedStatement PS=null;
        try {
            PS = db.con.prepareStatement("INSERT INTO codecp.competition VALUES (?,?,?,?,?);");
            PS.setObject(1,obj.getIdCompetition()); 
            PS.setObject(2,obj.getLevelComp()); 
            PS.setObject(3,obj.getStatut()); 
            PS.setObject(4,obj.getDatedebut()); 
            PS.setObject(5,obj.getDatefin()); 
        } catch (SQLException ex) {
            System.out.println("error create");
        }
           
        
        return (db.dmlQuery(PS) == 0) ? false : true;  
    }

    @Override
    public boolean update(Competition obj , String id) {
        PreparedStatement PS=null;
        try {
            PS = db.con.prepareStatement("UPDATE codecp.competition SET Level_Comp = ?, Statut = ?, Date_debut = ?, Date_fin = ? WHERE codecp.competition.Id_Competition = ?;");
           
            PS.setObject(1,obj.getLevelComp()); 
            PS.setObject(2,obj.getStatut()); 
            PS.setObject(3,obj.getDatedebut()); 
            PS.setObject(4,obj.getDatefin()); 
             PS.setObject(5,id); 
        } catch (SQLException ex) {
            System.out.println("error update");
        }
           
        
        return (db.dmlQuery(PS) == 0) ? false : true;  
    }

    @Override
    public boolean delete(String id) {
        PreparedStatement PS=null;
        try {
            PS = db.con.prepareStatement("DELETE FROM codecp.competition WHERE codecp.competition.Id_Competition = ?;");
            PS.setObject(1,id); 
        } catch (SQLException ex) {
            System.out.println("error create");
        }
           
        
        return (db.dmlQuery(PS) == 0) ? false : true;  
    }
    public boolean AddProbleme(String id , probleme p){
        
        PreparedStatement PS=null;
        try {
            PS = db.con.prepareStatement("insert into codecp.compose values (? ,?);");
            PS.setObject(1,id); 
            PS.setObject(2,p.getIdProbleme()); 
        } catch (SQLException ex) {
            System.out.println("error create");
        }
           
        
        return (db.dmlQuery(PS) == 0) ? false : true;  
        
    }
    public boolean deleteProbleme(String id_Compet , String id_Prob){
        PreparedStatement PS=null;
        try {
            PS = db.con.prepareStatement("delete from codecp.compose where codecp.compose.Id_Probleme =? AND codecp.compose.Id_Competition =?;");
            PS.setObject(1,id_Prob); 
            PS.setObject(2,id_Compet); 
        } catch (SQLException ex) {
            System.out.println("error create");
        }
           
        
        return (db.dmlQuery(PS) == 0) ? false : true; 
    }
    public ResultSet AffcherListeProbleme(String id){
        
            String req;
            req = " select P.Id_Probleme , P.Titre , P.Level from codecp.probleme P , codecp.compose C where P.Id_Probleme=C.Id_Probleme AND C.Id_Competition ='"+id+"';";
            Statement St;
            ResultSet Rs=null;
             try {
                 St=db.con.createStatement();
                 Rs= St.executeQuery(req);
//            while(Rs.next()){
//                System.out.println(Rs.getString(1)+"---->"+Rs.getString(2));
//            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete select");
        }
        return Rs;
                        
                        
    }
    public boolean AddUser(String Id_User , String Id_Compt){
        
        PreparedStatement PS=null;
        try {
            PS = db.con.prepareStatement("insert into codecp.participe values (? ,?);");
            PS.setObject(1,Id_User); 
            PS.setObject(2,Id_Compt); 
        } catch (SQLException ex) {
            System.out.println("error addUser");
        }
           
        
        return (db.dmlQuery(PS) == 0) ? false : true;  
    }
    public boolean DeleteUser(String Id_U , String Id_Compt){
        
        PreparedStatement PS=null;
        try {
            PS = db.con.prepareStatement("delete from codecp.participe where codecp.participe.Id_User =? and codecp.participe.Id_Competition = ?;");
            PS.setObject(1,Id_U); 
            PS.setObject(2,Id_Compt); 
        } catch (SQLException ex) {
            System.out.println("error create");
        }
           
        
        return (db.dmlQuery(PS) == 0) ? false : true; 
    }
    public ResultSet showUsers(String id_comp){
            String req;
            req = "  select u.Username from codecp.user u , codecp.participe C where u.Id_User=C.Id_User AND C.Id_Competition ='"+id_comp+"';";
            Statement St;
            ResultSet Rs=null;
             try {
                 St=db.con.createStatement();
                 Rs= St.executeQuery(req);
            while(Rs.next()){
                System.out.println(Rs.getString(1));
            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete select");
        }
        return Rs;
            
    }
    
   public String CalculerLevel(String id_Comp){
       //ResultSet RS = this.AffcherListeProbleme(id_Comp);
       Integer easy=0 ;
       Integer medium=0 ;
       Integer hard=0;
        ResultSet Rs = this.AffcherListeProbleme(id_Comp);
                
        try {
            while(Rs.next()){
                if(Rs.getString("Level").equals("easy")){
                    easy++;
                }
                if(Rs.getString("Level").equals("medium")){
                    medium++;
                }
                if(Rs.getString("Level").equals("hard")){
                    hard++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCompetition.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(max(max(easy, hard),medium) == easy){
            return "easy";
        }
        if(max(max(easy, hard),medium) == easy){
            return "medium";
        }
        return "hard";
        
   }

    
}
