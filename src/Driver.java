package minilib;

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

        String curPage = "main";
        String prevPage = "main";
        ArrayList<Book> latestResults = new ArrayList<Book>();
        Book curBook = null;

        System.out.println("---------------------------");
        System.out.println("--~ Welcome to MiniLib! ~--");
        System.out.println("---------------------------\n");

        while (true) {

            if (curPage.equals("main")) {
                System.out.println("What would you like to do?");
                System.out.println("(search, recommend, browse, checkedout, available, add, remove, exit)");
                String input = userInput.nextLine().trim().toLowerCase();

                if (input.equals("exit")) {
                    System.out.println("\n--------------// Program End //--------------");
                    userInput.close();
                    break;
                } else if (input.equals("search")) {
                    curPage = "search";
                } else if (input.equals("recommend")) {
                    curPage = "recommend";
                } else if (input.equals("browse")) {
                    latestResults = library.getInventory();
                    prevPage = "main";
                    curPage = "results";
                } else if (input.equals("checkedout")) {
                    latestResults = library.getCheckedOutBooks();
                    prevPage = "main";
                    curPage = "results";
                } else if (input.equals("available")) {
                    latestResults = library.getAvailableBooks();
                    prevPage = "main";
                    curPage = "results";
                } else if (input.equals("add")) {
                    curPage = "add";
                } else if (input.equals("remove")) {
                    curPage = "remove";
                } else {
                    System.out.println("That is not a valid option.");
                }
            }

            else if (curPage.equals("search")) {
                System.out.println("Search by title or author?");
                String mode = userInput.nextLine().trim().toLowerCase();

                if (!mode.equals("title") && !mode.equals("author")) {
                    System.out.println("Please type title or author.");
                } else {
                    System.out.println("Enter your search: ");
                    String input = userInput.nextLine().trim();

                    if (mode.equals("title")) {
                        latestResults = library.searchByTitle(input);
                    } else {
                        latestResults = library.searchByAuthor(input);
                    }

                    prevPage = "search";
                    curPage = "results";
                }
            }

            else if (curPage.equals("recommend")) {
                System.out.println("Enter a genre (or press enter to browse entire library): ");
                String input = userInput.nextLine().trim();

                latestResults = library.recommend(input);
                prevPage = "recommend";
                curPage = "results";
            }

            else if (curPage.equals("results")) {
                library.printResults(latestResults);

                if (latestResults.size() == 0) {
                    System.out.println("Type back to return or home to go to main menu:");
                    String input = userInput.nextLine().trim().toLowerCase();

                    if (input.equals("back")) {
                        curPage = prevPage;
                    } else {
                        curPage = "main";
                    }
                } else {
                    while (true) {
                        System.out.println("Input a book index to inspect.");
                        System.out.println("Or type back or home.");
                        String input = userInput.nextLine().trim().toLowerCase();

                        if (input.equals("back")) {
                            curPage = prevPage;
                            break;
                        } else if (input.equals("home")) {
                            curPage = "main";
                            break;
                        } else {
                            try {
                                int index = Integer.parseInt(input);
                                if (index >= 0 && index < latestResults.size()) {
                                    curBook = latestResults.get(index);
                                    prevPage = "results";
                                    curPage = "inspection";
                                    break;
                                } else {
                                    System.out.println("Please input a valid index.");
                                }
                            } catch (Exception e) {
                                System.out.println("Please provide a valid input.");
                            }
                        }
                    }
                }
            }

            else if (curPage.equals("inspection")) {
                library.inspectByTitle(curBook.getTitle());

                while (true) {
                    System.out.println("What would you like to do?");
                    System.out.println("(checkout, return, rate, back, home)");
                    String input = userInput.nextLine().trim().toLowerCase();

                    if (input.equals("checkout")) {
                        boolean success = library.checkout(curBook.getTitle());
                        if (success) {
                            System.out.println("Successfully checked out " + curBook.getTitle() + ".");
                        } else {
                            System.out.println("Could not check out that book.");
                        }
                        library.inspectByTitle(curBook.getTitle());
                    }

                    else if (input.equals("return")) {
                        boolean success = library.returnBook(curBook.getTitle());
                        if (success) {
                            System.out.println("Successfully returned " + curBook.getTitle() + ".");
                        } else {
                            System.out.println("Could not return that book.");
                        }
                        library.inspectByTitle(curBook.getTitle());
                    }

                    else if (input.equals("rate")) {
                        System.out.print("Enter a new rating from 0.0 to 10.0: ");
                        String ratingText = userInput.nextLine().trim();

                        try {
                            double newRating = Double.parseDouble(ratingText);
                            boolean success = library.rateBook(curBook.getTitle(), newRating);
                            if (success) {
                                System.out.println("Rating updated.");
                            } else {
                                System.out.println("Invalid rating.");
                            }
                        } catch (Exception e) {
                            System.out.println("Please enter a number.");
                        }

                        library.inspectByTitle(curBook.getTitle());
                    }

                    else if (input.equals("back")) {
                        curPage = prevPage;
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
                    while (true) {
                        System.out.println("Try again? (y/n): ");
                        String input = userInput.nextLine().trim().toLowerCase();
                        if (input.equals("n") || input.equals("no")) {
                            curPage = "main";
                            break;
                        } else if (input.equals("y") || input.equals("yes")) {
                            curPage = "add";
                            break;
                        } else {
                            System.out.println("Not understood.");
                        }
                    }
                } else {
                    curPage = "main";
                }
            }

            else if (curPage.equals("remove")) {
                System.out.println("\n[-------- Remove A Book --------]");
                System.out.println("What is the title that you wish to remove from the library?: ");
                String input = userInput.nextLine();

                boolean bookRemoved = library.removeByTitle(input);

                if (bookRemoved) {
                    System.out.println("\nSuccess! Removed " + input + " from your library.");
                    curPage = "main";
                } else {
                    while (true) {
                        System.out.println("\nCouldn't find book title. Try again? (y/n): ");
                        input = userInput.nextLine().trim().toLowerCase();
                        if (input.equals("n") || input.equals("no")) {
                            curPage = "main";
                            break;
                        } else if (input.equals("y") || input.equals("yes")) {
                            curPage = "remove";
                            break;
                        } else {
                            System.out.println("Not understood.");
                        }
                    }
                }
                System.out.println("[-------------------------------]\n");
            }

            else {
                System.out.println("Error: unknown value for curPage");
                break;
            }
        }
    }
}
