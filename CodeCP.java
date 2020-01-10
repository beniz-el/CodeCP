/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Amal
 */
public class CodeCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Database db = new Database();
        //DaoCompetition daoC = new DaoCompetition(db);
        Competition C = new Competition( "easy", true , null , null);
        Competition C1 = new Competition( "easy", true , null , null);
        Competition C2 = new Competition( "easy", true , null , null);
        Competition C3 = new Competition( "hard", true , null , null);
        probleme P = new probleme( null, null, null, null , null);
        probleme P2 = new probleme( "2", "hard", "hard", "hard" , "hard");
        DaoPrblms DaoP = new DaoPrblms(db);
//        daoC.create(C1);
//        daoC.create(C2);
//        daoC.create(C3);
//        daoC.delete("A12");
//        daoC.update(C3, "AZE");
//        daoC.AddProbleme("AZE", P);
//        daoC.AddUser("amal", "AZE");
//        daoC.AffcherListeProbleme("AZE");
//        daoC.all();
//        daoC.showUsers("AZE");
//        DaoP.delete("1pp23");
//        DaoP.update(P2, "123");
        User U = new User("123", "1234", "@gmail");
        User U2;
        U2 = new User("12323", "1234", "amalalala@gmail" , "233","233","233","233","233");
        daoUser daoU = new daoUser(db);
        //daoU.create(U2);
        //daoU.update(U2, "123");
        //daoU.delete("123");
//        daoU.all();
        
     
        
        
       
    }
    
}
