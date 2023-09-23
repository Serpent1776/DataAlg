import DSListStuff.*;
public class Library implements Inventory {
DSArrayList<Book> Library;
public Library() {
Library = new DSArrayList<Book>();
}
/**
* Adds a new book to inventory with 3 copies
* @param author - author of book to add
* @param title - title of book to add
* @param price - cost of book
* O(n) time
*/
public void addBook(String author, String title, double price) {
    Book newBook = new Book(author, title, price);
    Library.add(newBook);
}
/**
* Gets all books currently in stock (more than 0 copies available)
* @return DSArrayList of Book objects representing those in stock
*/
public DSArrayList<Book> getInStock() throws DSListException {
    DSArrayList<Book> theStock = new DSArrayList<Book>(); 
    for(int i = 0; i < Library.size(); i++) {
        Book CurrentBook = Library.get(i);
        if(CurrentBook.getCopies() > 0) {
            TheStock.add(CurrentBook);
        }
    }
    return theStock;
}
/**
* Gets all books recorded in inventory by a particular author
* @param author - name of author requested
* @return DSArrayList of Book objects by that author
*/
public DSArrayList<Book> getAllByAuthor(String author) {
    return new DSArrayList<Book>();
}
/**
* Purchases copies of a book, adjusting the inventory as described in the
assignment
* @param title name of the book
* @param quantity how many copies are requested
* @return total amount paid for the book
*/
public double purchase(String title, int quantity) {
    return 0.0;
}
/**
* Returns all books that have sold the most copies
* @return list of such books
*/
public DSArrayList<Book> getBestSellers() {
    return new DSArrayList<Book>();
}
/**
* Resets number of copies in inventory for all books to 3
*/
public void refresh() {

}
/**
* Returns current value of total amount paid for books
* @return total revenue
*/
public double getRevenue() {
    return 0.0;
}
}
