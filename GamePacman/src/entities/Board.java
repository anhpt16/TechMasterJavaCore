package entities;

import utils.Constant;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private int[][] board;
    private final int SIZE_TILE = Constant.TILE;
    private final int SIZE_FOOD = 6;
    private final int SIZE_CAPSULE_POWER = 10;
    private final Color WALL_COLOR = Color.BLUE;
    private final Color GRID_COLOR = Color.PINK;
    private final Color FOOD_COLOR = Color.WHITE;
    private final Color CAPSULE_COLOR = Color.WHITE;
    private final Color GATE_COLOR = Color.WHITE;

    public Board(int[][] board) {
        this.board = board;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
    /* Thiết lập giá trị mới */
    public void setNewValue(int x, int y, int value){
        board[x][y] = value;
    }
    /* Vẽ grid cho bản đồ */
    public void paintGrid(Graphics g){
        for (int i = 0; i < board.length; i++) {
            g.setColor(GRID_COLOR);
            g.drawLine(0, i * (SIZE_TILE), (board[i].length) * SIZE_TILE, i * SIZE_TILE);
        }
        for (int i = 0; i < board[0].length; i++) {
            g.setColor(GRID_COLOR);
            g.drawLine(i * SIZE_TILE, 0, i * SIZE_TILE, (board.length) * SIZE_TILE);
        }
    }

    /* Vẽ bản đồ dựa trên Level */
    public void paintBoard(Graphics g){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == Constant.FOOD){
                    g.setColor(FOOD_COLOR);
                    g.fillOval((j * SIZE_TILE) + ((SIZE_TILE - SIZE_FOOD) / 2), (i * SIZE_TILE) + ((SIZE_TILE - SIZE_FOOD) / 2), SIZE_FOOD, SIZE_FOOD);
                }
                else if (board[i][j] == Constant.CAPSULE){
                    g.setColor(CAPSULE_COLOR);
                    g.fillOval((j * SIZE_TILE) + ((SIZE_TILE - SIZE_CAPSULE_POWER) / 2), (i * SIZE_TILE) + ((SIZE_TILE - SIZE_CAPSULE_POWER) / 2), SIZE_CAPSULE_POWER, SIZE_CAPSULE_POWER);
                }
                else if (board[i][j] == Constant.WALL_HORIZONTAL){
                    g.setColor(WALL_COLOR);
                    g.drawLine(j * SIZE_TILE, i * SIZE_TILE, (j + 1) * SIZE_TILE, i * SIZE_TILE);
                    g.drawLine(j * SIZE_TILE, (i + 1) * SIZE_TILE, (j + 1) * SIZE_TILE, (i + 1) * SIZE_TILE);
                }
                else if (board[i][j] == Constant.WALL_VERTICAL){
                    g.setColor(WALL_COLOR);
                    g.drawLine(j * SIZE_TILE, i * SIZE_TILE, j * SIZE_TILE, (i + 1) * SIZE_TILE);
                    g.drawLine((j + 1) * SIZE_TILE, i * SIZE_TILE, (j + 1) * SIZE_TILE, (i + 1) * SIZE_TILE);
                }
                else if (board[i][j] == Constant.WALL_TOPRIGHT){
                    g.setColor(WALL_COLOR);
                    g.drawLine(j * SIZE_TILE, i * SIZE_TILE, (j * SIZE_TILE + (SIZE_TILE / 2)), i * SIZE_TILE);
                    g.drawLine((j + 1) * SIZE_TILE, (i * SIZE_TILE + (SIZE_TILE / 2)), (j + 1) * SIZE_TILE, (i + 1) * SIZE_TILE);
                    g.drawArc(j * SIZE_TILE, i * SIZE_TILE, SIZE_TILE, SIZE_TILE, 360, 90);
                }
                else if (board[i][j] == Constant.WALL_TOPLEFT){
                    g.setColor(WALL_COLOR);
                    g.drawLine(j * SIZE_TILE, (i * SIZE_TILE + (SIZE_TILE / 2)), j * SIZE_TILE, (i + 1) * SIZE_TILE);
                    g.drawLine((j * SIZE_TILE + (SIZE_TILE / 2)), i * SIZE_TILE, (j + 1) * SIZE_TILE, i * SIZE_TILE);
                    g.drawArc(j * SIZE_TILE, i * SIZE_TILE, SIZE_TILE, SIZE_TILE, 90, 90);
                }
                else if (board[i][j] == Constant.WALL_BOTLEFT){
                    g.setColor(WALL_COLOR);
                    g.drawLine(j * SIZE_TILE, i * SIZE_TILE, j * SIZE_TILE, (i * SIZE_TILE + (SIZE_TILE / 2)));
                    g.drawLine((j * SIZE_TILE + (SIZE_TILE / 2)), (i + 1) * SIZE_TILE, (j + 1) * SIZE_TILE, (i + 1) * SIZE_TILE);
                    g.drawArc(j * SIZE_TILE, i * SIZE_TILE, SIZE_TILE, SIZE_TILE, 180, 90);
                }
                else if (board[i][j] == Constant.WALL_BOTRIGHT){
                    g.setColor(WALL_COLOR);
                    g.drawLine(j * SIZE_TILE, (i + 1) * SIZE_TILE, (j * SIZE_TILE + (SIZE_TILE / 2)), (i + 1) * SIZE_TILE);
                    g.drawLine((j + 1) * SIZE_TILE, i * SIZE_TILE, (j + 1) * SIZE_TILE, (i * SIZE_TILE + (SIZE_TILE / 2)));
                    g.drawArc(j * SIZE_TILE, i * SIZE_TILE, SIZE_TILE, SIZE_TILE, 270, 90);
                }
                else if (board[i][j] == Constant.GATE){
                    g.setColor(GATE_COLOR);
                    g.drawLine(j * SIZE_TILE, (i * SIZE_TILE) + (SIZE_TILE / 2), (j + 1) * SIZE_TILE, (i * SIZE_TILE) + (SIZE_TILE / 2));
                }
            }
        }
    }

}
