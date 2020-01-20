/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Date;

public class User extends Personne{
  
    String Mdp;
    String E_Mail;
    String Tel;
    String Photo;
    String Nom;
    String Prenom;
    String Language;
    Date Date_Inscription ;
    boolean Actif ;
    int Seuil;
    String path ;
    
    public User(){}
    
     public User(String password, String email){
        super();
       Mdp = password;
       E_Mail = email;
       Date_Inscription = new Date();
   }
   public User(String password, String nom, String pre, String tel, String email, String lang, String image){
       super();
       Mdp = password;
       Nom = nom;
       Prenom = pre;
       Tel = tel;
       E_Mail = email;
       Language = lang;
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
        return E_Mail;
    }
    public void setEmail(String mail){
        E_Mail = mail;
    }

    public Date getDate_Inscription() {
        return Date_Inscription;
    }
    public void setDate_Inscription(Date date) {
        Date_Inscription = date;
    }

    public boolean getActif() {
        return Actif;
    }
    public void setActif(boolean act) {
        Actif = act;
    }

    public int getSeuil() {
        return Seuil;
    }
    public void setSeuil(int seuil) {
        this.Seuil = seuil;
    }

    public String getPath() {
        return path;
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
        return Language;
    }
    public void setLangage(String lang){
        Language = lang;
    }
   
   
    public void setPath(String path) {
        this.path = path;
    }
    
 
}
