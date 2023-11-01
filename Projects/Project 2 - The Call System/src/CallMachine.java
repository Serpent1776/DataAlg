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
        public boolean equals(Call otherCall) {
            return (number.equals(otherCall.number) && name.equals(otherCall.name));
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
        size--;
        return temps;
    }
    public String grabCall() throws CallException {
       if(mostRecentCall == null) {throw new CallException("No Calls have been received.");}
        return mostRecentCall.toString();
    }
    public String findNumber(String name) throws CallException {
        if(mostRecentCall == null) {throw new CallException("There are no calls to find.");}
        Call c1 = mostRecentCall;
        while(c1 != null) {
            if(name.equals(c1.name)) {
                return "Caller " + name + " found. Their number is " + c1.number + ".";
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
    public void purge() throws CallException {
        int removeCount = 0;
        if(this.size < 2) {throw new CallException("There are no calls to purge.");}
        Call c1 = mostRecentCall;
        while (c1 != null && c1.next != null) {
            if(c1.next.equals(mostRecentCall)) { 
                removeCount++; //removes at least 1 gauranteed
                //summary: programs conducts teleportation to remove multiple, adajecent dupes at once
                    Call c2 = c1.next; //the 2nd iterator for teleport location
                    while (c2.next != null && c2.next.equals(mostRecentCall)) { 
                       removeCount++; 
                    //iterates until null or c2.next isn't equal to mostRecentCall
                       c2 = c2.next; 
                    }
                    Call call = new Call(c1.number, c1.name, c2.next); //new box with teleport location
                    c1.next = c2.next; //placeholder
                    c1 = call; //the teleportation and removal 
                }
            c1 = c1.next;
        }
        size -= removeCount; 
        }
    public String getCalls(int k) throws CallException {
         if(mostRecentCall == null) {throw new CallException("There are no calls to show.");}
        String sumString = "";
        Call c1 = mostRecentCall;
        for(int i = 0; i < k; i++) {
            if(c1 != null) {
            sumString += c1 + "\n";
            c1 = c1.next;
            } else {
            break;
            }
        }
        if(c1 == null) {
            sumString += "No more calls.";
        }
        return sumString;
    }
}
