package algorithm;

import entities.Ghost;
import utils.Constant;

import java.util.ArrayList;
import java.util.Collections;

public class AStar {
    private int[][] matrix;

    public AStar(int[][] matrix) {
        this.matrix = matrix;
    }

    /* Tìm kiếm các node kề với node xét, đưa ra các thông số của các node kề xo với node đích */
    public ArrayList<int[]> searchNode(int pointX, int pointY, int targetX, int targetY, int g0){
        /* Các biến sử dụng */
        int g, h, f;
        ArrayList<int[]> listNode = new ArrayList<>();
        if ((pointX + 1) >= 0 && (pointX + 1) <= (matrix.length - 1) && pointY >= 0 && pointY <= (matrix[0].length - 1)){
            if (matrix[pointX + 1][pointY] < 3){
                g = 1 + g0;
                h = Math.abs(targetX - (pointX + 1)) + Math.abs(targetY - pointY);
                f = g + h;
//            System.out.println("[" + (pointX + 1) + "][" + pointY + "]\t" + "g: " + g + ", h: " + h + " ,f: " + f);
                listNode.add(new int[]{pointX + 1, pointY, g, h, f, pointX, pointY});
            }
        }
        if ((pointX - 1) >= 0 && (pointX - 1) <= (matrix.length - 1) && pointY >= 0 && pointY <= (matrix[0].length - 1)){
            if (matrix[pointX - 1][pointY] < 3){
                g = 1 + g0;
                h = Math.abs(targetX - (pointX - 1)) + Math.abs(targetY - pointY);
                f = g + h;
//            System.out.println("[" + (pointX - 1) + "][" + pointY + "]\t" + "g: " + g + ", h: " + h + " ,f: " + f);
                listNode.add(new int[]{pointX - 1, pointY, g, h, f, pointX, pointY});
            }
        }
        if (pointX >= 0 && pointX <= (matrix.length - 1) && (pointY + 1) >= 0 && (pointY + 1) <= (matrix[0].length - 1)){
            if (matrix[pointX][pointY + 1] < 3){
                g = 1 + g0;
                h = Math.abs(targetX - pointX) + Math.abs(targetY - (pointY + 1));
                f = g + h;
//            System.out.println("[" + pointX + "][" + (pointY + 1) + "]\t" + "g: " + g + ", h: " + h + " ,f: " + f);
                listNode.add(new int[]{pointX, pointY + 1, g, h, f, pointX, pointY});
            }
        }
        if (pointX >= 0 && pointX <= (matrix.length - 1) && (pointY - 1) >= 0 && (pointY - 1) <= (matrix[0].length - 1)){
            if (matrix[pointX][pointY - 1] < 3){
                g = 1 + g0;
                h = Math.abs(targetX - pointX) + Math.abs(targetY - (pointY - 1));
                f = g + h;
//            System.out.println("[" + pointX + "][" + (pointY - 1) + "]\t" + "g: " + g + ", h: " + h + " ,f: " + f);
                listNode.add(new int[]{pointX, pointY - 1, g, h, f, pointX, pointY});
            }
        }

        return listNode;
    }

    public ArrayList<int[]> searchPath(int ghostX, int ghostY, int pacmanX, int pacmanY){
        /* Chuyển đổi tọa độ sang chỉ số trong ma trận */
        /*
        * vector: (X, Y) --> index: [Y/size][X/size]
        * */
        int indexGhostX = (ghostY - ((Constant.TILE - Constant.GHOST_SIZE) / 2)) / Constant.TILE;
        int indexGhostY = (ghostX - ((Constant.TILE - Constant.GHOST_SIZE) / 2)) / Constant.TILE;
        int indexPacmanX = (pacmanY - ((Constant.TILE - Constant.GHOST_SIZE) / 2)) / Constant.TILE;
        int indexPacmanY = (pacmanX - ((Constant.TILE - Constant.GHOST_SIZE) / 2)) / Constant.TILE;
        /* Các danh sách sử dụng */
        ArrayList<int[]> bestPath = new ArrayList<>();
        ArrayList<int[]> visitedNodes = new ArrayList<>();
        ArrayList<int[]> openNodes = new ArrayList<>();
        int g0 = 0;
        int h0 = Math.abs(indexPacmanX - indexGhostX) + Math.abs(indexPacmanY - indexGhostY);
        int f0 = h0; // (g0 + h0)
        openNodes.add(new int[]{indexGhostX, indexGhostY, g0, h0, f0, indexGhostX, indexGhostY});
        while (!openNodes.isEmpty()){
            int[] currentNode = getNodeMinFInList(openNodes);
            if (currentNode[0] == indexPacmanX && currentNode[1] == indexPacmanY){
//                System.out.println("Search Completed !");
                visitedNodes.add(currentNode);
                break;
            }
            else {
                g0 = currentNode[2];
                ArrayList<int[]> neighborNodes = searchNode(currentNode[0], currentNode[1], indexPacmanX, indexPacmanY, g0);
                visitedNodes.add(currentNode);
                for (int i = 0; i < neighborNodes.size(); i++){
                    isNodeInList(neighborNodes.get(i), openNodes, visitedNodes);
                }
                openNodes.remove(currentNode);
            }
        }
        /* Thêm node đích là node cuối cùng của đường đi tốt nhất sau đó thêm lần lượt các node là cha của con từ dưới lên */
        bestPath.add(visitedNodes.get(visitedNodes.size() - 1));
        int x = 0;
        for (int i = visitedNodes.size() - 1; i >= 0; i--) {
            if (visitedNodes.get(i)[0] == bestPath.get(x)[5] && visitedNodes.get(i)[1] == bestPath.get(x)[6]) {
                bestPath.add(visitedNodes.get(i));
                x++;
            }
        }
        Collections.reverse(bestPath);
//        for (int[] node : bestPath) {
//            System.out.println("Node: (" + node[0] + ", " + node[1] + ")");
//            System.out.println("g: " + node[2]);
//            System.out.println("h: " + node[3]);
//            System.out.println("f: " + node[4]);
//            System.out.println("Parent: (" + node[5] + ", " + node[6] + ")");
//            System.out.println("------------------------------");
//        }
        return bestPath;
    }

    public ArrayList<int[]> searchPath(Ghost ghost, int pacmanX, int pacmanY){
        /* Chuyển đổi tọa độ sang chỉ số trong ma trận */
        /*
         * vector: (X, Y) --> index: [Y/size][X/size]
         * */
        int indexGhostX = (ghost.getY() - ((Constant.TILE - Constant.GHOST_SIZE) / 2)) / Constant.TILE;
        int indexGhostY = (ghost.getX() - ((Constant.TILE - Constant.GHOST_SIZE) / 2)) / Constant.TILE;
        int indexPacmanX = (pacmanY - ((Constant.TILE - Constant.GHOST_SIZE) / 2)) / Constant.TILE;
        int indexPacmanY = (pacmanX - ((Constant.TILE - Constant.GHOST_SIZE) / 2)) / Constant.TILE;
        /* Các biến sử dụng */
        ArrayList<int[]> bestPath = new ArrayList<>();
        ArrayList<int[]> visitedNodes = new ArrayList<>();
        ArrayList<int[]> openNodes = new ArrayList<>();
        int g0 = 0;
        int h0 = Math.abs(indexPacmanX - indexGhostX) + Math.abs(indexPacmanY - indexGhostY);
        int f0 = h0; // (g0 + h0)
        openNodes.add(new int[]{indexGhostX, indexGhostY, g0, h0, f0, indexGhostX, indexGhostY});
        /* Thêm vào node hiện tại */
        ghost.addNodeBack(new int[]{indexGhostX, indexGhostY});
        /* Loại bỏ node quay đầu */
        int[] nodeBack;
        nodeBack = ghost.getNodeBack();
        if (nodeBack != null){
            visitedNodes.add(nodeBack);
        }
//        int hBack;
//        if (direction == Constant.RIGHT && matrix[indexGhostX][indexGhostY - 1] < 3){
//            hBack = Math.abs(indexPacmanX - indexGhostX) + Math.abs(indexPacmanY - indexGhostY -1);
//            visitedNodes.add(new int[]{indexGhostX, indexGhostY - 1, 1, hBack, hBack + 1, indexGhostX, indexGhostY});
//        }
//        else if (direction == Constant.LEFT && matrix[indexGhostX][indexGhostY + 1] < 3){
//            hBack = Math.abs(indexPacmanX - indexGhostX) + Math.abs(indexPacmanY - indexGhostY + 1);
//            visitedNodes.add(new int[]{indexGhostX, indexGhostY + 1, 1, hBack, hBack + 1, indexGhostX, indexGhostY});
//        }
//        else if (direction == Constant.UP && matrix[indexGhostX + 1][indexGhostY] < 3){
//            hBack = Math.abs(indexPacmanX - indexGhostX + 1) + Math.abs(indexPacmanY - indexGhostY);
//            visitedNodes.add(new int[]{indexGhostX + 1, indexGhostY, 1, hBack, hBack + 1, indexGhostX, indexGhostY});
//        }
//        else if (direction == Constant.DOWN && matrix[indexGhostX - 1][indexGhostY] < 3){
//            hBack = Math.abs(indexPacmanX - indexGhostX - 1) + Math.abs(indexPacmanY - indexGhostY);
//            visitedNodes.add(new int[]{indexGhostX - 1, indexGhostY, 1, hBack, hBack + 1, indexGhostX, indexGhostY});
//        }
        /* Tìm đường đi */
        while (!openNodes.isEmpty()){
            int[] currentNode = getNodeMinFInList(openNodes);
            if (currentNode[0] == indexPacmanX && currentNode[1] == indexPacmanY){
//                System.out.println("Search Completed !");
                visitedNodes.add(currentNode);
                break;
            }
            else {
                g0 = currentNode[2];
                ArrayList<int[]> neighborNodes = searchNode(currentNode[0], currentNode[1], indexPacmanX, indexPacmanY, g0);
                visitedNodes.add(currentNode);
                for (int i = 0; i < neighborNodes.size(); i++){
                    isNodeInList(neighborNodes.get(i), openNodes, visitedNodes);
                }
                openNodes.remove(currentNode);
            }
        }
        /* Thêm node đích là node cuối cùng của đường đi tốt nhất sau đó thêm lần lượt các node là cha của con từ dưới lên */
        bestPath.add(visitedNodes.get(visitedNodes.size() - 1));
        int x = 0;
        for (int i = visitedNodes.size() - 1; i >= 0; i--) {
            if (visitedNodes.get(i)[0] == bestPath.get(x)[5] && visitedNodes.get(i)[1] == bestPath.get(x)[6]) {
                bestPath.add(visitedNodes.get(i));
                x++;
            }
        }
        Collections.reverse(bestPath);
//        for (int[] node : bestPath) {
//            System.out.println("Node: (" + node[0] + ", " + node[1] + ")");
//            System.out.println("g: " + node[2]);
//            System.out.println("h: " + node[3]);
//            System.out.println("f: " + node[4]);
//            System.out.println("Parent: (" + node[5] + ", " + node[6] + ")");
//            System.out.println("------------------------------");
//        }
        return bestPath;
    }

    /* Trả về phần tử có giá trị f nhỏ nhất trong list */
    public int[] getNodeMinFInList(ArrayList<int[]> listNode){
        int[] minNode = listNode.get(0);
        int minF = minNode[4];
        for (int[] node : listNode){
            if (node[4] < minF){
                minNode = node;
                minF = node[4];
            }
        }
        return minNode;
    }

    /*
    Kiểm tra xem node có trong tập đóng hay không, nếu có thì kết thúc hàm
    Kiểm tra xem node có ở trong tập mở hay không hay không, nếu có thì so sánh và chọn ra node có giá trị g nhỏ hơn và đưa và thay thế node ở trong list
    Nếu node không có cả trong tập đóng và tập mở thì thêm node đó vào tập mở
    */
    public void isNodeInList(int[] nodeInput, ArrayList<int[]> openNodes, ArrayList<int[]> visitedNodes){
        for (int i = 0; i < visitedNodes.size(); i++) {
            int[] node = visitedNodes.get(i);
            if (node[0] == nodeInput[0] && node[1] == nodeInput[1]){
                return;
            }
        }
        for (int i = 0; i < openNodes.size(); i++) {
            int[] node = openNodes.get(i);
            if (node[0] == nodeInput[0] && node[1] == nodeInput[1] && nodeInput[2] < node[2]) {
                openNodes.set(i, nodeInput); // Thay đổi giá trị của phần tử trong danh sách
                return;
            }
        }
        openNodes.add(nodeInput);
    }

    public static void main(String[] args) {
        AStar aStar = new AStar(Constant.BOARD_LEVEL_1);
        /* Kiểm tra node tại vị trí (50, 50) */
//        aStar.searchNode(60, 60, 324, 60, 0);
        /* kiểm tra đường dẫn tốt nhất từ vị trí (50, 50) đến (218, 650) */
        aStar.searchPath(50, 73, 218, 650);
    }
}
