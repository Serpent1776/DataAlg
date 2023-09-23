
public class Pizza implements Comparable<Pizza> {
    private int slices;
    private Topping[] toppings;
    private double size;
    private boolean isHot;
    private boolean isBoxed;
    public Pizza(int slices, Topping[] toppings, double size, boolean isHot, boolean isBoxed) {
        this.slices = slices;
        this.toppings = toppings;
        this.size = size;
        this.isHot = isHot;
        this.isBoxed = isBoxed;
    }
    public Topping[] getToppings() {
        return toppings;
    }
    public void setToppings(Topping[] toppings) {
        this.toppings = toppings;
    }
    public int getSlices() {
        return slices;
    }
    public double getSize() {
        return size;
    }
    public void setSlices(int slices) {
        this.slices = slices;
    }
    public void setSize(double size) {
        this.size = size;
    }
    public void setHot(boolean isHot) {
        this.isHot = isHot;
    }
    public void setBoxed(boolean isBoxed) {
        this.isBoxed = isBoxed;
    }
    
    public int compareTo(Pizza otherPizza) {
        int equality = 0;
        equality += this.slices - otherPizza.slices;
        equality += (int)(Math.round(this.size - otherPizza.size));
        if(this.isHot && !otherPizza.isHot) {equality += 1;} 
        else if (!this.isHot && otherPizza.isHot) {equality -= 1;}
        if(this.isBoxed && !otherPizza.isBoxed) {equality += 1;} 
        else if (!this.isBoxed && otherPizza.isBoxed) {equality -= 1;}
        return equality;
    }
    public String toString() {
        String str = "Slices: " + this.slices + ", Size: " + this.size;
        if(this.isHot) {str += ", It's hot and";} else {str += ", It's cold and";}
        if(this.isBoxed) {str += " boxed.";} else {str += " unboxed.";}
        return str;
    }
}
