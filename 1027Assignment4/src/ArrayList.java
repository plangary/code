import java.util.Iterator;

public class ArrayList<E> implements ListADT<E>, Iterable<E>{
    protected final int DEFAULT_CAPACITY = 100;
    private final int NOT_FOUND = -1;
    protected int rear;
    protected E[] list;

    /**
     * Creates an empty list using the default capacity.
     */
    public ArrayList()
    {
        rear = 0;
        list = (E[])(new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Creates an empty list using the specified capacity.
     *
     * @param initialCapacity  the integer value of the size of the array list
     */
    public ArrayList (int initialCapacity)
    {
        rear = 0;
        list = (E[])(new Object[initialCapacity]);
    }

    /**
     * Removes and returns the last element in this list.
     *
     * @return                           the last element in the list
     * @throws EmptyCollectionException  if an empty collection exception occurs
     */
    public E removeLast () throws EmptyCollectionException
    {
        //left as programming project
        return null;
    }

    /**
     * Removes and returns the first element in this list.
     *
     * @return                           the first element in the list
     * @throws EmptyCollectionException  if an empty collection exception occurs
     */
    public E removeFirst() throws EmptyCollectionException
    {
        //left as programming project
        return null;
    }

    /**
     * Removes and returns the specified element.
     *
     * @param element                    the element to be removed and returned
     *                                   from the list
     * @return                           the removed elememt
     * @throws ElementNotFoundException  if an element not found exception occurs
     */
    public E remove (E element)
    {
        E result;
        int index = find (element);

        if (index == NOT_FOUND)
            throw new ElementNotFoundException ("list");

        result = list[index];
        rear--;
        /** shift the appropriate elements */
        for (int scan=index; scan < rear; scan++)
            list[scan] = list[scan+1];

        list[rear] = null;

        return result;
    }

    /**
     * Returns a reference to the element at the front of this list.
     * The element is not removed from the list.  Throws an
     * EmptyCollectionException if the list is empty.
     *
     * @return                           a reference to the first element in the
     *                                   list
     * @throws EmptyCollectionException  if an empty collection exception occurs
     */
    public E first() throws EmptyCollectionException
    {        return null;

        //left as programming project
    }

    /**
     * Returns a reference to the element at the rear of this list.
     * The element is not removed from the list.  Throws an
     * EmptyCollectionException if the list is empty.
     *
     * @return  a reference to the last element of this list
     * @throws EmptyCollectionException  if an empty collection exception occurs
     */
    public E last() throws EmptyCollectionException
    {
        return null;
        //left as programming project
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param target  the element that the list is searched for
     * @return        true if the target is in the list, false if otherwise
     */
    public boolean contains (E target)
    {
        return (find(target) != NOT_FOUND);
    }

    /**
     * Returns the array index of the specified element, or the
     * constant NOT_FOUND if it is not found.
     *
     * @param target  the element that the list will be searched for
     * @return        the integer index into the array containing the target
     *                element, or the NOT_FOUND constant
     */
    private int find (E target)
    {
        int scan = 0, result = NOT_FOUND;
        boolean found = false;

        if (! isEmpty())
            while (! found && scan < rear)
                if (target.equals(list[scan]))
                    found = true;
                else
                    scan++;

        if (found)
            result = scan;

        return result;
    }

    /**
     * Returns true if this list is empty and false otherwise.
     *
     * @return  true if the list is empty and false if otherwise
     */
    public boolean isEmpty()
    {
        return false;
        //left as programming project
    }

    /**
     * Returns the number of elements currently in this list.
     *
     * @return  the integer representation of the number of elements in the list
     */
    public int size()
    {
        //left as programming project
        return -1;

    }

    /**
     * Returns an iterator for the elements currently in this list.
     *
     * @return  an iterator for the elements in this list
     */
    public Iterator<E> iterator()
    {
        return new ArrayIterator<E> (list, rear);
    }

    /**
     * Returns a string representation of this list.
     *
     * @return  the string representation of this list
     */
    public String toString()
    {
        return null;
        //left as programming project
    }

    /**
     * Creates a new array to store the contents of this list with
     * twice the capacity of the old one.
     */
    protected void expandCapacity()
    {
        E[] larger = (E[])(new Object[list.length*2]);

        for (int scan=0; scan < list.length; scan++)
            larger[scan] = list[scan];

        list = larger;
    }

}
