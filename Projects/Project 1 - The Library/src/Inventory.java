import DSListStuff.*;
public interface Inventory {
/**
* Adds a new book to inventory with 3 copies
* @param author - author of book to add
* @param title - title of book to add
* @param price - cost of book
*/
public void addBook(String author, String title, double price) throws DSListException, LibraryException;
/**
* Gets all books currently in stock (more than 0 copies available)
* @return DSArrayList of Book objects representing those in stock
*/
public DSArrayList<Book> getInStock() throws DSListException;
/**
* Gets all books recorded in inventory by a particular author
* @param author - name of author requested
* @return DSArrayList of Book objects by that author
*/
public DSArrayList<Book> getAllByAuthor(String author) throws DSListException;
/**
* Purchases copies of a book, adjusting the inventory as described in the
assignment
* @param title name of the book
* @param quantity how many copies are requested
* @return total amount paid for the book
*/
public double purchase(String title, int quantity) throws DSListException, LibraryException;
/**
* Returns all books that have sold the most copies
* @return list of such books
*/
public DSArrayList<Book> getBestSellers() throws DSListException, LibraryException;
/**
* Resets number of copies in inventory for all books to 3
*/
public void refresh() throws DSListException, LibraryException;
/**
* Returns current value of total amount paid for books
* @return total revenue
*/
public double getRevenue() throws DSListException, LibraryException;
}
