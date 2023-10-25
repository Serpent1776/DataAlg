package DSQueuestuff;

public interface DSQueue<E> {
/**
* Add element to back of queue
* @param element - what is added
*/
public void enqueue(E element);
/**
* remove and return front element from queue
* @return original front element
* @throws DSStackException - when queue is empty
*/
public E dequeue() throws DSQueueException;
/**
* return (but not remove) front of queue
* @return front element
* @throws DSStackException - when queue is empty
*/
public E peekFront() throws DSQueueException;
/**
* checks if the queue is empty
* @return true if queue empty; false otherwise
*/
public boolean isEmpty();
}
