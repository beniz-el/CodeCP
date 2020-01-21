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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class daoUser extends daoPersonne {
   
 
    public daoUser(Database db){
         super(db);
    }
   
    
    public boolean create(Personne p){ 
        PreparedStatement Pst = null;
        super.create((Personne)p);
        try {   
            Pst = getDb().con.prepareStatement("INSERT INTO codecp.user VALUES(?,?,?,?,?,?,?,?,?,?,?,?);");
            System.out.println((p).getUsername());
            Pst.setObject(1, (p).getUsername());
            Pst.setObject(2, ((User)p).getMdp());
            Pst.setObject(3, ((User)p).getEmail());
            Pst.setObject(4, "");
            Pst.setObject(5, "");
            Pst.setObject(6, "");
            Pst.setObject(7, ""); 
            Pst.setObject(8, "");
            Pst.setObject(9, ((User)p).getDate_Inscription());
            Pst.setBoolean(10, false);
            Pst.setInt(11, 0);
            Pst.setObject(12, "");
          
        } catch (SQLException ex) {
            Logger.getLogger(daoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
         return (getDb().dmlQuery(Pst) == 0) ? false : true;  
    }
    
    //ajouter ou modifier infos
    public boolean update(Personne p, String Id){
        boolean rs = false;
        System.out.println("hello");
        
        int exist=0;
        String user = p.getUsername();
        System.out.println(user);
       ResultSet Rs = null;
        String sql = "SELECT count(Username) FROM codecp.user WHERE Username='"+user+"';";
        Statement St;
             try {
                 St=getDb().con.createStatement();
                 Rs= St.executeQuery(sql);
            while(Rs.next()){
                 exist = Integer.parseInt(Rs.getString(1));
            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete count");
        }
             System.out.println(exist);
        if(exist >= 1){
            System.out.println("Username existe deja, choisissez un autre:\n");
            Scanner MyUser = new Scanner(System.in);  
            System.out.println(user+"1\n");
            System.out.println(user+"2\n");
            System.out.println(user+"3\n");
            String userName = MyUser.nextLine(); 
            p.setUsername(userName);
//            System.out.println(userName);
//            System.out.println(p.getUsername());
            System.out.println("hi"+((User)p).getMdp());
            this.update(p, Id);
            System.out.println("bye");
        }
        else{
            System.out.println("hnaaaa");
        super.update(p, Id);
        try {
            PreparedStatement Pst;
            Pst = getDb().con.prepareStatement("UPDATE codecp.user set Username = ?, Mdp = ?,E_Mail=?, Tel=?, Photo = ? ,Nom =?, Prenom =? , Language=?   WHERE Username=?;");
            Pst.setString(1, ((User)p).getUsername());
            Pst.setString(2, ((User)p).getMdp());
             Pst.setString(7, ((User)p).getEmail());
             Pst.setString(6, ((User)p).getTel());
             Pst.setString(8, ((User)p).getPhoto());
            Pst.setString(3, ((User)p).getNom());
            Pst.setString(4, ((User)p).getPrenom());
            Pst.setString(5, ((User)p).getLangage()); 
            Pst.setString(9, Id);
            
           if(getDb().dmlQuery(Pst) == 1){
               rs=true;
           }
        } catch (SQLException ex) {
            Logger.getLogger(daoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
       return rs;
                           
    }
    
      public boolean update1(Personne p, String Id){
        boolean rs = false;
        try {
            PreparedStatement Pst;
            Pst = getDb().con.prepareStatement("UPDATE codecp.user set Mdp = ?, Nom =?, Prenom =? , Language=?, Tel=?, E_Mail=? , Photo = ? , WHERE Username=?;");
            
            Pst.setString(1, ((User)p).getMdp());
            Pst.setString(2, ((User)p).getNom());
            Pst.setString(3, ((User)p).getPrenom());
            Pst.setString(4, ((User)p).getLangage());
            Pst.setString(5, ((User)p).getTel());
            Pst.setString(6, ((User)p).getEmail());
            Pst.setString(7, ((User)p).getPhoto());
            Pst.setString(8, Id);
            
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
        super.delete(id);
        String sql = "DELETE FROM user WHERE Username=?;";
        try {
            PreparedStatement stmt = getDb().con.prepareStatement(sql);
            stmt.setString(1, id);
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
            req = "select * from codecp.user;";
            Statement St;
             try {
                 St=getDb().con.createStatement();
                 Rs= St.executeQuery(req);
            while(Rs.next()){
                System.out.println(Rs.getString(1)+"---->"+Rs.getString(2)+"---->"+Rs.getString(3)+"---->"
                        +Rs.getString(4)+"---->"+Rs.getString(5)+"---->"+Rs.getString(6)+"---->"+Rs.getString(7)+"---->"+Rs.getString(8)
                         +"---->"+Rs.getObject(9)+"---->"+Rs.getObject(10)+"---->"+Rs.getString(11));
            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete select");
        }
      return Rs;

          
    }

    @Override
    public ResultSet find(String id) {
        ResultSet Rs = null;
        String sql = "Select * FROM user WHERE Username='"+ id+"';";
        Statement St;
             try {
                 St=getDb().con.createStatement();
                 Rs= St.executeQuery(sql);
            while(Rs.next()){
//                  System.out.println(Rs.getString(1)+"---->"+Rs.getString("Username")+"---->"+Rs.getString("Mdp")+"---->"+Rs.getString("Nom")+"---->"
//                        +Rs.getString("Prenom")+"---->"+Rs.getString("Language")+"---->"+Rs.getString("E_Mail")+"---->"+Rs.getString("Tel")+"---->"+Rs.getString("Date_Inscription")
//                         +"---->"+Rs.getObject("Actif")+"---->"+Rs.getObject("Seuil")+"---->"+Rs.getString("path"));
            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete select");
        }
      return Rs;

    }

    public ResultSet getSubmiisions(String id){
      ResultSet Rs = null;
        String sql = "Select * FROM codecp.submit WHERE Username='"+ id+"';";
        Statement St;
             try {
                 St=getDb().con.createStatement();
                 Rs= St.executeQuery(sql);
            while(Rs.next()){
//                  System.out.println(Rs.getString(1)+"---->"+Rs.getString(2));
            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete select");
        }
      return Rs;
 }
    
    public ResultSet getTTactif(){
        ResultSet Rs = null;
        String sql = "Select * FROM codecp.user WHERE Actif=1;";
        Statement St;
             try {
                 St=getDb().con.createStatement();
                 Rs= St.executeQuery(sql);
            while(Rs.next()){
//                  System.out.println(Rs.getString(1)+"---->"+Rs.getString(2));
            }
        
        } catch (SQLException ex) {
            System.out.println("PB dans la requete select");
        }
      return Rs;
    }
   
    

}
