import java.util.*;
import java.util.ArrayList;

public class OrderedList<E> {
    private E[] items; //array []
    private int size;
    private final int DEFAULT_CAPACITY = 100;


    public OrderedList() {
        items = (E[]) (new Object[DEFAULT_CAPACITY]); // initializes array with default size
        size = 0;
    }

    /**
     * Checks if list is empty.
     *
     * @return True if empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(E element) {
        if (!(element instanceof Comparable)) {
            System.out.println("Element you are trying to insert does not implement Comparable!");
            return;
        }

        if (items.length == size) // check to see if array is full
            expandCapacity();

        Comparable temp = (Comparable) element; // create comparable element


        int scan = 0;
        while (scan < size && temp.compareTo(items[scan]) > 0) // iterate through array checking compareTo value
            scan++;

        for (int scan2 = size; scan2 > scan; scan2--) // shifts elements accordingly
            items[scan2] = items[scan2 - 1];
        items[scan] = element;
        size++;
    }

    public void expandCapacity() { // expands array size

        E[] larger = (E[]) (new Object[items.length * 2]); // creates temporary larger array

        for (int scan = 0; scan < items.length; scan++) // copys elements over to new array
            larger[scan] = items[scan];

        items = larger;


    }

    public String toString() { // returns string representation of array
        String result = "";
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null)
                result += items[i].toString();
                i++;
        }

        return result;
    }


    public Iterator<E> iteratorAscending() {
        return new IteratorAscending<E>(items, size); // returns iterator ascending object
    }

    public Iterator<E> iteratorDescending() {
        return new IteratorDescending<>(items, size); // returns iterator decsennding object

    }

    public int getLength() { //returns length of array
        return size;
    }

    public E[] getItems() {
        return items;
    } // returns items array
}


