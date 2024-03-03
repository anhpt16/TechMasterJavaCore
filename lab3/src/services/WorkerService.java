package services;

import entities.Worker;

import java.util.ArrayList;
import java.util.Scanner;

public class WorkerService {
    public Worker inputInfo(Scanner sc){
        System.out.print("--Enter Name: ");
        String name = sc.nextLine();
        System.out.print("--Enter Age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("--Enter Salary: ");
        long salary = Long.parseLong(sc.nextLine());
        System.out.print("--Enter work Location: ");
        String workPlace = sc.nextLine();
        return new Worker(name, age, salary, workPlace);
    }

    public ArrayList<Worker> addWorker(Scanner sc, ArrayList<Worker> workers){
        if (workers == null){
            workers = new ArrayList<>();
        }
        System.out.println("--------- Add Worker ---------");
        System.out.print("Enter number of Worker: ");
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Worker " + (i + 1) + ": ");
            workers.add(inputInfo(sc));
        }
        return workers;
    }

    public
}
