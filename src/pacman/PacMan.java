
package pacman;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

enum DIRECTION {
    UP, DOWN, LEFT, RIGHT
}

/**
 * @author KevinCamp
 */
public class PacMan extends MovableEntity {
    boolean isVisible;
    String name;
    boolean isDead;

    Rectangle[] mazeRect;
    Circle[] pacDots;

    ImageView pacmanImageview;
    ImageView ghostImageView;
    StackPane test;

    Bounds pacmanBounds;
    Bounds pacDotBounds[];

    //movement
    boolean moving;
    private String currentDirection;

    Timeline tl;
    KeyFrame kf;

    public PacMan(Rectangle[] mazeRect, ImageView ghost, Circle[] pacDots, StackPane sp) {
        getSprite();
        this.mazeRect = mazeRect;
        this.ghostImageView = ghost;
        this.pacDots = pacDots;
        this.test = sp;
        this.isDead = false;
        this.pacDotBounds = new Bounds[this.pacDots.length];


    }

    public void setup(ImageView imgView) {
        this.pacmanImageview = imgView;
        this.pacmanImageview.setOnKeyPressed(e -> {
            this.getKeyboardInput(e, this.pacmanImageview);
        });
        this.currentDirection = "UP";
        this.moving = false;


    }

    public void setId(String name) {
        this.name = name;
    }

    @Override
    public Rectangle2D getSprite() {
        return new Rectangle2D(607, 344, 32, 32);
    }

    public String getId() {
        return this.name;
    }

    @Override
    public boolean isVisible() {
        return this.isVisible;
    }

    @Override
    public void update() {

        if (!this.isDead) {
            if (this.moving) {
                switch (this.currentDirection) {
                    case "UP":
                        moveUp(this.pacmanImageview);
                        break;
                    case "DOWN":
                        moveDown(this.pacmanImageview);
                        break;
                    case "LEFT":
                        moveToLeft(this.pacmanImageview);
                        break;
                    case "RIGHT":
                        moveToRight(this.pacmanImageview);
                        break;
                    default:
                        System.out.println("ERROR Default");
                        break;

                }
            }
        }else{

        }
        collisionDetection(this.mazeRect, this.pacmanImageview);


    }

    //TODO Change this to make it not incorrect
    public void isDead() {
        this.isDead = true;
        this.isVisible = false;
    }


    public boolean collisionDetection(Rectangle[] mazeRect, ImageView pacman) {

//        for (int i = 0; i < this.pacDots.length; i++) {
//
//            Bounds pacManBounds = pacman.getBoundsInParent();
//
//            if (pacManBounds.intersects(pacDotBounds[i])) {
//                this.test.getChildren().remove(this.pacDots[i]);
//                this.pacDotBounds[i] = null;
//
//                System.out.println("PACDOT HIT");
//            }
//        }

        for (int i = 1; i < mazeRect.length; i++) {
            Bounds mazeWall = mazeRect[i].getBoundsInParent();
            Bounds pacmanBounds = pacman.getBoundsInParent();

            if (pacmanBounds.intersects(mazeWall)) {

                return true;
            }
            if (pacmanBounds.intersects(this.ghostImageView.getBoundsInParent())) {
                this.pacmanImageview.setViewport(new DeadPacMan().getSprite());
                this.isDead = true;
                this.moving = false;
                System.out.println("Ghost Collision");
            }
        }


        if (this.posX > (450 - 30)) {
            setDirection(DIRECTION.LEFT);
        }
        if (this.posY > (300 - 25)) {
            setDirection(DIRECTION.UP);
        }
        if (this.posX < (-450 + 30)) {
            setDirection(DIRECTION.RIGHT);
        }
        if (this.posY < (-300 + 25)) {
            setDirection(DIRECTION.DOWN);
        }

        this.moving = true;
        return false;
    }

    private void setDirection(DIRECTION dir) {
        switch (dir) {
            case UP:
                this.currentDirection = "UP";
                break;
            case DOWN:
                this.currentDirection = "DOWN";
                break;
            case LEFT:
                this.currentDirection = "LEFT";
                break;
            case RIGHT:
                this.currentDirection = "RIGHT";
                break;
            default:
                break;
        }
    }

    private String getDirection() {
        return this.currentDirection;
    }


    private void moveToLeft(ImageView imgView) {
        imgView.setTranslateX(imgView.getTranslateX() - 10);
        if (collisionDetection(this.mazeRect, this.pacmanImageview)) {
            imgView.setTranslateX(imgView.getTranslateX() + 10);
            this.moving = false;
        }
    }

    private void moveToRight(ImageView imgView) {
        imgView.setTranslateX(imgView.getTranslateX() + 10);
        if (collisionDetection(this.mazeRect, this.pacmanImageview)) {
            imgView.setTranslateX(imgView.getTranslateX() - 10);
            this.moving = false;
        }
    }

    private void moveDown(ImageView imgView) {
        imgView.setTranslateY(imgView.getTranslateY() + 10);
        if (collisionDetection(this.mazeRect, this.pacmanImageview)) {
            imgView.setTranslateY(imgView.getTranslateY() - 10);
            this.moving = false;
        }
    }

    private void moveUp(ImageView imgView) {
        imgView.setTranslateY(imgView.getTranslateY() - 10);
        if (collisionDetection(this.mazeRect, this.pacmanImageview)) {
            imgView.setTranslateY(imgView.getTranslateY() + 10);
            this.moving = false;
        }
    }

    public void getKeyboardInput(KeyEvent e, ImageView img) {
        switch (e.getCode()) {
            case A:
                // moveToLeft(img);
                setDirection(DIRECTION.LEFT);
                break;
            case D:
                //moveToRight(img);
                setDirection(DIRECTION.RIGHT);
                break;
            case S:
                //moveDown(img);
                setDirection(DIRECTION.DOWN);
                break;
            case W:
                // moveUp(img);
                setDirection(DIRECTION.UP);
                break;
        }
    }

}
