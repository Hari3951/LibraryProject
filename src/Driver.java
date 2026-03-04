public class Driver {
    // team we need to figure this one out

    // any ideas??


    //uhhhhh ok so:
    //everything loads in, and we can throw the users into a library with a message like:
    //"[Library Name]"
    //----------------

    //then ask for user input using the scanner class:
    //(the user can always type "!back" to return to the previous prompt)
    //"what would you like to do? (Search, Recommend, Add, Browse)" 
    //> search would then prompt the user to search with either author name or book title, and then
    //  prints a long list of books that matched the search (sorted based on rating)
    //> recommend would ask the user for a genre and then return a list of books which all have that genre
    //> add would ask the user for title, then author, then genre of the book, and then create a new book from that data.
    //> browse would just print out all the books in the library.

    //once the user is either in the indexed list printed by search, recommend, or browse, they'll see smth like this:
    //[1] title by ---- (fantasy)
    //[2] title2 by person2 (historical fiction)
    // . . . 
    // and then they are prompted to type in a number to inspect a book closer, or to return to the main prompter

    //if they choose to inspect a book closer, it'll print a page with like maybe even a summary of the book, but will also
    //show stuff like ratings. Maybe an image?

    //and then all the books total can be stored on a text file and get loaded into the library's collection variable every time it loads.

}
