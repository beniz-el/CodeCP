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
        db = new Database();
    }
    
    public void create(User u){
        try {
            PreparedStatement Pst;
            Pst = db.con.prepareStatement( "INSERT INTO User VALUES(?,?)");
            Pst.setInt(1, u.getIdUser());
            Pst.setString(2, u.getUsername());
            Pst.setString(3, u.getMdp());
            if(Pst.executeUpdate()!=0){
                System.out.println("Ajout effectuee");
            }
            else{
                System.out.println("PB dans INSERT");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(daoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //ajouter ou modifier infos
    public void update(User u){
        try {
            PreparedStatement Pst;
            Pst = db.con.prepareStatement("UPDATE User set Nom =?, Prenom =? ,Mdp=?, Tel=?, Email=? WHERE Id_User=?");
            Pst.setString(1, u.getNom());
            Pst.setString(2, u.getPrenom());
            Pst.setString(3, u.getMdp());
            Pst.setString(4, u.getTel());
            Pst.setString(5, u.getEmail());
            if(Pst.executeUpdate()!=0){
                System.out.println("Mise a jour effectuee");
            }
            else{
                System.out.println("user nexiste pas");
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
   
       
                           
    }
    
    //supprimer
    public void delete(User u){
        String sql = "DELETE FROM User WHERE Id_User=?";
        try {
            PreparedStatement stmt = db.con.prepareStatement(sql);
            stmt.setInt(1, u.getIdUser());
            stmt.executeUpdate();
            System.out.println("supprimee");
        } catch (SQLException ex) {
            Logger.getLogger(daoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    //lister
    public Vector<User> all(){
        
            Vector<User> users = new Vector<User>();
            
            String findAllQuery = "SELECT *FROM User;";
            ResultSet rs = db.query(findAllQuery);
            try {
                
            while(rs.next()){
                User u = new User();
                
                u.setUsername(rs.getString("Username"));
                u.setNom(rs.getString("Nom"));
                u.setPrenom(rs.getString("Prenom"));
                u.setEmail(rs.getString("Email"));
                u.setLangage(rs.getString("Langage"));
                u.setTel(rs.getString("Tel"));
                
                users.add(u);
                
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(daoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
            return users;
          
    }

    @Override
    public User find(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
