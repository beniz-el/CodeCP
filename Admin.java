/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecp;


public class Admin extends Personne{
    String login;
    String password;
    
    public Admin(String log, String pass){
        super("Admin");
        login = log;
        password=pass;
    }
    
    public String getLogin(){
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUsername() {
        return Username;
    }
    public String getMdp(){
        return password;
    }
    public void setMdp(String mdp){
        password = mdp;
    }
}
