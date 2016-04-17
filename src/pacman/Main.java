package pacman;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 * Created by dylan on 2016-04-01.
 */
public class Main extends Application
{
    private MazeLevel level;

    public void start (Stage stage)
    {
        stage.setTitle("JavaFX PacMan");
        stage.setResizable(false);
        this.level = new MazeLevel();
        stage.setScene(this.level.getScene());
        stage.show();
    }

    public static void main (String[] args)
    {
        launch(args);
    }
}
