/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecp;

import java.sql.Connection;
import java.util.Vector;




public abstract class dao<T> {

   protected Database db;
   
   public abstract T find(String id); //Rechercher
   
   public abstract Vector<User> all(); //recuperer tout
   
   public abstract void create(T obj);
   
   public abstract void update(T obj);
   
   public abstract void delete (T obj);
   
}
