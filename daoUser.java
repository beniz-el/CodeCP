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


public class daoUser extends dao<User> {
     Database db;
    public daoUser(Database db){
         this.db = db;
    }
    
    public boolean create(User u){
           
            PreparedStatement Pst = null;
        try {
            Pst = db.con.prepareStatement( "INSERT INTO User VALUES(?,?,?,?,?,?,?,?,?)");
            Pst.setObject(1, u.getIdUser());
            Pst.setObject(2, u.getUsername());
            Pst.setObject(3, u.getMdp());
            Pst.setObject(4, u.getEmail());
            Pst.setObject(5, "");
            Pst.setObject(6, "");
            Pst.setObject(8, ""); 
            Pst.setObject(9, "");
            System.out.println("hello");
          
        } catch (SQLException ex) {
            Logger.getLogger(daoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
         return (db.dmlQuery(Pst) == 0) ? false : true;  
    }
    
    //ajouter ou modifier infos
    public boolean update(User u, String Id){
        boolean rs = false;
        try {
            PreparedStatement Pst;
            Pst = db.con.prepareStatement("UPDATE User set Username = ?, Mdp = ?, Nom =?, Prenom =? , Language=?, Tel=?, E_Mail=? , Photo = ? WHERE Id_User=?");
            Pst.setString(1, u.getUsername());
            Pst.setString(2, u.getMdp());
            Pst.setString(3, u.getNom());
            Pst.setString(4, u.getPrenom());
            Pst.setString(5, u.getLangage());
            Pst.setString(6, u.getTel());
            Pst.setString(7, u.getEmail());
            Pst.setString(8, u.getPhoto());
            Pst.setString(9, Id);
            
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
        String sql = "DELETE FROM User WHERE Id_User=?";
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
            req = "select * from User";
            Statement St;
             try {
                 St=db.con.createStatement();
                 Rs= St.executeQuery(req);
            while(Rs.next()){
                System.out.println(Rs.getString(1)+"---->"+Rs.getString("Username")+"---->"+Rs.getString("Mdp")+"---->"+Rs.getString("Nom")+"---->"
                        +Rs.getString("Prenom")+"---->"+Rs.getString("Language")+"---->"+Rs.getString("E_Mail")+"---->"+Rs.getString("Tel"));
            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete select");
        }
      return Rs;

          
    }

    @Override
    public ResultSet find(String id) {
        ResultSet Rs = null;
        String sql = "Select * FROM User WHERE Id_User="+ id;
        Statement St;
             try {
                 St=db.con.createStatement();
                 Rs= St.executeQuery(sql);
            while(Rs.next()){
                System.out.println(Rs.getString(1)+"---->"+Rs.getString("Username")+"---->"+Rs.getString("Mdp")+"---->"+Rs.getString("Nom")+"---->"
                        +Rs.getString("Prenom")+"---->"+Rs.getString("Language")+"---->"+Rs.getString("E_Mail")+"---->"+Rs.getString("Tel"));
            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete select");
        }
      return Rs;

    }



    

}
