import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends JPanel {
    BufferedImage[] imagePlayer;
    Timer timer;
    int currentIndex;
    Graphics g;

    public Main() {
        setPreferredSize(new Dimension(600, 660));
        setBackground(Color.BLACK);

        imagePlayer = new BufferedImage[4];
        for (int i = 0; i < 4; i++) {
            imagePlayer[i] = loadImage("F:\\TechMasterJavaCore\\testMap\\src\\Images\\" + i + ".png");
        }
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentIndex = (currentIndex + 1) % imagePlayer.length;
                repaint();
            }
        });
        timer.start();
    }

    BufferedImage loadImage(String fileImage){
        try {
            // Load image from file
            return ImageIO.read(new File(fileImage));
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
            return null;
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[][] board = {
                {6, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5},
                {3, 6, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 6, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 3},
                {3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3},
                {3, 3, 1, 6, 4, 4, 5, 1, 6, 4, 4, 4, 5, 1, 3, 3, 1, 6, 4, 4, 4, 5, 1, 6, 4, 4, 5, 1, 3, 3},
                {3, 3, 2, 3, 0, 0, 3, 1, 3, 0, 0, 0, 3, 1, 3, 3, 1, 3, 0, 0, 0, 3, 1, 3, 0, 0, 3, 2, 3, 3},
                {3, 3, 1, 7, 4, 4, 8, 1, 7, 4, 4, 4, 8, 1, 7, 8, 1, 7, 4, 4, 4, 8, 1, 7, 4, 4, 8, 1, 3, 3},
                {3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3},
                {3, 3, 1, 6, 4, 4, 5, 1, 6, 5, 1, 6, 4, 4, 4, 4, 4, 4, 5, 1, 6, 5, 1, 6, 4, 4, 5, 1, 3, 3},
                {3, 3, 1, 7, 4, 4, 8, 1, 3, 3, 1, 7, 4, 4, 5, 6, 4, 4, 8, 1, 3, 3, 1, 7, 4, 4, 8, 1, 3, 3},
                {3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 1, 1, 1, 1, 3, 3, 1, 1, 1, 1, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3},
                {3, 7, 4, 4, 4, 4, 5, 1, 3, 7, 4, 4, 5, 0, 3, 3, 0, 6, 4, 4, 8, 3, 1, 6, 4, 4, 4, 4, 8, 3},
                {3, 0, 0, 0, 0, 0, 3, 1, 3, 6, 4, 4, 8, 0, 7, 8, 0, 7, 4, 4, 5, 3, 1, 3, 0, 0, 0, 0, 0, 3},
                {3, 0, 0, 0, 0, 0, 3, 1, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 1, 3, 0, 0, 0, 0, 0, 3},
                {8, 0, 0, 0, 0, 0, 3, 1, 3, 3, 0, 6, 4, 4, 9, 9, 4, 4, 5, 0, 3, 3, 1, 3, 0, 0, 0, 0, 0, 7},
                {4, 4, 4, 4, 4, 4, 8, 1, 7, 8, 0, 3, 0, 0, 0, 0, 0, 0, 3, 0, 7, 8, 1, 7, 4, 4, 4, 4, 4, 4},
                {0, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0},
                {4, 4, 4, 4, 4, 4, 5, 1, 6, 5, 0, 3, 0, 0, 0, 0, 0, 0, 3, 0, 6, 5, 1, 6, 4, 4, 4, 4, 4, 4},
                {5, 0, 0, 0, 0, 0, 3, 1, 3, 3, 0, 7, 4, 4, 4, 4, 4, 4, 8, 0, 3, 3, 1, 3, 0, 0, 0, 0, 0, 6},
                {3, 0, 0, 0, 0, 0, 3, 1, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 1, 3, 0, 0, 0, 0, 0, 3},
                {3, 0, 0, 0, 0, 0, 3, 1, 3, 3, 0, 6, 4, 4, 4, 4, 4, 4, 5, 0, 3, 3, 1, 3, 0, 0, 0, 0, 0, 3},
                {3, 6, 4, 4, 4, 4, 8, 1, 7, 8, 0, 7, 4, 4, 5, 6, 4, 4, 8, 0, 7, 8, 1, 7, 4, 4, 4, 4, 5, 3},
                {3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3},
                {3, 3, 1, 6, 4, 4, 5, 1, 6, 4, 4, 4, 5, 1, 3, 3, 1, 6, 4, 4, 4, 5, 1, 6, 4, 4, 5, 1, 3, 3},
                {3, 3, 1, 7, 4, 5, 3, 1, 7, 4, 4, 4, 8, 1, 7, 8, 1, 7, 4, 4, 4, 8, 1, 3, 6, 4, 8, 1, 3, 3},
                {3, 3, 2, 1, 1, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 1, 1, 2, 3, 3},
                {3, 7, 4, 5, 1, 3, 3, 1, 6, 5, 1, 6, 4, 4, 4, 4, 4, 4, 5, 1, 6, 5, 1, 3, 3, 1, 6, 4, 8, 3},
                {3, 6, 4, 8, 1, 7, 8, 1, 3, 3, 1, 7, 4, 4, 5, 6, 4, 4, 8, 1, 3, 3, 1, 7, 8, 1, 7, 4, 5, 3},
                {3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 1, 1, 1, 1, 3, 3, 1, 1, 1, 1, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3},
                {3, 3, 1, 6, 4, 4, 4, 4, 8, 7, 4, 4, 5, 1, 3, 3, 1, 6, 4, 4, 8, 7, 4, 4, 4, 4, 5, 1, 3, 3},
                {3, 3, 1, 7, 4, 4, 4, 4, 4, 4, 4, 4, 8, 1, 7, 8, 1, 7, 4, 4, 4, 4, 4, 4, 4, 4, 8, 1, 3, 3},
                {3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3},
                {3, 7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8, 3},
                {7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8}
        };
        for (int i = 0; i < board.length; i++) {
            g.setColor(Color.RED);
            g.drawLine(0, i * 20, (board[i].length) * 20, i * 20);
        }
        for (int i = 0; i < board[0].length; i++) {
            g.setColor(Color.RED);
            g.drawLine(i * 20, 0, i * 20, (board.length) * 20);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1){
                    g.setColor(Color.WHITE);
                    g.fillOval((j * 20) + 6, (i * 20) + 6, 8, 8);
                }
                else if (board[i][j] == 2){
                    g.setColor(Color.WHITE);
                    g.fillOval((j * 20) + 1, (i * 20) + 1, 18, 18);
                }
                else if (board[i][j] == 4){
                    g.setColor(Color.BLUE);
                    g.drawLine(j * 20, (i * 20) + 10, (j + 1) * 20, (i * 20) + 10);
                }
                else if (board[i][j] == 3){
                    g.setColor(Color.BLUE);
                    g.drawLine((j * 20) + 10, (i * 20), (j * 20) + 10, (i + 1) * 20);

                }
                else if (board[i][j] == 5){
                    g.setColor(Color.BLUE);
                    g.drawArc((j * 20) - 10, (i * 20) + 10, 20, 20, 360, 90);
                }
                else if (board[i][j] == 6){
                    g.setColor(Color.BLUE);
                    g.drawArc((j * 20) + 10, (i * 20) + 10, 20, 20, 90, 90);
                }
                else if (board[i][j] == 7){
                    g.setColor(Color.BLUE);
                    g.drawArc((j * 20) + 10, (i * 20) - 10, 20, 20, 180, 90);
                }
                else if (board[i][j] == 8){
                    g.setColor(Color.BLUE);
                    g.drawArc((j * 20) - 10, (i * 20) - 10, 20, 20, 270, 90);
                }
                else if (board[i][j] == 9){
                    g.setColor(Color.white);
                    g.drawLine(j * 20, (i * 20) + 10, (j + 1) * 20, (i * 20) + 10);
                }
            }
        }
//        if (imagePlayer[currentIndex] != null) {
//            g.drawImage(imagePlayer[currentIndex], 40, 40, this);
//        }
        g.drawImage(imagePlayer[currentIndex], 40, 40, this);

    }


    public static void main(String[] args) {
        /*
        0 : đường đi
        1 : đồ ăn
        2 : viên sức mạnh
        3 : đường dọc
        4 : đường ngang
        5 : đường trên phải
        6 : đường trên trái
        7 : đường dưới trái
        8 : đường dưới phải
        9 : cổng hồi sinh
        */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 800);
                Main panel = new Main();
                frame.add(panel);
                frame.setVisible(true);
            }
        });
    }
}
