/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class daoUser extends daoPersonne {
     Database db;
    public daoUser(Database db){
         this.db = db;
    }
   
    
    public boolean create(Personne p){
           
            PreparedStatement Pst = null;
           super.create(p);
        try {   
            Pst = db.con.prepareStatement( "INSERT INTO user VALUES(?,?,?,?,?,?,?,?,?,?,?,?);");
            Pst.setObject(1, ((User)p).getUsername());
            Pst.setObject(2, ((User)p).getMdp());
            Pst.setObject(3, ((User)p).getEmail());
            Pst.setObject(4, "");
            Pst.setObject(5, "");
            Pst.setObject(6, "");
            Pst.setObject(7, ""); 
            Pst.setObject(8, "");
            Pst.setObject(9, ((User)p).getDate_Inscription());
            Pst.setBoolean(10, false);
            Pst.setInt(11, 0);
            Pst.setObject(12, "");
          
        } catch (SQLException ex) {
            Logger.getLogger(daoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
         return (db.dmlQuery(Pst) == 0) ? false : true;  
    }
    
    //ajouter ou modifier infos
    public boolean update(Personne p, String Id){
        boolean rs = false;
        super.update(p, Id);
        try {
            PreparedStatement Pst;
            Pst = db.con.prepareStatement("UPDATE user set Username = ?, Mdp = ?, Nom =?, Prenom =? , Language=?, Tel=?, E_Mail=? , Photo = ? , WHERE Username=?;");
            Pst.setString(1, ((User)p).getUsername());
            Pst.setString(2, ((User)p).getMdp());
            Pst.setString(3, ((User)p).getNom());
            Pst.setString(4, ((User)p).getPrenom());
            Pst.setString(5, ((User)p).getLangage());
            Pst.setString(6, ((User)p).getTel());
            Pst.setString(7, ((User)p).getEmail());
            Pst.setString(8, ((User)p).getPhoto());
            Pst.setString(9, Id);
            
           if(db.dmlQuery(Pst) == 1){
               rs=true;
           }
        } catch (SQLException ex) {
            Logger.getLogger(daoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
   
       return rs;
                           
    }
    
      public boolean update1(Personne p, String Id){
        boolean rs = false;
        try {
            PreparedStatement Pst;
            Pst = db.con.prepareStatement("UPDATE user set Mdp = ?, Nom =?, Prenom =? , Language=?, Tel=?, E_Mail=? , Photo = ? , WHERE Username=?;");
            
            Pst.setString(1, ((User)p).getMdp());
            Pst.setString(2, ((User)p).getNom());
            Pst.setString(3, ((User)p).getPrenom());
            Pst.setString(4, ((User)p).getLangage());
            Pst.setString(5, ((User)p).getTel());
            Pst.setString(6, ((User)p).getEmail());
            Pst.setString(7, ((User)p).getPhoto());
            Pst.setString(8, Id);
            
           if(db.dmlQuery(Pst) == 1){
               rs=true;
           }
        } catch (SQLException ex) {
            Logger.getLogger(daoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
   
       return rs;
                           
    }
    
    //supprimer
    public boolean delete(String id){
        boolean rs = false;
        super.delete(id);
        String sql = "DELETE FROM user WHERE Username=?;";
        try {
            PreparedStatement stmt = db.con.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate();
            rs = true;
        } catch (SQLException ex) {
            Logger.getLogger(daoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    //lister
    public ResultSet all(){
           ResultSet Rs =null ;
        String req;
            req = "select * from user;";
            Statement St;
             try {
                 St=db.con.createStatement();
                 Rs= St.executeQuery(req);
            while(Rs.next()){
                System.out.println(Rs.getString(1)+"---->"+Rs.getString("Mdp")+"---->"+Rs.getString("Nom")+"---->"
                        +Rs.getString("Prenom")+"---->"+Rs.getString("Language")+"---->"+Rs.getString("E_Mail")+"---->"+Rs.getString("Tel")+"---->"+Rs.getString("Date_Inscription")
                         +"---->"+Rs.getObject("Actif")+"---->"+Rs.getObject("Seuil")+"---->"+Rs.getString("path"));
            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete select");
        }
      return Rs;

          
    }

    @Override
    public ResultSet find(String id) {
        ResultSet Rs = null;
        String sql = "Select * FROM user WHERE Username="+ id+";";
        Statement St;
             try {
                 St=db.con.createStatement();
                 Rs= St.executeQuery(sql);
            while(Rs.next()){
                  System.out.println(Rs.getString(1)+"---->"+Rs.getString("Username")+"---->"+Rs.getString("Mdp")+"---->"+Rs.getString("Nom")+"---->"
                        +Rs.getString("Prenom")+"---->"+Rs.getString("Language")+"---->"+Rs.getString("E_Mail")+"---->"+Rs.getString("Tel")+"---->"+Rs.getString("Date_Inscription")
                         +"---->"+Rs.getObject("Actif")+"---->"+Rs.getObject("Seuil")+"---->"+Rs.getString("path"));
            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete select");
        }
      return Rs;

    }



    

}
