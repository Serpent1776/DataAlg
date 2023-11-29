import java.awt.event.*;
import java.io.*;
//import java.nio.file.*;
import java.util.Scanner;
//import javax.swing.*;
public class AlmaniacDriver {
    public static void main(String[] args) throws Exception {
        AlmanicTree theAlmanic = new AlmanicTree();
        AlmanicWindows window = new AlmanicWindows();
        String directions = "";
        System.out.print(theAlmanic);
        PrintWriter overwrite = null;
        Scanner objectMaker = new Scanner(System.in);
        /**/
        //initialization
        /*
         * Play "function"
         * If yes to a distinguishing question, has a confirmation of an is it.
         * If no to a distinguishing question, it moves without question to the next question.
         * If yes on confirmation, it ends play, celebrating.
         * If no on confrimation, it moves to next question.
         * If it hits a null pointer, it asks the user and makes a new node, ending play.
         * During play. it logs the user's answers in the console.
         */
        try {
        File answers = new File("answers.txt");  
        Scanner answersAdd = new Scanner(answers);
        if(answersAdd.hasNextLine()) {init(theAlmanic, answersAdd);} else {theAlmanic.add("start", "Is it a zombie?", "");}
        overwrite = new PrintWriter(new FileWriter(answers, false)); 
        } catch (FileNotFoundException e) {
            theAlmanic.add("start", "Is it a plant?", "");
            overwrite = new PrintWriter(new FileWriter("answers.txt", false));
        } 
        final PrintWriter WRITE = overwrite;
        window.addWindowListenerTitleMenu(new WindowAdapter() {
            public void windowClosed(WindowEvent windowClosed) {
                theEnd(WRITE, theAlmanic);
            }});
        window.addWindowListenerQuestionarre(new WindowAdapter() {
            public void windowClosed(WindowEvent windowClosed) {
                window.questionarreVisibletoggle();
                window.titleVisibletoggle();
            }});
        window.addActionListenerPlay(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent buttonPressed) {
            window.titleVisibletoggle();
            window.setGameQuestion(theAlmanic.getQuestionHelper(theAlmanic.getPos()));
            window.setConfirmQuestion("Is it a " + theAlmanic.getNameHelper(theAlmanic.getPos()) + "?");
            window.questionarreVisibletoggle();
        }
       }); 
       window.addActionListenerEnd(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent buttonPressed) { 
            theEnd(WRITE, theAlmanic);
        }
        });
        window.addActionListenerQYes(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent buttonPressed) {
            if(!theAlmanic.posAtRoot()) {
            window.questionarreVisibletoggle();
            window.confirmVisibletoggle();
            } else {
              try {
            theAlmanic.posright();
            window.setGameQuestion(theAlmanic.getQuestionHelper(theAlmanic.getPos()));
            window.setConfirmQuestion("Is it a " + theAlmanic.getNameHelper(theAlmanic.getPos()) + "?");
            yesCase(directions);
            } catch(Exception e) {
                window.questionarreVisibletoggle();
                System.out.print("You tripped me up! Name for"+ theAlmanic.getPvz() + "?");
                String name = objectMaker.nextLine();
                System.out.print("Question that makes this" + theAlmanic.getPvz() + "unique from the others? \n (look above \"End Log\" to help)");
                String question = objectMaker.nextLine();
                theAlmanic.add(name, question, directions);
                theAlmanic.posreset();
                destroyString(directions);
                if(theAlmanic.getPoz() == 1) {theAlmanic.togglePoz();}
                window.titleVisibletoggle();
            }
            }
            
        }
       }); 
        window.addActionListenerQNo(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent buttonPressed) {
            try {
            if(theAlmanic.posAtRoot()) {theAlmanic.togglePoz();}
            theAlmanic.posleft();
            window.setGameQuestion(theAlmanic.getQuestionHelper(theAlmanic.getPos()));
            window.setConfirmQuestion("Is it a " + theAlmanic.getNameHelper(theAlmanic.getPos()) + "?");
            noCase(directions);
            } catch(Exception e) {
                window.questionarreVisibletoggle();
                System.out.print("You tripped me up! Name for"+ theAlmanic.getPvz() + "?");
                String name = objectMaker.nextLine();
                System.out.print("Question that makes this" + theAlmanic.getPvz() + "unique from the others? \n (look above \"End Log\" to help)");
                String question = objectMaker.nextLine();
                theAlmanic.add(name, question, directions);
                theAlmanic.posreset();
                destroyString(directions);
                if(theAlmanic.getPoz() == 1) {theAlmanic.togglePoz();}
                window.titleVisibletoggle();
            }
        }
       }); 
        window.addActionListenerCYes(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent buttonPressed) {
            //end play
            window.confirmVisibletoggle();
            //window.questionarreVisibletoggle();
            window.titleVisibletoggle();
        }
        });
        window.addActionListenerCNo(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent buttonPressed) {
            try {
            theAlmanic.posright();
            window.setGameQuestion(theAlmanic.getQuestionHelper(theAlmanic.getPos()));
            window.setConfirmQuestion("Is it a " + theAlmanic.getNameHelper(theAlmanic.getPos()) + "?");
            yesCase(directions);
            window.confirmVisibletoggle();
            window.questionarreVisibletoggle();
            } catch(Exception e) {
                window.confirmVisibletoggle();
                System.out.print("You tripped me up! Name for"+ theAlmanic.getPvz() + "?");
                String name = objectMaker.nextLine();
                System.out.print("Question that makes this" + theAlmanic.getPvz() + "unique from the others? \n (look above \"End Log\" to help)");
                String question = objectMaker.nextLine();
                theAlmanic.add(name, question, directions);
                theAlmanic.posreset();
                destroyString(directions);
                if(theAlmanic.getPoz() == 1) {theAlmanic.togglePoz();}
                window.titleVisibletoggle();
            }
        }
        }); 
       
       window.titleVisibletoggle();
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
    public static void theEnd(PrintWriter save, AlmanicTree theAlmanic) {
        save.println(theAlmanic);
        save.close();
        System.exit(0);
    }
    public static void yesCase(String d) {
        d += "R";
    }
    public static void noCase(String d) {
        d += "L";
    }
    public static void destroyString(String d) {
        d = "";
    }
}
