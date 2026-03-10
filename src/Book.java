package minilib;

import java.util.ArrayList;

public class Book {
    
    private String title;
    private String author;
    private String genre;
    private double rating;
    private String series;
    private boolean checkedOut;

    private static int totalBooks = 0;

    public Book() {
        this.title = "";
        this.author = "";
        this.genre = "UNLABELED";
        this.rating = -1.0;
        this.series = "Standalone";
        this.checkedOut = false;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.genre = "UNLABELED";
        this.rating = -1.0;
        this.series = "Standalone";
        this.checkedOut = false;
        totalBooks++;
    }

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = -1.0;
        this.series = "Standalone";
        this.checkedOut = false;
        totalBooks++;
    }

    public Book(String title, String author, String genre, double rating, String series) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
        this.series = series;
        this.checkedOut = false;
        totalBooks++;
    }

    public Book(Book book) {
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.genre = book.getGenre();
        this.rating = book.getRating();
        this.series = book.getSeries();
        this.checkedOut = book.isCheckedOut();
        totalBooks++;
    }

    public void checkOut() {
        checkedOut = true;
    }

    public void checkIn() {
        checkedOut = false;
    }

    public boolean rate(double newRating) {
        if (newRating < 0.0 || newRating > 10.0) {
            return false;
        }
        rating = newRating;
        return true;
    }

    public ArrayList<Book> findSiblings(MiniLibrary library) {
        ArrayList<Book> libraryInventory = library.getInventory();
        ArrayList<Book> siblings = new ArrayList<Book>();

        if (this.getSeries().toLowerCase().equals("standalone")) {
            return siblings;
        }

        for (Book book : libraryInventory) {
            if (!this.equals(book) &&
                book.getSeries().toLowerCase().equals(this.getSeries().toLowerCase())) {
                siblings.add(book);
            }
        }
        return siblings;
    }

    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }
    
    public String getSeries() {
        return series;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean status) {
        checkedOut = status;
    }
    
    public static int getTotalBooks() {
        return totalBooks;
    }

    public String toString() {
        String status = "Available";
        if (checkedOut) {
            status = "Checked Out";
        }

        return "\"" + title + "\" by " + author +
               " (" + genre + ", " + series + ", rating: " + rating + ", " + status + ")";
    }

    public boolean equals(Book otherBook) {
        boolean titleMatch = this.title.equalsIgnoreCase(otherBook.getTitle());
        boolean authorMatch = this.author.equalsIgnoreCase(otherBook.getAuthor());
        return titleMatch && authorMatch;
    }
}
