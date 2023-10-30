import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
public class CallDriver {
    public static void main(String[] args) throws Exception {
        CallMachine regular = new CallMachine();
        CallMachine blocked = new CallMachine();
        startup(regular, blocked);
        CallWindow callMachine = new CallWindow();
        JFrame window = callMachine.getWindow();
        JFrame confirm = callMachine.getConfirm();
        JPanel answerPanel = callMachine.getAnswerPanel();
        JButton yes = new JButton("yes");
        JButton no = new JButton("no");
        Scanner scan = new Scanner(System.in);
        answerPanel.add(yes);
        answerPanel.add(no);
        JPanel panel = callMachine.getPanel();
        JButton delete = new JButton("delete");
        JButton recieve = new JButton("receive");
        JButton block = new JButton("block");
        JButton previousCalls = new JButton("Show prev");
        JButton find = new JButton("find number");
        JLabel lastCall = new JLabel("");
        lastCall.setHorizontalAlignment(SwingConstants.CENTER);
        ///confirm.setVisible(true);
        panel.add(recieve);
        panel.add(delete);
        panel.add(block);
        panel.add(previousCalls);
        panel.add(find);
        window.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent windowClosed) {
                end();
            }
        });
        window.getContentPane().add(BorderLayout.CENTER, panel);
        window.getContentPane().add(BorderLayout.SOUTH, lastCall);
        confirm.getContentPane().add(BorderLayout.CENTER, answerPanel);
        try {
            lastCall.setText("Last Caller is " + regular.grabCall());
        } catch (Exception e) {
            lastCall.setText(e.getMessage());
        }
        window.setVisible(true);
        recieve.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent buttonPressed) {
            window.setVisible(false);
            try {
            receive(regular, blocked, scan);
            } catch(Exception e) {
                System.out.print(e.getMessage());
            }
            window.setVisible(true);
            try {
                lastCall.setText("Last Caller is " + regular.grabCall());
            } catch (Exception e) {
                lastCall.setText(e.getMessage());
            }
          }  
        });
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent buttonPressed) {
                window.setVisible(false);
                if(regular.size() > 0) {
                confirm.setVisible(true);
            } else {
                System.out.print("There are no calls to delete.");
                window.setVisible(true);
            }
            }
        });
        block.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent buttonPressed) {
                window.setVisible(false);
                try {
                    blockLastCall(regular, blocked);
                } catch(Exception e) {
                    System.out.print(e.getMessage());
                }
                window.setVisible(true);
                try {
                    lastCall.setText("Last Caller is " + regular.grabCall());
                } catch (Exception e) {
                    lastCall.setText(e.getMessage());
                }
            }
        });  
        previousCalls.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent buttonPressed) {
                window.setVisible(false);
            try{
                System.out.print(showPrevious(regular, scan));
                window.setVisible(true);
            } catch (Exception e) {
                System.out.print(e.getMessage());
                window.setVisible(true);
            }
            }
        }); 
        find.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent buttonPressed) {
                window.setVisible(false);
                try{
                    System.out.println(findNumber(regular, scan));
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
                window.setVisible(true);
            }
        });
        yes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent buttonPressed) {
             try {
                
            
                deleteLastCall(regular); 
      
             } catch (Exception e) {
                System.out.println(e.getMessage());
             }
                confirm.setVisible(false);
                window.setVisible(true);
                 try {
                    lastCall.setText("Last Caller is " + regular.grabCall());
                } catch (Exception e) {
                    lastCall.setText(e.getMessage());
                }
            }
        });
        no.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent buttonPressed) {
              confirm.setVisible(false);
              window.setVisible(true);
            }
        });
    }
   
    
    /*Receive a call: 
    -Prompt for the phone number and the name of the caller. 
    -Store this data in a way to make further processing as efficient as possible. 
    -Note that the call may be immediately blocked (see option 6). 
    -A caller with the name "Unknown Caller" should automatically be blocked.
    */
    public static void receive(CallMachine calls, CallMachine block, Scanner scan) throws CallException {
         System.out.println("Name:");
            String callerName = scan.nextLine();
            String callerNumber = "";
            while(callerNumber.length() != 10) {
                System.out.print("Number(the 10 digits only):");
                callerNumber = scan.nextLine();
            }
            if(block.callExists(callerNumber, callerName)) {throw new CallException("This caller is blocked.");}

            if(callerName.equals("Unknown Caller")) {
                block.addCall(callerNumber, callerName);
            } else {
                calls.addCall(callerNumber, callerName);
            }

    }
    /* 
    Delete last call: 
    -Prompt the user to make sure they want to do this. //that's in main
    -If so, remove the most recent call from memory. 
    -This should give an error message and not prompt for confirmation if there are no numbers in memory. 
    */
    public static void deleteLastCall(CallMachine calls) throws CallException {
        calls.removeCall();
    }
    /* 
    Show previous calls: 
    -Prompt for a number k; 
    -display the last k calls, starting with the most recent. 
    -If there are no calls in memory, do not prompt for k. 
    -If k is larger than the number of calls in memory: 
        -display all the calls
        -then print the message: “No more calls”. 
    */
    public static String showPrevious(CallMachine calls, Scanner scan) throws CallException {
        System.out.print("How many calls? ");
        String callList = calls.getCalls(scan.nextInt());
        return callList;
    } 
    /* 
    Purge call: 
    -Removes all copies of the most recent call that appear somewhere else in the list. 
    -So, for example, if the list were A, B, C, A, D, B, A, C (starting with most recent): 
        -this option would turn the list into A, B, C, D, B, C. 
        -If it were A, B, C, D, B, it would remain as is. There should be no output from this option.
    */
    public static void purge() {
        
    }
    /*  
    Find number: 
    -Prompt the user for a name. 
    -Return the number associated with that name if it appears in the call list 
    -print an appropriate response if not. 
    -Do not prompt for a name if the call list is empty. 
    -Name matches should be exact, including spaces, punctuation, and case.
    */
    public static String findNumber(CallMachine calls, Scanner scan) throws CallException {
        System.out.print("What's the name of the caller you're looking for? "); 
        return calls.findNumber(scan.nextLine());
    }
    /* 
    Block call: 
    -Add the most recent call to a “block list”. 
    -This should also remove that instance of the call from the regular list. 
    -If that number/name combination is ever received again in option 1, 
    -it should not be added to the call list 
    -(print an appropriate message when the call is received instead). 
    -Blocking a call does not purge the call from the list (as in option 4). 
    -For example, if the list were A, B, C, A, D, B, A, C (starting with most recent), 
    -after executing the block call option, 
    -the list would B, C, A, D, B, A, C with A asdded to the block list. 
    */
    public static void blockLastCall(CallMachine calls, CallMachine block) throws CallException {
        if(calls.size() < 1) {throw new CallException("There are no calls to block.");}
        String[] blockedCall = calls.removeCall();
        block.addCall(blockedCall[0], blockedCall[1]);
    }
    /* 
    Quit the program:
    -quits the program
     */
    public static void end() {
        System.exit(0);
    }
    /*
     * for testing the code
     */
    public static void startup(CallMachine calls, CallMachine block) {
        calls.addCall("1233234342", "fine");
        calls.addCall("1800666539", "NFT Guy"); 
        calls.addCall("1800463845", "Evil Corp");
        calls.addCall("1233254342", "fr");
        calls.addCall("1235234342", "dem");
        block.addCall("1800463845", "Evil Corp");
        block.addCall("1233294342", "Unknown Caller");
        block.addCall("1800666539", "NFT Guy"); 
        
    }
}
