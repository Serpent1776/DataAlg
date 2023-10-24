package StackStuff;

public class DSLinkedStack<E> implements DSStack<E>{
    private class Node<E> {
        private E data;
        private Node<E> next;
        public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
        }
    }
    private Node<E> head_ptr;
    private int size;
    public void push(E x) {
        this.head_ptr = new Node<E>(x, this.head_ptr);
        size++;
    }
    public E pop() throws DSStackException {
        if (size == 0) {
        throw new DSStackException("Stack is empty");
        }
        E result = this.head_ptr.data;
        this.head_ptr = this.head_ptr.next;
        size--;
        return result;
    }
    public E peek() throws DSStackException {
        if(size == 0) {throw new DSStackException("Stack is empty");}
        return this.head_ptr.data;
    }
    public E peekNextToTop() throws DSStackException {
        if(size == 0) {throw new DSStackException("Stack is empty");}
        if(size == 1) {return null;}
        return this.head_ptr.next.data;

    }
    public boolean isEmpty() {
        return size == 0;
    }
}
