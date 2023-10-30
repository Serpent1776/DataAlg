public class CallMachine {
    private class Call {
        private String number;
        private String name;
        private Call next;
        public Call(String number, String name, Call next) {
            this.number = number;
            this.name = name; 
            this.next = next;
        }  
        public String toString() {
            return name + ": " + number; 
        }
}
    private Call mostRecentCall;
    private int size;
    public CallMachine() {
    mostRecentCall = null;
    this.size = 0;
    }
    public void addCall(String number, String name) {
        mostRecentCall = new Call(number, name, mostRecentCall);
        size++;
    }
    public String[] removeCall() throws CallException {
        if(mostRecentCall == null) {throw new CallException("There are no calls to delete.");}
        String[] temps = {mostRecentCall.number, mostRecentCall.name}; 
        mostRecentCall = mostRecentCall.next;
        return temps;
    }
    public String grabCall() throws CallException {
       if(mostRecentCall == null) {throw new CallException("No Calls have been received.");}
        return mostRecentCall.toString();
    }
    public String findNumber(String name) throws CallException {
        Call c1 = mostRecentCall;
        while(c1 != null) {
            if(name.equals(c1.name)) {
                return "Caller " + name + " found. Their number is " + c1.number;
            }
            c1 = c1.next;
        }
        throw new CallException("Caller not found.");
    }
    public boolean callExists(String number, String name) {
        Call c1 = mostRecentCall;
        while(c1 != null) {
            if(number.equals(c1.number) && name.equals(c1.name)) {
                return true;
            }
            c1 = c1.next;
        }
        return false;
    }
    public int size() {
        return this.size;
    }
    public void purge() {
        
    }
    public String getCalls(int k) throws CallException {
         if(mostRecentCall == null) {throw new CallException("There are no calls to show.");}
        String sumString = "";
        Call c1 = mostRecentCall;
        for(int i = 0; i < k; i++) {
            if(c1 != null) {
            sumString += c1 + "\n";
            c1 = c1.next;
            }
        }
        if(c1 == null) {
            sumString += "No more calls.";
        }
        return sumString;
    }
}
