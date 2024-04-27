package algorithm;

import entities.Pacman;
import utils.Constant;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class AlgorithmSearch {
    private int[][] matrix;

    public AlgorithmSearch(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[] searchFourthPoint(Pacman pacman) {
        int[] result = new int[2];
        /* Vị trí hiện tại của Pacman trong ma trận */
        int indexPacX = (pacman.getY() - ((Constant.TILE - Constant.PACMAN_SIZE) / 2)) / Constant.TILE; //--> hàng
        int indexPacY = (pacman.getX() - ((Constant.TILE - Constant.PACMAN_SIZE) / 2)) / Constant.TILE; //--> cột
        /* Tìm vị trí dựa trên hướng di chuyển của Pacman */
        if (pacman.getDirection() == Constant.RIGHT){
            for (int i = 0; i <= 4; i++) {
                if ((indexPacX - i) >= 0 && (indexPacX - i) <= (matrix.length - 1) && (indexPacY + 4 - i) >= 0  && (indexPacY + 4 - i) <= (matrix[0].length - 1)){
                    if (matrix[indexPacX - i][indexPacY + 4 - i] < 3){
                        result[0] = ((indexPacY + 4 - i) * Constant.TILE) + ((Constant.TILE - Constant.GHOST_SIZE) / 2);
                        result[1] = ((indexPacX - i) * Constant.TILE) + ((Constant.TILE - Constant.GHOST_SIZE) / 2);
                        return result;
                    }
                }
                if ((indexPacX + i) <= (matrix.length - 1) && (indexPacX + i) >= 0 && (indexPacY + 4 - i) < (matrix[0].length - 1) && (indexPacY + 4 - i) >= 0){
                    if (matrix[indexPacX + 1][indexPacY + 4 - i] < 3){
                        result[0] = ((indexPacY + 4 - i) * Constant.TILE) + ((Constant.TILE - Constant.GHOST_SIZE) / 2);
                        result[1] = ((indexPacX + 1) * Constant.TILE) + ((Constant.TILE - Constant.GHOST_SIZE) / 2);
                        return result;
                    }
                }
            }
        }
        else if (pacman.getDirection() == Constant.LEFT){
            for (int i = 0; i <= 4; i++) {
                if ((indexPacX - i) >= 0 && (indexPacX - i) <= (matrix.length - 1) && (indexPacY - 4 + i) <= (matrix[0].length - 1) && (indexPacY - 4 + i) >= 0){
                    if (matrix[indexPacX - i][indexPacY - 4 + i] < 3){
                        result[0] = ((indexPacY - 4 + i) * Constant.TILE) + ((Constant.TILE - Constant.GHOST_SIZE) / 2);
                        result[1] = ((indexPacX - i) * Constant.TILE) + ((Constant.TILE - Constant.GHOST_SIZE) / 2);
                        return result;
                    }
                }
                if ((indexPacX + i) >= 0 && (indexPacX + i) <= (matrix.length - 1) && (indexPacY - 4 + i) >= 0 && (indexPacY - 4 + i) <= (matrix[0].length - 1)){
                    if (matrix[indexPacX + i][indexPacY - 4 + i] < 3){
                        result[0] = ((indexPacY - 4 + i) * Constant.TILE) + ((Constant.TILE - Constant.GHOST_SIZE) / 2);
                        result[1] = ((indexPacX + i) * Constant.TILE) + ((Constant.TILE - Constant.GHOST_SIZE) / 2);
                        return result;
                    }
                }
            }
        }
        else if (pacman.getDirection() == Constant.UP){
            for (int i = 0; i <= 4; i++) {
                if ((indexPacX - 4 + i) >= 0 && (indexPacX - 4 + i) <= (matrix.length - 1) && (indexPacY - i) >= 0 && (indexPacY - i) <= (matrix[0].length - 1)){
                    if (matrix[indexPacX - 4 + i][indexPacY - i] < 3){
                        result[0] = ((indexPacY - i) * Constant.TILE) + ((Constant.TILE - Constant.GHOST_SIZE) / 2);
                        result[1] = ((indexPacX - 4 + i) * Constant.TILE) + ((Constant.TILE - Constant.GHOST_SIZE) / 2);
                        return result;
                    }
                }
                if ((indexPacX - 4 + i) >= 0 && (indexPacX - 4 + i) <= (matrix.length - 1) && (indexPacY + i) >= 0 && (indexPacY + i) <= (matrix[0].length - 1)){
                    if (matrix[indexPacX - 4 + i][indexPacY + i] < 3){
                        result[0] = ((indexPacY + i) * Constant.TILE) + ((Constant.TILE - Constant.GHOST_SIZE) / 2);
                        result[1] = ((indexPacX - 4 + i) * Constant.TILE) + ((Constant.TILE - Constant.GHOST_SIZE) / 2);
                        return result;
                    }
                }
            }
        }
        else if (pacman.getDirection() == Constant.DOWN){
            for (int i = 0; i <= 4; i++) {
                if ((indexPacX + 4 - i) >= 0 && (indexPacX + 4 - i) <= (matrix.length - 1) && (indexPacY - i) >= 0 && (indexPacY - i) <= (matrix[0].length - 1)){
                    if (matrix[indexPacX + 4 - i][indexPacY - i] < 3){
                        result[0] = ((indexPacY - i) * Constant.TILE) + ((Constant.TILE - Constant.GHOST_SIZE) / 2);
                        result[1] = ((indexPacX + 4 - i) * Constant.TILE) + ((Constant.TILE - Constant.GHOST_SIZE) / 2);
                        return result;
                    }
                }
                if ((indexPacX + 4 - i) >= 0 && (indexPacX + 4 - i) <= (matrix.length - 1) && (indexPacY + i) >= 0 && (indexPacY + i) <= (matrix[0].length - 1)){
                    if (matrix[indexPacX + 4 - i][indexPacY + i] < 3){
                        result[0] = ((indexPacY + i) * Constant.TILE) + ((Constant.TILE - Constant.GHOST_SIZE) / 2);
                        result[1] = ((indexPacX + 4 - i) * Constant.TILE) + ((Constant.TILE - Constant.GHOST_SIZE) / 2);
                        return result;
                    }
                }
            }
        }
        return null;
    }

    public int[] searchAroundPoint(Pacman pacman, int count){
        /* Bước 1: Chuyển tọa độ vector sang chỉ số trong ma trận */
        int indexY = ((pacman.getX() + (Constant.PACMAN_SIZE / 2)) / Constant.TILE);
        int indexX = ((pacman.getY() + (Constant.PACMAN_SIZE / 2)) / Constant.TILE);
        /* Đưa ra chỉ số hợp lệ dựa vào vị trí hiện tại trong ma trận */
        int indexHighestY = matrix.length;
        int indexHighestX = matrix[0].length;
        /* Đưa ra cột và hàng bắt đầu đến kết thúc duyệt */
        int indexStartX = indexX - count;
        int indexStartY = indexY - count;
        int indexEndX = indexX + count;
        int indexEndY = indexY + count;

        if (indexStartX < 0){
            indexStartX = 0;
        }
        else if (indexEndX > indexHighestX){
            indexEndX = matrix.length - 1;
        }
        if (indexStartY < 0){
            indexStartY = 0;
        }
        else if (indexEndY > indexHighestY){
            indexEndY = matrix[0].length - 1;
        }
        /* Tạo một list để lưu trữ các điểm hợp lệ */
        ArrayList<int[]> listPoint = new ArrayList<>();
        /* Bước 2: Duyệt vào chọn ra các điểm hợp lệ */
        for (int i = indexStartX; i < indexEndX; i++) {
            for (int j = indexStartY; j < indexEndY; j++) {
                if (matrix[i][j] < 3){
                    listPoint.add(new int[]{i, j});
                }
            }
        }
        for (int[] point : listPoint){
            System.out.println("X: " + point[0] + ", Y: " + point[1]);
        }
        if (!listPoint.isEmpty()){
            /* Bước 3: Lấy ngẫu nhiên một điểm có trong list */
            Random random = new Random();
            int randomIndex = random.nextInt(listPoint.size());
            int[] randomPoint = listPoint.get(randomIndex);
            /* Chuyển điểm hiện tại về vector */
            randomPoint[0] = ((randomPoint[0] * Constant.TILE) + (Constant.TILE / 2) - (Constant.GHOST_SIZE / 2));
            randomPoint[1] = ((randomPoint[1] * Constant.TILE) + (Constant.TILE / 2) - (Constant.GHOST_SIZE / 2));
            /* Chuyển về theo theo thứ tự của vector */
            int temp = randomPoint[0];
            randomPoint[0] = randomPoint[1];
            randomPoint[1] = temp;
            return randomPoint;
        }
        else {
            return null;
        }
    }

    public static void main(String[] args) {
        Pacman pacman = new Pacman(242, 50, Constant.PACMAN_ANIMATION);
        AlgorithmSearch algorithmSearch = new AlgorithmSearch(Constant.BOARD_LEVEL_1);
        algorithmSearch.searchFourthPoint(pacman);
    }
}
