package DSListStuff;
import java.util.ArrayList;
public class DSLinkedList<E extends Comparable<E>> implements DSList<E> {
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
    private Node<E> last_ptr;
    /*
     * get item from a certain spot
     * @param  postition - the spot
     * @return item at that spot
     * @throws DSListException
     */
    public DSLinkedList() {
        this.size = 0;
        this.head_ptr = null;
        this.last_ptr = null;
    }
    public E get(int pos) throws DSListException {
        if(pos < 0 || pos > this.size) {
            throw new DSListException("that position cannot be gotten!");
        }
        Node<E> p1 = this.head_ptr;
        for(int i = 0; i < pos; i++) {
            p1 = p1.next;
        }
        return p1.data;
    }
     /*
     * does the list contain a certain item
     * @param element the item we're looking for
     * @return true if there, false if not
     */
    public boolean contains(E element) {
       Node<E> p1 = this.head_ptr; 
        boolean exists = false;
        while(p1.next != null) {
            if(p1 == element) {
                exists = true;
                break;
            }
            p1 = p1.next;
         }
         return exists;
    }
      /*
     * does the list contain a certain item
     * @param element the item we're looking for
     * @return position of the element if it's there, -1 if not
     */
    public int postitionOf(E element) {
        Node<E> p1 = this.head_ptr;
        int pos = 0; 
        boolean exists = false;
        while(p1.next != null) {
            if(p1 == element) {
                exists = true;
                break;
            }
            pos++;
            p1 = p1.next;
         }
         if(exists) {
        return pos;
         } else {
        return -1;
         }
    }
     /*
     * adds an element to the end of the list
     * @param element what we want to add
     * @throws DSListException
     */
    public void add(E element) {
       if(this.head_ptr == null) {
            this.addtoFront(element);
       } else {
            Node<E> box = new Node<E>(element, null);
            this.last_ptr.next = box;
            this.last_ptr = box;
            this.size++;
    }
    }
    public void addtoFront(E element) {
        Node<E> box = new Node<E>(element, head_ptr);
        Node<E> temp = this.head_ptr;
        this.head_ptr = box;
        box.next = temp;
        this.size++;
        if(this.size == 1) {
            this.last_ptr = box;
        }
    }
    public void add(E element, int postition) throws DSListException {
         if(this.head_ptr == null) {
            this.addtoFront(element);
       }
        if(postition < 0 || postition > this.size) {
            throw new DSListException("that position cannot be reached!");
        }
        if(postition == 0) {
            this.addtoFront(element);
        }
        if(postition == this.size) {
            this.add(element);
        }
        Node<E> p1 = this.head_ptr;
        for(int i = 0; i < postition - 1; i++) {
            p1 = p1.next;
        }
        Node<E> box = new Node<E>(element, p1.next);
        p1.next = box;
        this.size++;
        
    }
     public void remove(int postition) throws DSListException {
         if(postition == 0) {
            this.head_ptr = this.head_ptr.next;
            this.size--;
            if(this.head_ptr == null) {this.last_ptr = null;}
       } 
        if(postition < 0 || postition > this.size) {
            throw new DSListException("that position cannot be reached!");
        }
        Node<E> p1 = this.head_ptr;
        for(int i = 0; i < postition - 1; i++) {
            p1 = p1.next;
            p1.next = p1.next.next;
        }
        this.size--;
    }
        
     /*
     * gives the number of elements in it
     * @returns that amount as an int
     * @throws DSListException
     */
    public int size() {
        return this.size;
    }
     /*
     * replaces an element
     * @param element that will replace it 
     * @param positon where the replacement will happen
     * @throws DSListException
     */
    public void replace(E element, int postition) throws DSListException {
        if(postition < 0 || postition > this.size) {
            throw new DSListException("that position cannot be reached!");
        }
        Node<E> p1 = this.head_ptr;
        for(int i = 0; i < postition; i++) {
            p1 = p1.next;
        }
        Node<E> box = new Node<E>(element, p1.next);
        p1 = box;
    }
    /*  public void addSorted(E x)  - 
    assuming the list is already sorted, add x into the appropriate spot in that list, 
    shifting all other elements as necessary. 
    You should use the method compareTo, not <, in your code.
     It should look like array[i].compareTo(x) < 0 to check if elements[i] is smaller than x.
     Time: O(n)
     */
    public void addSorted(E x) throws DSListException {
         if(this.head_ptr == null) {
            this.addtoFront(x);
       }
         Node<E> p1 = this.head_ptr;
         int pos = 0;
         while(p1 != null) {
            if(p1.data.compareTo(x) < 0) {
                pos++;
                p1 = p1.next;
            } else {
                break;
            }
         }
         if(pos == 0) {
            this.addtoFront(x);
         } else {
         try {
         this.add(x, pos);
         } catch(Exception e) {
            throw e;
         }
        }
    }
     /*
        public ArrayList<Integer> allIndices(E x) - 
        returns an ArrayList (the one built into Java) consisting of all the indices where x appears. 
        For example, if x were 'a' in the list 'r','u','t','a','b','a','g','a', 
        this method would return a list containing 3,5,7. 
        If x does not appear, return the empty list. Be sure to use equals rather than == for comparison.
        Time: O(n)
        */
    public ArrayList<Integer> allIndices(E x) {
            ArrayList<Integer> indices = new ArrayList<Integer>();
            Node<E> p1 = this.head_ptr;
            int pos = 0;
            while(p1 != null) {
                if(p1.data.equals(x)) {
                    indices.add(pos);
                }
                p1 = p1.next;
                pos++;
            }
            return indices;
         }
        /*
        public void clear() - removes all elements from the list.
        Time: O(1)
        */ 
        public void clear() {
            this.head_ptr = null;
            this.size = 0;
        }
        /*
        public boolean equals(DSLinkedList<E> otherList) -
         returns true if this list is the same as otherList,
         meaning it has exactly the same elements in the same order. 
         Be sure to use equals, not ==, to compare list elements.
         Time: O(n)
        */
        public boolean equals(DSLinkedList<E> otherList) {
            if(otherList.size != this.size) {return false;}
            Node<E> p1 = this.head_ptr;
            Node<E> p2 = otherList.head_ptr;
            while(p1 != null) {
                if(!(p1.data.equals(p2.data))) {
                    return false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            return true;
        }

        /*
        public void rotate() - moves the first element of the list to the end, 
        shifting elements as appropriate. You may assume the list will have at least one element. 
        For example, 
        rotating 'r','u','t','a','b','a','g','a' gives the list 'u', 't', 'a', 'b', 'a', 'g', 'a', 'r'. 
        Time: O(n)/O(1)
        */
        public void rotate() {
            //Node<E> p1 = this.head_ptr;
        //while(p1.next != null) { 
            /*E temp = p1.next.data;
            p1.next.data = p1.data; 
            p1.data = temp;
            p1 = p1.next;/* */
            Node<E> box = new Node<E>(this.head_ptr.data, null);
            this.last_ptr.next = box;
            this.last_ptr = box;
            this.head_ptr = this.head_ptr.next;
            //}
         }
         /*public E getMode() throws DSListException. 
It should return the element that appears most often in the list. 
For example, if the list were [6, 5, 1, 5, 2, 3, 1, 5, 4], 
it would return 5 since there are 3 5s in the list, 2 1s, and every other element appears just once. 
If there is a tie for mode, you could return any one of the tied elements. 
For example, with [6, 5, 1, 5, 2, 3, 1, 5, 1], you could return either 5 or 1. 
If the list is empty, throw an exception.  
Time: O(n^2)*/
    public E getMode() throws DSListException {
        if(size == 0) {throw new DSListException("This function cannot be done on empty lists!");}
        boolean endItAll = false;
        E mode = this.head_ptr.data;
        Node<E> p1 = this.head_ptr;
        int[] counters = new int[this.size];
        int pos = 0;
            while(p1 != null) {
                E x = p1.data;
                Node<E> p2 = this.head_ptr;
                    while(p2 != null) {
                        if(p2.data.equals(x)) {
                            counters[pos]++;
                        }
                     p2 = p2.next;
                    }
                for(int l = 0; l < size; l++) {
                    if(counters[l] > this.size/2) {
                        endItAll = true;
                        break;
                    }
                }
                if(endItAll) {break;}
            //System.out.println(counters); this line is just for debugging    
         pos++;
         p1 = p1.next;
        }
        int greatest = counters[0];
        Node<E> p3 = this.head_ptr;
        pos = 0;
        while(p3 != null) {
            if(counters[pos] > greatest) {
                greatest = counters[pos];
                mode = p3.data;
            }
            pos++;
            p3 = p3.next;
        }
        return mode;
    }

        public String toString() {
            String o = "";
            Node<E> p1 = this.head_ptr;
            int nodeNum = 1;
            while(p1 != null) {
                o += "Node " + nodeNum + ":\n";
                o += p1.data + "\n";
                p1 = p1.next;
                nodeNum++;
            }
            return o;
        }
        public int lengthRecursiveHelper() {
            return lengthRecursive(head_ptr);
        }
        private int lengthRecursive(Node<E> base_ptr) {
            if(base_ptr == null) {return 0;}
            int lenRest = lengthRecursive(base_ptr.next);
            return lenRest + 1;
        }

}