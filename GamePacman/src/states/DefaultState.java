package states;

import entities.Ghost;
import utils.Constant;

import javax.swing.*;

public class DefaultState extends GhostState{
    private Ghost ghost;
    public DefaultState(Ghost ghost,ImageIcon imageIcon, int speedGhost, long seconds) {
        super(imageIcon, speedGhost, seconds);
        this.ghost = ghost;
    }

    @Override
    public void startState() {
        super.startState();
        ghost.setGhostImage(imageIcon);
        if ((ghost.getX() % 2 == 1) || (ghost.getY() % 2 == 1)){
            ghost.setSpeed(Constant.SPEED_FEAR);
        }
        else {
            ghost.setSpeed(Constant.SPEED_DEFAULT);
        }
    }
}
