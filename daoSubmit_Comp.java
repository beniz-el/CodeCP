
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class daoSubmit_Comp extends dao<Submit_In_Comp>{
    Database db ;
    public daoSubmit_Comp(Database db){
        this.db = db;
    }

    @Override
    public ResultSet find(String id) {
        ResultSet Rs = null;
        String sql = "Select * FROM codecp.submit_in_comp WHERE Id_Submit="+ id+";";
        Statement St;
             try {
                 St=db.con.createStatement();
                 Rs= St.executeQuery(sql);
            while(Rs.next()){
                  System.out.println(Rs.getString(1)+"---->"+Rs.getString("Username"));
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
            req = "select * from codecp.submit_in_comp;";
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
    public boolean create(Submit_In_Comp obj) {
        PreparedStatement Pst = null;
        try {   
            Pst = db.con.prepareStatement("INSERT INTO codecp.submit_in_comp VALUES(?,?,?,?,?,?,?,?);");
            //System.out.println((p).getUsername());
            Pst.setObject(1, obj.getUsername());
            Pst.setObject(2, obj.getId_Probleme());
            Pst.setObject(3, obj.getId_Submit());
            Pst.setObject(4, obj.getId_Competition());
            Pst.setObject(5, obj.getDate());
            Pst.setObject(6, obj.getVerdict());
            Pst.setObject(7, obj.getLanguage());
            Pst.setObject(8, obj.getPath()); 
          
        } catch (SQLException ex) {
            Logger.getLogger(daoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
         return (db.dmlQuery(Pst) == 0) ? false : true;  
    }

    @Override
    public boolean update(Submit_In_Comp obj, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public ResultSet AfficherUser(String idUser){
    ResultSet Rs =null ;
            String req;
                req = "select * from codecp.submit_in_comp where Username="+idUser+";";
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
    public ResultSet AfficherProbleme(String idProblm){
        ResultSet Rs =null ;
        String req;
            req = "select * from codecp.submit_in_comp where Id_Probleme="+idProblm+";";
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
    
    public static int getCount() throws SQLException{
        Database db1 = new Database();
        ResultSet Rs =null ;
        String req;
            req = "select count(*) from codecp.submit_in_comp;";
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
