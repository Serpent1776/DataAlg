package StackStuff;

public interface DSStack<E> {
    /*
     * add element on top of stack
     * @param x
     */
    public void push(E x);
    /*
     * remove and return top element from stack
     * @return top element
     * @throws DSStackException when stack is empty
     */
    public E pop() throws DSStackException;
     /*
     * return top element from stack
     * @return top element
     * @throws DSStackException when stack is empty
     */
    public E peek() throws DSStackException;
    /*
     * @returns boolean
     */
    public boolean isEmpty();
    

}
