package pacman;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.SVGPath;
import javafx.util.Duration;

/**
 * Created by dylan on 2016-04-03.
 */
public class MazeLevel {


    //MazeScene
   private Scene maze;
   private Pane paneMaze;

    //TODO Use an Array for the PacDots and Ghosts.
    //Maze Entities
    private PacMan pacMan;
    private ImageView pacManImgView;
    private Ghost blinky;
    private ImageView blinkyImgView;

    //ANIMATION
    Timeline tl;
    KeyFrame kf;
    PathTransition pth;
    SVGPath svgPath = new SVGPath();



    //MAIN SPRITE IMAGE
    Image spriteImage;

    //TODO This is only for testing
    FileLoader ftmp = new FileLoader();
    PathDataLoader pdl = new PathDataLoader();
    //ImageView
    private ImageView imgMaze;



    public MazeLevel()
    {
        this.paneMaze = new Pane();

        this.spriteImage = getSpriteImagePath("assets/img/PacManSprite.png");

        this.imgMaze = new ImageView(this.spriteImage);
        this.imgMaze.setViewport(getMazeSprite());

        this.pacMan = new PacMan();
        this.pacManImgView = new ImageView(this.spriteImage);
        this.pacManImgView.setViewport(this.pacMan.getSprite());

        this.blinky = new Ghost(GhostNames.CLYDE);
        this.blinkyImgView = new ImageView(this.spriteImage);
        this.blinkyImgView.setViewport(this.blinky.getSprite());

        addToMaze(this.imgMaze);
        addToMaze(this.pacManImgView);
        addToMaze(this.blinkyImgView);

        this.svgPath.setContent(pdl.getPathData(ftmp.loadPathFile("./src/assets/pathData/path2.txt")));

        //Path Transition and Controlling Sprites
        this.pth = new PathTransition();
        this.pth.setNode(this.blinkyImgView);
        this.pth.setPath(this.svgPath);
        this.pth.setInterpolator(Interpolator.LINEAR);

        this.pth.setDuration(Duration.seconds(25));
        this.pth.setCycleCount(Timeline.INDEFINITE);
        this.pth.setAutoReverse(true);
        this.pth.play();


        this.maze = new Scene(paneMaze, 540, 490);

    }

    public void addToMaze(Node object)
    {
        this.paneMaze.getChildren().add(object);
    }

    //This should load the PacManSprite.png file generally...
    private Image getSpriteImagePath(String path)
    {
        //Should get around to making this FileLoader class static...
        FileLoader f = new FileLoader();

        Image tmpImage = new Image(f.loadImageFile(path).getPath());
        return tmpImage;

    }


    //TODO  only return the sprite for the Maze
    private Rectangle2D getMazeSprite()
    {
        //For Experimental purposes only, hardcoded to load the rect related to the main map itself. (0,5),(490,545)
        Rectangle2D spriteImg = new Rectangle2D(0,5,490,540);

        return spriteImg;
    }


    public Scene getScene() {
        return this.maze;
    }
}
