package pacman;

/**
 * @author KevinCamp
 */
public interface Entity
{

    boolean isVisible ();

    void update ();

    String getId ();

    void setId (String name);
}
