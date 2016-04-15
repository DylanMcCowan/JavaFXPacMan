
package pacman;

import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
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

    ImageView pacmanImageview;
    ImageView ghostImageView;
    ImageView ghostImageView2;

    //movement
    boolean moving;
    private String currentDirection;

    public PacMan(Rectangle[] mazeRect, ImageView ghost, ImageView ghost2) {
        getSprite();
        this.mazeRect = mazeRect;
        this.ghostImageView = ghost;
        this.ghostImageView2 = ghost2;
        this.isDead = false;

    }

    public void setup(ImageView imgView) {
        this.pacmanImageview = imgView;

        this.pacmanImageview.setOnKeyPressed(e -> {
            this.getKeyboardInput(e, this.pacmanImageview);
        });
        this.currentDirection = "UP";
        this.moving = false;

        this.pacmanImageview.setTranslateY(205);


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

        Bounds pacmanBounds = pacman.getBoundsInParent();

        for (int i = 1; i < mazeRect.length; i++) {
            Bounds mazeWall = mazeRect[i].getBoundsInParent();

            if (pacmanBounds.intersects(mazeWall)) {
                return true;
            }
            if (pacmanBounds.intersects(this.ghostImageView.getBoundsInParent())) {
                this.pacmanImageview.setViewport(new DeadPacMan().getSprite());
                this.isDead = true;
                this.moving = false;
            }
            if (pacmanBounds.intersects(this.ghostImageView2.getBoundsInParent())) {
                this.pacmanImageview.setViewport(new DeadPacMan().getSprite());
                this.isDead = true;
                this.moving = false;
            }
        }


        if (this.posX > (450 - 30)) {
            setDirection(DIRECTION.LEFT);
        }
        if (this.posY > (300 - 20)) {
            setDirection(DIRECTION.UP);
        }
        if (this.posX < (-450 + 30)) {
            setDirection(DIRECTION.RIGHT);
        }
        if (this.posY < (-300 + 15)) {
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
