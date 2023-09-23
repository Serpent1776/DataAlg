public class Book implements Comparable<Book> {
    String author;
    String title;
    double price;
    int copies;
    int copiesSold;

    public Book(String author, String title, double price) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.copies = 3;
        this.copiesSold = 0;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPrice(double price) {
        if(price > 0.0) {
        this.price = price;
        }
    }
    public void setCopies(int copies) {
        if(copies > 0) {
        this.copies = copies;
        }
    }
    public void setCopiesSold(int copiesSold) {
        if(copies > 0) {
        this.copiesSold = copiesSold;
        }
    }
    public int compareTo(Book other) {
        int authorComparison = this.author.compareTo(other.author);
        int titleComparison = this.title.compareTo(other.title);
        int priceComparison = (int)(Math.round(this.price - other.price));
        int copiesComparison = (int)(Math.round(this.copies - other.copies));
        int copiesSoldComparison = (int)(Math.round(this.copiesSold - other.copiesSold));
        return authorComparison + titleComparison + priceComparison + copiesComparison + copiesSoldComparison;
        
    }

}
