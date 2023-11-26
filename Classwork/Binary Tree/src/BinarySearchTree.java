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
                    
                }
            }
        }
    }
}
