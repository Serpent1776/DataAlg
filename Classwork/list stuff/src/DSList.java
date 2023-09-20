public interface DSList<E> {
    /*
     * get item from a certain spot
     * @param  postition - the spot
     * @return item at that spot
     * @throws DSListException
     */
    public E get(int pos) throws DSListException;
     /*
     * does the list contain a certain item
     * @param element the item we're looking for
     * @return true if there, false if not
     */
    public boolean contains(E element);
      /*
     * does the list contain a certain item
     * @param element the item we're looking for
     * @return position of the element if it's there, -1 if not
     */
    public int postitionOf(E element);
     /*
     * adds an element to the end of the list
     * @param element what we want to add
     * @throws DSListException
     */
    public void add(E element);
    public void add(E element, int postition) throws DSListException;
     /*
     * gives the number of elements in it
     * @returns that amount as an int
     * @throws DSListException
     */
    public int size();
     /*
     * replaces an element
     * @param element that will replace it 
     * @param positon where the replacement will happen
     * @throws DSListException
     */
    public void replace(E element, int postition) throws DSListException;
}