package pacman;

import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by dylan on 2016-04-03.
 */
public class MazeLevel {


    //MazeScene
   private Scene maze;
   private Pane paneMaze;

    //ImageView
    private ImageView imgMaze;



    public MazeLevel()
    {
        this.paneMaze = new Pane();

        this.imgMaze = getImageView("assets/img/PacManSprite.png");
        this.imgMaze.setViewport(getSprite());

        addToMaze(this.imgMaze);

        this.maze = new Scene(paneMaze, 540, 490);

    }

    public void addToMaze(Node object)
    {
        this.paneMaze.getChildren().add(object);
    }

    //This should load the PacManSprite.png file generally...
    private Image getSpriteImagePath(String path)
    {
        FileLoader f = new FileLoader();
        Image tmpImage = new Image(f.loadImageFile(path).getPath());

        return tmpImage;

    }

    private ImageView getImageView(String path)
    {
        ImageView imgView = new ImageView(getSpriteImagePath(path));

        return imgView;
    }

    public Rectangle2D getSprite()
    {
        //For Experimental purposes only, hardcoded to load the rect related to the main map itself. (0,5),(490,545)
        Rectangle2D spriteImg = new Rectangle2D(0,5,490,540);

        return spriteImg;
    }


    public Scene getScene() {
        return this.maze;
    }
}
