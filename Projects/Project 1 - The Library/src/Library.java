import DSListStuff.*;
public class Library implements Inventory {
DSArrayList<Book> library;
public Library() {
library = new DSArrayList<Book>();
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
    library.add(newBook);
}
/**
* Gets all books currently in stock (more than 0 copies available)
* @return DSArrayList of Book objects representing those in stock
* O(n) time, Exception case 1: O(1) time
*/
public DSArrayList<Book> getInStock() throws DSListException {
    if(library.size() == 0) {
    throw new DSListException("There is no books in the inventory");
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
    throw new DSListException("No books are in stock.");
}
/**
* Gets all books recorded in inventory by a particular author
* @param author - name of author requested
* @return DSArrayList of Book objects by that author
* O(n) time, Exception case 1: O(1) time
*/
public DSArrayList<Book> getAllByAuthor(String author) throws DSListException {
    if(library.size() == 0) {
    throw new DSListException("There is no books in the inventory");
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
* O(n) time
*/
public double purchase(String title, int quantity) throws DSListException, LibraryException {
    Book sellingBook = null;
    for(int i = 0; i < library.size(); i++) {
        try {
        if(library.get(i).getTitle() == title) {
            sellingBook = library.get(i);
            break;
        }
    } catch(DSListException e) {
        throw new DSListException(e.getMessage());
    }
    }
    if(sellingBook == null) {throw new LibraryException( title + " isn't in the library.");}
    if(quantity > sellingBook.getCopies()) {
        throw new LibraryException("Quantity is more than the book's copies!");
    }
    sellingBook.setCopies(sellingBook.getCopies() - quantity);

    return quantity*sellingBook.getPrice();
}
/**
* Returns all books that have sold the most copies
* @return list of such books
* O(n) time
*/
public DSArrayList<Book> getBestSellers() throws DSListException{
    Book greatest = library.get(0);
    for(int i = 0; i < library.size(); i++) {
        if(greatest.getCopiesSold() < library.get(i).getCopiesSold()) {
            greatest = library.get(i);
        }
    }
    DSArrayList<Book> bestSellers = new DSArrayList<Book>();
    for(int i = 0; i < library.size(); i++) {
        if(greatest.getCopiesSold() == library.get(i).getCopiesSold()) {
            bestSellers.add(library.get(i));
        }
    }
    return bestSellers;
}
/**
* Resets number of copies in inventory for all books to 3
* O(n) time
*/
public void refresh() throws DSListException {
  for(int i = 0; i < library.size(); i++) {
    library.get(i).setCopies(3);
  }
}
/**
* Returns current value of total amount paid for books
* @return total revenue
* O(n) time
*/
public double getRevenue() throws DSListException, LibraryException {
    double sum = 0.0;
    for(int i = 0; i < library.size() ;i++) {
        Book summedBook = library.get(i);
        sum += summedBook.getPrice()*summedBook.getCopiesSold();
    }
    if(sum == 0.0) {throw new LibraryException("Nothing has been sold, so no revenue.");}
    return sum;
}
}
