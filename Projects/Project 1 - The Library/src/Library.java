import DSListStuff.*;
public class Library implements Inventory {
DSArrayList<Book> library;
DSArrayList<String> authors;
DSArrayList<String> titles;
public Library() {

this.library = new DSArrayList<Book>();
this.authors = new DSArrayList<String>();
this.titles = new DSArrayList<String>();
}
/**
* Adds a new book to inventory with 3 copies
* @param author - author of book to add
* @param title - title of book to add
* @param price - cost of book
* @time O(n) time
*/
public void addBook(String author, String title, double price) throws DSListException, LibraryException {
    Book newBook = new Book(author, title, price);
    library.addSorted(newBook);
    int pos = library.postitionOf(newBook);
    authors.add(author, pos);
    titles.add(title, pos);
}
/**
* Gets all books currently in stock (more than 0 copies available)
* @return DSArrayList of Book objects representing those in stock
* @time O(n) time, DSListException case 1: O(1) time
*/
public DSArrayList<Book> getInStock() throws DSListException {
    if(library.size() == 0) {
    throw new DSListException("There are no books in the inventory!");
    }
    DSArrayList<Book> theStock = new DSArrayList<Book>(); 
    for(int i = 0; i < library.size(); i++) {
        Book CurrentBook = library.get(i);
        if(CurrentBook.getCopies() > 0) {
            theStock.add(CurrentBook);
        }
    }
    if(theStock.size() > 0) {
    return theStock;
    }
    throw new DSListException("No books are in stock!");
}
/**
* Gets all books recorded in inventory by a particular author
* @param author - name of author requested
* @return DSArrayList of Book objects by that author
* @time O(n) time, DSListException case 1: O(1) time
*/
public DSArrayList<Book> getAllByAuthor(String author) throws DSListException {
    if(library.size() == 0) {
    throw new DSListException("There are no books in the inventory!");
    }
    DSArrayList<Book> authorBooks = new DSArrayList<Book>(); 
    for(int i = 0; i < library.size(); i++) {
        Book CurrentBook = library.get(i);
        if(CurrentBook.getAuthor().equals(author)) {
            authorBooks.add(CurrentBook);
        }
    }
    if(authorBooks.size() > 0) {
    return authorBooks;
    }
    throw new DSListException("No books by this author.");
}
/**
* Purchases copies of a book, adjusting the inventory as described in the
assignment
* @param title name of the book
* @param quantity how many copies are requested
* @return total amount paid for the book
* @time O(n) time
*/
public double purchase(String title, int quantity) throws DSListException, LibraryException {
    Book sellingBook = null; //using so if an error exists, I'll know. 
    for(int i = 0; i < library.size(); i++) { //loop that finds the book to be sold
        try {
        if(library.get(i).getTitle().equals(title)) {
            sellingBook = library.get(i);
            break;
        }
    } catch(DSListException e) {
        throw new DSListException(e.getMessage());
    }
    }
    if(sellingBook == null) {throw new LibraryException( title + " isn't in this library.");}
    if(quantity > sellingBook.getCopies()) {
        throw new LibraryException("Quantity is more than the book's copies!");
    }
    sellingBook.setCopies(sellingBook.getCopies() - quantity); //decrement of copies
    sellingBook.setCopiesSold(sellingBook.getCopiesSold() + quantity); //increment of copies sold
    return quantity*sellingBook.getPrice();
}
/**
* Returns all books that have sold the most copies
* @return list of such books
* @time O(n) time, LibraryException case: O(1) time
*/
public DSArrayList<Book> getBestSellers() throws DSListException, LibraryException{
    if(library.size() == 0) {throw new LibraryException("There are no books in the inventory!");}
    Book greatestSold = library.get(0);
    for(int i = 0; i < library.size(); i++) { //finds the greatest sold book
        if(greatestSold.getCopiesSold() < library.get(i).getCopiesSold()) {
            greatestSold = library.get(i);
        }
    }
    DSArrayList<Book> bestSellers = new DSArrayList<Book>();
    for(int i = 0; i < library.size(); i++) { 
        //puts stuff in the DSArrayList if it equals the greatest sold book
        if(greatestSold.getCopiesSold() == library.get(i).getCopiesSold()) {
            bestSellers.addSorted(library.get(i));
        }
    }
    return bestSellers;
}
/**
* Resets number of copies in inventory for all books to 3
* @time O(n) time, LibraryException case: O(1)
*/
public void refresh() throws DSListException, LibraryException {
    if(library.size() == 0) {throw new LibraryException("There is nothing to refresh since, there are no books in the inventory!");}
  for(int i = 0; i < library.size(); i++) {
    library.get(i).setCopies(3);
  }
}
/**
* Returns current value of total amount paid for books
* @return total revenue
* @time O(n) time, LibraryException case 1: O(1) time
*/
public double getRevenue() throws DSListException, LibraryException {
    if(library.size() == 0) {throw new LibraryException("Zero total revenue was produced during the execution of this program.");}
    double sum = 0.0;
    for(int i = 0; i < library.size() ;i++) {
        Book summedBook = library.get(i);
        sum += summedBook.getPrice()*summedBook.getCopiesSold();
    }
    if(sum == 0.0) {throw new LibraryException("Zero total revenue was produced during the execution of this program.");}
    return sum;
}
public DSArrayList<Book> getLibrary() {
    return library;
}
public DSArrayList<String> getauthors() {
    return authors;
}
public DSArrayList<String> getTitles() {
    return titles;
} 

}
