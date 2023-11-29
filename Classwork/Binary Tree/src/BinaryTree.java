public class BinaryTree<E> {
    protected class Node<E> {
        public E data;
        public Node<E> left;
        public Node<E> right;
        public Node(E data, Node<E> left, Node<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    protected Node<E> root;
    protected int size;
    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }
    public int height() {
        return height(this.root);
    }
    private int height(Node<E> current) {
        if(current == null) {return -1;}
        int leftHeight = height(current.left);
        int rightHeight = height(current.right);
        if(leftHeight > rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }
    }
    public void add(E data, String LR) {
        this.root = (add(data, LR, this.root));
        size++;
    }
    private Node<E> add(E data, String directions, Node<E> current) {
        if(directions.equals("")) {
            return new Node<E>(data, null, null);
        }
        if(directions.charAt(0) == 'L' && current != null) {
            current.left = add(data, directions.substring(1), current.left);
        } else if (directions.charAt(0) == 'R' && current != null) {
            current.right = add(data, directions.substring(1), current.right);
        }
        return current;
    }
    public String toString() {
        return toString(this.root);
    }
    public String toString(Node<E> location1) {
      if(location1 == null) {return "";}
        String tree = " " + location1.data;
      return tree + toString(location1.left) + toString(location1.right);
    }
    public int counthelper() {
        return countRecursive(this.root, 0);
    }
    private int countRecursive(Node<E> pos, int count) {
        if(pos == null) {return 0;}
        count++;
        return count + countRecursive(pos.left, 0) + countRecursive(pos.right, 0);
    }
}
