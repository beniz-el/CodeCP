/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecp;

import java.util.Date;

public class Submit {
    int Id_Submit;
    Date date;
    String verdict;
    
    public void AfficherUser(){
        
    }
    public void AfficherProbleme(){
        
    }
    public int getIdSubmit(){
        return Id_Submit;
    }
    public Date getDate(){
        return date;
    }
    public void setDate(Date d){
        date = d;
    }
    public String getVerdict(){
        return verdict;
    }

    public void setVerdict(String verdict) {
        this.verdict = verdict;
    }
    
}
