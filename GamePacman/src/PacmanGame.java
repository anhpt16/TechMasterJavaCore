import entities.*;
import utils.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PacmanGame extends JPanel implements KeyListener {
    private Board board;
    private int[][] matrix;
    private Pacman pacman;
    private Ghost blinky;
    private Ghost inky;
    int[][] level = Constant.BOARD_LEVEL_1;
    private boolean isPaused = true;

    /* Các biến sử dụng trong hàm inputProcess() */
//    private int direction = 0; // Biến này lưu trữ hướng di chuyển đúng của pacman
    private int directionCommand = -1; // Biến này lưu trữ hướng di chuyển nhận được từ bàn phím
    private boolean[] turnAllowed = {false, false, false, false}; // Biến này lưu trữ hướng di chuyển hợp lệ

    public PacmanGame() {
        /* Thiết lập cho JPanel */
        setPreferredSize(new Dimension(1000, 1000));
        setBackground(Constant.BACKGROUND_COLOR);
        setFocusable(true);
        addKeyListener(this);
        /* Khởi tạo level cho trò chơi */
        board = new Board(level);
        matrix = board.getBoard();
        /* Tạo Pacman với hoạt ảnh và tọa độ ban đầu */
        pacman = new Pacman(Constant.PACMAN_START_POSITION_X, Constant.PACMAN_START_POSITION_Y, Constant.PACMAN_ANIMATION);
        /* Thiết lập thời gian chuyển động của animation */
        pacman.start();
        /* Tạo Ghost với tọa độ ban đầu*/
        blinky = new Blinky(Constant.GHOST_START_POSITION_X, Constant.GHOST_START_POSITION_Y, Constant.BLINKY, pacman, board);
        inky = new Inky(Constant.GHOST_START_POSITION_X, Constant.GHOST_START_POSITION_Y, Constant.INKY, pacman, board);
    }

    /* Vẽ hình ảnh entities.Pacman */
    public void drawPacman(Graphics g) {
        if (pacman.getDirection() == Constant.RIGHT) {
            g.drawImage(pacman.getCurrentFrame().getImage(), pacman.getX(), pacman.getY(), null);
        } else if (pacman.getDirection() == Constant.LEFT) {
            g.drawImage(flipImage(pacman.getCurrentFrame().getImage()), pacman.getX(), pacman.getY(), null);
        } else if (pacman.getDirection() == Constant.UP) {
            g.drawImage(rotateImage(pacman.getCurrentFrame().getImage(), 270), pacman.getX(), pacman.getY(), null);
        } else if (pacman.getDirection() == Constant.DOWN) {
            g.drawImage(rotateImage(pacman.getCurrentFrame().getImage(), 90), pacman.getX(), pacman.getY(), null);
        }
    }

    /* Lật ảnh */
    public Image flipImage(Image image) {
        // Lật hình ảnh
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-image.getWidth(null), 0);
        BufferedImage flippedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = flippedImage.createGraphics();
        g.drawImage(image, tx, null);
        g.dispose();
        // Tạo ImageIcon mới từ hình ảnh đã lật
        return flippedImage;
    }

    /* Xoay ảnh */
    public Image rotateImage(Image image, double degree) {
        // Tạo ma trận biến đổi để xoay ảnh
        AffineTransform tx = AffineTransform.getRotateInstance(Math.toRadians(degree), image.getWidth(null) / 2.0, image.getHeight(null) / 2.0);
        // Tạo ảnh mới sau khi đã xoay
        BufferedImage rotatedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = rotatedImage.createGraphics();
        g.setTransform(tx);
        g.drawImage(image, 0, 0, null);
        g.dispose();
        // Trả về ảnh đã xoay
        return rotatedImage;
    }

    /* Kiểm tra các hướng có thể rẽ tại vị trí hiện tại */
    public boolean[] checkPosition(int x, int y) {
        boolean[] result = {false, false, false, false};
        /* Vị trí trung tâm của ảnh */
        int centerX = x + (Constant.PACMAN_SIZE / 2);
        int centerY = y + (Constant.PACMAN_SIZE / 2);
        /* Các điểm cần kiểm tra: trên, dưới, trái, phải */
        int deviation = 1; // Độ lệch 1px
        int pointLeftX = centerX - (Constant.TILE / 2) - deviation;
        int pointLeftY = centerY;
        int pointRightX = centerX + (Constant.TILE / 2) + deviation;
        int pointRightY = centerY;
        int pointUpX = centerX;
        int pointUpY = centerY - (Constant.TILE / 2) - deviation;
        int pointDownX = centerX;
        int pointDownY = centerY + (Constant.TILE / 2) + deviation;
        /* Kiểm tra đi thẳng */
        if (pacman.getDirection() == Constant.RIGHT && matrix[pointRightY / Constant.TILE][pointRightX / Constant.TILE] < 3) {
            result[Constant.RIGHT] = true;
        }
        if (pacman.getDirection() == Constant.LEFT && matrix[pointLeftY / Constant.TILE][pointLeftX / Constant.TILE] < 3) {
            result[Constant.LEFT] = true;
        }
        if (pacman.getDirection() == Constant.UP && matrix[pointUpY / Constant.TILE][pointUpX / Constant.TILE] < 3) {
            result[Constant.UP] = true;
        }
        if (pacman.getDirection() == Constant.DOWN && matrix[pointDownY / Constant.TILE][pointDownX / Constant.TILE] < 3) {
            result[Constant.DOWN] = true;
        }
        /* Kiểm tra quay đầu */
        if (pacman.getDirection() == Constant.RIGHT && matrix[pointLeftY / Constant.TILE][pointLeftX / Constant.TILE] < 3) {
            result[Constant.LEFT] = true;
        }
        if (pacman.getDirection() == Constant.LEFT && matrix[pointRightY / Constant.TILE][pointRightX / Constant.TILE] < 3) {
            result[Constant.RIGHT] = true;
        }
        if (pacman.getDirection() == Constant.UP && matrix[pointDownY / Constant.TILE][pointDownX / Constant.TILE] < 3) {
            result[Constant.DOWN] = true;
        }
        if (pacman.getDirection() == Constant.DOWN && matrix[pointUpY / Constant.TILE][pointUpX / Constant.TILE] < 3) {
            result[Constant.UP] = true;
        }
        /* Kiểm tra rẽ trái và phải */
        if (pacman.getDirection() == Constant.UP || pacman.getDirection() == Constant.DOWN) {
            if (centerY % Constant.TILE == (Constant.TILE / 2)) {
                if (matrix[pointLeftY / Constant.TILE][pointLeftX / Constant.TILE] < 3) {
                    result[Constant.LEFT] = true;
                }
                if (matrix[pointRightY / Constant.TILE][pointRightX / Constant.TILE] < 3) {
                    result[Constant.RIGHT] = true;
                }
            }
        }
        /* Kiểm tra rẽ lên và xuống */
        if (pacman.getDirection() == Constant.RIGHT || pacman.getDirection() == Constant.LEFT) {
            if (centerX % Constant.TILE == (Constant.TILE / 2)) {
                if (matrix[pointUpY / Constant.TILE][pointUpX / Constant.TILE] < 3) {
                    result[Constant.UP] = true;
                }
                if (matrix[pointDownY / Constant.TILE][pointDownX / Constant.TILE] < 3) {
                    result[Constant.DOWN] = true;
                }
            }
        }

//        System.out.print("Direction = " + direction + "  (" + x + "," + y + ")--(" + centerX + "," + centerY + ")  ");
//        System.out.print("LEFT: " + result[Constant.LEFT] + " - ");
//        System.out.print("RIGHT: " + result[Constant.RIGHT] + " - ");
//        System.out.print("UP: " + result[Constant.UP] + " - ");
//        System.out.print("DOWN: " + result[Constant.DOWN] + "\n");
        return result;
    }

    /* Cập nhật vị trí khi nhấn phím */
    public void updatePacmanDirection(Pacman pacman) {
        turnAllowed = checkPosition(pacman.getX(), pacman.getY());
        if (directionCommand == Constant.RIGHT && turnAllowed[Constant.RIGHT]) {
            pacman.setDirection(Constant.RIGHT);
        } else if (directionCommand == Constant.LEFT && turnAllowed[Constant.LEFT]) {
            pacman.setDirection(Constant.LEFT);
        } else if (directionCommand == Constant.UP && turnAllowed[Constant.UP]) {
            pacman.setDirection(Constant.UP);
        } else if (directionCommand == Constant.DOWN && turnAllowed[Constant.DOWN]) {
            pacman.setDirection(Constant.DOWN);
        }
    }

    /* Cập nhật vị trí của Pacman */
    public void updatePacmanPosition(Pacman pacman) {
        int x = pacman.getX();
        int y = pacman.getY();
        turnAllowed = checkPosition(x, y);
        if (pacman.getDirection() == Constant.RIGHT && turnAllowed[Constant.RIGHT]) {
            x += pacman.getPACMAN_SPEED();
            pacman.setX(x);
        } else if (pacman.getDirection() == Constant.LEFT && turnAllowed[Constant.LEFT]) {
            x -= pacman.getPACMAN_SPEED();
            pacman.setX(x);
        } else if (pacman.getDirection() == Constant.UP && turnAllowed[Constant.UP]) {
            y -= pacman.getPACMAN_SPEED();
            pacman.setY(y);
        } else if (pacman.getDirection() == Constant.DOWN && turnAllowed[Constant.DOWN]) {
            y += pacman.getPACMAN_SPEED();
            pacman.setY(y);
        }
//        else {
//            pacman.stopAnimation();
//        }
    }
    /* Cập nhật khi pacman ăn viên thuốc */
    public void updatePacmanCapsule(Pacman pacman){
        int deviation = 0; // Độ lệch
        /* Vị trí trung tâm của ảnh */
        int centerX = pacman.getX() + (Constant.PACMAN_SIZE / 2);
        int centerY = pacman.getY() + (Constant.PACMAN_SIZE / 2);
        if (pacman.getDirection() == Constant.LEFT || pacman.getDirection() == Constant.RIGHT) {
            if (centerX % Constant.TILE == (Constant.TILE / 2) - deviation || centerX % Constant.TILE == (Constant.TILE / 2) + deviation) {
                if (matrix[centerY / Constant.TILE][centerX / Constant.TILE] == Constant.CAPSULE) {
                    board.setNewValue(centerY / Constant.TILE, centerX / Constant.TILE, Constant.SPACE);
                    pacman.gainPoint(Constant.SCORE_CAPSULE);
                    blinky.getTimer().cancel();
                    blinky.setFearState();
                    inky.getTimer().cancel();
                    inky.setFearState();
                }
            }
        }
        if (pacman.getDirection() == Constant.UP || pacman.getDirection() == Constant.DOWN) {
            if (centerY % Constant.TILE == (Constant.TILE / 2) - deviation || centerY % Constant.TILE == (Constant.TILE / 2) + deviation) {
                if (matrix[centerY / Constant.TILE][centerX / Constant.TILE] == Constant.CAPSULE) {
                    board.setNewValue(centerY / Constant.TILE, centerX / Constant.TILE, Constant.SPACE);
                    pacman.gainPoint(Constant.SCORE_CAPSULE);
                    blinky.getTimer().cancel();
                    blinky.setFearState();
                    inky.getTimer().cancel();
                    inky.setFearState();
                }
            }
        }
    }
    /* Kiểm tra va chạm giữa pacman và ghost */
    public void checkCollision(Pacman pacman, Ghost ghost){
        if (Math.abs(pacman.getX() - ghost.getX()) < 20 && Math.abs(pacman.getY() - ghost.getY()) < 20 ){
            if (ghost.isFearState()){
                System.out.println("Pacman ăn ghost");
                ghost.setDeadState();
                pacman.gainPoint(Constant.SCORE_GHOST);
            }
            else if (!ghost.isFearState() && !ghost.isDeadState()){
                System.out.println("Ghost ăn pacman");
                if (pacman.getLife() > 0){
                    pacman.die();
                }
                else {
                    System.exit(0);
                }
            }
        }
    }

    /* Cập nhật điểm số của Pacman */
    public void updatePacmanScore(Pacman pacman) {
        int deviation = 0; // Độ lệch
        /* Vị trí trung tâm của ảnh */
        int centerX = pacman.getX() + (Constant.PACMAN_SIZE / 2);
        int centerY = pacman.getY() + (Constant.PACMAN_SIZE / 2);
        if (pacman.getDirection() == Constant.LEFT || pacman.getDirection() == Constant.RIGHT) {
            if (centerX % Constant.TILE == (Constant.TILE / 2) - deviation || centerX % Constant.TILE == (Constant.TILE / 2) + deviation) {
                if (matrix[centerY / Constant.TILE][centerX / Constant.TILE] == Constant.FOOD) {
                    board.setNewValue(centerY / Constant.TILE, centerX / Constant.TILE, Constant.SPACE);
                    pacman.gainPoint(Constant.SCORE_FOOD);
                }
            }
        }
        if (pacman.getDirection() == Constant.UP || pacman.getDirection() == Constant.DOWN) {
            if (centerY % Constant.TILE == (Constant.TILE / 2) - deviation || centerY % Constant.TILE == (Constant.TILE / 2) + deviation) {
                if (matrix[centerY / Constant.TILE][centerX / Constant.TILE] == Constant.FOOD) {
                    board.setNewValue(centerY / Constant.TILE, centerX / Constant.TILE, Constant.SPACE);
                    pacman.gainPoint(Constant.SCORE_FOOD);
                }
            }
        }
    }
    /* Kiểm tra điều kiện thắng */
    public void checkWin(){
        for (int i = 0; i < level.length ; i++) {
            for (int j = 0; j < level[0].length; j++) {
                if (level[i][j] == 1){
                    return;
                }
            }
        }
        System.exit(0);
    }

    /* Vẽ điểm số */
    public void drawScore(Graphics g) {
        g.setColor(Constant.TEXT_COLOR);
        g.setFont(Constant.TEXT_FONT);
        g.drawString("Score: " + pacman.getScore(), 30, (matrix.length * Constant.TILE) + 50);
    }

    /* Vẽ mạng */
    public void drawLife(Graphics g){
        g.setColor(Constant.TEXT_COLOR);
        g.setFont(Constant.TEXT_FONT);
        g.drawString("Life: " + pacman.getLife(), 200, (matrix.length * Constant.TILE) + 50);
    }

    /* Xử lý đầu vào từ người chơi */
    public void processInput() {

    }
    /* Vẽ đường đi của Ghost */
    public void drawGhostPath(Ghost ghost, Color color ,Graphics g) {
        ArrayList<int[]> path = ghost.getPath();
        for (int i = 0; i < path.size() - 1; i++) {
            int x1 = path.get(i)[1];
            int y1 = path.get(i)[0];
            int x2 = path.get(i + 1)[1];
            int y2 = path.get(i + 1)[0];
            g.setColor(color);
            g.drawLine(x1, y1, x2, y2);

        }
    }

    /* Dừng và tiếp tục trò chơi */
    public void togglePauseGame() {
        isPaused = !isPaused;
    }

    /* Cập nhật trạng thái cho trò chơi */
    public void updateGame() {
        if (!isPaused){
            updatePacmanDirection(pacman);
            updatePacmanPosition(pacman);
            updatePacmanCapsule(pacman);
            updatePacmanScore(pacman);
            checkCollision(pacman, blinky);
            checkCollision(pacman, inky);
            blinky.move();
            inky.move();
            checkWin();
        }
    }

    /* Kết xuất hình ảnh cho trò chơi */
    public void renderGame() {
        if (!isPaused){
            repaint();
        }
    }

    @Override
    /* Hàm này giúp hiển thị tất cả các hình ảnh có trong trò chơi */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        board.paintBoard(g);
        drawPacman(g);
        g.drawImage(blinky.getGhostImage().getImage(), blinky.getX(), blinky.getY(), null);
        g.drawImage(inky.getGhostImage().getImage(), inky.getX(), inky.getY(), null);
//        drawGhostPath(blinky, Color.RED ,g);
//        drawGhostPath(inky, Color.WHITE ,g);
        drawScore(g);
        drawLife(g);
//        board.paintGrid(g);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        /* Không sử dụng */
    }

    @Override
    /* Xử lý sự kiện khi phím được nhấn */
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                directionCommand = Constant.RIGHT;
                break;
            case KeyEvent.VK_LEFT:
                directionCommand = Constant.LEFT;
                break;
            case KeyEvent.VK_UP:
                directionCommand = Constant.UP;
                break;
            case KeyEvent.VK_DOWN:
                directionCommand = Constant.DOWN;
                break;
            case KeyEvent.VK_P: // Xử lý khi phím "p" được nhấn
                togglePauseGame(); // Gọi phương thức để thay đổi trạng thái dừng trò chơi
                break;
        }
    }

    @Override
    /* Xử lý sự kiện khi phím được nhả */
    public void keyReleased(KeyEvent e) {
//        directionCommand = -1;
    }
}
