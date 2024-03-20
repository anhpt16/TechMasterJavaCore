package IServices;

import entities.Ministration;

import java.util.ArrayList;

public interface IMinistrationService {
    Ministration inputInfo();
    void displayList(ArrayList<Ministration> ministrations);
    void addMinistration(ArrayList<Ministration> ministrations);
    Ministration findMinistrationById(ArrayList<Ministration> ministrations, int id);
}
