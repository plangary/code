import java.util.Iterator;

public class TreeNode<E> implements Comparable<E> {

    private TreeNode<E> parent;
    private E data;
    private String name;
    private OrderedList<TreeNode<E>> children;


    public TreeNode(TreeNode<E> parent, E data, String name) { // initializes instance variables using specified parameters
        this.parent = parent;
        this.name = name;
        this.data = data;
        children = new OrderedList<>();

    }

    public TreeNode<E> getParent() { //returns parent
        return parent;
    }


    public String getName() { // returns name
        return name;
    }

    public TreeNode<E> addChild(TreeNode<E> child) { // adds child to tree


        child.parent = this; // sets parent of child
        this.children.insert(child); // inserts child node to list
        return child;

    }


    public void print(int depth) { // prints children of node
        // OrderedList<String> hack=(OrderedList<String>) data; - could not resolve casting error when using this method
        //Iterator<String> iter=hack.iteratorDescending();

        OrderedList<TreeNode<E>> temp = children;
        Iterator<TreeNode<E>> iter = temp.iteratorDescending();


        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }




    public OrderedList<TreeNode<E>> getChildren() { // returns children
        return children;
    }


    @Override
    public int compareTo(E o) {
        return 0;
    }
}
