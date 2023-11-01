import java.math.*;
import java.util.ArrayList;
import java.util.List;


public class Recursion {
    public static void main(String[] args) {
        try {
        //System.out.println(Math.pow(365, 5));
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(6);
        list.add(8);
        list.add(-4);
        list.add(1);
        list.add(3);
        int[] sumlist = {6, 8, -4, 1, 3};
        System.out.println(sumArr(sumlist, 0)); 
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static BigDecimal factorial(BigDecimal num, int n) { 
        if(n <= 1) {return num;}
        return num.multiply(factorial(num.add(new BigDecimal("1")), n-1));
    }
    public static BigDecimal sumUp(BigDecimal num, int n) { 
        if(n <= 1) {return num;}
        return num.add(sumUp(num.add(new BigDecimal("1")), n-1));
    }
    public static BigInteger StringSum(String num, int n) {
        if(n == 0) {return new BigInteger("0");}
        return new BigInteger(num.substring(n - 1, n)).add(StringSum(num, n - 1));
        
    }
    public static BigDecimal permutation(int capacity, int pers) throws Exception {
         if(pers > capacity) {throw new Exception("permutations is more than capacity");}
        int fact = capacity - pers;
        BigDecimal capafact = factorial(new BigDecimal("1"), capacity);
        BigDecimal factfact = factorial(new BigDecimal("1"), fact);
        return capafact.divide(factfact);
    }
    
    public static BigDecimal choose(int capacity, int choices) throws Exception {
        if(choices > capacity) {throw new Exception("choices is more than capacity");}
        int fact = capacity - (choices - 1);
        BigDecimal BigOne = new BigDecimal("" + fact);
        BigDecimal BigFact = factorial(BigOne, capacity - (fact - 1));
        BigDecimal factChoices = factorial(new BigDecimal("1"), choices);
        return BigFact.divide(factChoices);
    }
    public static int sumList(List<Integer> intList) {
        if(intList.size() == 0) {return 0;}
        int base = intList.get(0);
        return base + sumList(intList.subList(1, intList.size()));
    }
    public static int sumArr(int[] arr, int base) {
        if(base == arr.length) {return 0;}
        int sumRest = sumArr(arr, base + 1);
        return arr[base] + sumRest;
    }
}
