import com.sun.tools.corba.se.idl.constExpr.Or;

/**
 * Contains the main function and the recursive method....
 */
public class SystemPrint {

    private static TreeNode<Data> root;

    /**
     * The main method
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Data source = new Data(); // creates data object

        OrderedList<String> names = new OrderedList<>(); // creates ordered list of names
        for (int i = 0; i < source.getChildData().length; i++) { // for each child data item, adds child data name to list
            names.insert(source.getChildData()[i].getName());
        }
        root = new TreeNode<Data>(null, source, "Root"); // creates root of node with
        recurse3(source, root);

    }


    public static void recurse3(Data dir, TreeNode dirNode) { // takes data container and node as parameters
        Data[] array = dir.getChildContainers(); // gets child container of original container
        String n = "";
        for (int i = 0; i < array.length; i++) { //iterates through child containers and creates ordered list of names for each
            OrderedList<String> names = new OrderedList<>();
            {
                for (int x = 0; x < array[i].getChildData().length; x++) { // gets child data of each child container and adds name to list
                    names.insert(array[i].getChildData()[x].getName());
                    n = array[i].getChildData()[x].getName();
                }

                TreeNode<OrderedList> node = new TreeNode<>(dirNode, names, n); // creates new node and adds node to tree
                dirNode.addChild(node);
                recurse3(dir.getChildContainers()[i], node); //calls recursive function again using new container and node
            }


        }


    }

   /* public static void recurse(Data dir, TreeNode dirNode) {
        Data[] array = null;
        for (int i = 0; i < dir.getChildContainers().length; i++) {
            array = dir.getChildContainers();
            OrderedList<String> names = new OrderedList<>();
            {
                for (int x = 0; x < dir.getChildContainers()[i].getChildData().length; x++) {
                    names.insert(dir.getChildContainers()[i].getChildData()[x].getName());
                }

                TreeNode<OrderedList> node = new TreeNode<>(dirNode, names, dir.getChildContainers()[i].getName());
                dirNode.addChild(node);
                recurse(dir.getChildContainers()[i], node);
                System.out.println(node);
            }


        }


    }
    */


    public static void recurse2(Data dir[], TreeNode dirNode) {
        for (int i = 0; i < dir.length; i++) {
            OrderedList<String> name = new OrderedList<>();
            //if (dir[i].isContainer())
            name.insert(dir[i].getName());
            System.out.println(dir[i].getName());

            for (int x = 0; x < dir[x].getChildData().length; x++) {
                // if (!dir[i].isContainer())
                name.insert(dir[x].getChildData()[x].getName());
            }
            TreeNode<String> node = new TreeNode<String>(dirNode, dir[i].getName(), dir[i].getName());
            recurse2(dir[i].getChildContainers(), node);


        }


    }
}
