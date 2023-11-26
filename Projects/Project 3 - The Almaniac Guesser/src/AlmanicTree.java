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
        public String toQuestion() {
            return question;
        }
        public String toString() {
            return name + "=" + question + "=" + directions;
        }
    }
    leaf root;
    int size;
    public AlmanicTree() {
        this.root = null;
        this.size = 0;
    }
    @Override
    public void add(String name, String question, String directions) {
        this.root = add(name, question, directions, directions, root);
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
    public String toString(leaf leaf) {
      if(leaf == null) {return "";}
        String tree = "\n" + leaf;
      return tree + toString(leaf.left) + toString(leaf.right);
    }
}
