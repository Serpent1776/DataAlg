import java.math.BigDecimal;
import java.math.BigInteger;

public class Recursion {
    public static void main(String[] args) {
        try {
        //System.out.println(Math.pow(365, 5));
        System.out.println();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static BigDecimal factorial(BigDecimal num, int n) { 
        if(n == 1) {return num;}
        return num.multiply(factorial(num.add(new BigDecimal("1")), n-1));
    }
    public static BigDecimal choose(int capacity, int choices) throws Exception {
        if(choices > capacity) {throw new Exception("choices is more than capacity");}
        int fact = capacity - (choices - 1);
        BigDecimal BigOne = new BigDecimal("" + fact);
        BigDecimal BigFact = factorial(BigOne, capacity - (fact - 1));
        BigDecimal factChoices = factorial(new BigDecimal("1"), choices);
        return BigFact.divide(factChoices);
    }
}
