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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.util.Duration;

/**
 * Created by dylan on 2016-04-03.
 */
public class MazeLevel {

    Rectangle[] mazeRect;

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
        Rectangle GamesSpace = new Rectangle(900,600);

//Spawn
        Rectangle l1 = new Rectangle(300, 20);
        l1.setFill(Color.BLUE);
        l1.setTranslateY(245);
        Rectangle l2 = new Rectangle(20, 210);
        l2.setFill(Color.BLUE);
        l2.setTranslateY(340);
        l2.setTranslateX(210);
        Rectangle l3 = new Rectangle(20, 210);
        l3.setFill(Color.BLUE);
        l3.setTranslateY(340);
        l3.setTranslateX(-210);
//right of spawn
        Rectangle l4 = new Rectangle(120, 200);
        l4.setFill(Color.BLUE);
        l4.setTranslateY(150);
        l4.setTranslateX(335);
        Rectangle l5 = new Rectangle(120, 240);
        l5.setFill(Color.BLUE);
        l5.setTranslateY(-140);
        l5.setTranslateX(335);
//left of spawn
        Rectangle l6 = new Rectangle(120, 200);
        l6.setFill(Color.BLUE);
        l6.setTranslateY(150);
        l6.setTranslateX(-335);
        Rectangle l7 = new Rectangle(120, 240);
        l7.setFill(Color.BLUE);
        l7.setTranslateY(-140);
        l7.setTranslateX(-335);
// middle
        Rectangle l9 = new Rectangle(20, 145);
        l9.setFill(Color.BLUE);
        l9.setTranslateY(115);
        l9.setTranslateX(210);
        Rectangle l10 = new Rectangle(20, 145);
        l10.setFill(Color.BLUE);
        l10.setTranslateY(115);
        l10.setTranslateX(-210);
//ghost spawn
        Rectangle l8 = new Rectangle(300, 20);
        l8.setFill(Color.BLUE);
        l8.setTranslateY(175);
        Rectangle l12 = new Rectangle(20, 120);
        l12.setFill(Color.BLUE);
        l12.setTranslateY(110);
        l12.setTranslateX(140);
        Rectangle l13 = new Rectangle(20, 120);
        l13.setFill(Color.BLUE);
        l13.setTranslateY(110);
        l13.setTranslateX(-140);
        Rectangle l16 = new Rectangle(100, 20);
        l16.setFill(Color.BLUE);
        l16.setTranslateY(55);
        l16.setTranslateX(100);
        Rectangle l17 = new Rectangle(100, 20);
        l17.setFill(Color.BLUE);
        l17.setTranslateY(55);
        l17.setTranslateX(-100);
//top
        Rectangle l14 = new Rectangle(20, 240);
        l14.setFill(Color.BLUE);
        l14.setTranslateY(-140);
        l14.setTranslateX(210);
        Rectangle l15 = new Rectangle(20, 240);
        l15.setFill(Color.BLUE);
        l15.setTranslateY(-140);
        l15.setTranslateX(-210);
        Rectangle l18 = new Rectangle(300, 100);
        l18.setFill(Color.BLUE);
        l18.setTranslateY(-70);
        Rectangle l19 = new Rectangle(300, 90);
        l19.setFill(Color.BLUE);
        l19.setTranslateY(-215);;

mazeRect = new Rectangle[19];

for(int i =1; i < mazeRect.length;i++){
    switch(i){
        case 1:
            mazeRect[i] = l1;
            break;
        case 2:
            mazeRect[i] = l2;
            break;
        case 3:
            mazeRect[i] = l3;
            break;
        case 4:
            mazeRect[i] = l4;
            break;
        case 5:
            mazeRect[i] = l5;
            break;
        case 6:
            mazeRect[i] = l6;
            break;
        case 7:
            mazeRect[i] = l7;
            break;
        case 8:
            mazeRect[i] = l8;
            break;
        case 9:
            mazeRect[i] = l9;
            break;
        case 10:
            mazeRect[i] = l10;
            break;
        case 11:
            //mistake, no rectangle l11
            mazeRect[i] = l19;
            break;
        case 12:
            mazeRect[i] = l12;
            break;
        case 13:
            mazeRect[i] = l13;
            break;
        case 14:
            mazeRect[i] = l14;
            break;
        case 15:
            mazeRect[i] = l15;
            break;
        case 16:
            mazeRect[i] = l16;
            break;
        case 17:
            mazeRect[i] = l17;
            break;
        case 18:
            mazeRect[i] = l18;
            System.out.println("Final Added");
            break;
        
    }
}
        this.paneMaze = new Pane();

        this.spriteImage = getSpriteImagePath("assets/img/PacManSprite.png");

//        this.imgMaze = new ImageView(this.spriteImage);
//        this.imgMaze.setViewport(getMazeSprite());

//        this.pacMan = new PacMan();
//        this.pacManImgView = new ImageView(this.spriteImage);
//        this.pacManImgView.setViewport(this.pacMan.getSprite());

//        this.blinky = new Ghost(GhostNames.CLYDE);
//        this.blinkyImgView = new ImageView(this.spriteImage);
//        this.blinkyImgView.setViewport(this.blinky.getSprite());

       // addToMaze(this.imgMaze);
       // addToMaze(this.pacManImgView);
       // addToMaze(this.blinkyImgView);

//        this.svgPath.setContent(pdl.getPathData(ftmp.loadPathFile("./src/assets/pathData/path2.txt")));
//
//        //Path Transition and Controlling Sprites
//        this.pth = new PathTransition();
//        this.pth.setNode(this.blinkyImgView);
//        this.pth.setPath(this.svgPath);
//        this.pth.setInterpolator(Interpolator.LINEAR);
//
//        this.pth.setDuration(Duration.seconds(25));
//        this.pth.setCycleCount(Timeline.INDEFINITE);
//        this.pth.setAutoReverse(true);
//        this.pth.play();

        for (int i = 1; i < this.mazeRect.length; i++) {
            this.paneMaze.getChildren().add(this.mazeRect[i]);
        }


        this.maze = new Scene(this.paneMaze, 900, 600);

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
