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
        DaoPrblms daoP = new DaoPrblms(db);
//        probleme Pb = new probleme("ez21", "2", "edcvfr", "tgb", null);
//        daoP.ModifierProbleme(Pb, "33");
        daoP.SupprimerProbleme("212123");
        
        
       
    }
    
}
