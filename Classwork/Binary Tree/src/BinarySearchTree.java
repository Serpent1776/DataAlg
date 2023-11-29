public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {
    public BinarySearchTree() {
        super();
    }

    public void add(E value) {
        if(this.root == null) {
            this.root = new Node<E>(value, null, null);
        } else {
            Node<E> ptr = this.root;
            Node<E> parent = null;
            while(ptr != null) {
                parent = ptr;
                if(value.compareTo(ptr.data) < 0) {
                    ptr = ptr.left;
                } else if(value.compareTo(ptr.data) > 0) {
                    ptr = ptr.right;
                } else {return;}
            }
            if(value.compareTo(parent.data) < 0) {
                parent.left = new Node<E>(value, null, null);
            } else {
                parent.right = new Node<E>(value, null, null);
            }
        }
        size++;
    }
    public void addRecurvsive(E data) {
        this.root = add(data, this.root);
    }
    private Node<E> add(E value, Node<E> current) {
        if(current == null) {
            size++;
            return new Node<E>(value, null, null);
        }
        if(value.compareTo(current.data) < 0) {
            current.left = add(value, current.left);
            return current;
        } else if(value.compareTo(current.data) > 0) {
            current.right = add(value, current.right);
            return current;
        } else {return current;}
    }
    public int countSmaller(E data) {
        return countSmallerRecursive(data, this.root, 0);
    }
    private int countSmallerRecursive(E value, Node<E> pos, int count) {
        if(pos == null) {
            return 0;
        }
        if(value.compareTo(pos.data) > 0) {
            count++;
        }
        int left = countSmallerRecursive(value, pos.left, 0);
        int right = countSmallerRecursive(value, pos.right, 0);
        return count + left + right;
    }
}
