    public class App {
       
        static public void main(String args[]) {
         
        }
        //a
       public boolean isMinuteFree(int minute) {
        //I show which minute is free 
        return true;
       }
 
        public int findFreeBlock(int period, int duration) {
               int block = -1;
               int[] minutes = new int[60];
               for(int i = 0; i < 60; i++) {minutes[i] = i;} 
               if(isMinuteFree(duration)) {
                       
               }
 
               return block;
        }
        //b
        public boolean makeAppointment(int period1, int period2, int minutes) {
               boolean canItBeMade = false;
               for(int i = period1; i <= period2; i++) {
               if(findFreeBlock(i, minutes) != -1) {
                canItBeMade = true;
               }
               }
               if(canItBeMade) {
                      reserveBlock();
               }
               return canItBeMade;
        }
        public void reserveBlock() {
               //reserves a block
        }
    }
