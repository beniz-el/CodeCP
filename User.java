/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecp;

public class User {
    static int id =0;
    String Id_User;
    String Username;
    String Mdp;
    String Email;
    String Tel;
    String Photo;
    String Nom;
    String Prenom;
    String Langage;
    
     public User(String User, String password, String email){
       Integer i = ++id;
       Id_User = "U"+i.toString();
       Username = User;
       Mdp = password;
       Email = email;
   }
   public User(String User, String password, String nom, String pre, String tel, String email, String lang, String image){
       Integer i = ++id;
       Id_User = "U"+i.toString();
       Username = User;
       Mdp = password;
       Nom = nom;
       Prenom = pre;
       Tel = tel;
       Email = email;
       Langage = lang;
       Photo = image;
   }

    public String getPhoto(){
        return Photo;
    }
    public void setPhoto(String image){
        Photo = image;
    }
    
      
    public String getMdp(){
        return Mdp;
    }
    public void setMdp(String mdp){
        Mdp = mdp;
    }
    public String getEmail(){
        return Email;
    }
    public void setEmail(String mail){
        Email = mail;
    }
    public String getTel(){
        return Tel;
    }
    public void setTel(String tele){
        Tel = tele;
    }
    public String getNom(){
        return Nom;
    }
    public void setNom(String name){
        Nom = name;
    }
    public String getPrenom(){
        return Prenom;
    }
    public void setPrenom(String pre){
        Prenom = pre;
    }
    public String getLangage(){
        return Langage;
    }
    public void setLangage(String lang){
        Langage = lang;
    }
    public String getUsername(){
        return Username;
    }
     public void setUsername(String user){
        Username = user;
    }
    
    public String getIdUser(){
        return Id_User;
    }
    
 
}
