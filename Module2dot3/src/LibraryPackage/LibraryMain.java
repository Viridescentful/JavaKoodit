package LibraryPackage;

public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();

        User newuser = new User("Veikko", 28);

        Book firstbook = new Book("Introduction to coding", "Known person", 2004);
        Book secondbook = new Book("Introduction to coding #2", "Known person", 2006);
        Book thirdbook = new Book("Introduction to malicious coding", "Bad person", 2007);

        library.addBook(firstbook);
        library.addBook(secondbook);
        library.addBook(thirdbook);

        firstbook.setRating(8.0);
        secondbook.setRating(2.5);
        thirdbook.setRating(10.0);

        library.borrowBook("Introduction to coding #2", "Known person", newuser);
        System.out.println();

        library.displayBooks();

        library.findBooksByAuthor("Bad person");

        library.returnBook("Introduction to coding #2", "Known person", newuser);
        System.out.println();

        library.displayBooks();

        System.out.println("The average rating of all the books is: " + String.format("%.2f", library.averageRating()));
        System.out.println();
        System.out.println("The highest rated book is: " + library.highestRating());
    }
}
