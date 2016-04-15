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
    boolean isVisible;
    String name;
    SVGPath svgPath;
    SVGPath spawnPath;
    int SPAWN_PATH;

    FileLoader ftmp = new FileLoader();
    PathDataLoader pdl = new PathDataLoader();

   final String spawn_Path;

    public Ghost (Enum GHOST_NAME)
    {
        this.setId(GHOST_NAME.name());
        this.svgPath = new SVGPath();
        this.spawnPath = new SVGPath();


       this.spawn_Path = pdl.getPathData(ftmp.loadPathFile("./src/assets/pathData/spawnPath.txt"));

        setInitialPath();
    }

    @Override
     public void setId (String name)
    {
        this.name = name;
    }

    @Override
    public Rectangle2D getSprite() {

        switch(this.getId())
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
                return new Rectangle2D(585, 230, 32,32);
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
    public void update ()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private void setInitialPath(){
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

    protected void selectPath(){

        Random rnd = new Random();
        int path = rnd.nextInt(3);
        switch(path){
            case 0:
                this.svgPath = new SVGPath();
                this.svgPath.setContent(pdl.getPathData(ftmp.loadPathFile("./src/assets/pathData/path1.txt")));
                this.SPAWN_PATH = 0;
                break;
            case 1:
                this.svgPath = new SVGPath();
                this.svgPath.setContent(pdl.getPathData(ftmp.loadPathFile("./src/assets/pathData/path2.txt")));
                this.SPAWN_PATH = 1;
                break;
            case 2:
                this.svgPath = new SVGPath();
                this.svgPath.setContent(pdl.getPathData(ftmp.loadPathFile("./src/assets/pathData/path3.txt")));
                this.SPAWN_PATH = 2;
                break;
            case 3:
                this.svgPath = new SVGPath();
                this.svgPath.setContent(pdl.getPathData(ftmp.loadPathFile("./src/assets/pathData/path4.txt")));
                this.SPAWN_PATH = 3;
        }
    }
}
