
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amal
 */
public class Submit_In_Comp extends Submit_abst {
    String Id_Competition;
    String Id_Submit;
        public Submit_In_Comp( String Username ,String Id_Competition , String Id_Probleme,Date Date, String Verdict, String Language , String content , String extension ) {
        Integer id=0;
        try {
            id = daoSubmit_Comp.getCount();
        } catch (SQLException ex) {
            Logger.getLogger(Personne.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.Id_Submit = "SUB"+(id++).toString();
        this.setDate(Date);
        this.setId_Probleme(Id_Probleme);
        this.setPath(path);
        this.setLanguage(Language);
        this.setUsername(Username);
        this.setId_Competition(Id_Competition);
        this.setVerdict(Verdict);
        String Nom = getId_Submit()+"."+extension;
        String dir = "submissions_In_Comp/"+getUsername();
        String pathi = dir+Nom;
        File fi = new File(dir, Nom );
        try {
            fi.createNewFile();//create a file in the directory
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FileWriter fw = new FileWriter(fi.getPath()); 
            fw.write(content); //write in the file
            fw.flush();
            fw.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        this.setPath(pathi);
        
    }
    public String getId_Competition() {
        return Id_Competition;
    }

    public void setId_Competition(String Id_Competition) {
        this.Id_Competition = Id_Competition;
    }

    public String getId_Submit() {
        return Id_Submit;
    }

    public void setId_Submit(String Id_Submit) {
        this.Id_Submit = Id_Submit;
    }
    
}
