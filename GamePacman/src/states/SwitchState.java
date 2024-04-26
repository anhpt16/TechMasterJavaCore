package states;

import java.util.ArrayList;
import java.util.TimerTask;

public class SwitchState extends TimerTask {
    private ArrayList<GhostState> ghostStates;

    public SwitchState(ArrayList<GhostState> ghostStates) {
        this.ghostStates = ghostStates;
    }

    @Override
    public void run() {

    }
}
