import java.awt.event.*;
import java.io.*;
//import java.nio.file.*;
import java.util.Scanner;
//import javax.swing.*;
public class AlmaniacDriver {
    public static void main(String[] args) throws Exception {
        AlmanicTree theAlmanic = new AlmanicTree(); //tree for the guessing game
        AlmanicWindows game = new AlmanicWindows(theAlmanic); 
        System.out.print(theAlmanic);
        PrintWriter overwrite = null;
        Scanner leafMaker = new Scanner(System.in); //makes the new leaf at the make the element ending
        /**/
        //initialization
        try {
        File answers = new File("Projects\\Project 3 - The Almaniac Guesser\\src\\pVzAnswers.txt");  
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
                theAlmanic.posreset();
                System.out.println("End Log");
                game.titleVisibletoggle();
            }});
        game.addWindowListenerConfirm(new WindowAdapter() {
            public void windowClosed(WindowEvent windowClosed) {
                game.confirmVisibletoggle();
                theAlmanic.posreset();
                System.out.println("End Log");
                game.titleVisibletoggle();
            }});    
        game.addActionListenerPlay(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent buttonPressed) {
            try {
            /*
             * Play "function"
             * If yes to a distinguishing question, it moves right to the next until it hits a leaf. aka qYes
             * If no to a distinguishing question, it moves left to the next question until it hits a leaf. aka qNo
             * A Confirmation window pops up when this happens.
             * If yes on confirmation, it ends play, celebrating. aka cYes
             * If no on confrimation, it has the user make a new leaf for the tree by asking for a name
             * and a question that makes it unique. aka cNo
             * During play. it logs the user's answers in the console, so they make questions easier 
             * (including the confirmation question).
             */
            game.titleVisibletoggle();
            game.setGameQuestion("Think of a plant or zombie: " + theAlmanic.getStrHelper(theAlmanic.getPos()));
            System.out.println("Start Log"); 
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
                theAlmanic.setPlant(); //sets the string at the make a new element ending to be "plant"   
            }
            game.questionarreVisibletoggle();
            System.out.println(theAlmanic.getStrHelper(theAlmanic.getPos()) + " Yes");
            theAlmanic.setPlant();
            theAlmanic.posright();
            game.setGameQuestion(theAlmanic.getStrHelper(theAlmanic.getPos()));
            game.questionarreVisibletoggle();
            } catch(Exception e) { //below shows what happens when it hits a leaf
                //System.out.println(e);
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
                theAlmanic.setZombie(); //sets the string at the make a new element ending to be "zombie"
            }
            game.questionarreVisibletoggle();
            System.out.println(theAlmanic.getStrHelper(theAlmanic.getPos()) + " No");
            theAlmanic.posleft();
            game.setGameQuestion(theAlmanic.getStrHelper(theAlmanic.getPos()));
            game.questionarreVisibletoggle();
            } catch(Exception e) { //below shows what happens when it hits a leaf
                game.setConfirmQuestion("Is it a " + theAlmanic.getLeafname(theAlmanic.getPos()) + "?");
                game.confirmVisibletoggle();
            }
        }
       }); 
       //Confirmation window buttion
          game.addActionListenerCYes(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent buttonPressed) {
           try { //no make new element ending
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
            try { //make a new element ending
            game.confirmVisibletoggle(); 
            System.out.println("Is it a " + theAlmanic.getLeafname(theAlmanic.getPos()) + "? Noooo!!");
            System.out.println("End Log");
            System.out.print("You tripped me up! Name for "+ theAlmanic.getPvz() + "? ");
            String name = leafMaker.nextLine();
            AlmanicEntry newEntry = new AlmanicEntry(name, theAlmanic.getPosDirections() + "Y");
            System.out.print("Question that makes this " + theAlmanic.getPvz() + " unique from the others? \n (look \"End Log\" to help) \n");
            String question = leafMaker.nextLine();
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
    /* initalizes the program if file content is there and saved. does equal standard variable 
     * the format: (leaf boolean)=(str)=(directions)
    */
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
    } 
    /* 
     * Pretty much makes a small tree to start to program if there is no file
     */
    public static void enrooten(AlmanicTree theAlmanic) {
        AlmanicEntry sunFlower = new AlmanicEntry("Sunflower", "Y");
        AlmanicEntry zombie = new AlmanicEntry("Browncoat", "N");
        theAlmanic.enRoot("Is it a plant?", zombie, sunFlower);
    }
    public static void theEnd(PrintWriter save, AlmanicTree theAlmanic) {
        save.print(theAlmanic);
        save.close();
        System.exit(0);
    }
   
}
