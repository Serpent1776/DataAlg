public class das {
    
    public static void main(String[] args) {
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        String str = "" + zeros + ones + twos + threes + fours;
        int i = 0;
        while(i < 7){
           str = "" + zeros + ones + twos + threes + fours;
           System.out.println(str);
           zeros = intfromstr(0, str);
           ones = intfromstr(1, str);
           twos = intfromstr(2, str);
           threes = intfromstr(3, str);
           fours = intfromstr(4, str);
           i++;
        }
    }
    public static int intfromstr(int num, String digit) {
        int times = 0;
        for(int i = 0; i < digit.length(); i++) {
            if(num == (Integer.parseInt(digit.substring(i, i+1)))) {
             times++;
            }
        }
        return times;
    }
}
