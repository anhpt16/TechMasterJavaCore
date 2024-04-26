package states;

import utils.Constant;

import javax.swing.*;

public class FearState extends GhostState{
    public FearState(int speedGhost, long seconds) {
        super(Constant.SCARED, speedGhost, seconds);
    }
}
