
package pacman;

import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author KevinCamp
 */
public class PacMan extends MovableEntity
{
    boolean isVisible;
    String name;
    boolean isDead;
    Circle c1;
    Rectangle[] mazeRect;

    public PacMan ()
    {
        getSprite();
    }

    public void setId (String name)
    {
        this.name = name;
    }

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
    
    public boolean collisionDetection(){
    for(int i=1;i<mazeRect.length; i++){
Bounds wallObject = mazeRect[i].getBoundsInParent();
    
Bounds circleObject = c1.getBoundsInParent();

if(circleObject.intersects(wallObject)){
    return true;
}
}
    return false;
}


public void moveToLeft (Circle circle)
{
if(collisionDetection()==true){
    circle.setTranslateX(circle.getTranslateX() +15);
}
else{
circle.setTranslateX(circle.getTranslateX() - 10);
}
}

public void moveToRight (Circle circle)
{
if(collisionDetection()==true){
    circle.setTranslateX(circle.getTranslateX() -15);
}
else{
circle.setTranslateX(circle.getTranslateX() + 10);
}
}

public void moveDown (Circle circle)
{
if(collisionDetection()==true){
    circle.setTranslateY(circle.getTranslateY() -15);
}
else{
circle.setTranslateY(circle.getTranslateY() + 10);
}
}

public void moveUp (Circle circle)
{
if(collisionDetection()==true){
    circle.setTranslateY(circle.getTranslateY() +15);
}
else{
circle.setTranslateY(circle.getTranslateY() - 10);
}
}

public void getKeyboardInput (KeyEvent e, Circle circle)
{
switch (e.getCode()) {
case A:
moveToLeft(circle);
break;
case D:
moveToRight(circle);
break;
case S:
moveDown(circle);
break;
case W:
moveUp(circle);
break;
}
}

}
