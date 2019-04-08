import java.util.Iterator;
import java.util.*;

public class IteratorDescending<E> implements Iterator {

    private int arraySize;// size of array
    private int current;
    private E[] items;// array of time E

    public IteratorDescending (E[] collection, int size){// initializes instance variables using specified parameters
        items = collection;
        arraySize = size;
        current = 0;
    }

    public boolean hasNext() {// checks if next element exists and returns true if it does, false if not
        return (current<arraySize);
    }

    public E next() {// returns next element
        if (!hasNext()) {// if no next element, throws exception
            throw new NoSuchElementException();
        }
        current ++;
        return items[current-1];
    }

}
ß