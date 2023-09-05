    public class Hw1 {
       
        static public void main(String args[]) {
         //testing for AP question 2, making sure my program has the specifications. (Still a part of problem I.)
        String str; 
        int x;
        Sign sign1 = new Sign("ABC222DE", 3);
        x = sign1.numberOfLines();
        System.out.println();
        System.out.println(x);
        str = sign1.getLines();
        System.out.println(str);
        str = sign1.getLines();
        System.out.println(str);
        Sign sign2 = new Sign("ABCD", 10);
        x = sign2.numberOfLines();
        System.out.println();
        System.out.println(x);
        str = sign2.getLines();
        System.out.println(str);
        Sign sign3 = new Sign("ABCDEF", 6);
        x = sign3.numberOfLines();
        System.out.println();
        System.out.println(x);
        str = sign3.getLines();
        System.out.println(str);
        Sign sign4 = new Sign("", 4);
        x = sign4.numberOfLines();
        System.out.println();
        System.out.println(x);
        str = sign4.getLines();
        System.out.println(str);
        Sign sign5 = new Sign("AB_CD_EF", 2);
        x = sign5.numberOfLines();
        System.out.println();
        System.out.println(x);
        str = sign5.getLines();
        System.out.println(str);       
        }
        //Ap question number 1 below for problem I.
        //a
       public boolean isMinuteFree(int period, int minute) {
        //I show which minute is free 
        return true;
       }
 
        public int findFreeBlock(int period, int duration) {
              //finds a free block
               int freeMinute = -1; //the first free minute
               for(int i = 0; i < 60; i++) { //i goes from 0 to 59
               if(isMinuteFree(period, i)) {
                     i = freeMinute;
                    break;
               }
              }
               return freeMinute;
        }
        //b
        public boolean makeAppointment(int startPeriod, int endPeriod, int duration) {
              //seeing if an appointment can be made
               boolean canItBeMade = false;
               int theBlock = 0; //for getting the block
               int counter = startPeriod; //for getting block's period
               for(int i = startPeriod; i <= endPeriod; i++) { //for loop to find the free block in the period range
                  counter++;
                  theBlock = findFreeBlock(i, duration);
               if(theBlock != -1) {
                canItBeMade = true;
                break;
               }
               }
               if(canItBeMade) {
                      reserveBlock(counter, duration, theBlock);
               }
               return canItBeMade;
        }
        public void reserveBlock(int period, int duration, int minute) {
               //reserves a block
        }
    }
