package minilib;

import java.util.ArrayList;

public class Book {
    
    private String title;
    private String author;
    private String genre;
    //private boolean isCheckOut;
    private double rating;
    private String series;
    
    private static int totalBooks = 0;

    // Constructor for book class would go here
	///uhhhh okay i didn't see all the stuff in minilibrary so some of these constructors need updating
    public Book() { //literally just a placeholder so that the code can compile in the driver
    	this.title = "";
    	this.author = "";
    	this.genre = "UNLABELED";
    	this.rating = -1.0;
    	this.series = "Standalone";
    }
    
    
    public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.genre = "UNLABELED";
		this.rating = -1.0; 
		this.series = "Standalone";
        //this.isCheckOut = false;
		totalBooks++;
	}
	
	public Book(String title, String author, String genre) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.rating = -1.0;
		this.series = "Standalone";
        //this.isCheckOut = false;
		totalBooks++;
	}

	public Book(String title, String author, String genre, double rating, String series) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.rating = rating;
		this.series = series;
        //this.isCheckOut = false;
		totalBooks++;
	}
	
	public Book(Book book) {
		this.title = book.getTitle();
		this.author = book.getAuthor();
		this.genre = book.getGenre();
		this.rating = book.getRating();
		this.series = book.getSeries();
        //this.isCheckOut = false;
		totalBooks++;
	}
	
    // Method for Checking out a book
//    public void checkOut(){
//        isCheckOut = true;
//    }
//    
//    // Method for Checking in a book
//    public void checkIn(){
//        isCheckOut = false;
//    }
    
    //(if time) method for rating a book
    
	//for the sake of preserving mental strength, assume preconditions are met
	//preconditions: library is not null
	public ArrayList<Book> findSiblings(MiniLibrary library){
		ArrayList<Book> libraryInventory = library.getInventory();
		ArrayList<Book> siblings = new ArrayList<Book>();
		
		if (this.getSeries().toLowerCase().equals("standalone")) {
			return siblings;
		}
		
		for (Book book : libraryInventory) {
			if (!this.equals(book) &&
					book.getSeries().toLowerCase().equals(this.getSeries().toLowerCase())){
				siblings.add(book);
			}
		}
		return siblings;
	}
	
	
    // Getters for title, author, genre, rating, etc.
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
    
    public static int getTotalBooks() {
    	return totalBooks;
    }
//    public boolean isCheckedOut() {
//        return isCheckOut;
//    }
//
//	public void setCheckedOut(boolean status) {
//         this.isCheckOut = status;
//    }

    
    // Method for displaying a single book 
    public String toString() {
		String bookString = "\""+this.title+"\""+" by "+this.author+" ("+genre+")";
		return bookString;
	}

    //equals method
    public boolean equals(Book otherBook) {
		boolean titleMatch = this.title.equals(otherBook.getTitle());
		boolean authorMatch = this.author.equals(otherBook.getAuthor());
		
		if (titleMatch && authorMatch) return true; 
		else return false;
	}
    

}
