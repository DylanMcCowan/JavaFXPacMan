package pacman;

import javafx.geometry.Rectangle2D;

/**
 * @author KevinCamp
 */
public interface Entity
{

    boolean isVisible ();

    void update ();

    String getId ();

    void setId (String name);

    Rectangle2D getSprite();
}
