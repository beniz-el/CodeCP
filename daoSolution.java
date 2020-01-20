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
import java.util.logging.Logger;

/**
 *
 * @author DREAM INFO
 */
public class daoSolution extends dao<Solution>{

     Database db ;
    public daoSolution(Database db){
        this.db = db;
    }
    
    @Override
    public ResultSet find(String id) {
         PreparedStatement PS=null;
         ResultSet Rs=null;
        try {
            PS = db.con.prepareStatement("select * from codecp.solution where Id_Solution=?;");
            PS.setObject(1,id); 
            Rs= PS.executeQuery();
            while(Rs.next()){
                System.out.println(Rs.getString(1)+"---->"+Rs.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println("error find");
        }
        return Rs;
    }

    @Override
    public ResultSet all() {
      String req;
            req = "select * from codecp.solution";
            Statement St;
            ResultSet Rs=null;
             try {
                 St=db.con.createStatement();
                 Rs= St.executeQuery(req);
            while(Rs.next()){
                System.out.println(Rs.getString(1)+"---->"+Rs.getString(2));
            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete select");
        }
        return Rs;
    }

    @Override
    public boolean create(Solution obj) {
       PreparedStatement PS=null;
        try {
            PS = db.con.prepareStatement("INSERT INTO codecp.solution VALUES (?,?,?);");
            PS.setObject(1,obj.getId_Solution()); 
            PS.setObject(2,obj.getPath()); 
            PS.setObject(3,obj.getLanguage()); 
        } catch (SQLException ex) {
            System.out.println("error create");
        }
           
        
        return (db.dmlQuery(PS) == 0) ? false : true;  
    }

    @Override
    public boolean update(Solution obj, String id) {
       boolean rs = false;
        try {
            PreparedStatement Pst;
            Pst = db.con.prepareStatement("UPDATE codecp.solution set path = ?, Language =?  WHERE Id_Solution=?;");
            Pst.setString(1, obj.getPath());
            Pst.setString(2, obj.getLanguage());
            Pst.setString(3, id);
            
           if(db.dmlQuery(Pst) == 1){
               rs=true;
           }
        } catch (SQLException ex) {
            Logger.getLogger(daoSolution.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
   
       return rs;
    }

    @Override
    public boolean delete(String id) {
         boolean rs = false;
        String sql = "DELETE FROM codecp.solution WHERE Id_Solution=?;";
        try {
            PreparedStatement stmt = db.con.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate();
            rs = true;
        } catch (SQLException ex) {
            Logger.getLogger(daoSolution.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
        
public static int getCount() throws SQLException{
        Database db1 = new Database();
        ResultSet Rs =null ;
        String req;
            req = "select count(*) from codecp.solution;";
            Statement St;
             try {
                 St=db1.con.createStatement();
                 Rs= St.executeQuery(req);
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete select");
        }
         Rs.next();
            return (Rs.getInt(1));
        
    }
    
    
}
