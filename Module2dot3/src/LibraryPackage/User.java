package LibraryPackage;

import java.util.ArrayList;

public class User {
    private String name;
    private int age;

    private ArrayList<Book> borrowedbooks = new ArrayList<>();

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addBook(Book book) {
        borrowedbooks.add(book);
    }

    public void removeBook(Book book) {
        if (borrowedbooks.contains(book)) {
            borrowedbooks.remove(book);
        }
    }

    public ArrayList<Book> getBorrowedbooks() {
        return borrowedbooks;
    }

    public Boolean isBookAvailable(Book book) {
        return borrowedbooks.contains(book);
    }
}
