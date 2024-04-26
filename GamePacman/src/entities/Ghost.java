package entities;

import services.GhostMovement;
import states.*;
import utils.Constant;

import javax.swing.*;
import java.util.*;
import java.util.Timer;

public abstract class Ghost {
    /* Các thuộc tính */
    protected Pacman pacman;
    protected Board board;
    protected int x,y;
    protected ImageIcon ghostImage;
    protected GhostState currentState;
    protected int speed;

    /* Các state */
    protected Timer timer = new Timer();
    protected GhostState defaultState;
    protected GhostState scatteredState;
    protected GhostState fearState;
    protected GhostState deadState;
    /* Kiểu di chuyển */
    protected GhostMovement ghostMovement;
    protected ArrayList<int[]> path;
    protected int direction;
    protected ArrayList<int[]> nodeBack; // lưu trữ node back

    public Ghost(int x, int y, ImageIcon ghostImage, Pacman pacman, Board board) {
        this.x = x;
        this.y = y;
        this.ghostImage = ghostImage;
        this.pacman = pacman;
        this.board = board;
        this.ghostMovement = new GhostMovement(board, this);
        this.direction = -1;
        this.nodeBack = new ArrayList<>();
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int[] getNodeBack(){
        if (nodeBack.size() < 2){
            return null;
        }
        else
            return nodeBack.get(1);
    }

    public void addNodeBack(int[] node){
        // 0 - current node
        // 1 - node back
        if (nodeBack.size() == 0){
            nodeBack.add(node);
        }
        else if (nodeBack.size() == 1){
            if (!Arrays.equals(nodeBack.get(0), node)){
                int[] temp = nodeBack.get(0);
                nodeBack.set(0, node);
                nodeBack.add(1, temp);
            }
        }
        else if (nodeBack.size() == 2){
            if (!Arrays.equals(nodeBack.get(0), node) && !Arrays.equals(nodeBack.get(1), node)){
                int[] temp = nodeBack.get(0);
                nodeBack.set(0, node);
                nodeBack.set(1, temp);
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public ImageIcon getGhostImage() {
        return ghostImage;
    }

    public ArrayList<int[]> getPath() {
        return path;
    }

    public void setPath(ArrayList<int[]> path) {
        this.path = path;
    }

    public void move(){};
}
