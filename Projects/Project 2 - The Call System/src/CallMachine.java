public class CallMachine {
    private class Call {
        int number;
        String name;
        Call next;
        public Call(int number, String name, Call next) {
            this.number = number;
            this.name = name; 
            this.next = next;
        }
        public int getNumber() {
            return number;
        }  
        public String toString() {
            return name + ": " + number; 
        }
}
    Call mostRecentCall;
    int size;
    public CallMachine() {
    mostRecentCall = null;
    int size = 0;
    }
    public void addCall(int number, String name) {
        mostRecentCall = new Call(number, name, mostRecentCall);
        size++;
    }
    public void removeCall() throws CallException {
        if(mostRecentCall == null) {throw new CallException("There are no calls");}
        mostRecentCall = mostRecentCall.next;
    }
    public int findNumber(String name) {
        return -1;
    }
    public void purge() {
        
    }
    public String getCalls(int k) {
        String sumString = "";
        Call c1 = mostRecentCall;
        for(int i = 0; i <= k; i++) {
            if(c1 != null) {
            sumString += c1;
            c1 = c1.next;
            }
        }
        if(c1 == null) {
            sumString += "\nNo more calls";
        }
        return sumString;
    }
}
