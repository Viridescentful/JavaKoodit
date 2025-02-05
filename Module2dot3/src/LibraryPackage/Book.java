package LibraryPackage;

public class Book {
    private String title;
    private String author;
    private int publishingyear;

    private String review;
    private double rating;

    public Book(String title, String author, int publishingyear) {
        this.title = title;
        this.author = author;
        this.publishingyear = publishingyear;
        this.review = "";
        this.rating = 0.0;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishingyear() {
        return publishingyear;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public double getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Year: " + publishingyear;
    }
}
