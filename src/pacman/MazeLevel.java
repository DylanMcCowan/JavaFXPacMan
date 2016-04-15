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
    private Bounds pacManBounds;

    //TODO Use an Array for the PacDots and Ghosts.
    //Maze Entities
    private PacMan pacMan;
    private ImageView pacManImgView;
    private Ghost blinky;
    private ImageView blinkyImgView;
    private Ghost pinky;
    private ImageView pinkyImgView;

    //ANIMATION
    Timeline tl;
    KeyFrame kf;
    PathTransition pth;
    PathTransition pinkyPath;
    SVGPath svgPath = new SVGPath();

    //MAIN SPRITE IMAGE
    Image spriteImage;

    //Level PacDot Number Count
    protected int pacdotCount;

    public MazeLevel() {

        this.mazeData = getMaze();
        this.paneMaze = generateMazeLevel();

        this.paneMaze.setStyle("-fx-background-color: black");

        this.spriteImage = getSpriteImagePath("assets/img/PacManSprite.png");


        this.blinky = new Ghost(GhostNames.BLINKY);
        this.blinkyImgView = new ImageView(this.spriteImage);
        this.blinkyImgView.setViewport(this.blinky.getSprite());

        this.pinky = new Ghost(GhostNames.PINKY);
        this.pinkyImgView = new ImageView(this.spriteImage);
        this.pinkyImgView.setViewport(this.pinky.getSprite());

        this.pacManImgView = new ImageView(this.spriteImage);
        this.pacMan = new PacMan(this.mazeData, this.blinkyImgView, this.pacdots, this.paneMaze);
        this.pacManImgView.setViewport(this.pacMan.getSprite());
        this.pacMan.setup(this.pacManImgView);

        this.pacDotBounds = new Bounds[pacdots.length];

        for (int i = 0; i < this.pacdots.length; i++) {
            this.pacdots[i].setFill(Color.YELLOW);
            this.pacDotBounds[i] = this.pacdots[i].getBoundsInParent();
        }


        this.pacdotCount = this.pacdots.length;

        addToMaze(this.pacManImgView);
        addToMaze(this.blinkyImgView);
        addToMaze(this.pinkyImgView);


        this.blinky.svgPath.setTranslateX(-440);
        this.blinky.svgPath.setTranslateY(-295);

        this.pinky.svgPath.setTranslateX(-440);
        this.pinky.svgPath.setTranslateY(-295);

        //Path Transition and Controlling Sprites
        this.pth = new PathTransition();
        this.pth.setNode(this.blinkyImgView);
        this.pth.setPath(this.blinky.svgPath);

        this.pinkyPath = new PathTransition();
        this.pinkyPath.setNode(this.pinkyImgView);
        this.pinkyPath.setPath(this.pinky.svgPath);
        //TODO FIX THIS
        if(this.pinkyPath.getNode().equals(this.pth.getNode()))
        {
            this.pinky.selectPath();
            this.pinkyPath.setPath(this.pinky.svgPath);
            System.out.println("PREVENT!");
        }

        this.pinkyPath.setInterpolator(Interpolator.LINEAR);
        this.pinkyPath.setDuration(Duration.seconds(25));
        this.pinkyPath.setCycleCount(Timeline.INDEFINITE);
        this.pinkyPath.setAutoReverse(true);


        this.pth.setInterpolator(Interpolator.LINEAR);
        this.pth.setDuration(Duration.seconds(25));
        this.pth.setCycleCount(Timeline.INDEFINITE);
        this.pth.setAutoReverse(true);

        this.pinkyPath.play();
        this.pth.play();

        this.maze = new Scene(this.paneMaze, 900, 600);

        //TIMELINE AND KEYFRAME
        this.kf = new KeyFrame(Duration.millis(150), e -> {
            checkPacDots();
            this.pacMan.update();
            this.pacMan.posX = this.pacManImgView.getTranslateX();
            this.pacMan.posY = this.pacManImgView.getTranslateY();
        });
        this.tl = new Timeline();
        this.tl.getKeyFrames().add(this.kf);
        this.tl.setCycleCount(Timeline.INDEFINITE);
        this.tl.setRate(2.0);

        this.tl.play();


        this.pacManImgView.requestFocus();

    }

    public void addToMaze(Node object) {
        this.paneMaze.getChildren().add(object);
    }

    //This should load the PacManSprite.png file generally...
    private Image getSpriteImagePath(String path) {
        //Should get around to making this FileLoader class static...
        FileLoader f = new FileLoader();
        Image tmpImage = new Image(f.loadImageFile(path).getPath());
        return tmpImage;

    }

    //TODO  only return the sprite for the Maze
    private Rectangle2D getMazeSprite() {
        //For Experimental purposes only, hardcoded to load the rect related to the main map itself. (0,5),(490,545)
        return new Rectangle2D(0, 5, 490, 540);

    }

    public StackPane generateMazeLevel() {
        StackPane tmpMazePane = new StackPane();
        Rectangle[] tmpMaze = this.mazeData;

        Circle[] tmpDots = getPacDots();
        this.pacdots = new Circle[tmpDots.length];
        this.pacdots = tmpDots;

        for (int i = 1; i < tmpMaze.length; i++) {
            tmpMazePane.getChildren().add(tmpMaze[i]);
        }

        for (int j = 0; j < tmpDots.length; j++) {
            tmpMazePane.getChildren().add(this.pacdots[j]);
        }


        return tmpMazePane;
    }

    private void checkPacDots() {

       this.pacManBounds = this.pacManImgView.getBoundsInParent();

        for (int i = 0; i < this.pacdots.length; i++) {
            this.pacDotBounds[i] = this.pacdots[i].getBoundsInParent();
        }

        //TODO FIX THIS
        for (int i = 0; i < this.pacDotBounds.length; i++) {
            if (this.pacDotBounds[i].intersects(this.pacManBounds)) {
               this.pacDotBounds[i] = null;
                this.paneMaze.getChildren().remove(this.pacdots[i]);
                System.out.println("Hmms");

            }
        }
        
        int count= 0;
        for(int i =0; i<this.pacdots.length;i++){
            if(paneMaze.getChildren().contains(this.pacdots[i])){
                
            }
            else{
               count++; 
            }
            if(count==this.pacdots.length){
            this.tl.pause();
            this.pinkyPath.pause();
            this.pth.pause();
            System.out.println("YOU WIN! √_√");
            }
        }
        
    }

    private Rectangle[] getMaze() {
        Rectangle[] tmpRect;
        tmpRect = MazeData.generateMazeData();
        return tmpRect;
    }

    private Circle[] getPacDots() {
        Circle[] tmpPacdots = PacDot.generatePacDotData();
        return tmpPacdots;
    }

    public Scene getScene() {
        return this.maze;
    }


}
