package states;

import entities.Ghost;
import utils.Constant;

import javax.swing.*;

public class DeadState extends GhostState{
    private Ghost ghost;

    public DeadState(Ghost ghost, int speedGhost) {
        imageIcon = Constant.DEAD;
        this.speedGhost = speedGhost;
        this.ghost = ghost;
    }

    public void startState(){
        ghost.setGhostImage(imageIcon);
        if ((ghost.getX() % 2 == 1) || (ghost.getY() % 2 == 1)){
            ghost.setSpeed(Constant.SPEED_FEAR);
        }
        else {
            ghost.setSpeed(Constant.SPEED_DEFAULT);
        }
    }
}
