package DSQueuestuff;

public class DSLinkedQueue<E> implements DSQueue<E> {
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
    public DSLinkedQueue() {
        front = null;
        back = null;
        size = 0;
    }
  public void enqueue(E data) {
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
  public E dequeue() throws DSQueueException {
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
  //enqueue & dequeue
  public void moveToRear() throws DSQueueException {
    try {
    enqueue(this.dequeue());
  } catch (Exception e) {
      throw new DSQueueException(e.getMessage());
    } 
  }
  //work with nodes directly
  public void moveToRear2() {
    Node<E> box = new Node<E>(front.data, null);
    back.next = box;
    back = box;
    this.front = front.next;
  }
  //enqueue & dequeue
  public void moveToFront() throws DSQueueException {
     try {
    for(int i = 0; i < size-1; i++) {
    enqueue(this.dequeue());
    }
  } catch (Exception e) {
      throw new DSQueueException(e.getMessage());
    } 
  }
  public String toString() {
    String o = "";
    Node<E> p1 = this.front;
    int nodeNum = 1;
    while(p1 != null) {
        o += "Node " + nodeNum + ":\n";
        o += p1.data + "\n";
        p1 = p1.next;
        nodeNum++;
    }
    return o;
  }
}
