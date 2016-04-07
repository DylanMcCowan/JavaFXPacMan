/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import javafx.geometry.Rectangle2D;

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
        getSprite();
    }

    public void setId (String name)
    {
        this.name = name;
    }

    //TODO Insert Correct Sprite Bounds
    @Override
    public Rectangle2D getSprite() {
        return new Rectangle2D(607, 344, 32,32);
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

    //TODO Change this to make it not incorrect
    public void isDead(){
        this.isDead =true;
        this.isVisible=false;
    }
}
