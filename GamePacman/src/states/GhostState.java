package states;

import javax.swing.*;

public abstract class GhostState {
    protected ImageIcon imageIcon;
    protected int speedGhost;
    protected long seconds;

    public GhostState() {
    }

    public GhostState(ImageIcon imageIcon, int speedGhost, long seconds) {
        this.imageIcon = imageIcon;
        this.speedGhost = speedGhost;
        this.seconds = seconds;
    }

    public long getSeconds() {
        return seconds;
    }

    public void startState(){}
}
