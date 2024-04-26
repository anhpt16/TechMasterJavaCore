import utils.Constant;

import javax.swing.*;

public class Main{
    public static void main(String[] args) {
        /* Khởi tạo và hiển thị JFrame */
        JFrame frame = new JFrame("Game Pacman");
        PacmanGame game = new PacmanGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        /* Các thông số cho vòng lặp game */
        boolean isRunning = true;
        long startTime;
        long elapsedTime;
        long waitTime;
        /* Đây là vòng lặp game - Giới hạn tốc độ của trò chơi là 60FPS */
        while (isRunning){
            startTime = System.nanoTime();

            /* Xử lý đầu vào */
            game.processInput();
            /* Cập nhật trò chơi */
            game.updateGame();
            /* Vẽ các hình ảnh */
            game.renderGame();

            elapsedTime = System.nanoTime() - startTime;
            waitTime = Constant.TARGET_TIME - elapsedTime / 1000000; //Chuyển nano -> millisecond

            if (waitTime > 0){
                try {
                    Thread.sleep(waitTime);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
