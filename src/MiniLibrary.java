import java.util.ArrayList;
import java.util.Scanner;

public class MiniLibrary {
    private ArrayList<Book> inventory;

    public MiniLibrary() {
        inventory = new ArrayList<Book>();
    }

    public MiniLibrary(ArrayList<Book> startingInventory) {
        inventory = new ArrayList<Book>();
        if (startingInventory != null) {
            for (int i = 0; i < startingInventory.size(); i++) {
                Book b = startingInventory.get(i);
                if (b != null) inventory.add(b);
            }
        }
    }

    public ArrayList<Book> searchByTitle(String titleQuery) {
        ArrayList<Book> results = new ArrayList<Book>();
        String q = normalize(titleQuery);

        for (int i = 0; i < inventory.size(); i++) {
            Book b = inventory.get(i);
            if (b != null) {
                String t = normalize(b.getTitle());
                if (t.indexOf(q) >= 0) {
                    results.add(b);
                }
            }
        }

        sortByRatingDesc(results);
        return results;
    }

    public ArrayList<Book> searchByAuthor(String authorQuery) {
        ArrayList<Book> results = new ArrayList<Book>();
        String q = normalize(authorQuery);

        for (int i = 0; i < inventory.size(); i++) {
            Book b = inventory.get(i);
            if (b != null) {
                String a = normalize(b.getAuthor());
                if (a.indexOf(q) >= 0) {
                    results.add(b);
                }
            }
        }

        sortByRatingDesc(results);
        return results;
    }

    public ArrayList<Book> recommend(String optionalGenre) {
        ArrayList<Book> results = new ArrayList<Book>();

        String g = normalize(optionalGenre);
        boolean filterGenre = (g.length() > 0);

        for (int i = 0; i < inventory.size(); i++) {
            Book b = inventory.get(i);
            if (b != null) {
                if (!filterGenre) {
                    results.add(b);
                } else {
                    if (normalize(b.getGenre()).equals(g)) { 
                        results.add(b);
                    }
                }
            }
        }

        sortByRatingDesc(results);
        return results;
    }

    public ArrayList<Book> getAllBooksSortedByTitle() {
        ArrayList<Book> results = getInventory();
        sortByTitleAsc(results);
        return results;
    }

    public ArrayList<Book> getAllBooksSortedByAuthor() {
        ArrayList<Book> results = getInventory();
        sortByAuthorAsc(results);
        return results;
    }

    public ArrayList<Book> getBooksOfGenreSortedByTitle(String genreQuery) {
        ArrayList<Book> results = new ArrayList<Book>();
        String q = normalize(genreQuery);

        for (int i = 0; i < inventory.size(); i++) {
            Book b = inventory.get(i);
            if (b != null && normalize(b.getGenre()).equals(q)) {
                results.add(b);
            }
        }

        sortByTitleAsc(results);
        return results;
    }

    public Book inspectByTitle(String exactTitle) {
        Book b = getByExactTitle(exactTitle);
        if (b == null) {
            System.out.println("No book found with title: " + exactTitle);
            return null;
        }

        System.out.println("\n[-------- Book Inspection --------]");
        System.out.println("\""+b.getTitle()+"\""+" ("+b.getSeries()+")");
        System.out.println("by "+b.getAuthor());
        System.out.println();
        System.out.println("Rating: "+b.getRating());
        System.out.println("Genre: "+b.getGenre());
		
        ArrayList<Book> siblings = b.findSiblings(this);
        if (siblings.size() > 0) {
            System.out.println("Other books in the same series:");
            sortByRatingDesc(siblings);
            for (int i = 0; i < siblings.size(); i++) {
                System.out.println("  " + siblings.get(i)); 
            }
        } else {
            if (!normalize(b.getSeries()).equals("standalone")) {
                System.out.println("No other books in the library from this series.");
            } else {
                System.out.println("This book is a Standalone (no series).");
            }
        }
        
     

        return b;
    }

    public boolean add(Book book) {
        if (book == null) return false;

        if (getByExactTitle(book.getTitle()) != null) {
            return false;
        }
        inventory.add(book);
        return true;
    }

    public Book addBookInteractive(Scanner input) {
        if (input == null) return null;

        System.out.println("\n[-------- Add A Book --------]");

        System.out.print("Title: ");
        String title = input.nextLine().trim();

        if (title.length() == 0) {
            System.out.println("Title cannot be blank.");
            return null;
        }
        if (getByExactTitle(title) != null) {
            System.out.println("A book with that title already exists.");
            return null;
        }

        System.out.print("Author: ");
        String author = input.nextLine().trim();

        System.out.print("Genre: ");
        String genre = input.nextLine().trim();

        System.out.print("Series name (or press Enter for Standalone): ");
        String series = input.nextLine().trim();
        if (series.length() == 0) series = "Standalone";

        double rating = readRating(input);

        Book created = new Book(title, author, genre, rating, series);
        inventory.add(created);

        System.out.println("\nAdded: " + created);
        System.out.println("[----------------------------]\n");

        return created;
    }

    public boolean removeByTitle(String exactTitle) {
        for (int i = 0; i < inventory.size(); i++) {
            Book b = inventory.get(i);
            if (b != null && equalsIgnoreCaseSafe(b.getTitle(), exactTitle)) {
                inventory.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Book> getInventory() {
        ArrayList<Book> copy = new ArrayList<Book>();
        for (int i = 0; i < inventory.size(); i++) {
            copy.add(inventory.get(i));
        }
        return copy;
    }

    public int size() { return inventory.size(); }

    public void printResults(ArrayList<Book> results) {
        System.out.println("\n----==// Library Results //==----\n");

        if (results == null || results.size() == 0) {
            System.out.println("\n           (no matches)\n");
        } else {
            for (int i = 0; i < results.size(); i++) {
                System.out.println("["+i+"] "+results.get(i));
            }
        }

        System.out.println("\n------========<<📙>>========------\n");
    }

    private Book getByExactTitle(String exactTitle) {
        for (int i = 0; i < inventory.size(); i++) {
            Book b = inventory.get(i);
            if (b != null && equalsIgnoreCaseSafe(b.getTitle(), exactTitle)) {
                return b;
            }
        }
        return null;
    }

    private static String normalize(String s) {
        if (s == null) return "";
        return s.trim().toLowerCase();
    }

    private static boolean equalsIgnoreCaseSafe(String a, String b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.trim().equalsIgnoreCase(b.trim());
    }

    private static void sortByRatingDesc(ArrayList<Book> list) {
        if (list == null) return;

        for (int i = 0; i < list.size() - 1; i++) {
            int bestIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getRating() > list.get(bestIndex).getRating()) {
                    bestIndex = j;
                }
            }
            if (bestIndex != i) {
                Book temp = list.get(i);
                list.set(i, list.get(bestIndex));
                list.set(bestIndex, temp);
            }
        }
    }

    private static void sortByTitleAsc(ArrayList<Book> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int best = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getTitle().compareToIgnoreCase(list.get(best).getTitle()) < 0) {
                    best = j;
                }
            }
            Book temp = list.get(i);
            list.set(i, list.get(best));
            list.set(best, temp);
        }
    }

    private static void sortByAuthorAsc(ArrayList<Book> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int best = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getAuthor().compareToIgnoreCase(list.get(best).getAuthor()) < 0) {
                    best = j;
                }
            }
            Book temp = list.get(i);
            list.set(i, list.get(best));
            list.set(best, temp);
        }
    }

    private static double readRating(Scanner input) {
        while (true) {
            System.out.print("Rating (0.0 to 10.0): ");
            String line = input.nextLine().trim();

            try {
                double r = Double.parseDouble(line);
                if (r >= 0.0 && r <= 10.0) {
                    return r;
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number from 0 to 10.");
            }
        }
    }
}
