package pacman;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.util.Duration;

/**
 * Created by dylan on 2016-04-03.
 */
public class MazeLevel {

    //MazeScene
   private Scene maze;
   private StackPane paneMaze;

    //MazeData
    private Rectangle[] mazeData;

    private Circle[] pacdots;
    private Bounds[] pacDotBounds;

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

    public MazeLevel()
    {

        Rectangle GamesSpace = new Rectangle(1199, 799);

        this.mazeData = getMaze();
        this.paneMaze = generateMazeLevel();


        this.spriteImage = getSpriteImagePath("assets/img/PacManSprite.png");


        this.pacdots = new Circle[this.getPacDots().length];
        this.pacdots = this.getPacDots();


        this.blinky = new Ghost(GhostNames.BLINKY);
        this.blinkyImgView = new ImageView(this.spriteImage);
        this.blinkyImgView.setViewport(this.blinky.getSprite());

        this.pacManImgView = new ImageView(this.spriteImage);
        this.pacMan = new PacMan(this.mazeData, this.blinkyImgView, this.pacdots, this.paneMaze);
        this.pacManImgView.setViewport(this.pacMan.getSprite());
        this.pacMan.setup(this.pacManImgView);


       addToMaze(this.pacManImgView);
       addToMaze(this.blinkyImgView);

        this.pacDotBounds = new Bounds[this.pacdots.length];

        for (int i = 0; i < this.pacdots.length; i++) {
            this.pacDotBounds[i] = this.pacdots[i].getBoundsInParent();
            this.pacdots[i].setStroke(Color.RED);
        }



        this.svgPath.setContent(pdl.getPathData(ftmp.loadPathFile("./src/assets/pathData/path1.txt")));
        this.svgPath.setTranslateX(-440);
        this.svgPath.setTranslateY(-295);

//        //Path Transition and Controlling Sprites
        this.pth = new PathTransition();
        this.pth.setNode(this.blinkyImgView);
        this.pth.setPath(this.svgPath);

        this.pth.setInterpolator(Interpolator.LINEAR);
        this.pth.setDuration(Duration.seconds(25));
        this.pth.setCycleCount(Timeline.INDEFINITE);
        this.pth.setAutoReverse(true);
        this.pth.play();

        this.maze = new Scene(this.paneMaze, 900, 600);

        //TIMELINE AND KEYFRAME
        this.kf = new KeyFrame(Duration.millis(100), e -> { this.pacMan.update(); this.pacMan.posX = this.pacManImgView.getTranslateX(); this.pacMan.posY = this.pacManImgView.getTranslateY(); checkPacDots(); } );
        this.tl = new Timeline();
        this.tl.getKeyFrames().add(this.kf);
        this.tl.setCycleCount(Timeline.INDEFINITE);
        this.tl.setRate(2.0);

        this.tl.play();
        this.pacManImgView.requestFocus();

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
        return new Rectangle2D(0,5,490,540);

    }

    public StackPane generateMazeLevel()
    {
        StackPane tmpMazePane = new StackPane();
        Rectangle[] tmpMaze = this.mazeData;


        Circle[] tmpDots = getPacDots();

            for (int i = 1; i < tmpMaze.length; i++) {
                tmpMazePane.getChildren().add(tmpMaze[i]);
            }

            for (int j = 0; j < tmpDots.length; j++) {
                tmpMazePane.getChildren().add(tmpDots[j]);
            }


        return tmpMazePane;
    }

    private void checkPacDots() {

        for (int i = 0; i < this.pacdots.length; i++) {
            this.pacDotBounds[i] = this.pacdots[i].getBoundsInParent();
        }

        Bounds pacManBounds = this.pacMan.pacmanImageview.getBoundsInParent();

        for (int i = 0; i < this.pacdots.length; i++) {
            if (this.pacDotBounds[i].intersects(pacManBounds)) {
                this.paneMaze.getChildren().remove(this.pacdots[i]);
                this.pacDotBounds[i] = null;
                System.out.println("PAC DOT HIT");
                System.out.println(this.pacdots[i]);
            }
        }

    }


    public ImageView getGhosts()
    {
        return this.blinkyImgView;
    }

    private Rectangle[] getMaze()
    {
        Rectangle[] tmpRect;
        tmpRect = MazeData.generateMazeData();
        return tmpRect;
    }

    private Circle[] getPacDots()
    {
        Circle[] tmpPacdots = PacDot.generatePacDotData();
        return tmpPacdots;
    }

    public Scene getScene() {
        return this.maze;
    }
    
    
}
