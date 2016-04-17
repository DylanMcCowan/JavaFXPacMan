package pacman;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class StartMenu extends GridPane
{
    //Intro Pane
    private GridPane startPane;

    private Button bttnStart;
    private Button bttnExit;
    private boolean begin;
    private ImageView pacmantitle;

    public StartMenu()
    {
        this.startPane = new GridPane();
        this.startPane.setStyle("-fx-background-color: linear-gradient(black, blue);");
        this.begin = false;
        this.startPane.setAlignment(Pos.CENTER);
        this.startPane.setPrefSize(900, 600);

        pacmantitle = new ImageView("./assets/img/pacmantitle.png");

        this.bttnStart = new Button("Start Game!");
        this.bttnStart.setMinWidth(300);
        this.bttnExit = new Button("Exit Game!");
        this.bttnExit.setMinWidth(300);


        this.startPane.add(this.pacmantitle, 1, 1);
        this.startPane.add(this.bttnStart, 1, 2);
        this.startPane.add(this.bttnExit,1,3);
        this.startPane.setVgap(15.0);
        this.startPane.setHgap(10.0);
        getChildren().add(this.startPane);


        this.startPane.setVisible(true);

        this.bttnStart.setOnMouseClicked(e -> {
            this.setVisible(false);
            this.begin = true;

        } );

        this.bttnExit.setOnMouseClicked(e -> {
            Platform.exit();
        });
    }

    public boolean checkBegin()
    {
        return this.begin;
    }



}
