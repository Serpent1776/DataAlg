import DSListStuff.*;
//import java.math.*;
public class Recurse {
    public static void main(String[] args) throws Exception {
        //2,3,5,-5,6, -9
        DSLinkedList<Integer> sus = new DSLinkedList<Integer>();
        sus.add(2);
        sus.add(3);
        sus.add(5);
        sus.add(-5);
        sus.add(-5);
        sus.add(9);
        //sus.add(2) 
        System.out.println(sus.hasConsecutiveRepeathelper());
    }
    /*
1. listOfSquares(n) - returns a DSList<Integer> of the squares of the integers from 1 to n. 
    For example, if n=4, it would return a list containing 1, 4, 9, and 16 (in that order). 
*/
public static DSList<Integer> listofSquares(int n) throws DSListException {
    if(n == 0) {return null;}
    DSList<Integer> list = new DSArrayList<Integer>(); //new list
    list.add(n*n); //adds square
    DSList<Integer> listRest = listofSquares(n-1); //the rest of the list, recursive case
    if(listRest != null) {
    listRest.add(list.get(0)); //list gets appended to the end, appending the square
    }
   if(n < 2) { //null mitigater
    return list; //one case just grabs the list, so there is no null.
    } else {
   return listRest; //returns living list
   }

}


/*
2. bitFlip(s) - takes a string of 0s and 1s and flips all the 0s to 1s and all the 1s to 0s. 
For example, bitFlip("001101") would return "110010".
*/
public static String bitFlips(String s) {
    if(s == "") {return "";}
    switch (s.substring(0,1)) {
        case "1":
            return "0" + bitFlips(s.substring(1));
    
        default:
            return "1" + bitFlips(s.substring(1));
    }
}
/*
3. expand(s) — given a string where the characters at even indices are letters and the characters 
at odd indices are single digits (like "a3b8z3e0y2"), 
this method returns the string obtained by replacing each character at an even index 
with a number of copies of it equal to the digit immediately following it. 
For the string given above, the result should be "aaabbbbbbbbzzzyy".
*/
public static String expand(String s) {
    if(s == "") {return "";}
    String sus = s.substring(0,2);
    String su = "";
    for(int i = 0; i < Integer.parseInt(sus.substring(1,2)); i++) {
        su += sus.substring(0, 1);
    }
    return su + expand(s.substring(2));
}

/*
4. containsNegativePair(list) — returns true if anywhere in the list there are consecutive integers that
 are negatives of each other. It returns false otherwise. 
 For instance, it would return true for the list [2,3,5,-5,6, -9] because that list contains 
 the consecutive pair, 5, -5, which are negatives of each other.
 It would also return true for [2,3,-5, 5, 6, -9], but false for [2, 3, 5, -9, -5, 6]. 
 The "list" passed in should be of type LinkedList<Integer>.
*/
public static boolean containsNegativePair(DSLinkedList<Integer> list) {
    try {
        boolean boofirst = (list.get(0) == -list.get(1) || -list.get(0) == list.get(1)); 
    return boofirst || containsNegativePair(list.subList(1));
    } catch(Exception e) {
        return false;
    }
}
/*
5. hasConsecutiveRepeat() - this method should be considered part of DSLinkedList<E>. 
It should return true if this list contains two consecutive equal elements and false otherwise. 
For example, this is true for the list [7,3,3,9,2, 9] because of the two 3s (but not the two 9s). 
This one will need a helper function.  */
//Is found in this linked list.
}


