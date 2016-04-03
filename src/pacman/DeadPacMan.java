package pacman;

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
