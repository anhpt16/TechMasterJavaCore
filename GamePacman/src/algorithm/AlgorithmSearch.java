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
        /* Các điểm giới hạn khi duyệt ma trận */
        int topPoint = indexPacX - 4;
        int bottomPoint = indexPacX + 4;
        int rightPoint = indexPacY + 4;
        int leftPoint = indexPacY - 4;
        if (topPoint < 0){
            topPoint = 0;
        }
        if (bottomPoint > (matrix.length - 1)){
            bottomPoint = matrix.length - 1;
        }
        if (rightPoint > (matrix[0].length - 1)){
            rightPoint = matrix[0].length - 1;
        }
        if (leftPoint < 0){
            leftPoint = 0;
        }
        /* Tìm vị trí dựa trên hướng di chuyển của Pacman */
        if (pacman.getDirection() == Constant.RIGHT){
            for (int i = indexPacX + 4; i >= indexPacX; i--) {

                if (matrix[i][indexPacY] < 3){
                    result[0] = (indexPacX * Constant.TILE) + ((Constant.TILE - Constant.PACMAN_SIZE) / 2);
                    result[1] = (i * Constant.TILE) + ((Constant.TILE - Constant.PACMAN_SIZE) / 2);
                }
            }
        }
        else if (pacman.getDirection() == Constant.LEFT){
            for (int i = indexPacY - 4; i >= indexPacY; i--) {
                if (matrix[indexPacX][i] < 3){
                    result[0] = (i * Constant.TILE) + ((Constant.TILE - Constant.PACMAN_SIZE) / 2);
                    result[1] = (indexPacX * Constant.TILE) + ((Constant.TILE - Constant.PACMAN_SIZE) / 2);
                }
            }
        }
        else if (pacman.getDirection() == Constant.UP){

        }
        else if (pacman.getDirection() == Constant.DOWN){

        }
        return result;
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
