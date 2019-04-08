import com.sun.istack.internal.localization.NullLocalizable;

public class Node {

    private Configuration key;
    private Node next;

    public Node(Configuration key) {
        this.key = key;
        next = null;
    }

    public Node(Configuration key, Node next) {

        this.next = next;
        this.key = key;

    }

    public int getScore() {
        return key.getScore();
    }

    public Node getNext() {
        return next;
    }

    public String getKey() {
        return key.getStringConfig();
    }


    public void setNext(Node nextVal) {
        next = nextVal;
    }

    public void setKey(Configuration key) {
        this.key = key;
    }
}
