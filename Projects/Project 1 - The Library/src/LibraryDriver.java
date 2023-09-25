//import DSListStuff.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
public class LibraryDriver {
    /* Project requirements here, driver furfills all requirements:
        using both a gui and the console to do so.
    The user should be to do the following

       1. Add a new book – 
            If a user chooses this option, he or she should then be prompted for the author, title, and price of that book. 
            You may assume that all info is typed correctly and that it is really a new book (i.e. it’s not already listed in the inventory). 
            The program should then add this book to the list with three copies in stock.
     
        2. List all in-stock books – 
            Print (in a neatly formatted way) 
            all the books in the inventory that are in stock with all of their associated information. 
            The program should print the message “No books in the inventory” 
            if there are (duh!) no books in the inventory, or “No books in stock” 
            if there are (double duh!) no books in stock.

       3. List all the books by a particular author – 
            The user should be prompted for the author’s name. 
            Print all the information associated with each book by that author. 
            If there are no such books, print an appropriate message instead. 
            (Print info for books in or out of stock.)

        4. Record a purchase - 
            Prompt the user for the title of the book bought, and how many copies were purchased. 
            If there are enough copies in stock, the total price paid for the books should be added to the total revenue, 
            the number of copies sold should be incremented appropriately, 
            and the number of copies in stock should be decremented appropriately. 
            If there aren’t enough copies, print an error message. 
            You can assume the title actually exists in the inventory,
            and that the number of copies purchased is a non-negative integer.
            Print the total price paid to the screen.

        5. Print all “best sellers” – 
            Print the information for the book(s) that sold the most copies. 
            If there is more than one such book, print all of them. (So if no books are sold, you’ll print all the books. 
            If there are no books in the inventory, print an appropriate message. 
            A book can be a best seller even if it’s out of stock.)

        6. Refresh inventory – 
            Set the number of copies in stock of all books in the inventory back to three.

        7. Close the program – 
            This should print the total revenue earned during the program’s execution and then quit the program.
     */

    /* I decided to make the driver have a hybrid between:
    *  having a gui to press buttons and a system.in interactions.
    */
    public static void main(String[] args) {
        Library theLibrary = new Library();
        Window theWindow = new Window();
        startup(theLibrary); //for testing the program. 
        Scanner user = new Scanner(System.in);
        JFrame window = theWindow.getWindow(); //makes the display frame
        window.addWindowListener(new WindowAdapter() { 
            //end of program runs when the x is clicked.
            @Override
            public void windowClosed(WindowEvent windowClosed) {
                closing(theLibrary); //gets the revenue produced in the program or tells that there's none
                System.exit(0);
            }
        });
        JPanel buttonPanel = theWindow.getPanel();
        JButton addBook = new JButton("add a new book");
        JButton listAllInStock = new JButton("list all books in stock");
        JButton listAllByAuthor = new JButton("list all books by a certain author");
        JButton recordPurchase = new JButton("Record a purchase");
        JButton bestSellers = new JButton("print Best Sellers");
        JButton refresh = new JButton("refresh books");
        buttonPanel.add(addBook);
        buttonPanel.add(listAllInStock);
        buttonPanel.add(listAllByAuthor);
        buttonPanel.add(recordPurchase);
        buttonPanel.add(bestSellers);
        buttonPanel.add(refresh);
        window.getContentPane().add(BorderLayout.CENTER, buttonPanel);
        window.setVisible(true);
        addBook.addActionListener(new ActionListener() { 
            /*method activates when the "add a new book" button is pressed
             *it hides the window for protection and has the user make it via system.in interactions.
             */
                public void actionPerformed(ActionEvent buttonPressed) {
                    window.setVisible(false);
                    addNewBook(user, theLibrary);
                    window.setVisible(true);
                }
              });
        listAllInStock.addActionListener(new ActionListener() {
            /*method activates when the corresponding button is pressed
             *it hides the window for protection.
             */
            public void actionPerformed(ActionEvent buttonPressed) {
                window.setVisible(false);
                try {
                System.out.println("Books currently in stock:\n" + theLibrary.getInStock());
                } catch (Exception except) {
                    System.out.println(except.getMessage());
                }
                window.setVisible(true);
            }
        });
        listAllByAuthor.addActionListener(new ActionListener() {
            /*method activates when the corresponding button is pressed
             *it hides the window for protection.
             */
            public void actionPerformed(ActionEvent buttonPressed) {
                window.setVisible(false);
                String author = getAuthor(user);
                try {
                System.out.println("Books by " + author + ":\n" + theLibrary.getAllByAuthor(author));
                } catch (Exception except) {
                    System.out.println(except.getMessage());
                }
                window.setVisible(true);
            }
        });
        recordPurchase.addActionListener(new ActionListener() {
            /*method activates when the corresponding button is pressed
             *it hides the window for protection.
             */
            public void actionPerformed(ActionEvent buttonPressed) {
                window.setVisible(false);
                String title = getTitle(user);
                int bookPos = theLibrary.getTitles().postitionOf(title);
                /*
                 * this tells the user what they are getting if the book's found
                 * otherwise it returns back to the original state before it was activated
                 */
                if(bookPos != -1) { 
                    try {
                        Book theBook = theLibrary.getLibrary().get(bookPos);
                        System.out.println("You're getting " + theBook.getTitle() + " by " + theBook.getAuthor() + "!");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    } 
                } else {
                    window.setVisible(true);
                    System.out.println(title + " isn't in this library!");
                    return;
                    }
                int quantity = getQuantity(user); 
                user.nextLine();
                try { //tells what was gained in revenue by the purchase and the current revenue
                    System.out.println(theLibrary.purchase(title, quantity) + " was gained in revenue by this purchase!");
                    System.out.println("Current revenue: $" + Math.floor(theLibrary.getRevenue()*100)/100);
                } catch (Exception except) { 
                    //exception cases, refreshs the library of the case of an exception
                    System.out.println(except.getMessage());
                    try {
                    theLibrary.refresh();
                    } catch (Exception listex) {
                    System.out.println(listex.getMessage());
                    }
                }
                window.setVisible(true);
            }
        });
        bestSellers.addActionListener(new ActionListener() {
            /*method activates when the corresponding button is pressed
             *it hides the window for protection.
             */
            public void actionPerformed(ActionEvent buttonPressed) {
                window.setVisible(false);
                try {
                System.out.println("Best Sellers:\n" + theLibrary.getBestSellers());
                } catch (Exception except) {
                    System.out.println(except.getMessage());
                }
                window.setVisible(true);
            }
        });
        refresh.addActionListener(new ActionListener() { 
            /*method activates when the "refreshed" button is pressed
             *it hides the window for protection and has the user make it via system.in interactions.
             */
                public void actionPerformed(ActionEvent buttonPressed) {
                    window.setVisible(false);
                try {
                theLibrary.refresh();
                } catch (Exception except) {
                    System.out.println(except.getMessage());
                }
                window.setVisible(true);
                System.out.println("The Library has been refreshed!");
            }
        });
    }
    /*
     * @param Scanner
     * @param Library
     * void
     * Makes and Adds a new book with the user interaction for it
     */
    public static void addNewBook(Scanner s, Library l) {
        try {
        System.out.println("Who's the author? ");
        String author = s.nextLine();
        System.out.println("What's the title? ");
        String title = s.nextLine();
        System.out.println("The price? (only the number please) ");
        double price = s.nextDouble();
        l.addBook(author, title, price);
        System.out.println("your new book has been made and added to the library!");
        s.nextLine(); //this is here to prevent le funny scanner bug
        } catch (Exception e) {
            System.out.println("your book isn't added to the library!");
        }
    }
    /*
     * @param Scanner
     * void
     * gets an author of a book by asking the user
     */
    public static String getAuthor(Scanner user) {
        System.out.println("Who's the author?");
        return user.nextLine();
    }
    /*
     * @param Scanner
     * void
     * gets a quantity by asking the user
     */
    public static int getQuantity(Scanner user) {
        System.out.println("How much are you getting? (only the number please)");
        return user.nextInt();
    }
    /*
     * @param Scanner
     * void
     * gets the title of an book by asking the user
     */
    public static String getTitle(Scanner user) {
        System.out.println("What's the title?");
        return user.nextLine();
    }
    /*
     * @param Library
     * void
     * the closing program process, prints the revenue that was produced during the time of the program
     */
    public static void closing(Library library) {
        try {
        System.out.println("$" + Math.floor(library.getRevenue()*100)/100 + " in total revenue was produced during this program's execution!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    /* @param Library
     * void
     * adds varibles to the program for testing purposes, making it less tedious to test
    */
    public static void startup(Library library) {
        try {
        library.addBook("sus", "impostor", 5.092);
        library.addBook("George Orwell", "1984", 10);
        library.addBook("Huxley", "Brave New World", 30);
        library.addBook("sus", "b", 300);
        } catch(Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
