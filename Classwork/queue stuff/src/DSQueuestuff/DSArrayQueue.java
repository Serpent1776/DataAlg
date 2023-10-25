package DSQueuestuff;

public class DSArrayQueue<E> implements DSQueue<E> {
    int front;
    int back;
    E[] array;
    int size;
    @SuppressWarnings("Unchecked")
    public DSArrayQueue() {
        this.front = 0;
        this.back = 0;
        this.size = 0;
        this.array = (E[]) new Object[15];

    }
    @Override
    public void enqueue(E element) {
        if(this.size == 0) {
            this.front = 0;
            this.back = 0;
            this.array[0] = element;
            this.back++;
            this.size++;
        } else {
            if(this.size == this.array.length) {expand();}
            this.array[back] = element;
            this.back = (this.back + 1) % this.array.length;
            /*if(this.back == this.array.length) {this.back = 0;} */
            this.size++;
        }
    }
    @SuppressWarnings("Unchecked")
    public void expand() {
        E[] newArray = (E[]) new Object[2*this.array.length];
        int pos = this.front;
        for(int i = 0; i < this.size; i++) {
            newArray[i] = this.array[pos];
            pos = (pos+1) % this.array.length;
        }
        this.front = 0;
        this.back = this.size;
        this.array = newArray;
    }
    @Override
    public E dequeue() throws DSQueueException {
        if(this.size == 0) {throw new DSQueueException("Queue is empty");}
        E temp = this.array[this.front];
        this.front = (this.front+1) % this.array.length;
        this.size--;
        return temp;
    }
    @Override
    public E peekFront() throws DSQueueException {
        if(this.size == 0) {throw new DSQueueException("Queue is empty");}
        return this.array[this.front];
    }
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
