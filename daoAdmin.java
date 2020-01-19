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


public class daoAdmin extends daoPersonne{
      Database db;
    public daoAdmin(Database db){
         this.db = db;
    }

    @Override
    public boolean delete(String id) {
        return super.delete(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Personne p, String id) {
        boolean rs = false;
        super.update(p, id);
        try {
            PreparedStatement Pst;
            Pst = db.con.prepareStatement("UPDATE admin set login = ?, Password =? WHERE Username=?;");
            Pst.setString(1, ((Admin)p).getLogin());
            Pst.setString(2, ((Admin)p).getMdp());
            Pst.setString(3, id);
            
           if(db.dmlQuery(Pst) == 1){
               rs=true;
           }
        } catch (SQLException ex) {
            Logger.getLogger(daoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
   
       return rs;
                  
    }

    @Override
    public boolean create(Personne p) {
        PreparedStatement Pst = null;
           super.create(p);
        try {   
            Pst = db.con.prepareStatement( "INSERT INTO admin VALUES(?,?,?);");
            Pst.setObject(1, ((Admin)p).getUsername());
            Pst.setObject(2, ((Admin)p).getLogin());
            Pst.setObject(3, ((Admin)p).getMdp());
          
        } catch (SQLException ex) {
            Logger.getLogger(daoAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
         return (db.dmlQuery(Pst) == 0) ? false : true;  
    }

    @Override
    public ResultSet all() {
        ResultSet Rs =null ;
        String req;
            req = "select * from admin;";
            Statement St;
             try {
                 St=db.con.createStatement();
                 Rs= St.executeQuery(req);
            while(Rs.next()){
                System.out.println(Rs.getString(1)+"---->"+Rs.getString("login")+"---->"+Rs.getString("Password"));
            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete select");
        }
      return Rs;

    }

    @Override
    public ResultSet find(String id) {
        return super.find(id); //To change body of generated methods, choose Tools | Templates.
    }
    
}
