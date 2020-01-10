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
/**
 *
 * @author Amal
 */
public class daoUser extends DAO<User>{
    Database db;
     public daoUser(Database db){
         this.db = db;
    }
    
    public boolean create(User u){
           boolean rs = false;
        try {
            PreparedStatement Pst;
            Pst = db.con.prepareStatement( "INSERT INTO codecp.User VALUES(?,?,?,?,?,?,?,?,?)");
            Pst.setString(1, u.getIdUser());
            Pst.setString(2, u.getUsername());
            Pst.setString(3, u.getMdp());
            Pst.setString(4, u.getEmail());
            Pst.setString(5, "");
            Pst.setString(6, "");
            Pst.setString(7, "");
            Pst.setString(8, ""); 
            Pst.setString(9, "");
            
            if(db.dmlQuery(Pst) == 1){
                rs=true;
            }
            
        } catch (SQLException ex) {
            System.out.println("error insert user");
        }
        return rs;
    }
    
    //ajouter ou modifier infos
    public boolean update(User u, String Id){
        boolean rs = false;
        try {
            PreparedStatement Pst;
            Pst = db.con.prepareStatement("UPDATE codecp.user set Username = ?, Mdp = ? , E_Mail=? , Tel=? , Photo = ? ,Nom =? ,  Prenom =? , Language=? WHERE codecp.user.Id_User=? ;");
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
            System.out.println("error update user");
        }
   
       return rs;
                           
    }
    
    //supprimer
    public boolean delete(String id){
        boolean rs = false;
        String sql = "DELETE FROM codecp.User WHERE Id_User=?";
        try {
            PreparedStatement stmt = db.con.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate();
            rs = true;
        } catch (SQLException ex) {
            System.out.println("error delete user");
        }
        
        return rs;
    }
    
    //lister
    public ResultSet all(){
           ResultSet Rs =null ;
        String req;
            req = "select * from codecp.User;";
            Statement St;
             try {
                 St=db.con.createStatement();
                 Rs= St.executeQuery(req);
//            while(Rs.next()){
//                System.out.println(Rs.getString(1)+"---->"+Rs.getString(2)+"---->"+Rs.getString(3)+"---->"+Rs.getString(4)+"---->"
//                        +Rs.getString(5)+"---->"+Rs.getString(6)+"---->"+Rs.getString(7)+"---->"+Rs.getString(8));
//            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete select user");
        }
      return Rs;

          
    }

    @Override
    public ResultSet find(String id) {
        ResultSet Rs = null;
        String sql = "Select * FROM codecp.User WHERE Id_User='"+ id+"';";
        Statement St;
             try {
                 St=db.con.createStatement();
                 Rs= St.executeQuery(sql);
//            while(Rs.next()){
//                System.out.println(Rs.getString(1)+"---->"+Rs.getString("Username")+"---->"+Rs.getString("Mdp")+"---->"+Rs.getString("Nom")+"---->"
//                        +Rs.getString("Prenom")+"---->"+Rs.getString("Langage")+"---->"+Rs.getString("E_mail")+"---->"+Rs.getString("Tel"));
//            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete find user");
        }
      return Rs;

    }
}
