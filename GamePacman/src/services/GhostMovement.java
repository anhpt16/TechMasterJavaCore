package services;

import algorithm.AStar;
import algorithm.AlgorithmSearch;
import entities.Board;
import entities.Ghost;
import entities.Pacman;
import utils.Constant;

import java.util.ArrayList;

public class GhostMovement {
    private AStar aStar;
    private Board board;
    private Ghost ghost;

    public GhostMovement(Board board, Ghost ghost) {
        this.aStar = new AStar(board.getBoard());
        this.board = board;
        this.ghost = ghost;
    }

    /* Lấy ra đường dẫn */
    public ArrayList<int[]> getPath(Ghost ghost, Pacman pacman){
        /* Lấy ra hướng di chuyển theo các chỉ số của ma trận */
        ArrayList<int[]> path = aStar.searchPath(ghost, pacman.getX(), pacman.getY(), ghost.getDirection());
        ArrayList<int[]> filteredIndexPath = new ArrayList<>();
        int indexX = 0, indexY = 0;
        for (int i = 0; i < path.size(); i++) {
            indexX = path.get(i)[0];
            indexY = path.get(i)[1];
            filteredIndexPath.add(new int[]{indexX, indexY});
        }
        /* Thiết lập đường đi cho ghost */
        ghost.setPath(filteredIndexPath);
        System.out.println("Filter index:  " + "[" + filteredIndexPath.get(1)[0] + "][" + filteredIndexPath.get(0)[0] + "]" + "[" + filteredIndexPath.get(1)[1] + "][" + filteredIndexPath.get(0)[1] + "]");
//        for (int[] node : path) {
//            System.out.println("Node: (" + node[0] + ", " + node[1] + ")");
//            System.out.println("g: " + node[2]);
//            System.out.println("h: " + node[3]);
//            System.out.println("f: " + node[4]);
//            System.out.println("Parent: (" + node[5] + ", " + node[6] + ")");
//            System.out.println("------------------------------");
//        }
        /* Chuyển thành hướng di chuyển theo tọa độ vector */
        for (int i = 0; i < filteredIndexPath.size(); i++) {
            filteredIndexPath.get(i)[0] = (filteredIndexPath.get(i)[0] * Constant.TILE) + (Constant.TILE / 2);
            filteredIndexPath.get(i)[1] = (filteredIndexPath.get(i)[1] * Constant.TILE) + (Constant.TILE / 2);
        }
        return filteredIndexPath;
    }

    /* Di chuyển theo đường dẫn */
    public void move(ArrayList<int[]> filteredIndexPath){
        int ghostSpeed = ghost.getSpeed();
        int currentGhostY = ghost.getY();
        int currentGhostX = ghost.getX();

        if (filteredIndexPath.get(1)[0] == filteredIndexPath.get(0)[0] && filteredIndexPath.get(1)[0] != (currentGhostY + (Constant.GHOST_SIZE / 2))){
            if (filteredIndexPath.get(1)[0] > (currentGhostY + (Constant.GHOST_SIZE / 2))){
                currentGhostY += ghostSpeed;
                ghost.setY(currentGhostY);
            }
            else {
                currentGhostY -= ghostSpeed;
                ghost.setY(currentGhostY);
            }
        }
        else if (filteredIndexPath.get(1)[1] == filteredIndexPath.get(0)[1] && filteredIndexPath.get(1)[1] != (currentGhostX + (Constant.GHOST_SIZE / 2))){
            if (filteredIndexPath.get(1)[1] > (currentGhostX + (Constant.GHOST_SIZE / 2))){
                currentGhostX += ghostSpeed;
                ghost.setX(currentGhostX);
            }
            else {
                currentGhostX -= ghostSpeed;
                ghost.setX(currentGhostX);
            }
        }
        else if ((filteredIndexPath.get(1)[0] > filteredIndexPath.get(0)[0])){
            currentGhostY += ghostSpeed;
            ghost.setY(currentGhostY);
            System.out.println("Y: " + currentGhostY);
        }
        else if ((filteredIndexPath.get(1)[0] < filteredIndexPath.get(0)[0])){
            currentGhostY -= ghostSpeed;
            ghost.setY(currentGhostY);
            System.out.println("Y: " + currentGhostY);
        }
        else if ((filteredIndexPath.get(1)[1] > filteredIndexPath.get(0)[1])){
            currentGhostX += ghostSpeed;
            ghost.setX(currentGhostX);
            System.out.println("X: " + currentGhostX);
        }
        else if ((filteredIndexPath.get(1)[1] < filteredIndexPath.get(0)[1])){
            currentGhostX -= ghostSpeed;
            ghost.setX(currentGhostX);
            System.out.println("X: " + currentGhostX);
        }
        System.out.println("[" + filteredIndexPath.get(1)[0] + "][" + filteredIndexPath.get(0)[0] + "]" + "[" + filteredIndexPath.get(1)[1] + "][" + filteredIndexPath.get(0)[1] + "]");
//        System.out.println("x: " + ghost.getX() + ", y: " + ghost.getY());
        System.out.println("---------");
    }

    public void chasePacman(Pacman pacman){
        ArrayList<int[]> path = getPath(ghost, pacman);
        move(path);
    }
    public void blockHeadPacman(Pacman pacman){
        AlgorithmSearch algorithmSearch = new AlgorithmSearch(board.getBoard());
        int[] point = algorithmSearch.searchFourthPoint(pacman);
//        move(ghost.getX(), ghost.getY(), point[0], point[1], ghost.getSpeed());
    }
    public void dodgePacman(Pacman pacman){

    }
    public void moveToCorner(){

    }
    public void moveToGate(){

    }

    public static void main(String[] args) {
    }
}
