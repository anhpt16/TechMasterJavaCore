package views;

import entities.Position;
import entities.Staff;
import entities.TaskTable;
import services.PositionService;
import services.StaffService;
import services.TaskTableService;
import utils.InputCheck;
import utils.Constant;

import java.util.ArrayList;

public class Menu {
    StaffService staffService = StaffService.getInstance();
    PositionService positionService = PositionService.getInstance();
    TaskTableService taskTableService = TaskTableService.getInstance();

    InputCheck inputCheck = InputCheck.getInstance();

    public void startMenu(ArrayList<Staff> staffs, ArrayList<Position> positions, ArrayList<TaskTable> taskTables){
        int choice;
        do {
            System.out.println("1. Nhập danh sách thành viên");
            System.out.println("2. In ra danh sách thành viên");
            System.out.println("3. Nhập danh sách vị trí công việc");
            System.out.println("4. In ra danh sách vị trí công việc");
            System.out.println("5. Nhập danh sách phân công công việc");
            System.out.println("6. In ra danh sách phân công");
            System.out.println("7. Sắp xếp danh sách phân công theo họ tên");
            System.out.println("8. Sắp xếp danh sách phân công theo số ngày làm");
            System.out.println("9. In ra tổng tiền thưởng của các thành viên");
            System.out.println("10. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = inputCheck.checkIntInput(1, 10);

            switch (choice) {
                case Constant.INPUT_LIST_STAFF:
                    staffService.addStaff(staffs);
                    break;
                case Constant.DISPLAY_LIST_STAFF:
                    staffService.displayList(staffs);
                    break;
                case Constant.INPUT_LIST_POSITION:
                    positionService.addPosition(positions);
                    break;
                case Constant.DISPLAY_LIST_POSITION:
                    positionService.displayList(positions);
                    break;
                case Constant.INPUT_LIST_TASK:
                    taskTableService.inputInfo(staffs, positions, taskTables);
                    break;
                case Constant.DISPLAY_LIST_TASK:
                    taskTableService.displayList(taskTables);
                    break;
                case Constant.SORT_TASK_BY_NAME:
                    taskTableService.sortTaskTableByName(taskTables);
                    break;
                case Constant.SORT_TASK_BY_DAYS:
                    taskTableService.sortTaskTableByDays(taskTables);
                    break;
                case Constant.DISPLAY_TOTAL_BONUS:
                    taskTableService.manageSalary(taskTables);
                    break;
                case Constant.EXIT:
                    return;
            }
        } while (choice != Constant.EXIT);
    }

    public int nextMenuWhenFullPosition(){
        int choice;
        System.out.println("1. Chuyển qua nhân viên khác");
        System.out.println("2. Quay lại menu");
        System.out.print("Chọn: ");
        choice = inputCheck.checkIntInput(1, 2);
        return choice;
    }

    public int nextMenuWhenInputPosition(){
        int choice;
        System.out.println("1. Tiếp tục nhập");
        System.out.println("2. Chuyển qua nhân viên khác");
        System.out.println("3. Quay lại menu");
        System.out.print("Chọn: ");
        choice = inputCheck.checkIntInput(1, 3);
        return choice;
    }
}
