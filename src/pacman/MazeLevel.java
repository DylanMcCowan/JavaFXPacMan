package pacman;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Created by dylan on 2016-04-03.
 */
public class MazeLevel {


    //MazeScene
    Scene maze;
    Pane paneMaze;



    public MazeLevel()
    {
        this.paneMaze = new Pane();







        this.maze = new Scene(paneMaze, 640, 480);

    }

    public void addToMaze(Node object)
    {
        this.paneMaze.getChildren().add(object);
    }



}
