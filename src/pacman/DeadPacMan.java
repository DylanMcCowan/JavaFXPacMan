
package pacman;

/**
 *
 * @author KevinCamp
 */
public class DeadPacMan implements Entity {
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
