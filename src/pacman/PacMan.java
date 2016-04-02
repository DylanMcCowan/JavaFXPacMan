/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

/**
 *
 * @author KevinCamp
 */
public class PacMan extends MoveableEntity {
    
   boolean isVisible;
   String name;
   
   public void setId(String name){
       this.name=name;
   }
   
   public String getId(){
       return this.name;
   }
   
   public boolean visible(){
       return isVisible;
   }
}
