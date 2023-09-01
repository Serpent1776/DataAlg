import java.util.Arrays;
public class App {
       
       static public void main(String args[]) {
        int len = 6;
        boolean[] yo = new boolean[len];
        boolean[] allTrue = new boolean[len];
        for(int i = 0; i < allTrue.length; i++) {
              allTrue[i] = !allTrue[i];
        }
        int position = 0;
        //boolean first = true;
        while(!Arrays.equals(yo, allTrue)) {
              for(int i = 0; i < len; i++) {
                     if(yo[i]) {System.out.print(1);}else{System.out.print(0);}
              }
                     System.out.println();
              //position algorithm nearest false
                            for(int i = 0; i < len -1; i++) {
                                   if(yo[i]) {
                                          position = i;
                                          break;
                                   }
                            }      
                     for(int i = 0; i < len - 1; i++) {
                             //position++;
                             yo[position%len] = !yo[position%len];   
                             position++; 
                     }
              }


              /* // rng algorithm
              int ran =(int)(Math.random()*len);
              for(int i = 0; i < len-1; i++) {
                     yo[(ran+i)%len] = !yo[(ran+i)%len];
              }*/
               
        for(int i = 0; i < len; i++) {
                     if(yo[i]) {System.out.print(1);}else{System.out.print(0);}
              }

       }
}