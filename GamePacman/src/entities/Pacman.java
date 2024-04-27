package entities;

import utils.Constant;

import javax.swing.*;
import java.util.ArrayList;

public class Pacman extends Thread {
    private int x, y;
    private final PacmanAnimation animation;
    private boolean runAnimation = true;
    private final int PACMAN_SPEED = 3;
    private int life;
    private int score = 0;
    private int direction;
    private boolean isEatenGhost;

    public Pacman(int x, int y, ArrayList<ImageIcon> frames) {
        this.x = x;
        this.y = y;
        this.animation = new PacmanAnimation(frames);
        this.life = 4;
        this.direction = Constant.RIGHT;
    }

    public void animate() {
        animation.nextFrame();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getPACMAN_SPEED() {
        return PACMAN_SPEED;
    }

    public void gainPoint(int type) {
        this.score += type;
    }

    public void die() {
        this.life -= 1;
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        x = Constant.PACMAN_START_POSITION_X;
        y = Constant.PACMAN_START_POSITION_Y;
        System.out.println(life);
    }

    public ImageIcon getCurrentFrame() {
        return animation.getCurrentFrame();
    }

    public void stopAnimation() {
        this.runAnimation = false;
    }

    public void runAnimation() {
        this.runAnimation = true;
    }

    public void setEatenGhost(boolean isEatenGhost){
        this.isEatenGhost = isEatenGhost;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                animate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
