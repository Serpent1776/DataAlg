public class CallDriver {
    public static void main(String[] args) throws Exception {
        CallMachine regular = new CallMachine();
        CallMachine blocked = new CallMachine();
    }
    /*Receive a call: 
    -Prompt for the phone number and the name of the caller. 
    -Store this data in a way to make further processing as efficient as possible. 
    -Note that the call may be immediately blocked (see option 6). 
    -A caller with the name "Unknown Caller" should automatically be blocked.
    */
    public static void receive() {

    }
    /* 
    Delete last call: 
    -Prompt the user to make sure they want to do this. 
    -If so, remove the most recent call from memory. 
    -This should give an error message and not prompt for confirmation if there are no numbers in memory. 
    */
    public static void delete() {

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
    public static String showPrevious() {
        String callList = "";
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
    public static int findNumber() {
        return 0;
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
    -the list would B, C, A, D, B, A, C with A added to the block list. 
    */
    public static void blockCall() {

    }
    /* 
    Quit the program:
    -quits the program
     */
    public static void end() {
        System.exit(0);
    }
}
