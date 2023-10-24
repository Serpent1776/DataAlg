public class Card {
    String desc;
    String title;
    boolean isDrawn;
    public Card(String desc, String title, boolean isDrawn) {
        this.desc = desc;
        this.title = title;
        this.isDrawn = isDrawn;
    }
    public void setDrawn(boolean isDrawn) {
        this.isDrawn = isDrawn;
    }
    public String toString() {
        
        if(isDrawn) {
            return "Title: " + this.title + "\nDescription: " + this.desc + "\nThis card has been drawn.";
        } else {
            return "Title: " + this.title + "\nDescription: " + this.desc + "\nThis card has not been drawn.";
        }
    }
}
