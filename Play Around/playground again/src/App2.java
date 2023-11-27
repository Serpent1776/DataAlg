import java.util.Scanner;
public class App2 {
    public static void main(String[] args) {
        Scanner typo = new Scanner(System.in);
        System.out.print("First one: ");
        String a = typo.next(); 
        System.out.print("Second one: ");
        String b = typo.next();
        System.out.println("Comparision: " + compo(a, b));
    }
    public static String compo(String a, String b) {
        int comp = a.compareTo(b);
        if(comp > 0) {
            return "first > second";
        } else if (comp < 0) {
            return "first < second";
        } else {
            return "first = second";
        }
    }
}
