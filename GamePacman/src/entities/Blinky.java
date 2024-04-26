package entities;

import states.*;
import utils.Constant;

import javax.swing.*;
import java.util.ArrayList;
import java.util.TimerTask;

public class Blinky extends Ghost {
    /* Hàm này được gọi để chuyển đổi state */
    private TimerTask switchState = new TimerTask() {
        @Override
        public void run() {
//            if (currentState == defaultState) {
//                currentState = scatteredState;
//                timer.schedule(switchState, scatteredState.getSeconds() * 1000);
//            } else if (currentState == scatteredState) {
//                currentState = defaultState;
//                timer.schedule(switchState, defaultState.getSeconds() * 1000);
//            } else if (currentState == fearState) {
//                currentState = defaultState;
//                timer.schedule(switchState, defaultState.getSeconds() * 1000);
//            } else if (currentState == deadState) {
//
//            }
        }
    };

    public Blinky(int x, int y, ImageIcon ghostImage, Pacman pacman, Board board) {
        super(x, y, ghostImage, pacman, board);
        speed = 2;
        /* Khởi tạo các trạng thái cho Blinky */
        defaultState = new DefaultState(ghostImage, speed, 8);
        scatteredState = new ScatteredState(ghostImage, speed, 5);
        fearState = new FearState(speed, 6);
        deadState = new DeadState(speed);
        /* Đặt trạng thái ban đầu của Blinky là trạng thái mặc định */
        currentState = defaultState;
        /* Bắt đầu bộ đếm */
//        timer.schedule(switchState, defaultState.getSeconds() * 1000);
    }

    @Override
    public void move() {
        super.move();
        if (currentState == scatteredState) {
            ghostMovement.moveToCorner();

        } else if (currentState == fearState) {
            ghostMovement.dodgePacman(pacman);
        } else if (currentState == deadState) {
            ghostMovement.moveToGate();
        }
        /* Default State */
        else {
//            ghostMovement.chasePacman(pacman, speed);
            ghostMovement.chasePacman(pacman);
        }
    }
}
