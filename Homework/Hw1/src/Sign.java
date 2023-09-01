public class Sign { //Ap question 2 for problem I.
    String message;
    int width;

    public Sign(String message, int width) {
       this.message = message;
       this.width = width;
    }
    public int numberOfLines() { //finds the number of lines in the sign, rounded
         return Math.round(message.length()/((float)(width)));
    }
    public String getLines() { //prints where the line distinctions are, noted by a semicolon.
        if(message.length() == 0) {return null;} else {
            int speed = numberOfLines();
            if(speed > 1) {
                String linedMessage = "";
                String[] parts = new String[speed];
                for(int i = 0; i < speed; i++) { //breaking into parts and semi colon insertion (into those parts) loop
                        if(width*(i+1) < message.length()) {
                            parts[i] = message.substring(width*i, width*(i+1));
                            parts[i] += ";";
                        } else {
                            parts[i] = message.substring(width*i, message.length());
                            parts[i] += ";";
                        }
                }
                for(int i = 0; i < parts.length; i++) { //sums all the parts back up.
                        linedMessage += parts[i];
                    }
                return linedMessage;
            } else {
                return message;
            }
        }
    }
}
