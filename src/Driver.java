import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		MiniLibrary library = new MiniLibrary();

		library.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 9.2, "Middle-earth"));
        library.add(new Book("The Fellowship of the Ring", "J.R.R. Tolkien", "Fantasy", 9.5, "The Lord of the Rings"));
        library.add(new Book("The Two Towers", "J.R.R. Tolkien", "Fantasy", 9.3, "The Lord of the Rings"));
        library.add(new Book("The Return of the King", "J.R.R. Tolkien", "Fantasy", 9.6, "The Lord of the Rings"));
        library.add(new Book("Murder on the Orient Express", "Agatha Christie", "Mystery", 8.7, "Hercule Poirot"));
        library.add(new Book("A Game of Thrones", "George R.R. Martin", "Fantasy", 9.3, "A Song of Ice and Fire"));
        library.add(new Book("A Clash of Kings", "George R.R. Martin", "Fantasy", 9.1, "A Song of Ice and Fire"));
        library.add(new Book("A Storm of Swords", "George R.R. Martin", "Fantasy", 9.7, "A Song of Ice and Fire"));
        library.add(new Book("The Name of the Wind", "Patrick Rothfuss", "Fantasy", 9.4, "The Kingkiller Chronicle"));
        library.add(new Book("The Wise Man's Fear", "Patrick Rothfuss", "Fantasy", 9.2, "The Kingkiller Chronicle"));

        library.add(new Book("Dune", "Frank Herbert", "Science Fiction", 9.6, "Dune"));
        library.add(new Book("Foundation", "Isaac Asimov", "Science Fiction", 9.1, "Foundation"));
        library.add(new Book("Neuromancer", "William Gibson", "Science Fiction", 8.9, "Sprawl"));
        library.add(new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 9.0, "Standalone"));

        library.add(new Book("1984", "George Orwell", "Dystopian", 9.4, "Standalone"));
        library.add(new Book("Animal Farm", "George Orwell", "Political Satire", 9.1, "Standalone"));
        library.add(new Book("Brave New World", "Aldous Huxley", "Dystopian", 9.2, "Standalone"));
        library.add(new Book("Fahrenheit 451", "Ray Bradbury", "Dystopian", 9.0, "Standalone"));

        library.add(new Book("The Catcher in the Rye", "J.D. Salinger", "Classic", 8.8, "Standalone"));
        library.add(new Book("To Kill a Mockingbird", "Harper Lee", "Classic", 9.6, "Standalone"));
        library.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic", 9.3, "Standalone"));
        library.add(new Book("Moby Dick", "Herman Melville", "Classic", 8.7, "Standalone"));
        library.add(new Book("Pride and Prejudice", "Jane Austen", "Classic", 9.2, "Standalone"));

        library.add(new Book("Dracula", "Bram Stoker", "Horror", 9.0, "Standalone"));
        library.add(new Book("Frankenstein", "Mary Shelley", "Horror", 9.1, "Standalone"));
        library.add(new Book("The Shining", "Stephen King", "Horror", 9.3, "Standalone"));

        library.add(new Book("The Book Thief", "Markus Zusak", "Historical Fiction", 9.5, "Standalone"));
        library.add(new Book("All the Light We Cannot See", "Anthony Doerr", "Historical Fiction", 9.3, "Standalone"));

        library.add(new Book("Sapiens", "Yuval Noah Harari", "Nonfiction", 9.4, "Standalone"));

        library.add(new Book("The Hunger Games", "Suzanne Collins", "Young Adult", 9.1, "The Hunger Games"));
        library.add(new Book("Catching Fire", "Suzanne Collins", "Young Adult", 9.3, "The Hunger Games"));

        library.add(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", 9.4, "Harry Potter"));
        library.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", "Fantasy", 9.1, "Harry Potter"));
        library.add(new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "Fantasy", 9.5, "Harry Potter"));
        library.add(new Book("The Lightning Thief", "Rick Riordan", "Mythological Fantasy", 9.2, "Percy Jackson and the Olympians"));
library.add(new Book("The Sea of Monsters", "Rick Riordan", "Mythological Fantasy", 8.9, "Percy Jackson and the Olympians"));
library.add(new Book("The Titan's Curse", "Rick Riordan", "Mythological Fantasy", 9.0, "Percy Jackson and the Olympians"));
library.add(new Book("The Battle of the Labyrinth", "Rick Riordan", "Mythological Fantasy", 9.1, "Percy Jackson and the Olympians"));
library.add(new Book("The Last Olympian", "Rick Riordan", "Mythological Fantasy", 9.4, "Percy Jackson and the Olympians"));

library.add(new Book("The Lost Hero", "Rick Riordan", "Mythological Fantasy", 8.8, "Heroes of Olympus"));
library.add(new Book("The Son of Neptune", "Rick Riordan", "Mythological Fantasy", 9.0, "Heroes of Olympus"));
library.add(new Book("The Mark of Athena", "Rick Riordan", "Mythological Fantasy", 9.2, "Heroes of Olympus"));
library.add(new Book("The House of Hades", "Rick Riordan", "Mythological Fantasy", 9.3, "Heroes of Olympus"));
library.add(new Book("The Blood of Olympus", "Rick Riordan", "Mythological Fantasy", 8.7, "Heroes of Olympus"));

library.add(new Book("The Red Pyramid", "Rick Riordan", "Mythological Fantasy", 8.9, "The Kane Chronicles"));
library.add(new Book("The Throne of Fire", "Rick Riordan", "Mythological Fantasy", 8.8, "The Kane Chronicles"));
library.add(new Book("The Serpent's Shadow", "Rick Riordan", "Mythological Fantasy", 9.0, "The Kane Chronicles"));

library.add(new Book("Magnus Chase and the Sword of Summer", "Rick Riordan", "Mythological Fantasy", 9.1, "Magnus Chase"));
library.add(new Book("The Hammer of Thor", "Rick Riordan", "Mythological Fantasy", 9.0, "Magnus Chase"));
library.add(new Book("The Ship of the Dead", "Rick Riordan", "Mythological Fantasy", 8.9, "Magnus Chase"));

library.add(new Book("Circe", "Madeline Miller", "Mythological Fiction", 9.4, "Standalone"));
library.add(new Book("The Song of Achilles", "Madeline Miller", "Mythological Fiction", 9.5, "Standalone"));
library.add(new Book("Ariadne", "Jennifer Saint", "Mythological Fiction", 9.0, "Standalone"));
library.add(new Book("Elektra", "Jennifer Saint", "Mythological Fiction", 8.8, "Standalone"));
library.add(new Book("The Silence of the Girls", "Pat Barker", "Mythological Fiction", 9.0, "Standalone"));

library.add(new Book("And Then There Were None", "Agatha Christie", "Mystery", 9.6, "Standalone"));
library.add(new Book("Murder on the Orient Express", "Agatha Christie", "Mystery", 9.5, "Hercule Poirot"));
library.add(new Book("Death on the Nile", "Agatha Christie", "Mystery", 9.3, "Hercule Poirot"));
library.add(new Book("The ABC Murders", "Agatha Christie", "Mystery", 9.1, "Hercule Poirot"));
library.add(new Book("The Murder of Roger Ackroyd", "Agatha Christie", "Mystery", 9.6, "Hercule Poirot"));

library.add(new Book("The Hound of the Baskervilles", "Arthur Conan Doyle", "Mystery", 9.3, "Sherlock Holmes"));
library.add(new Book("A Study in Scarlet", "Arthur Conan Doyle", "Mystery", 9.0, "Sherlock Holmes"));
library.add(new Book("The Sign of Four", "Arthur Conan Doyle", "Mystery", 8.9, "Sherlock Holmes"));
library.add(new Book("The Adventures of Sherlock Holmes", "Arthur Conan Doyle", "Mystery", 9.4, "Sherlock Holmes"));

library.add(new Book("The Girl on the Train", "Paula Hawkins", "Thriller", 9.0, "Standalone"));
library.add(new Book("The Woman in the Window", "A.J. Finn", "Thriller", 8.9, "Standalone"));
library.add(new Book("Sharp Objects", "Gillian Flynn", "Thriller", 9.1, "Standalone"));
library.add(new Book("Dark Places", "Gillian Flynn", "Thriller", 8.9, "Standalone"));
library.add(new Book("The Reversal", "Michael Connelly", "Thriller", 8.8, "Lincoln Lawyer"));

library.add(new Book("One of Us Is Lying", "Karen M. McManus", "Young Adult Mystery", 9.1, "Bayview"));
library.add(new Book("One of Us Is Next", "Karen M. McManus", "Young Adult Mystery", 8.9, "Bayview"));
library.add(new Book("Two Can Keep a Secret", "Karen M. McManus", "Young Adult Mystery", 8.8, "Standalone"));
library.add(new Book("You'll Be the Death of Me", "Karen M. McManus", "Young Adult Mystery", 8.7, "Standalone"));

library.add(new Book("A Good Girl's Guide to Murder", "Holly Jackson", "Young Adult Mystery", 9.3, "AGGGTM"));
library.add(new Book("Good Girl, Bad Blood", "Holly Jackson", "Young Adult Mystery", 9.0, "AGGGTM"));
library.add(new Book("As Good As Dead", "Holly Jackson", "Young Adult Mystery", 9.1, "AGGGTM"));

library.add(new Book("Legend", "Marie Lu", "Young Adult Dystopian", 9.0, "Legend"));
library.add(new Book("Prodigy", "Marie Lu", "Young Adult Dystopian", 8.9, "Legend"));
library.add(new Book("Champion", "Marie Lu", "Young Adult Dystopian", 9.0, "Legend"));

library.add(new Book("Six of Crows", "Leigh Bardugo", "Young Adult Fantasy", 9.4, "Six of Crows"));
library.add(new Book("Crooked Kingdom", "Leigh Bardugo", "Young Adult Fantasy", 9.3, "Six of Crows"));

library.add(new Book("Shadow and Bone", "Leigh Bardugo", "Young Adult Fantasy", 8.8, "Grishaverse"));
library.add(new Book("Siege and Storm", "Leigh Bardugo", "Young Adult Fantasy", 8.7, "Grishaverse"));
library.add(new Book("Ruin and Rising", "Leigh Bardugo", "Young Adult Fantasy", 8.9, "Grishaverse"));

library.add(new Book("The Maze Runner", "James Dashner", "Young Adult Sci-Fi", 9.0, "Maze Runner"));
library.add(new Book("The Scorch Trials", "James Dashner", "Young Adult Sci-Fi", 8.7, "Maze Runner"));
library.add(new Book("The Death Cure", "James Dashner", "Young Adult Sci-Fi", 8.8, "Maze Runner"));

		String curPage = "main";
		String prevPage = "main";
		ArrayList<Book> latestResults = new ArrayList<Book>();
		Book curBook = new Book();

		System.out.println(
				"  ____________________________________________\n" +
				" /___________________________________________/|\n" +
				"|        Welcome to Mini Library             |\n" +
				"|____________________________________________|\n" +
				"|   (\\(\\)                                   |\n" +
				"|  ( -.-)  cozy shelves, warm tea            |\n" +
				"|  o_(\")(\")  and good books                  |\n" +
				"|____________________________________________|\n"
		);

		System.out.println("---------------------------");
		System.out.println("--~ Welcome to MiniLib! ~--");
		System.out.println("---------------------------\n");
		
		while (true) {
			
			if (curPage.equals("main")) {
				System.out.println("What would you like to do? (search, recommend, sort, add, remove, exit)");
				String input = userInput.nextLine().trim();
				
				if (input.equals("exit")) {
					System.out.println("\n--------------// Program End //--------------");
					userInput.close();
					break;
				} else if (input.equals("search")) {
					curPage = "search";
				} else if (input.equals("recommend")) {
					curPage = "recommend";
				} else if (input.equals("sort")) {
					curPage = "sort";
				} else if (input.equals("add")) {
					curPage = "add";
				} else if (input.equals("remove")) {
					curPage = "remove";
				} else {
					System.out.print("That is not a valid option. ");
				}
			} 
			
			else if (curPage.equals("search")) {
				System.out.println("Enter a title or author: ");
				String input = userInput.nextLine().trim();
				
				ArrayList<Book> titleResults = library.searchByTitle(input);
				ArrayList<Book> authorResults = library.searchByAuthor(input);
				
				if (titleResults.size()>=authorResults.size()) {
					latestResults = titleResults;
				} else {
					latestResults = authorResults;
				}
				prevPage = "search";
				curPage = "results";
			}
			
			else if (curPage.equals("recommend")) {
				System.out.println("Enter a genre (or press enter to browse entire library): ");
				String input = userInput.nextLine().trim();
				System.out.println();
				
				latestResults = library.recommend(input);
				prevPage = "recommend";
				curPage = "results";
			}
			
			else if (curPage.equals("sort")) {
				System.out.println("How would you like to sort the library? (title, author, genre)");
				String input = userInput.nextLine().trim().toLowerCase();
				
				if (input.equals("title")) {
					latestResults = library.getAllBooksSortedByTitle();
					prevPage = "sort";
					curPage = "results";
				} else if (input.equals("author")) {
					latestResults = library.getAllBooksSortedByAuthor();
					prevPage = "sort";
					curPage = "results";
				} else if (input.equals("genre")) {
					System.out.println("Enter the genre you want to view:");
					String genreInput = userInput.nextLine().trim();
					latestResults = library.getBooksOfGenreSortedByTitle(genreInput);
					prevPage = "sort";
					curPage = "results";
				} else {
					System.out.println("Invalid sort option.");
					curPage = "main";
				}
			}
			
			else if (curPage.equals("results")) {
				library.printResults(latestResults); 
				
				while (true) {
					System.out.println("Enter the number next to a book to inspect it (or type \"back\" or \"home\"):");
					String input = userInput.nextLine();
					
					if (input.equals("back")) {
						curPage = prevPage;
						break;
					} 
					else if (input.equals("home")) {
						curPage = "main";
						break;
					} 
					else {
						try {
							int index = Integer.parseInt(input);
							
							if (index >= 0 && index <= latestResults.size()-1) {
								curBook = latestResults.get(index);
								curPage = "inspection";
								break;
							}
							else System.out.println("Invalid number.");
						}
						catch (Exception e) {
							System.out.println("Please provide a valid number.");
						}
					}
				}
			}
			
			else if (curPage.equals("inspection")) {
				library.inspectByTitle(curBook.getTitle());
				
				while (true) {
					System.out.println("(Type \"back\" or \"home\") ");
					String input = userInput.nextLine();
					
					if (input.equals("back")) {
						curPage = "results";
						break;
					} 
					else if (input.equals("home")) {
						curPage = "main";
						break;
					} 
					else {
						System.out.println("Please give a valid input.");
					}
				}
			}
			
			else if (curPage.equals("add")) { 
				Book createdBook = library.addBookInteractive(userInput);
				
				if (createdBook == null) {
					System.out.println("Book could not be added.");
				}
				
				curPage = "main";
			}
			
			else if (curPage.equals("remove")) {
		    	System.out.println("[-------- Remove A Book --------]");
		    	System.out.println("Enter title to remove:");
		    	String input = userInput.nextLine();
				
				boolean bookRemoved = library.removeByTitle(input);
				
				if (bookRemoved) {
					System.out.println("Removed "+input+" from library.");
				} 
				else {
					System.out.println("Book not found.");
				}
				
				curPage = "main";
			}
		}
	}
}
