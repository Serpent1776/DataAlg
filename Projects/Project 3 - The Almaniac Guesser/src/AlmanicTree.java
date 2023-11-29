public class AlmanicTree implements GuessingTree {
    private class leaf {
        public String question;
        public String name;
        public String directions;
        public leaf left;
        public leaf right;
        public leaf(String name, String question, String directions) {
            this.name = name;
            this.question = question;
            this.directions = directions;
            this.left = null;
            this.right = null;
        }
        public boolean equals(leaf other) {
            return this.name.equals(other.name) && this.question.equals(other.question) && this.directions.equals(other.directions);
        }
        public String toString() {
            return name + "=" + question + "=" + directions;
        }
    }
    leaf root;
    leaf pos;
    int poz;
    String[] pvz = {"plant", "zombie"};
    int size;
    public AlmanicTree() {
        this.root = null;
        this.size = 0;
        this.poz = 0;
        
    }
    @Override
    public void add(String name, String question, String directions) {
        this.root = add(name, question, directions, directions, root);
        this.pos = this.root;
    }
    private leaf add(String name, String question, String directions, String direction, leaf current) {
        if(directions.equals("")) {
            return new leaf(name, question, direction);
        }
        if(directions.charAt(0) == 'L' && current != null) {
            current.left = add(name, question, directions.substring(1), direction, current.left);
        } else if (directions.charAt(0) == 'R' && current != null) {
            current.right = add(name, question, directions.substring(1), direction, current.right);
        }
        return current;
    }
    public String toString() {
        return toString(this.root);
    }
    public leaf getRoot() {
        return root;
    }
    public void posright() throws GuessingTreeException {
        if(this.pos == null) {throw new GuessingTreeException("null pos");}
        this.pos = this.pos.right;
    }
    public void posleft() throws GuessingTreeException {
        if(this.pos == null) {throw new GuessingTreeException("null pos");}
        this.pos = this.pos.left;
    }
    public void posreset() {
        this.pos = this.root;
    }
    public leaf getPos() {
        return pos;
    }
    public String getQuestionHelper(leaf l) {
        return l.question;
    }
    public String getNameHelper(leaf l) {
        return l.name;
    }
    public boolean posAtRoot() {
       return this.pos.equals(this.root);
    }
    public String toString(leaf l) {
      if(l == null) {return "";}
        String tree = "\n" + l;
      return tree + toString(l.left) + toString(l.right);
    }
    public void togglePoz() /*throws GuessingTreeException*/ {
        if(this.poz == 0) {this.poz = 1; return;}
        if(this.poz == 1) {this.poz = 0; return;}
        //throw new GuessingTreeException("Poz needs to be either 0 or 1");
    }
    public String getPvz() {
        return this.pvz[this.poz];
    }
    public int getPoz() {
        return poz;
    }
}
