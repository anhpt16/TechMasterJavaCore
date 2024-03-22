import entities.Position;
import entities.Staff;
import entities.TaskTable;
import views.Menu;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        ArrayList<Staff> staffs = new ArrayList<>();
        ArrayList<Position> positions = new ArrayList<>();
        ArrayList<TaskTable> taskTables = new ArrayList<>();

        menu.startMenu(staffs, positions, taskTables);
    }
}
