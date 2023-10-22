package DSQueuestuff;

public class LinkedQueue<E> {
    private class Node<E> {
        private E data;
        private Node<E> next;
    public Node(E data, Node<E> next) {
      this.data = data;
      this.next = next;
    }
    }
    private Node<E> front;
    private Node<E> back;
    private int size;
    public LinkedQueue() {
        front = null;
        back = null;
        size = 0;
    }
  public void enQueue(E data) {
    Node<E> newNode = new Node<E>(data, null);
    if(front == null) {
      front = newNode;
      back = newNode;
    } else {
    back.next = newNode;
    back = newNode;
    }
    size++;
  }
  public E deQueue() throws DSQueueException {
    if(size == 0) {throw new DSQueueException("the list is empty");}
    E ref = front.data;
    front = front.next;
    size--;
    return ref;
  }
  public E peekFront() throws DSQueueException {
    if(front == null) {throw new DSQueueException("there is nothing to look at because the list is empty");}
    return front.data;
  }
  public boolean isEmpty() {
    return size == 0;
  }
}
