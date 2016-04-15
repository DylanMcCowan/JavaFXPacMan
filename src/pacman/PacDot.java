package pacman;

import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author KevinCamp
 */
public class PacDot implements Entity
{
    protected boolean isVisible;
    public String name;


    //TODO Automate the contruction of the PacDot by calling the appropriate method from constructor
    public PacDot ()
    {

    }

    public static Circle[] generatePacDotData()
    {
        //pacdots
        Circle[] pacdots = new Circle[88];
        double width = 5;
        int Xpos = -420;
        int Ypos = -280;
        for (int i = 0; i < 13; i++) {
            pacdots[i] = new Circle(width);
            pacdots[i].setTranslateX(Xpos);
            pacdots[i].setTranslateY(Ypos);
            pacdots[i].setFill(Color.GREEN);
            Xpos += 70;
        }
        Xpos -= 70;
        for (int i = 13; i < 22; i++) {
            pacdots[i] = new Circle(width);
            pacdots[i].setTranslateX(Xpos);
            pacdots[i].setTranslateY(Ypos);
            pacdots[i].setFill(Color.GREEN);
            Ypos += 70;
        }
        Xpos = -420;
        Ypos = -280;
        for (int i = 22; i < 31; i++) {
            pacdots[i] = new Circle(width);
            pacdots[i].setTranslateX(Xpos);
            pacdots[i].setTranslateY(Ypos);
            pacdots[i].setFill(Color.GREEN);
            Ypos += 70;
        }
        Xpos = -350;
        Ypos = 20;
        for (int i = 31; i < 42; i++) {
            pacdots[i] = new Circle(width);
            pacdots[i].setTranslateX(Xpos);
            pacdots[i].setTranslateY(Ypos);
            pacdots[i].setFill(Color.GREEN);
            Xpos += 70;
        }
        Xpos = 175;
        Ypos = -230;
        for (int i = 42; i < 50; i++) {
            pacdots[i] = new Circle(width);
            pacdots[i].setTranslateX(Xpos);
            pacdots[i].setTranslateY(Ypos);
            pacdots[i].setFill(Color.GREEN);
            Ypos += 70;
        }
        Xpos = 250;
        Ypos = -230;
        for (int i = 50; i < 58; i++) {
            pacdots[i] = new Circle(width);
            pacdots[i].setTranslateX(Xpos);
            pacdots[i].setTranslateY(Ypos);
            pacdots[i].setFill(Color.GREEN);
            Ypos += 70;
        }
        Xpos = -250;
        Ypos = -230;
        for (int i = 58; i < 66; i++) {
            pacdots[i] = new Circle(width);
            pacdots[i].setTranslateX(Xpos);
            pacdots[i].setTranslateY(Ypos);
            pacdots[i].setFill(Color.GREEN);
            Ypos += 70;
        }
        Xpos = -175;
        Ypos = -230;
        for (int i = 66; i < 74; i++) {
            pacdots[i] = new Circle(width);
            pacdots[i].setTranslateX(Xpos);
            pacdots[i].setTranslateY(Ypos);
            pacdots[i].setFill(Color.GREEN);
            Ypos += 70;
        }
        Xpos = -120;
        Ypos = -140;
        for (int i = 74; i < 79; i++) {
            pacdots[i] = new Circle(width);
            pacdots[i].setTranslateX(Xpos);
            pacdots[i].setTranslateY(Ypos);
            pacdots[i].setFill(Color.GREEN);
            Xpos += 70;
        }
        Xpos = -120;
        Ypos = 210;
        for (int i = 79; i < 84; i++) {
            pacdots[i] = new Circle(width);
            pacdots[i].setTranslateX(Xpos);
            pacdots[i].setTranslateY(Ypos);
            pacdots[i].setFill(Color.GREEN);
            Xpos += 70;
        }
        Xpos = -120;
        Ypos = 280;
        for (int i = 84; i < 88; i++) {
            pacdots[i] = new Circle(width);
            pacdots[i].setTranslateX(Xpos);
            pacdots[i].setTranslateY(Ypos);
            pacdots[i].setFill(Color.GREEN);
            Xpos += 70;
        }

        return pacdots;

    }

    public void setId (String name)
    {
        this.name = name;
    }

    //TODO Insert Correct Sprite Bounds
    @Override
    public Rectangle2D getSprite() {
        return new Rectangle2D(635, 156, 24,24);
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


}
