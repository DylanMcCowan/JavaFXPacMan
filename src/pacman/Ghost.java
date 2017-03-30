package pacman;

import java.util.Random;

import javafx.geometry.Rectangle2D;
import javafx.scene.shape.SVGPath;


/**
 * @author dylan
 */
enum GhostNames
{
    BLINKY, PINKY, CLYDE, INKY,
}


/**
 *
 * @author KevinCamp
 */
public class Ghost extends MovableEntity
{
    //TODO MAKE ALL OF THESE PRIVATE
    boolean isVisible;
    String name;

    /*
    TODO Reduce dependency on SVGPath and develop systems capable of moving the ghosts in another fashion, as found in traditional pacman
     */

    SVGPath svgPath;
    SVGPath spawnPath;
    int SPAWN_PATH;

    //TODO Reduce need for this spawn path, will become obsolete after Ghosts no longer use SVGPath Data
   final String spawn_Path;

   //TODO Clean up the Ghost Constructor and implement improved file handling methods
    public Ghost (Enum GHOST_NAME)
    {

        this.setId(GHOST_NAME.name());
        this.svgPath = new SVGPath();
        this.spawnPath = new SVGPath();


       this.spawn_Path = PathDataLoader.getPathData(FileLoader.loadPathFile("./src/assets/pathData/spawnPath.txt"));

        setInitialPath();
    }

    @Override
     public void setId (String name) //TODO Do better data validation
    {
        this.name = name;
    }

    @Override
    public Rectangle2D getSprite() {

        switch(this.getId()) //TODO Review selection of sprites
        {
            case "BLINKY":
                return new Rectangle2D(615, 117, 32,32);
            case "PINKY":
                return new Rectangle2D(615, 80, 32, 32);
            case "INKY":
                return new Rectangle2D(615, 45, 32, 32);
            case "CLYDE":
                return new Rectangle2D(615, 45, 32,32);
            default:
                return new Rectangle2D(585, 230, 32,32); //TODO Change this to something appropriate
        }
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
    public void update () //TODO Develop and implement this method properly as designed for MovableEntity
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Deprecated
    private void setInitialPath(){ //TODO Remove this method when no longer dependant on Ghosts using SVGPath Data
        switch(this.getId()){
            case "BLINKY":
                this.spawnPath.setContent(this.spawn_Path);
                selectPath();
            case "PINKY":
                this.spawnPath.setContent(this.spawn_Path);
                selectPath();
            case "INKY":
                this.spawnPath.setContent(this.spawn_Path);
               selectPath();
            case "CLYDE":
                this.spawnPath.setContent(this.spawn_Path);
                selectPath();
            default:break;
        }
    }

    //TODO IMPLIMENT MEASURES TO PREVENT DUPLICATE PATH SELECTION BY GHOSTS
    protected void selectPath(){

        Random rnd = new Random();
        int path = rnd.nextInt(3);
        switch(path){
            case 0:
                this.svgPath = new SVGPath();
                this.svgPath.setContent(PathDataLoader.getPathData(FileLoader.loadPathFile("./src/assets/pathData/path1.txt")));
                this.SPAWN_PATH = 0;
                break;
            case 1:
                this.svgPath = new SVGPath();
                this.svgPath.setContent(PathDataLoader.getPathData(FileLoader.loadPathFile("./src/assets/pathData/path2.txt")));
                this.SPAWN_PATH = 1;
                break;
            case 2:
                this.svgPath = new SVGPath();
                this.svgPath.setContent(PathDataLoader.getPathData(FileLoader.loadPathFile("./src/assets/pathData/path3.txt")));
                this.SPAWN_PATH = 2;
                break;
            case 3:
                this.svgPath = new SVGPath();
                this.svgPath.setContent(PathDataLoader.getPathData(FileLoader.loadPathFile("./src/assets/pathData/path4.txt")));
                this.SPAWN_PATH = 3;
        }
    }
}
