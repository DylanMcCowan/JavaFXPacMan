/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

/**
 *
 * @author KevinCamp
 */
public class PacMan extends MoveableEntity
{
    boolean isVisible;
    String name;
    boolean isDead;

    public PacMan ()
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
    
    public void isDead(){
        this.isDead =true;
        this.isVisible=false;
    }
}
