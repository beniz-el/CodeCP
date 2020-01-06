/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecp;


import java.sql.*;


public class dao {

    private String Pilote;
    private String URL;
    private String Login;
    private String Password;
    
    private Connection MaConnexion;
    
   public void ToConnect(){
       System.out.println("CHARGEMENT DU DRIVER...");
        try {
            Class.forName(Pilote);
            System.out.println("Chargement de DRIVER OK");
            MaConnexion = DriverManager.getConnection(URL, Login, Password);
            System.out.println("Connecxion etablie.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Probleme de chargement de pilote");
        } catch (SQLException ex) {
            System.out.println("Pb de connexion URL, Login ou Password !!");
 
   }
   }

    public Connection getMaConnexion() {
        return MaConnexion;
    }

    public void setPilote(String Pilote) {
        this.Pilote = Pilote;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    

   
}
