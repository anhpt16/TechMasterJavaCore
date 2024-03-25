package services;

import entities.Position;
import entities.Staff;
import entities.TaskTable;
import iservices.ITaskTableService;
import views.Menu;
import utils.Constant;

import java.util.*;

public class TaskTableService extends GeneralService implements ITaskTableService {
    private static TaskTableService instance;
    private TaskTableService(){}
    public static TaskTableService getInstance(){
        if (instance == null)
            instance = new TaskTableService();
        return instance;
    }
    Menu menu = new Menu();

    StaffService staffService = StaffService.getInstance();
    PositionService positionService = PositionService.getInstance();

    @Override
    public void inputInfo(ArrayList<Staff> staffs, ArrayList<Position> positions, ArrayList<TaskTable> taskTables) {

        if (!inputCheck.checkNullArrayList(staffs, "Staff", "TaskTableService.inputInfo")
        || !inputCheck.checkNullArrayList(positions, "Position", "TaskTableService.inputInfo")
        || !inputCheck.checkNullArrayList(taskTables, "TaskTable", "TaskTableService.inputInfo"))
            return;
        do {
            Staff staff = null;
            Position position = null;
            TaskTable taskTable;
            int count = 0; // Biến đếm số nhiệm vụ mà nhân viên làm trong list
            //Nhập id
            System.out.print("--Nhập id nhân viên: ");
            int idStaff = inputCheck.checkIntInput();
            //Kiểm tra xem nhân viên có id này có tồn tại trong list không
            staff = staffService.findStaffById(staffs, idStaff);
            if (staff == null){
                //Nếu không tồn tại thì cho nhập lại
                System.out.println("Không tồn tại nhân viên này !");
                continue;
            }
            //Kiểm tra xem nhân viên này đã làm đủ vị trí chưa
            for (TaskTable t : taskTables){
                //Đếm số vị trí mà nhân viên được giao
                if (t.getStaff() == staff){
                    count++;
                }
            }
            //Kiểm tra số lượng vị trí so với tổng số lượng vị trí và số lượng vị trí max
            if (count >= 3 || count >= positions.size()){
                System.out.println("Nhân viên này đã làm đủ vị trí !");
                //In ra menu cho người dùng chọn
                int choice = menu.nextMenuWhenFullPosition();
                switch (choice){
                    //Chọn 1 thì quay lại nhập id
                    case 1:
                        continue;
                    //Chọn 2 thì quay lại menu
                    case 2:
                        return;
                    //Một số khác thì quay lại nhập id
                    default:
                        continue;
                }
            }
            //Nếu số lượng vị trí của nhân viên thỏa mãn thì nhập id của vị trí
            do {
                //Gán giá trị cho position và tasktable là null để có thể nhập liên tục nhiều vị trí
                position = null;
                taskTable = null;
                System.out.print("--Nhập id của vị trí: ");
                int idPosition = inputCheck.checkIntInput();
                //Kiểm tra xem vị trí này có tồn tại trong list không
                position = positionService.findPositionById(positions, idPosition);
                if (position == null){
                    //Nếu không tồn tại vị trí thì in ra thông báo
                    System.out.println("Không tồn tại vị trí này !");
                    continue;

                }
                //Nếu mà nhiệm vụ đó tồn tại thì kiểm tra xem nhân viên này đã được giao cho nhiệm vụ này trong bảng nhiệm vụ hay chưa
                for (TaskTable t : taskTables){
                    //Nếu tìm thấy thì khởi tạo đối tượng và thoát khỏi vòng lặp
                    if (t.getStaff() == staff && t.getPosition() == position){
                        taskTable = new TaskTable();
                        break;
                    }
                }
                //Nếu nhiệm vụ chưa được giao thì tạo nhiệm vụ cho nhân viên đó
                if (taskTable == null){
                    //Nhập số ngày làm cho vị trí đó
                    System.out.print("--Nhập số ngày làm: ");
                    int days = inputCheck.checkIntInput();
                    //Thêm nhiệm vụ cho nhân viên vào list
                    taskTables.add(new TaskTable(staff, position, days));
                    //Tăng số lượng nhiệm vụ trong list nhiệm vụ của nhân viên thêm 1
                    count++;
                }
                else {
                    //Nếu được giao rồi thì hiển thị thông báo
                    System.out.println("Nhiệm vụ này đã được giao !");
                }
                //Hiển thị menu khi nhập xong hoặc khi không tìm thấy vị trí
                int choice = menu.nextMenuWhenInputPosition();
                switch (choice){
                    //Chọn 1 thì tiếp tục nhập --> Kiểm tra lại số lượng nhiệm vụ trong list
                    case 1:
                        //Kiểm tra số lượng vị trí so với tổng số lượng vị trí và số lượng vị trí max
                        if (count >= 3 || count >= positions.size()){
                            System.out.println("Nhân viên này đã làm đủ vị trí !");
                            //------------In ra menu cho người dùng chọn
                            int choose = menu.nextMenuWhenFullPosition();
                            switch (choose) {
                                //Chọn 1 thì quay lại nhập id
                                case 1:
                                    break; // Thoát khỏi switchcase trong
                                //Chọn 2 thì quay lại menu
                                case 2:
                                    return;
                                //Một số khác thì quay lại nhập id
                                default:
                                    break;
                            }
                            break; //thoát khỏi switchcase ngoài
                            //------------------------------------------
                        }
                        else {
                            continue; //Tiếp tục nhập vị trí cho nhân viên
                        }
                    //Chọn 2 thì chuyển qua nhân viên khác
                    case 2:
                        break;
                    //Chọn 3 thì quay lại menu
                    case 3:
                        return;
                    //Những lựa chọn khác thì tiếp tục nhập vị trí cho nhân viên
                    default:
                        continue;
                }
                //Thoát khỏi vòng lặp nhập vị trí quay về nhập id
                break;
            } while(true);
        } while(true);
    }

    public void sortTaskTableByName(ArrayList<TaskTable> taskTables){
        Collections.sort(taskTables, new Comparator<TaskTable>() {
            @Override
            public int compare(TaskTable o1, TaskTable o2) {
                String[] s1 = o1.getStaff().getName().trim().split(" ");
                String[] s2 = o2.getStaff().getName().trim().split(" ");
                return s1[s1.length - 1].compareTo(s2[s2.length - 1]);
            }
        });
        displayList(taskTables);
    }

    public void sortTaskTableByDays(ArrayList<TaskTable> taskTables){
        Collections.sort(taskTables, new Comparator<TaskTable>() {
            @Override
            public int compare(TaskTable o1, TaskTable o2) {
                return o2.getDays() - o1.getDays();
            }
        });
        displayList(taskTables);
    }

    public void manageSalary(ArrayList<TaskTable> taskTables){
        Map<Staff, Long> tableSalary = new HashMap<>();
        for (TaskTable t : taskTables){
            if (tableSalary.containsKey(t.getStaff())){
                Long currentEarn = tableSalary.get(t.getStaff());
                tableSalary.put(t.getStaff(), currentEarn + t.getPosition().getBonus());
            }
            else {
                tableSalary.put(t.getStaff(), t.getPosition().getBonus());
            }
        }
        for (Staff key : tableSalary.keySet()){
            tableSalary.put(key, tableSalary.get(key) + (long) (0.1 * key.getSalary()));
        }
        System.out.printf("|%-5s|%-25s|%-15s|\n", "ID", "NAME", "Salary");
        for (Staff key : tableSalary.keySet()){
            System.out.printf("|%-5d|%-25s|%-15d|\n", key.getId(), key.getName(), tableSalary.get(key));
        }
    }
}
