package states;

import utils.Constant;

import javax.swing.*;

public class DeadState extends GhostState{
    public DeadState(int speedGhost) {
        imageIcon = Constant.DEAD;
        this.speedGhost = speedGhost;
    }
}
