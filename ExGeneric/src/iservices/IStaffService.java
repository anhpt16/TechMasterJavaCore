package iservices;

import entities.Staff;

import java.util.ArrayList;

public interface IStaffService {
    Staff inputInfo();
    void addStaff(ArrayList<Staff> staffs);
    Staff findStaffById(ArrayList<Staff> staffs, int id);
}
