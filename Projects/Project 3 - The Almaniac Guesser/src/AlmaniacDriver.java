import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
public class AlmaniacDriver {
    public static void main(String[] args) throws Exception {
        AlmanicTree theAlmanic = new AlmanicTree();
        System.out.print(theAlmanic);
        PrintWriter overwrite = null;
        /**/
        try {
        File answers = new File("C:\\Users\\Surp\\Documents\\DataAlg\\Projects\\Project 3 - The Almaniac Guesser\\src\\answers.txt");  
        Scanner answersAdd = new Scanner(answers);
        if(answersAdd.hasNextLine()) {init(theAlmanic, answersAdd);} else {theAlmanic.add("start", "Is it a zombie?", "");}
        overwrite = new PrintWriter(new FileWriter(answers, false)); 
        } catch (FileNotFoundException e) {
            theAlmanic.add("start", "Is it a zombie?", "");
            overwrite = new PrintWriter(new FileWriter("answer.txt", false));
        } 
        overwrite.println(theAlmanic);
        overwrite.close();
    }
    public static void init(AlmanicTree tree, Scanner textFile) {
        while(textFile.hasNextLine()) {
            String entry = textFile.nextLine(); 
            if(entry == "") {} else {
            String[] yo = entry.split("=");
            String name = yo[0];
            String question = yo[1];
            try {
            String directions = yo[2];
            tree.add(name, question, directions);
            } catch (Exception e) {tree.add(name, question, "");}
        }
    }
    }
}
