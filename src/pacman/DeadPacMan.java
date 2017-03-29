package pacman;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

/**
 *
 * @author KevinCamp
 */
public class DeadPacMan implements Entity
{
    boolean isVisible;
    String name;


    public void setId (String name)
    {
        this.name = name;
    }

    @Override
    public Rectangle2D getSprite() {
        return new Rectangle2D(585, 230, 32,32);
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
