public class Book {
    
    private String title;
    private String author;
    private String genre;
    private boolean isCheckOut;
    //private double ratings;
    
    private static int totalBooks = 0;

    // Constructor for book class would go here
    public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.genre = "UNLABELED";
        this.isCheckOut = false;
	}
	
	public Book(String title, String author, String genre) {
		this.title = title;
		this.author = author;
		this.genre = genre;
        this.isCheckOut = false;
	}

	public Book(Book book) {
		this.title = book.getTitle();
		this.author = book.getAuthor();
		this.genre = book.getGenre();
        this.isCheckOut = false;
	}
	
    // Method for Checking out a book
    public void checkOut(){
        isCheckOut = true;
    }
    
    // Method for Checking in a book
    public void checkIn(){
        isCheckOut = false;
    }
    
    //(if time) method for rating a book
    
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

    public boolean isChecked() {
        return isCheckOut;
    }

    // Method for displaying a single book 
    //is this what you were looking for?:
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
