package LibraryPackage;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        }
    }

    public void findBooksByAuthor(String author) {
        System.out.println("Books by author: " + author);
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                System.out.println(book);
            }
        }
        System.out.println();
    }

    public void displayBooks() {
        System.out.println("Library Catalog: ");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println();
    }

    public Boolean isBookinLibrary(Book book) {
        if (books.contains(book)) {
            return true;
        } else {
            return false;
        }
    }

    public void borrowBook(String title, String author, User user) {
        Book foundbook = null;

        for (Book book : books) {
            if (book.getAuthor().equals(author) && book.getTitle().equals(title)) {
                System.out.println(book);
                foundbook = book;
            }
        }

        if (foundbook != null) {
            System.out.println("Found Book: " + foundbook);
            books.remove(foundbook);
            user.addBook(foundbook);
        }
    }

    public void returnBook(String title, String author, User user) {
        Book foundbook = null;

        for (Book book : user.getBorrowedbooks()) {
            if (book.getAuthor().equals(author) && book.getTitle().equals(title)) {
                foundbook = book;
            }
        }

        if (foundbook != null) {
            System.out.println("Returned Book: " + foundbook);
            addBook(foundbook);
            user.removeBook(foundbook);
        }
    }

    public double averageRating() {
        double totalRating = 0;

        for (Book book : books) {
            totalRating += book.getRating();
        }

        return totalRating / books.size();
    }

    public Book highestRating() {
        Book highestRating = null;

        for (Book book : books) {
            if (highestRating == null) {
                highestRating = book;
            } else if (book.getRating() > highestRating.getRating()) {
                highestRating = book;
            }
        }

        return highestRating;
    }
}
