package services;

import utils.InputCheck;

import java.util.ArrayList;

public class GeneralService {
    InputCheck inputCheck = InputCheck.getInstance();

    public <T> void displayList(ArrayList<T> list){
        inputCheck.checkNullArrayList(list, list.getClass().getName(), "displayList");
        for (T t : list){
            System.out.println(t.toString());
        }
    }
}
