package minilib;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		MiniLibrary library = new MiniLibrary();
		
		String yellow = "\u001b[33;1m";
		String reset = "\u001b[0m";
		//before all the user stuff, define and create the library:
		library.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 9.2, "Middle-earth"));
        library.add(new Book("The Fellowship of the Ring", "J.R.R. Tolkien", "Fantasy", 9.5, "The Lord of the Rings"));
        library.add(new Book("The Two Towers", "J.R.R. Tolkien", "Fantasy", 9.3, "The Lord of the Rings"));
        library.add(new Book("The Return of the King", "J.R.R. Tolkien", "Fantasy", 9.6, "The Lord of the Rings"));
        library.add(new Book("Murder on the Orient Express", "Agatha Christie", "Mystery", 8.7, "Hercule Poirot"));
		//-----
        
		String curPage = "main"; //main (main directory), search, recommend, results, inspection, add, remove
		String prevPage = "main";
		ArrayList<Book> latestResults = new ArrayList<Book>();
		Book curBook = new Book();

		System.out.println(yellow+"---------------------------");
		System.out.println("--~ Welcome to MiniLib! ~--");
		System.out.println("---------------------------\n"+reset);
		
		while (true) { //based on the value of curPage, determines what function to run
			
			if (curPage.equals("main")) {
				System.out.println("What would you like to do? (search, recommend, add, remove, exit)");
				String input = userInput.nextLine().trim();
				
				if (input.equals("exit")) {
					System.out.println(yellow+"\n--------------// Program End //--------------"+reset);
					userInput.close();
					break; //end program
				} else if (input.equals("search")) {
					curPage = "search";
				} else if (input.equals("recommend")) {
					curPage = "recommend";
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
				
				//compare # of results for author and title, whichever has more results is printed
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
				//basically same as search, but with genre
				System.out.println("Enter a genre (or press enter to browse entire library): ");
				String input = userInput.nextLine().trim();
				System.out.println();
				
				latestResults = library.recommend(input);
				prevPage = "recommend";
				curPage = "results";
			}
			
			else if (curPage.equals("results")) {
				//prints out page, asks if use would like to inspect any closer
				library.printResults(latestResults); 
				//special interaction for no results
				if (latestResults.size() == 0) {
					while (true) {
						System.out.println("Retry search? (y/n): ");
						String input = userInput.nextLine();
						if (input.equals("n") || input.equals("no")) {
							curPage = "main"; 
							prevPage = "results";
							break;
						} else if (input.equals("y") || input.equals("yes")) {
							curPage = prevPage; //basically the only reason we track the prevPage
							prevPage = "results";
							break;
						} 
						else System.out.print("Not understood. ");
					}
				}
				//main interaction, asks user if they want to inspect a book closer:
				else {
					while (true) {
						System.out.println("Input a book index (or type \"back\" to search again, or \"home\" to return fully): ");
						String input = userInput.nextLine();
						if (input.equals("back")) {
							curPage = prevPage;
							prevPage = "results";
							break;
						} else if (input.equals("home")) {
							curPage = "main";
							prevPage = "results";
							break;
						} else {
							try {
								int index = Integer.parseInt(input);
								if (index >= 0 && index <= latestResults.size()-1) {
									curBook = latestResults.get(index);
									curPage = "inspection";
									prevPage = "results";
									break;
								} else System.out.println("Please input a valid index.");
							}
							catch (Exception e) {
								System.out.println("Please provide a valid input");
							}
						}
					}
				}
			}
			
			else if (curPage.equals("inspection")) {
				//basically prints out a more detailed look at the book. if we had more time this would probably be able to be more useful
				library.inspectByTitle(curBook.getTitle());
				
				//user interaction (return or rate):
				while (true) {
					System.out.println("(Type \"back\" to view search results, or \"home\" to return fully) ");
					String input = userInput.nextLine();
					if (input.equals("back")) {
						curPage = prevPage;
						prevPage = "search"; // may not be accurate if the person got here through recommend but im too lazy to track navigation back another layer
						break;
					} else if (input.equals("home")) {
						curPage = "main";
						prevPage = "inspection";
						break;
					} else {
						System.out.println("Please give a valid input.");
					}
				}
				
			}
			
//			else if (curPage.equals("rate")) {
//				//opens up the rate a book input
//			}
			
			// if I had more motivation then mayhaps there could be a file saving system where adding a book saves it to a permanent text file so that it doesnt reset once you exit
			else if (curPage.equals("add")) { 
				//opens up "add a book" input
				Book createdBook = library.addBookInteractive(userInput);
				
				if (createdBook == null) {
					while (true) {
						System.out.println("Try again? (y/n): ");
						String input = userInput.nextLine();
						if (input.equals("n") || input.equals("no")) {
							curPage = "main"; 
							prevPage = "add";
							break;
						} else if (input.equals("y") || input.equals("yes")) {
							curPage = "add";
							break;
						} 
						else System.out.print("Not understood. ");
					}
				} else {
					curPage = "main";
				}
			}
			
			else if (curPage.equals("remove")) {
		    	System.out.println(yellow+"\n[-------- Remove A Book --------]");
		    	System.out.println("What is the title that you wish to remove from the library?: ");
		    	String input = userInput.nextLine();
				boolean bookRemoved = library.removeByTitle(input);
				
				if (bookRemoved) {
					System.out.println("\nSuccess! Removed "+input+" from your library.");
					curPage = "main";
					prevPage = "remove";
				} else {
					while (true) {
						System.out.println("\nCouldn't find book title. Try again? (y/n): ");
						input = userInput.nextLine();
						if (input.equals("n") || input.equals("no")) {
							curPage = "main"; 
							prevPage = "remove";
							break;
						} else if (input.equals("y") || input.equals("yes")) {
							curPage = "remove";
							break;
						} 
						else System.out.print("Not understood. ");
					}
					
				}
				System.out.println("[-------------------------------]\n"+reset);
			}
			
			else { //just in case
				System.out.println("Error: unknown value for 'curPage'");
				break;
			}
		} // while true end
	} // main method end
} // class end
