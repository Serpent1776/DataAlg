public class App {
    public static void main(String[] args) throws Exception {
            double num = 1849; //3241, 121, 1849
            double ognum = num;
            double[] nums = new double[101];
            int end = 0;
            for(int i = nums.length - 1; i > 0; i--) {        
                nums[i] = Math.pow(2, i);
            }
            boolean[] powers = new boolean[101];
                double restore = num;
                for(int i = nums.length - 1; i > -1; i--) {
                    num -= nums[i];
                    if(num > 0) {
                        restore = num;
                       powers[i] = true;
                    }
                    if(num < 0) {
                        powers[i] = false;
                        num = restore;
                    }
                    if(num == 0.0) {
                        end = i;
                        break;
                    }
                }
                String binary = "";
                for(int i = nums.length - 1; i > end-1; i--) {

                    if(powers[i]) {binary += "1";}else{binary += "0";}
                }
       
                for(int i = 0; i < binary.length(); i++) {
                    if(binary.substring(i, i+1).equals("1")) {
                        binary = binary.substring(i);
                        break;
                    }
                }
            
                    System.out.println((int)(ognum) + " in base 2: " + binary);
                
             }

    }
