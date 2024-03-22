package services;

import entities.Position;
import iservices.IPositionService;

import java.util.ArrayList;
import java.util.Scanner;

public class PositionService extends GeneralService implements IPositionService {
    private static PositionService instance;
    private PositionService(){}
    public static PositionService getInstance(){
        if (instance == null)
            instance = new PositionService();
        return instance;
    }

    @Override
    public Position inputInfo() {
        System.out.print("--Nhập tên vị trí: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("--Nhập mức thưởng: ");
        long bonus = inputCheck.checkLongInput();
        return new Position(name, bonus);
    }

    @Override
    public void addPosition(ArrayList<Position> positions) {
        inputCheck.checkNullArrayList(positions, "Position", "addPosition");
        System.out.print("Nhập số lượng vị trí: ");
        int quantity = inputCheck.checkIntInput();
        for (int i = 0; i < quantity; i++) {
            System.out.println("Nhập thông tin cho vị trí thứ " + (i + 1));
            positions.add(inputInfo());
        }
    }

    @Override
    public Position findPositionById(ArrayList<Position> positions, int id) {
        inputCheck.checkNullArrayList(positions, "Position", "findPositionById");
        for (Position p : positions){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }
}
