package Comparetor;

import entities.BookSaving;

import java.util.Comparator;

public class BookSavingCompareByDeposit implements Comparator<BookSaving> {
    @Override
    public int compare(BookSaving s1, BookSaving s2) {
        return Long.compare(s1.getDeposit(), s2.getDeposit());
    }
}
