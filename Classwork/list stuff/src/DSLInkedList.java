abstract class DSLinkedList<E extends Comparable<E>> implements DSList<E> {
    private class Node<E> {
        public E data;
        public Node<E> next;

        public Node(E element, Node<E> following) {
            this.data = element;
            this.next = following;

        }
  }
    private int size;
    private Node<E> head_ptr;
    /*
     * get item from a certain spot
     * @param  postition - the spot
     * @return item at that spot
     * @throws DSListException
     */
    public E get(int pos) throws DSListException {
        // TODO
        return null;
    }
     /*
     * does the list contain a certain item
     * @param element the item we're looking for
     * @return true if there, false if not
     */
    public boolean contains(E element) {
         // TODO
        return false;
    }
      /*
     * does the list contain a certain item
     * @param element the item we're looking for
     * @return position of the element if it's there, -1 if not
     */
    public int postitionOf(E element) {
         // TODO
        return -1;
    }
     /*
     * adds an element to the end of the list
     * @param element what we want to add
     * @throws DSListException
     */
    public void add(E element) {

    }
    public void addtoFront(E element) {
        Node<E> box = new Node(element, head_ptr);
        Node<E> temp = this.head_ptr;
        this.head_ptr = box;
        box.next = temp;
        this.size++;
    }
    public void add(E element, int postition) throws DSListException {

    }
     /*
     * gives the number of elements in it
     * @returns that amount as an int
     * @throws DSListException
     */
    public int size() {
         // TODO
        return 0;
    }
     /*
     * replaces an element
     * @param element that will replace it 
     * @param positon where the replacement will happen
     * @throws DSListException
     */
    public void replace(E element, int postition) throws DSListException {

    }
}