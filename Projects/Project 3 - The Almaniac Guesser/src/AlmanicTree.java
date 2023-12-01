/*
 * 
 * Questions until it hits a leaf.
 */
import java.util.ArrayList;
public class AlmanicTree {
    private class leaf {
        public String str;
        public String directions;
        public leaf left;
        public leaf right;
        public boolean isLeaf;
        public leaf(String question, String directions, leaf left, leaf right) {
            this.str = question;
            this.directions = directions;
            this.left = left;
            this.right = right;
            this.isLeaf = false;
        }
        public leaf(AlmanicEntry entry) {
            this.str = entry.getName();
            this.directions = entry.getDirections();
            this.left = null;
            this.right = null;
            this.isLeaf = true;
            leaves.add(entry);
        }
        public leaf(boolean isLeaf, String str, String directions) {
            this.isLeaf = isLeaf;
            this.str = str;
            this.directions = directions;
        }
        public String toString() {
            return isLeaf + "=" + str + "=" + directions;
        }
    }
    leaf root;
    leaf pos;
    //int poz;
    String pvz;
    int size;
    String posDirections;
    ArrayList<AlmanicEntry> leaves;
    public AlmanicTree() {
        this.root = null;
        this.size = 0;
        //this.poz = 0;
        this.posDirections = "";
        this.pvz = "";
        leaves = new ArrayList<AlmanicEntry>();
    }
    
    public String toString() {
        return toString(this.root);
    }
    public leaf getRoot() {
        return root;
    }
    public void addLeaves(AlmanicEntry entry) {
        leaves.add(entry);
    }
    public AlmanicEntry findLeave(String name) {
        
        for(int i = 0; i < leaves.size(); i++) {
            if(name.equals(leaves.get(i).getName())) {
                return leaves.get(i);
            }
        }
        return null;
    }
    public void add(String separatingQuestion, AlmanicEntry entry) {
        this.root = add(separatingQuestion, entry, posDirections, root);
    }
    public void add(boolean isLeaf, String str, String directions) {
        this.root = add(isLeaf, str, directions, directions, root);
    }
    private leaf add(String question, AlmanicEntry entry, String directions, leaf current) {
        if(directions.equals("")) {
            leaf ent = new leaf(entry);
            current.directions += "L";
            return new leaf(question, posDirections, current, ent);
        }
        if(directions.charAt(0) == 'L' && current != null) {
            current.left = add(question, entry, directions.substring(1), current.left);
        } else if (directions.charAt(0) == 'R' && current != null) {
            current.right = add(question, entry, directions.substring(1), current.right);
        }
        return current;
    }
    private leaf add(boolean isLeaf, String question, String directions, String direction, leaf current) {
         if(directions.equals("")) {
            return new leaf(isLeaf, question, direction);
         }
         if(directions.charAt(0) == 'L' && current != null) {
            current.left = add(isLeaf, question, directions.substring(1), direction, current.left);
        } else if (directions.charAt(0) == 'R' && current != null) {
            current.right = add(isLeaf, question, directions.substring(1), direction, current.right);
        }
        return current;
    }
    public void root(String separatingQuestion, AlmanicEntry entry1, AlmanicEntry entry2) {
        this.root = new leaf(separatingQuestion, "", new leaf(entry1), new leaf(entry2));
        this.pos = this.root;
    }
    public void posright() throws GuessingTreeException {
        if(this.pos == null) {throw new GuessingTreeException("null pos");}
        this.pos = this.pos.right;
        this.posDirections += "R";
    }
    public void posleft() throws GuessingTreeException {
        if(this.pos == null) {throw new GuessingTreeException("null pos");}
        this.pos = this.pos.left;
        this.posDirections += "L";
    }
    public void posreset() {
        this.pos = this.root;
        this.posDirections = "";
    }
    public leaf getPos() {
        return pos;
    }
    public String getStrHelper(leaf l) throws GuessingTreeException {
        if(l.left == null && l.right == null) {throw new GuessingTreeException("this is leaf.");}
        return l.str;
    }
    public String getLeafname(leaf l) {
        return l.str;
    }
    public boolean posAtRoot() {
       return this.pos.equals(this.root);
    }
    public String toString(leaf l) {
      if(l == null) {return "";}
        String tree = "\n" + l;
      return tree + toString(l.left) + toString(l.right);
    }
    public void setPlant() {
        this.pvz = "plant";
    }
    public void setZombie() {
        this.pvz = "zombie";
    }
    public String getPvz() {
        return this.pvz;
    }
    public String getPosDirections() {
        return posDirections;
    }
}
