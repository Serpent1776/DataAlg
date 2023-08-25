public class Sign {
    String message;
    int width;

    public Sign(String message, int width) {
       this.message = message;
       this.width = width;
    }
    public int numberOfLines() {
         return Math.round(message.length()/((float)(width)));
    }
    public String getLines() {
        if(message.length() == 0) {return null;} else {
            int speed = numberOfLines();
            if(speed > 1) {
                String linedMessage = "";
                String[] parts = new String[speed];
                for(int i = 0; i < speed; i++) {
                        if(width*(i+1) < message.length()) {
                            parts[i] = message.substring(width*i, width*(i+1));
                            parts[i] += ";";
                        } else {
                            parts[i] = message.substring(width*i, message.length());
                            parts[i] += ";";
                        }
                }
                for(int i = 0; i < parts.length; i++) {
                        linedMessage += parts[i];
                    }
                return linedMessage;
            } else {
                return message;
            }
        }
    }
}
