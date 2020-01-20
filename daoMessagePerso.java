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


public class daoMessagePerso extends daoMessage{

    public daoMessagePerso(Database db) {
        super(db);
    }
   

    @Override
    public ResultSet find(String iD) {
       ResultSet Rs = null;
        String sql = "Select * FROM codecp.message_perso WHERE Id_Msg='"+iD+"';";
        Statement St;
            
             try {
                 St=db.con.createStatement();
                 Rs= St.executeQuery(sql);
            while(Rs.next()){
                  System.out.println(Rs.getString(1)+"---->"+Rs.getString(2)+"---->"+Rs.getString(3));
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
            req = "select * from codecp.message_perso;";
            Statement St;
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

    public boolean create(Message M) {
        PreparedStatement Pst = null;
         PreparedStatement Ps = null;
        try {
            
            Ps = db.con.prepareStatement( "INSERT INTO codecp.message_perso VALUES(?,?,?,?,?,?,?);");
            Ps.setObject(1, ((Message_Perso)M).getUsername_rece());
            Ps.setObject(2, ((Message_Perso)M).getUsername_eme());
            Ps.setObject(3, ((Message_Perso)M).getId_Msg());
              Ps.setObject(4, M.getContenu());
               Ps.setObject(5, M.getDate());
                Ps.setObject(6, M.getLu());
                 Ps.setObject(7, M.getObjet());
            
        } catch (SQLException ex) {
            Logger.getLogger(daoMessagePerso.class.getName()).log(Level.SEVERE, null, ex);
        }
         return (db.dmlQuery(Ps) == 0) ? false : true;  
    }

    @Override
    public boolean update(Message obj, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) {
      boolean rs = false;
        String sql = "DELETE FROM codecp.message_perso WHERE Id_Msg=?;";
        try {
            PreparedStatement stmt = db.con.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(daoMessagePerso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
   
    public static int getCount() throws SQLException{
        Database db1 = new Database();
        ResultSet Rs = null;
        String req;
        req = "select count(*) from codecp.message_perso;";
        Statement St;
        try{
        St=db1.con.createStatement();
        Rs = St.executeQuery(req);
        }
        catch(SQLException ex){
            System.out.println("PB dans la requete select");
        }
        Rs.next();
        return (Rs.getInt(1));
    }
    
}
