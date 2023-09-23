
public class Topping implements Comparable<Topping> {
    String toppingName;
    int toppingNum;

    public Topping(String toppingName, int toppingNum) {
        this.toppingName = toppingName;
        this.toppingNum = toppingNum;
    }
    public String getToppingName() {
        return toppingName;
    }
    public int getToppingNum() {
        return toppingNum;
    }
    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }
    public void setToppingNum(int toppingNum) {
        this.toppingNum = toppingNum;
    }
    public int compareTo(Topping otherTopping) {
        int nameComparision = this.toppingName.compareTo(otherTopping.toppingName);
        int numComparision = this.toppingNum - otherTopping.toppingNum;
        return nameComparision + numComparision;
    }
    public String toString() {
        String toppingString = "This pizza has " + toppingNum + " " + toppingName;
        if(toppingNum != 1) {toppingString += "s per slice";} else {toppingString += " per slice";}
        return toppingString;
    }
	
}
