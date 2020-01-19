/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecp;

public class Personne {
    static int id =0;
    String Username;
    
    public Personne(){
               ++id;
       Username = "U"+String.valueOf(id);
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
