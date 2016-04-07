package pacman;

import javafx.geometry.Rectangle2D;

/**
 *
 * @author KevinCamp
 */
public class DeadPacMan implements Entity
{
    boolean isVisible;
    String name;

    public DeadPacMan ()
    {

    }

    public void setId (String name)
    {
        this.name = name;
    }

    //TODO Insert Correct Sprite Bounds
    @Override
    public Rectangle2D getSprite() {
        return null;
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
