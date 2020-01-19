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
import java.util.logging.Level;
import java.util.logging.Logger;

public class daoPersonne extends dao<Personne> {
      Database db;
      public daoPersonne(){
     }
    public daoPersonne(Database db){
         this.db = db;
    }
    

    @Override
    public ResultSet find(String id) {
       ResultSet Rs = null;
        String sql = "Select * FROM Personne WHERE Username="+ id+";";
        Statement St;
             try {
                 St=db.con.createStatement();
                 Rs= St.executeQuery(sql);
            while(Rs.next()){
                  System.out.println(Rs.getString(1));
            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete select");
        }
      return Rs;

    }

    @Override
    public ResultSet all() {
        ResultSet Rs =null ;
        String req;
            req = "select * from Personne;";
            Statement St;
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

    @Override
    public boolean create(Personne p) {
       PreparedStatement Pst = null;
        try {
            Pst = db.con.prepareStatement( "INSERT INTO Personne VALUES(?);");
            Pst.setObject(1, p.getUsername());
           
          
        } catch (SQLException ex) {
            Logger.getLogger(daoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
         return (db.dmlQuery(Pst) == 0) ? false : true;  
    }

    @Override
    public boolean update(Personne p, String id) {
        boolean rs = false;
        try {
            PreparedStatement Pst;
            Pst = db.con.prepareStatement("UPDATE Personne set Username = ? WHERE Username=?;");
            Pst.setString(1, p.getUsername());
            Pst.setString(2, id);
          
            
           if(db.dmlQuery(Pst) == 1){
               rs=true;
           }
        } catch (SQLException ex) {
            Logger.getLogger(daoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
   
       return rs;
    }

    @Override
    public boolean delete(String id) {
        boolean rs = false;
        String sql = "DELETE FROM Personne WHERE Username=?;";
        try {
            PreparedStatement stmt = db.con.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate();
            rs = true;
        } catch (SQLException ex) {
            Logger.getLogger(daoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
}
