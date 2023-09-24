public class Book implements Comparable<Book> {
    String author;
    String title;
    double price;
    int copies;
    int copiesSold;

    public Book(String author, String title, double price) {
        this.author = author;
        this.title = title;
        this.price = Math.floor(price*100)/100;
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
        if(copies > -1) {
        this.copies = copies;
        }
    } 
    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public double getPrice() {
        return Math.floor(price*100)/100;
    }
    public int getCopies() {
        return copies;
    }
    public int getCopiesSold() {
        return copiesSold;
    }
    public void setCopiesSold(int copiesSold) {
        if(copies > -1) {
        this.copiesSold = copiesSold;
        }
    }
    public int compareTo(Book other) {
        int authorComparison = this.author.compareTo(other.author);
        int titleComparison = this.title.compareTo(other.title);
        int priceComparison = (int)(Math.round(this.price - other.price));
        return authorComparison + titleComparison + priceComparison;
        
    }
    public String toString() {
        String o = ". It has " + copies + " copies";
        if(copies == 0) {
            o += " and this book is not currently in stock.";
        } else {
            o += ".";
        }
        return title + " by " + author + o + "\n\tCost: " + price + "\tCopies sold: " + copiesSold;
    }

}
