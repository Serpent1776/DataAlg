import java.util.Scanner;
import java.util.ArrayList;
public class NumConverter {
    public static void main(String[] args) { //controller
        Scanner user = new Scanner(System.in);
        boolean isBinary = false;
        boolean working = true;
        while(working) {
        System.out.print("Hi User, What number or binary are you sending to convert to the other type? \n (only send the number): ");
        String number = user.nextLine();
        for(int i = 0; i < number.length(); i++) {
            if(number.substring(i, i+1).equals(".") || Integer.parseInt(number.substring(i, i+1)) < 2) {
                isBinary = true;
            } else {
                isBinary = false;
                break;
            }
        }
        if(isBinary) {
        System.out.print("User, do you want this number to be reffered as binary? Y or N? ");
        if(user.nextLine().equals("Y")) {
         System.out.println(binaryToNum(number));   
        } else {
         System.out.println(numToBinary(number));
        }} else {
         System.out.println(numToBinary(number));
        
        }
        System.out.print("User, want to put in another number? Y or N? ");
        if(user.nextLine().equals("N")) {
            working = false;
        }
    }
}

    public static String numToBinary(String a) {
        ArrayList<Integer> replay = new ArrayList<Integer>();
        boolean powers[] = new boolean[64];
        double nums[] = new double[64];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = Math.pow(2, i-(nums.length/2));
        }
        String number = a;
                double num = Double.parseDouble(number);
                double restore = num;
                double highestPower = 1;
                double lowestPower = 1;
              while(true) {
                if(num >= 1) {
                    for(int whole = nums.length - 1; whole > nums.length/2 - 1; whole--) {
                        num -= nums[whole];
                        if(num < 0) {
                            num = restore;
                        } else {
                             if(nums[whole] > highestPower) {
                             highestPower = nums[whole];   
                            }
                             replay.add(whole);
                            restore = num;
                        }
                    }
                }
                if(num <= 1) {
                    for(int dec = nums.length/2 - 1; dec > -1; dec--) {
                         num -= nums[dec];
                        if(num < 0) {
                            powers[dec] = false;
                            num = restore;
                        } else {
                            if(nums[dec] < lowestPower) {
                             lowestPower = nums[dec];   
                            }
                            replay.add(dec);
                            restore = num;
                        }
                    }
                }
                if(num == 0) {
                    break;
                }
            }
            for(int i = 0; i < replay.size(); i++) {
                powers[replay.get(i)] = true;
            }
            String binary = "";
            for(int i = powers.length - 1; i > -1; i--) {
                if(powers[i]) {binary += "1";}else{binary += "0";}
                if(i == powers.length/2) {binary += ".";}
            }
            // uses the log(a)/log(b) = log_a(b) formula to set it up
            if(Math.floor(Double.parseDouble(number)) != Double.parseDouble(number)) {
            return a + " is " + binary.substring((powers.length/2) - 1 - (int)(Math.log(highestPower)/Math.log(2)), powers.length/2 + 1 - (int)(Math.log(lowestPower)/Math.log(2))) + " in binary."; 
            } else {
            return a + " is " + binary.substring((powers.length/2) - 1 - (int)(Math.log(highestPower)/Math.log(2)), powers.length/2 - (int)(Math.log(lowestPower)/Math.log(2))) + " in binary.";    
            }
        }

        public static String binaryToNum (String number) {
             boolean powers[] = new boolean[64];
        double nums[] = new double[64];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = Math.pow(2, i-(nums.length/2));
        }
            int theDot = number.indexOf(".");
            if(theDot == -1) {
                int positives = number.length()-1;
                 double sum = 0;
                for(int i = 0; i <= positives; i++) {
                   if(number.substring(i,i+1).equals("1")) {
                    sum += nums[(positives - i) + powers.length/2];
                } 
                }
               return number + " is " + (int)(sum) + " in base10.";
                
            } else {
                int positives = theDot - 1;
                int negatives = number.length() - theDot - 1;
                double sum = 0;
                /* Something to explain this!
                 * 1100.01
                 * the dot is 4 here
                 * 0-3 are positive & 5-6 are negative
                 */
                for(int i = 0; i < positives; i++) {
                   if(number.substring(i,i + 1).equals("1")) {
                    sum += nums[(positives - i) + powers.length/2];
                } 
                }
                for(int i = negatives; i < number.length(); i++) {
                   if(number.substring(i,i+1).equals("1")) {
                    sum += nums[powers.length/2 - (i-theDot)];
                } 
                }
                String som = number + " is " + sum + " in base10.";
                return som;
            }
        }
}