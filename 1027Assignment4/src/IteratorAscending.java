import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorAscending<E> implements Iterator{


    private int arraySize; // size of array
    private int current;
    private E[] items; // array of time E

    public IteratorAscending (E[] collection, int size){ // initializes instance variables using specified parameters
        items = collection;
        arraySize = size;
        current = 0;
    }

    public boolean hasNext() {
        return (current<arraySize);
    } // checks if next element exists and returns true if it does, false if not

    public E next() { // returns next element
        if (!hasNext()) { // if no next element, throws exception
            throw new NoSuchElementException();
        }
        arraySize --;
        return items[arraySize];
    }

}
