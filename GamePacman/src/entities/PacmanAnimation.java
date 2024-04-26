package entities;

import javax.swing.*;
import java.util.ArrayList;

public class PacmanAnimation{
    private ArrayList<ImageIcon> frames;
    private int currentFrameIndex;

    public PacmanAnimation(ArrayList<ImageIcon> frames) {
        this.frames = frames;
        this.currentFrameIndex = 0;
    }
    public ImageIcon getCurrentFrame(){
        return frames.get(currentFrameIndex);
    }
    public void nextFrame(){
        currentFrameIndex = (currentFrameIndex + 1) % frames.size();
    }

}
