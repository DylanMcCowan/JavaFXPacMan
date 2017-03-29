package pacman;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Created by dylan on 2016-04-11.
 *
 * MazeData.java
 *
 * A file responsible for creating and operating the components of the Maze. Such as the Maze wall locations
 * and related rectangles
 *
 * This will produce a StackPane containing all components of the Maze for use in the game window
 */
public class MazeData {

    private StackPane mazeDataPane;


    public MazeData() {
        this.mazeDataPane = generateMaze(generateMazeData());
    }

    //TODO Check usages in game code
    public StackPane getMazeDataPane() {
        return this.mazeDataPane;
    }

    //TODO Redevelop this entire method and optimize the code
    public static Rectangle[] generateMazeData() {

        StackPane mazeDataPane = new StackPane();
        Rectangle[] mazeRect = new Rectangle[19];

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
        l19.setTranslateY(-215);

        //TODO Optimize this inefficient code
        for (int i = 1; i < mazeRect.length; i++) {
            switch (i) {
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
                    //TODO mistake, no rectangle l11 check variables
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

        return mazeRect;
    }

    //TODO Look for ways to improve this code
    public static StackPane generateMaze(Rectangle[] mazeRectData) {
        StackPane mazeDataPane = new StackPane();

        for (int i = 1; i < mazeRectData.length; i++) {
            mazeDataPane.getChildren().add(mazeRectData[i]);
        }

        return mazeDataPane;
    }

}
