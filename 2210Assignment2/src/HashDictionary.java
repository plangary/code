

public class HashDictionary implements DictionaryADT {

    private Node[] hashTable;
    private int tableSize;


    /**
     * Initialize Hashtable with specified size
     **/
    public HashDictionary(int size) {

        hashTable = new Node[size];
        tableSize = size;

        for (int i = 0; i < size; ++i) {
            hashTable[i] = null;
        }

    }

    /**
     * Inserts given data of type configuration in the dictionary. If value exists, exception will be thrown.
     */
    public int put(Configuration data) throws DictionaryException {
        int hashVal = getHash(data.getStringConfig()); // calculate hash value based on given string
        Node entryNode = new Node(data); // create new node for data
        Node temp = hashTable[hashVal];

        if (hashTable[hashVal] == null) { //if value at given index is NULL, assign value
            hashTable[hashVal] = entryNode;
            return 0;

        } else {
            while (temp != null) { // if there is a value in the index, check for duplicate. If duplicate, throw exception
                if (temp.getKey().equals(data.getStringConfig())) {
                    throw new DictionaryException("Duplicate Key!");
                }
                temp = temp.getNext();
            }
            entryNode.setNext(hashTable[hashVal]); // insert node at begining of linked list
            hashTable[hashVal] = entryNode;
            return 1;
        }


    }


    public void remove(String config) throws DictionaryException {
        int hashVal = getHash(config);
        Node temp = hashTable[hashVal];
        Node end = temp;

        if (temp == null) {
            throw new DictionaryException("Value does not exist!"); //throw exception if value at index is null
        } else if (temp.getKey() == config) {
            hashTable[hashVal] = temp.getNext();
        } else {
            while (temp.getNext() != null) { //traverse linked list to find specified string. Remove string and reconnect links
                temp = temp.getNext();
                if (temp.getKey().equals(config)) {
                    end.setNext(temp.getNext());
                }
                end = end.getNext();
            }
        }


    }

    public int getScore(String config) {
        int hashVal = getHash(config); //get hashvalue for specified string
        Node temp = hashTable[hashVal]; //create temporary node

        if (temp == null) { //null check
            return -1;
        } else if (temp.getKey().equals(config)) {
            return temp.getScore();
        } else {
            while (temp.getNext() != null) { // check locations where multiple values are inserted at the same index
                temp = temp.getNext();
                if (temp.getKey().equals(config)) {
                    return temp.getScore();
                }

            }

        }
        return -1;

    }

    private int getHash(String key) { //generate hash value
        char[] charArray = key.toCharArray(); //split string into character array
        int hashVal = charArray[charArray.length - 1];
        for (int i = 0; i < charArray.length; i++) {
            hashVal = (hashVal * 15 + charArray[i]) % tableSize;  //calculate hash value using function

        }

        return hashVal;

    }



}
