package states;

import entities.Ghost;
import utils.Constant;

import javax.swing.*;

public class FearState extends GhostState{
    private Ghost ghost;
    public FearState(Ghost ghost,int speedGhost, long seconds) {
        super(Constant.SCARED, speedGhost, seconds);
        this.ghost = ghost;
    }

    @Override
    public void startState(){
        ghost.setSpeed(speedGhost);
        ghost.setGhostImage(imageIcon);
    }
}
