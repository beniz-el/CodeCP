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

/**
 *
 * @author DREAM INFO
 */
public class daoCompose extends dao<Compose>{
      Database db ;
    public daoCompose(Database db){
        this.db = db;
    }

    @Override
    public ResultSet find(String id) {
         PreparedStatement PS=null;
         ResultSet Rs=null;
        try {
            PS = db.con.prepareStatement("select * from codecp.compose where Id_Competition=?;");
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
            req = "select * from codecp.compose";
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
    public boolean create(Compose obj) {
        PreparedStatement PS=null;
        try {
            PS = db.con.prepareStatement("INSERT INTO codecp.compose VALUES (?,?);");
            PS.setObject(1,obj.getId_Probleme()); 
            PS.setObject(2,obj.getId_Competition()); 
        
        } catch (SQLException ex) {
            System.out.println("error create");
        }

        return (db.dmlQuery(PS) == 0) ? false : true;  
    }

    @Override
    public boolean update(Compose obj, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) {
      PreparedStatement PS=null;
        try {
            PS = db.con.prepareStatement("DELETE FROM codecp.compose WHERE codecp.compose.Id_Competition = ?;");
            PS.setObject(1,id); 
        } catch (SQLException ex) {
            System.out.println("error create");
        }

        return (db.dmlQuery(PS) == 0) ? false : true;  
    }
    
    
}