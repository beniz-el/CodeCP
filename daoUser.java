
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class daoUser extends dao<User> {
    public daoUser(){
        Database db = new Database();
    }
    
    public boolean create(User u){
          boolean rs = false;
        try {
            PreparedStatement Pst;
            Pst = db.con.prepareStatement( "INSERT INTO User VALUES(?,?,?,?,?,?,?,?,?)");
            Pst.setInt(1, u.getIdUser());
            Pst.setString(2, u.getUsername());
            Pst.setString(3, u.getMdp());
            Pst.setString(4, "");
            Pst.setString(5, "");
            Pst.setString(6, "");
            Pst.setString(7, "");
            Pst.setString(8, ""); 
            Pst.setString(9, "");
            
            if(db.dmlQuery(Pst) == 1){
                rs=true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(daoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    //ajouter ou modifier infos
    public boolean update(User u, String Id){
        boolean rs = false;
        try {
            PreparedStatement Pst;
            Pst = db.con.prepareStatement("UPDATE User set Username = ?, Mdp = ?, Nom =?, Prenom =? , Langage=?, Tel=?, E_mail=? , Photo = ? WHERE Id_User=?");
            Pst.setString(1, u.getUsername());
            Pst.setString(2, u.getMdp());
            Pst.setString(3, u.getNom());
            Pst.setString(4, u.getPrenom());
            Pst.setString(5, u.getLangage());
            Pst.setString(6, u.getTel());
            Pst.setString(7, u.getEmail());
            Pst.setString(8, u.getPhoto());
            Pst.setInt(9, Integer.parseInt(Id));
            
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
            stmt.setInt(1, Integer.parseInt(id));
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
                        +Rs.getString("Prenom")+"---->"+Rs.getString("Langage")+"---->"+Rs.getString("E_mail")+"---->"+Rs.getString("Tel"));
            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete select");
        }
      return Rs;

          
    }
     
    //find
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
                        +Rs.getString("Prenom")+"---->"+Rs.getString("Langage")+"---->"+Rs.getString("E_mail")+"---->"+Rs.getString("Tel"));
            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete select");
        }
      return Rs;

    }



    

}
