package pacman;

import java.util.Random;
import java.util.Scanner;
import javafx.scene.shape.SVGPath;

/**
 *
 * @author KevinCamp
 */
public class Ghost extends MoveableEntity
{
    boolean isVisible;
    String name;
    SVGPath svg;
    SVGPath spawn;

    public Ghost ()
    {

    }
    
    public Ghost (String name){
        this.name= name;
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
                this.spawn = new SVGPath();
                spawn.setContent("/assets/pathData/spawnPath");
                selectPath();
            case "Pinky":
                this.spawn = new SVGPath();
                spawn.setContent("/assets/pathData/spawnPath");
                selectPath();
            case "Inky":
                this.spawn = new SVGPath();
                spawn.setContent("/assets/pathData/spawnPath");
                selectPath();
            case "Clyde":
                this.spawn = new SVGPath();
                spawn.setContent("/assets/pathData/spawnPath");
                selectPath();
            default:break;
        }
    }
    
    public void selectPath(){
        Random rnd = new Random();
        int path = rnd.nextInt(2);
        switch(path){
            case 0:
                this.svg = new SVGPath();
                svg.setContent("/assets/pathData/path1");
                ;
            case 1:
                this.svg = new SVGPath();
                svg.setContent("/assets/pathData/path2");
                ;
            case 2:
                this.svg = new SVGPath();
                svg.setContent("/assets/pathData/path3");
                ;
        }
    }
}
