package iservices;

import entities.Position;
import entities.Staff;
import entities.TaskTable;

import java.util.ArrayList;

public interface ITaskTableService {
    void inputInfo(ArrayList<Staff> staffs, ArrayList<Position> positions, ArrayList<TaskTable> taskTables);
    void sortTaskTableByName(ArrayList<TaskTable> taskTables);
    void sortTaskTableByDays(ArrayList<TaskTable> taskTables);
    void manageSalary(ArrayList<TaskTable> taskTables);
}
