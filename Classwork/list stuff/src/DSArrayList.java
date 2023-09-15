import java.util.Arrays;
import java.util.ArrayList;
public class DSArrayList<E extends Comparable<E>> implements DSList<E>{
    private E[] array; // array that holds them
    private int size; // how many elements live in the array
    @SuppressWarnings("unchecked")
    public DSArrayList() {
        this.array = (E[]) new Comparable[100];
        this.size = 0;
    }
    @SuppressWarnings("unchecked")
    public DSArrayList(int capacity) {
        this.array = (E[]) new Comparable[capacity];
        this.size = 0;
    }
    public E get(int pos) {
        if(size > pos) {
        return array[pos];
        }
        return null;
    }
    public void remove(E x) {
       int pos = postitionOf(x);
       //array[pos] = null;
       for(int i = pos; i < size-1; i++) {
        array[i] = array[i+1];
       }
       array[size-1] = null;
       size--;
    }
    public boolean contains(E element) {
        for(int i = 0; i < size; i++) {
            if(array[i].equals(element)) {
                return true;
            }
        }
        
        return false;
    }
    public int postitionOf(E element) {
         for(int i = 0; i < size; i++) {
            if(array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
    private void expand() {
          /*E[] newArr =  (E[]) new Object[this.array.length*2];
          for(int i = 0; i < size; i++) {
            newArr[i] = this.array[i];
          }
          this.array = newArr;
          */
          this.array = Arrays.copyOf(this.array, this.array.length*2);
    }
    public void add(E element) {
        if(size == array.length) {
            expand();
          }
        array[size] = element;
        size++;
        }
    public void add(E[] elements) {
        while(size + elements.length >= array.length) {
            expand();
            
        }
        for(int i = 0; i < elements.length; i++) {
            array[size + i] = elements[i];
        }
        size += elements.length;
    }
    public void add(E element, int postition) {
        if(postition < size) {
          if(size == array.length) {
                   expand();
          }
            if(array[postition] != null) {
                for(int i = size; i > postition - 1; i--) {
                    array[i + 1] = array[i];
                }
                array[postition] = element;
            } else {
                array[postition] = element;
            }
        } else {
            System.out.print("you can't add here, the position is too big");
        }
        size++;
    }
    public int size() {
        return size;
    }
    public void replace(E element, int postition) {
        if(postition < size && postition < array.length) {
            array[postition] = element;
        } else {
            System.out.print("you can't replace here, the position is too big");   
        }
    }
/*addSorted - assuming the list is already sorted, add x into the appropriate spot in that list, 
 *shifting all other elements as necessary.
 *You should use the method compareTo, not <, in your code. 
 *It should look like array[i].compareTo(x) < 0 to check if elements[i] is smaller than x.
 *Worst case: O(n)
 */    
    public void addSorted(E x) {
        int addLocation = -1;
        for(int i = 0; i < size; i++) {
            if(array[i].compareTo(x) >= 0) {
                addLocation = i;
                break;
            }
        }
        if(addLocation != -1) {
            add(x, addLocation);
        } else {
            add(x);
        }
    }

/*allIndices - returns an ArrayList (the one built into Java) consisting of all the indices where x appears. 
 *For example, if x were 'a' in the list 'r','u','t','a','b','a','g','a':
 *this method would return a list containing 3,5,7. 
 *If x does not appear, return the empty list. Be sure to use equals rather than == for comparison.
 *Worst case: O(n)
 */
    public ArrayList<Integer> allIndices(E x) {
        ArrayList<Integer> indices = new ArrayList<Integer>();
        for(int i = 0; i < size; i++) {
            if(array[i].equals(x)) {
                indices.add(i);
            }
        }
        return indices;
    }
/*clear - removes all elements from the list.
 *Worst case: O(1)
 */
 @SuppressWarnings("unchecked")
    public void clear() {
        int len =  array.length;
        this.array = (E[]) new Comparable[len];
        size = 0;
    } 
/*
 *equals returns true if this list is the same as otherList, 
 *meaning it has the same elements in the same order. 
 *Be sure to use equals, not ==, to compare list elements.
 *Worst case: O(n)
 */
    public boolean equals(DSArrayList<E> otherList) {
        for(int i = 0; i < size; i++) {
            if(!(array[i].equals(otherList.get(i)))) {
                return false;
            }
        }
        return true;
    }

/*rotate() - moves the first element of the list to the end, shifting elements as appropriate. 
You may assume the list will have at least one element. 
For example, rotating 'r','u','t','a','b','a','g','a' gives the list 'u', 't', 'a', 'b', 'a', 'g', 'a', 'r'. 
Worst case - O(n)
*/
    public void rotate() {
        for(int i = 0; i < size-1; i++) {
            if(i != 0) {
                E temp = this.array[i-1];
                this.array[i-1] = this.array[i];
                this.array[i] = temp;
            } else {
                E temp = this.array[size-1];    
                this.array[size-1] = this.array[i];
                this.array[i] = temp;
        }
        }
    }
    public String toString() {
        String arrStr = "[";
        for(int i = 0; i < size; i++) {
            if(i < size - 1) {
                arrStr += this.array[i] + ", ";
            } else {
                arrStr += this.array[i];    
            }
        }
        return arrStr + "]";
    }
}
