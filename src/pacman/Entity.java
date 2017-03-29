package pacman;

import javafx.geometry.Rectangle2D;

/**
 * @author KevinCamp
 */
public interface Entity
{
    boolean isVisible (); //Check to see if something is currently visible

    void update (); //TODO Allow implementation for updating all entity functionality

    String getId (); //Return the related entity id

    void setId (String name); //Set the entity ID

    /*
    Return the appropriate Rectangle2D block selecting the desired sprite from
    the sprite sheet.
     */
    public Rectangle2D getSprite();
}
