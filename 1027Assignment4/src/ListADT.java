import java.util.Iterator;

public interface ListADT<E> extends Iterable<E> {
    /**
     * Removes and returns the first element from this list.
     *
     * @return  the first element from this list
     */
    public E removeFirst ();

    /**
     * Removes and returns the last element from this list.
     *
     * @return  the last element from this list
     */
    public E removeLast ();

    /**
     * Removes and returns the specified element from this list.
     *
     * @param element  the element to be removed from the list
     */
    public E remove (E element);

    /**
     * Returns a reference to the first element in this list.
     *
     * @return  a reference to the first element in this list
     */
    public E first ();

    /**
     * Returns a reference to the last element in this list.
     *
     * @return  a reference to the last element in this list
     */
    public E last ();

    /**
     * Returns true if this list contains the specified target element.
     *
     * @param target  the target that is being sought in the list
     * @return        true if the list contains this element
     */
    public boolean contains (E target);

    /**
     * Returns true if this list contains no elements.
     *
     * @return  true if this list contains no elements
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this list.
     *
     * @return  the integer representation of number of elements in this list
     */
    public int size();

    /**
     * Returns an iterator for the elements in this list.
     *
     * @return  an iterator over the elements in this list
     */
    public Iterator<E> iterator();

    /**
     * Returns a string representation of this list.
     *
     * @return  a string representation of this list
     */
    public String toString();


}
