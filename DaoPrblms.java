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
import javax.xml.transform.Result;

/**
 *
 * @author Amal
 */
public class DaoPrblms extends DAO<probleme>{
    Database db ;
    public DaoPrblms(Database db){
        this.db = db;
    }
  
    
    @Override
    public ResultSet find(String id) {
        String req;
            req = "select * from codecp.probleme where codecp.probleme.Id_Probleme='"+id+"';";
            Statement St;
            ResultSet Rs=null;
             try {
                 St=db.con.createStatement();
                 Rs= St.executeQuery(req);
            while(Rs.next()){
                System.out.println(Rs.getString(1)+"---->"+Rs.getString(2)+"---->"+Rs.getString(3));
            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete select prblm");
        }
        return Rs;
    }

    @Override
    public ResultSet all() {
            String req;
            req = "select * from codecp.probleme";
            Statement St;
            ResultSet Rs=null;
             try {
                 St=db.con.createStatement();
                 Rs= St.executeQuery(req);
            while(Rs.next()){
                System.out.println(Rs.getString(1)+"---->"+Rs.getString(2)+"---->"+Rs.getString(3));
            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete select prblm");
        }
        return Rs;
    }

    @Override
    public boolean create(probleme obj) {
    PreparedStatement PS=null;
        try {
            PS = db.con.prepareStatement("INSERT INTO codecp.probleme VALUES (?, ?, ?, ?, ? , ?);");
            PS.setObject(1,obj.getIdProbleme()); 
            PS.setObject(2,obj.getId_Solution()); 
            PS.setObject(3,obj.getDescription()); 
            PS.setObject(4,obj.getLevel()); 
            PS.setObject(5,obj.getTitre()); 
            PS.setObject(6,obj.getTest()); 
        } catch (SQLException ex) {
            System.out.println("error create");
        }
        return (db.dmlQuery(PS) == 0) ? false : true;  
    }

    @Override
    public boolean update(probleme obj, String id) {
        PreparedStatement PS=null;
        try {
            PS = db.con.prepareStatement("UPDATE codecp.probleme SET Id_Solution = ?, DescriptionPb = ?, Level = ?, Titre = ?  WHERE codecp.probleme.Id_Probleme= ?;");          
            PS.setObject(1,obj.getId_Solution()); 
            PS.setObject(2,obj.getDescription()); 
            PS.setObject(3,obj.getLevel()); 
            PS.setObject(4,obj.getTitre()); 
            PS.setObject(5,id); 
        } catch (SQLException ex) {
            System.out.println("error update prblm");
        }
        return (db.dmlQuery(PS) == 0) ? false : true; 
    }

    @Override
    public boolean delete(String id) {
        PreparedStatement PS=null;
        try {
            PS = db.con.prepareStatement("DELETE FROM codecp.probleme WHERE codecp.probleme.Id_Probleme = ?;");
            PS.setObject(1,id); 
        } catch (SQLException ex) {
            System.out.println("error create");
        }
           
        
        return (db.dmlQuery(PS) == 0) ? false : true; 
    }
    
}
