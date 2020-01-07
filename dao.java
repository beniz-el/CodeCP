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
   
   public abstract void all(); //recuperer tout
   
   public abstract boolean create(T obj);
   
   public abstract boolean update(T obj);
   
   public abstract boolean delete (T obj);
   
}
