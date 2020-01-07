/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecp;

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
    
    public boolean create(User u){
        String insertQuery = "INSERT INTO User VALUES("
                + "'" + u.getIdUser() + "',"
                + "'" + u.getUsername() + "',"
                + "'" + u.getMdp() + "',"
                + "'','','','','','');";        
        
        return (db.dmlQuery(insertQuery) == 0) ? false : true;
    }
    
    //ajouter ou modifier infos
    public boolean update(User u){
        String updateQuery = "UPDATE User set"
                             + "Nom ='"+u.getNom()+"',"
                             + "Prenom ='"+u.getPrenom()+"',"
                             + "Mdp='"+u.getMdp()+"',"
                             + "Tel='"+u.getTel()+"',"
                             + "Email='"+u.getEmail()+"'"
                             +"WHERE Id_User='"+u.getIdUser()+"';";
        
        return (db.dmlQuery(updateQuery) == 0)? false : true;
                           
    }
    
    //supprimer
    public boolean delete(User u){
        String deleteQuery = "DELETE FROM User"
                             +"WHERE Id_User=" + u.getIdUser() +";";
        
        return (db.dmlQuery(deleteQuery) == 0) ? false : true;
    }
    
    //lister
    public void all(){
       
            String req;
            req = "select * from users";
            Statement St;
             try {
                 St=MyCon.createStatement();
                 ResultSet Rs= St.executeQuery(req);
            while(Rs.next()){
                System.out.println(Rs.getString(1)+"---->"+Rs.getString("Password"));
            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete select");
        }
          
    }
}
