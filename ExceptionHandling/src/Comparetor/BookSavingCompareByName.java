package Comparetor;

import entities.BookSaving;
import entities.Customer;

import java.util.Comparator;

public class BookSavingCompareByName implements Comparator<BookSaving> {

    @Override
    public int compare(BookSaving s1, BookSaving s2) {
        String[] o1 = s1.getCustomer().getName().trim().split(" ");
        String[] o2 = s2.getCustomer().getName().trim().split(" ");
        return o1[o1.length - 1].compareTo(o2[o2.length - 1]);
    }
}
