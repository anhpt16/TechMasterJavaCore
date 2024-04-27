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
    protected int[] revivalArea;
    /* Các state */
    protected Timer timer = new Timer();
    protected GhostState defaultState;
    protected GhostState scatteredState;
    protected GhostState fearState;
    protected GhostState deadState;
    protected boolean isFear;
    /* Kiểu di chuyển */
    protected GhostMovement ghostMovement;
    protected ArrayList<int[]> path;
    protected int direction;
    protected ArrayList<int[]> nodeBack; // lưu trữ node back
    /* Tọa độ ô góc */
    protected int[] nodeCorner; // lưu trữ hai ô góc của trạng thái state
    protected boolean nodeCornerFirst = true;
    protected boolean nodeCornerSecond = false;

    public Ghost(int x, int y, ImageIcon ghostImage, Pacman pacman, Board board) {
        this.x = x;
        this.y = y;
        this.ghostImage = ghostImage;
        this.pacman = pacman;
        this.board = board;
        this.ghostMovement = new GhostMovement(board, this);
        this.direction = -1;
        this.nodeBack = new ArrayList<>();
        nodeCorner = new int[2];
        revivalArea = new int[2];
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setGhostImage(ImageIcon ghostImage) {
        this.ghostImage = ghostImage;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int[] getNodeCorner() {
        return nodeCorner;
    }

    public boolean isNodeCornerFirst() {
        return nodeCornerFirst;
    }

    public void setNodeCornerFirst(boolean nodeCornerFirst) {
        this.nodeCornerFirst = nodeCornerFirst;
    }

    public boolean isNodeCornerSecond() {
        return nodeCornerSecond;
    }

    public void setNodeCornerSecond(boolean nodeCornerSecond) {
        this.nodeCornerSecond = nodeCornerSecond;
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

    public Timer getTimer() {
        return timer;
    }

    public int[] getRevivalArea() {
        return revivalArea;
    }

    public boolean isFearState(){
        if (currentState == fearState){
            return true;
        }
        return false;
    }

    public boolean isDeadState(){
        if (currentState == deadState){
            return true;
        }
        return false;
    }


    public void setDefaultState(){}
    public void setFearState(){}
    public void setDeadState(){}
    public void move(){};
}
