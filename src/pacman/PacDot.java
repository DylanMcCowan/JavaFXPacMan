package pacman;

/**
 *
 * @author KevinCamp
 */
public class PacDot implements Entity
{
    protected boolean isVisible;
    public String name;


    //Constructor to initalize the creation of a PacDot
    public PacDot ()
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
