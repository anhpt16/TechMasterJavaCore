package iservices;

import entities.Position;

import java.util.ArrayList;

public interface IPositionService {
    Position inputInfo();
    void addPosition(ArrayList<Position> positions);
    Position findPositionById(ArrayList<Position> positions, int id);
}
