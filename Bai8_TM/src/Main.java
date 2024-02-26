import entities.Family;
import entities.Person;
import services.FamilyService;
import services.PersonService;

import java.util.ArrayList;
import Utils.Constant;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //ArrayList
//        List<Integer> lst = new ArrayList<>();
//        lst.add(1);
//        lst.add(2);
//        System.out.println(lst);
//        lst.removeAll(new ArrayList<>(Arrays.asList(1)));
//        System.out.println(lst);
        //Bài tập slide 17
//        ArrayList<Person> lstPerson = new ArrayList<>();
//        PersonService pr = new PersonService();
////        Person pr1 = pr.input(sc);
////        lstPerson.add(pr1);
////        Person pr2 = pr.input(sc);
////        lstPerson.add(pr2);
//        pr.menu(sc, lstPerson);
        //Bài tập slide 18
        ArrayList<Family> arrFam = new ArrayList<>();
        FamilyService fs = new FamilyService();
        fs.menu(sc, arrFam);
    }
}
