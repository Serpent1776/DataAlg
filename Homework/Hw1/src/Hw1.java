    public class Hw1 {
       
        static public void main(String args[]) {
         //main testing for question 2, making sure my program has the specifications.
        String str; 
        int x;
        Sign sign1 = new Sign("ABC222DE", 3);
        x = sign1.numberOfLines();
        System.out.println(x);
        str = sign1.getLines();
        System.out.println(str);
        str = sign1.getLines();
        System.out.println(str);
        Sign sign2 = new Sign("ABCD", 10);
        x = sign2.numberOfLines();
        System.out.println(x);
        str = sign2.getLines();
        System.out.println(str);
        Sign sign3 = new Sign("ABCDEF", 6);
        x = sign3.numberOfLines();
        System.out.println(x);
        str = sign3.getLines();
        System.out.println(str);
        Sign sign4 = new Sign("", 4);
        x = sign4.numberOfLines();
        System.out.println(x);
        str = sign4.getLines();
        System.out.println(str);
        Sign sign5 = new Sign("AB_CD_EF", 2);
        x = sign5.numberOfLines();
        System.out.println(x);
        str = sign5.getLines();
        System.out.println(str);       
        }
        //Ap question number 1 below!
        //a
       public boolean isMinuteFree(int period, int minute) {
        //I show which minute is free 
        return true;
       }
 
        public int findFreeBlock(int period, int duration) {
              //finds a free block
               int block = -1;
               int[] minutes = new int[60];
               for(int i = 0; i < 60; i++) {minutes[i] = i;} //minute array made
               for(int i = 0; i < minutes.length; i++) { //for loop to find free block
               if(isMinuteFree(period, minutes[i])) {
                    minutes[i] = block;
                    break;
               }
              }
               return block;
        }
        //b
        public boolean makeAppointment(int period1, int period2, int minutes) {
              //seeing if an appointment can be made
               boolean canItBeMade = false;
               int theBlock = 0; //for getting the block
               int counter = period1; //for getting block's period
               for(int i = period1; i <= period2; i++) { //for loop to find the free block in the period range
                  counter++;
                  theBlock = findFreeBlock(i, minutes);
               if(theBlock != -1) {
                canItBeMade = true;
                break;
               }
               }
               if(canItBeMade) {
                      reserveBlock(counter, minutes, theBlock);
               }
               return canItBeMade;
        }
        public void reserveBlock(int period, int duration, int minute) {
               //reserves a block
        }
    }
