import java.awt.event.*;
import java.io.*;
//import java.nio.file.*;
import java.util.Scanner;
//import javax.swing.*;
public class AlmaniacDriver {
    public static void main(String[] args) throws Exception {
        AlmanicTree theAlmanic = new AlmanicTree();
        AlmanicWindows game = new AlmanicWindows();
        System.out.print(theAlmanic);
        PrintWriter overwrite = null;
        Scanner objectMaker = new Scanner(System.in);
        /**/
        //initialization
        try {
        File answers = new File("pVzAnswers.txt");  
        Scanner answersAdd = new Scanner(answers);
        if(answersAdd.hasNextLine()) {init(theAlmanic, answersAdd);} else {enrooten(theAlmanic);}
        overwrite = new PrintWriter(new FileWriter(answers, false)); 
        } catch (FileNotFoundException e) {
            enrooten(theAlmanic);
            overwrite = new PrintWriter(new FileWriter("pVzAnswers.txt", false));
        } 
        final PrintWriter WRITE = overwrite;
        game.addWindowListenerTitleMenu(new WindowAdapter() {
            public void windowClosed(WindowEvent windowClosed) {
                theEnd(WRITE, theAlmanic);
            }});
        game.addWindowListenerQuestionarre(new WindowAdapter() {
            public void windowClosed(WindowEvent windowClosed) {
                game.questionarreVisibletoggle();
                game.titleVisibletoggle();
            }});
        game.addActionListenerPlay(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent buttonPressed) {
            try {
            /*
             * Play "function"
             * If yes to a distinguishing question, has a confirmation of an is it. aka qYes
             * If no to a distinguishing question, it moves without question to the next question. aka qNo
             * If yes on confirmation, it ends play, celebrating. cYes
             * If no on confrimation, it moves to next question. cNo
             * If it hits a null pointer, it asks the user and makes a new node, ending play.
             * During play. it logs the user's answers in the console, so they make questions easier.
             */
            game.titleVisibletoggle();
            game.setGameQuestion("Think of a plant or zombie: " + theAlmanic.getStrHelper(theAlmanic.getPos()));
            game.questionarreVisibletoggle();
             } catch (Exception e) {
                System.out.print(e);
            }
        }
       }); 
       game.addActionListenerEnd(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent buttonPressed) { 
            theEnd(WRITE, theAlmanic);
        }
        });
        game.addActionListenerQYes(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent buttonPressed) {
              try {
            if(theAlmanic.posAtRoot()) {
                theAlmanic.setPlant();
                System.out.println("Start Log");   
            }
            game.questionarreVisibletoggle();
            System.out.println(theAlmanic.getStrHelper(theAlmanic.getPos()) + " Yes");
            theAlmanic.setPlant();
            theAlmanic.posright();
            game.setGameQuestion(theAlmanic.getStrHelper(theAlmanic.getPos()));
            game.questionarreVisibletoggle();
            } catch(Exception e) {
                ///System.out.println(e);
                game.setConfirmQuestion("Is it a " + theAlmanic.getLeafname(theAlmanic.getPos()) + "?");
                game.confirmVisibletoggle();
            }
            }
            
        }
       ); 
        game.addActionListenerQNo(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent buttonPressed) {
            try {
            if(theAlmanic.posAtRoot()) {
                theAlmanic.setZombie();
                System.out.println("Start Log");   
            }
            game.questionarreVisibletoggle();
            System.out.println(theAlmanic.getStrHelper(theAlmanic.getPos()) + " No");
            theAlmanic.posleft();
            game.setGameQuestion(theAlmanic.getStrHelper(theAlmanic.getPos()));
            game.questionarreVisibletoggle();
            } catch(Exception e) {
                game.setConfirmQuestion("Is it a " + theAlmanic.getLeafname(theAlmanic.getPos()) + "?");
                game.confirmVisibletoggle();
            }
        }
       }); 
          game.addActionListenerCYes(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent buttonPressed) {
           try {
            game.confirmVisibletoggle();
            System.out.println("Is it a " + theAlmanic.getLeafname(theAlmanic.getPos()) + "? Yes!!!");
            System.out.println("End Log");
            System.out.println("Yes, I guessed Right!!!\n");
            theAlmanic.posreset();
            game.setGameQuestion(theAlmanic.getStrHelper(theAlmanic.getPos()));
            game.titleVisibletoggle();
           } catch (Exception e) {
            System.out.print(e);
           }
        }});
       game.addActionListenerCNo(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent buttonPressed) {
            try {
            game.confirmVisibletoggle(); 
            System.out.println("Is it a " + theAlmanic.getLeafname(theAlmanic.getPos()) + "? Noooo!!");
            System.out.println("End Log");
            System.out.print("You tripped me up! Name for "+ theAlmanic.getPvz() + "? ");
            String name = objectMaker.nextLine();
            AlmanicEntry newEntry = new AlmanicEntry(name, theAlmanic.getPosDirections() + "R");
            System.out.print("Question that makes this " + theAlmanic.getPvz() + " unique from the others? \n (look above \"End Log\" to help) \n");
            String question = objectMaker.nextLine();
            theAlmanic.add(question, newEntry);
            theAlmanic.posreset();
            System.out.println();
            game.setGameQuestion(theAlmanic.getStrHelper(theAlmanic.getPos()));
            game.titleVisibletoggle();
            } catch (Exception e) {
            System.out.print(e);
           }
        }});
       game.titleVisibletoggle();
    }
    public static void init(AlmanicTree tree, Scanner textFile) {
        while(textFile.hasNextLine()) {
            String entry = textFile.nextLine(); 
            if(entry == "") {} else {   
            String[] yo = entry.split("=");
            boolean isLeaf = Boolean.parseBoolean(yo[0]);
            String str = yo[1];
            try {
            String directions = yo[2];
            tree.add(isLeaf, str, directions);
            if(isLeaf) {
                AlmanicEntry leaf = new AlmanicEntry(str, directions);
                tree.addLeaves(leaf);
            }
            } catch (Exception e) {tree.add(isLeaf, str, "");
        }
    }
    tree.posreset();
    }
    } /* */
    public static void enrooten(AlmanicTree theAlmanic) {
        AlmanicEntry sunFlower = new AlmanicEntry("Sunflower", "R");
        AlmanicEntry zombie = new AlmanicEntry("Regular Zombie", "L");
        theAlmanic.root("is it a plant?", zombie, sunFlower);
    }
    public static void theEnd(PrintWriter save, AlmanicTree theAlmanic) {
        save.println(theAlmanic);
        save.close();
        System.exit(0);
    }
   
}
