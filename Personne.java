
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Personne {
    String Username;
    
    public Personne(){
       Integer id=0;
        try {
            id = daoPersonne.getCount();
            //System.out.println("The id is " + id);
        } catch (SQLException ex) {
            Logger.getLogger(Personne.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       Username = "U"+(id++).toString();
        System.out.println(Username);
    }
    
    public Personne(String user){
        Username = user;
    }

    public String getUsername() {
        return Username;
    }
    public void setUsername(String user){
    Username = user;
    }
}
