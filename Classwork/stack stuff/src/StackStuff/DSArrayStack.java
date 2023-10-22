package StackStuff;

public class DSArrayStack<E> implements DSStack<E>{
     private E[] stack;
     private int size;
     @SuppressWarnings({"unchecked"})
     public DSArrayStack() {
        stack = (E[] )new Object[100];
        size = 0;
     }
     @SuppressWarnings({"unchecked"})
     public void expand() {
        E[] newArr =  (E[]) new Object[this.stack.length*2];
          for(int i = 0; i < size; i++) {
            newArr[i] = this.stack[i];
          }
          this.stack = newArr;
     }
    /*
     * add element on top of stack
     * @param x
     */
    public void push(E x) {
        if(size == stack.length) {expand();}
        stack[this.size] = x;
        size++;
    }
    /*
     * remove and return top element from stack
     * @return top element
     * @throws DSStackException when stack is empty
     */
    public E pop() throws DSStackException {
        if(!this.isEmpty()) {
        this.size--;
        return stack[this.size];
        } else {
        throw new DSStackException("DSStack - Empty list, there is nothing to pop");
        }
    }
     /*
     * return top element from stack
     * @return top element
     * @throws DSStackException when stack is empty
     */
    public E peek() throws DSStackException {
        return stack[this.size - 1];
    }
    /*
     * @returns is the stack empty
     */
    public boolean isEmpty() {
        return this.size == 0;
    }
    
}
