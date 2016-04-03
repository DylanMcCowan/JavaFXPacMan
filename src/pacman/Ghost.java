package pacman;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author KevinCamp
 */
public class Ghost extends MoveableEntity
{
    boolean isVisible;
    String name;

    public Ghost ()
    {

    }

    public void setId (String name)
    {
        this.name = name;
    }

    public String getId ()
    {
        return this.name;
    }

    @Override
    public boolean isVisible ()
    {
        return this.isVisible;
    }

    @Override
    public void update ()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void move(){
        switch(this.name){
            case "Blinky":
                selectPath();
            case "Pinky":
                selectPath();
            case "Inky":
                selectPath();
            case "Clyde":
                selectPath();
            default:break;
        }
    }
    
    public void selectPath(){
        Random rnd = new Random();
        int path = rnd.nextInt(3);
        switch(path){
            case 0:
                //set path here
                ;
            case 1:
                //set path here
                ;
            case 2:
                //set path here
                ;
            case 3:
                //set path here
                ;
        }
    }
}
