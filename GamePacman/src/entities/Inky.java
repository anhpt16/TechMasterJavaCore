package entities;

import states.DeadState;
import states.DefaultState;
import states.FearState;
import states.ScatteredState;
import utils.Constant;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Inky extends Ghost{
    /* Hàm này được gọi để chuyển đổi state */
    private TimerTask switchState = new TimerTask() {
        @Override
        public void run() {
            if (currentState == defaultState) {
                currentState = scatteredState;
                scatteredState.startState();
                System.out.println("Chuyển sang scatteredState");
                // Hủy bỏ việc lập lịch của switchState trước khi lập lịch lại
                cancel();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        switchState.run();
                    }
                }, scatteredState.getSeconds() * 1000);
            } else if (currentState == scatteredState) {
                currentState = defaultState;
                defaultState.startState();
                System.out.println("Chuyển sang defaultState");
                // Hủy bỏ việc lập lịch của switchState trước khi lập lịch lại
                cancel();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        switchState.run();
                    }
                }, defaultState.getSeconds() * 1000);
            }
            else if (currentState == fearState) {
                currentState = defaultState;
                defaultState.startState();
                System.out.println("CHuyển sang defaultstate từ fearstate");
                // Hủy bỏ việc lập lịch của switchState trước khi lập lịch lại
                cancel();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        switchState.run();
                    }
                }, scatteredState.getSeconds() * 1000);
            } else if (currentState == deadState) {
                currentState = defaultState;
                defaultState.startState();
                System.out.println("CHuyển sang defaultstate từ deadstate");
                // Hủy bỏ việc lập lịch của switchState trước khi lập lịch lại
                cancel();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        switchState.run();
                    }
                }, scatteredState.getSeconds() * 1000);
            }
        }
    };

    public Inky(int x, int y, ImageIcon ghostImage, Pacman pacman, Board board) {
        super(x, y, ghostImage, pacman, board);
        speed = 2;
        /* Thiết lập vị trí hồi sinh cho Pacman */
        revivalArea[0] = 362;
        revivalArea[1] = 362;
        /* Khởi tạo các trạng thái cho Blinky */
        defaultState = new DefaultState(this, ghostImage, speed, 5);
        scatteredState = new ScatteredState(this, ghostImage, speed, 5);
        fearState = new FearState(this, Constant.SPEED_FEAR, 6);
        deadState = new DeadState(this, speed);
        /* Đặt trạng thái ban đầu của Blinky là trạng thái mặc định */
        currentState = defaultState;
        /* Khởi tạo node góc cho Blinky */
        nodeCorner[0] = 50;
        nodeCorner[1] = 722;
        /* Bắt đầu bộ đếm */
        timer.schedule(switchState, defaultState.getSeconds() * 1000);
    }

    @Override
    public void setFearState() {
        super.setFearState();
        if (currentState == deadState){
            return;
        }
        /* Hủy bỏ lập lịch hiện tại và thực hiện một lập lịch mới */
        timer.cancel();
        System.out.println("Hủy bỏ timer");
        timer = new java.util.Timer();
        /* Chuyển sang fear state */
        currentState = fearState;
        System.out.println("Chuyển sang fearState");
        fearState.startState();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                switchState.run();
            }
        }, fearState.getSeconds() * 1000);
    }

    @Override
    public void setDeadState() {
        super.setDeadState();
        timer.cancel();
        timer = new Timer();
        currentState = deadState;
        deadState.startState();
    }

    @Override
    public void setDefaultState() {
        super.setDefaultState();
        currentState = defaultState;
        defaultState.startState();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                switchState.run();
            }
        }, defaultState.getSeconds() * 1000);
    }

    @Override
    public void move() {
        super.move();
        if (currentState == scatteredState) {
            ghostMovement.moveToCorner();

        } else if (currentState == fearState) {
            ghostMovement.dodgePacman();
        } else if (currentState == deadState) {
            if (x == revivalArea[0] && y == revivalArea[1]){
                setDefaultState();
            }
            else{
                ghostMovement.moveToGate();
            }
        }
        /* Default State */
        else if (currentState == defaultState){
//            ghostMovement.chasePacman(pacman);
            ghostMovement.blockHeadPacman(pacman);
//            ghostMovement.moveToCorner();
        }
    }
}
