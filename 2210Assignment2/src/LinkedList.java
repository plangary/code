public class LinkedList {
    private Node head;


   // public static void main(String[] args){
        /*Configuration data1 = new Configuration("data1", 1);
        Configuration data2 = new Configuration("data2", 1);
        Configuration data3 = new Configuration("data3", 1);
        Configuration data4 = new Configuration("data4", 1);
        Configuration data5 = new Configuration("data5", 1);
        Configuration data6 = new Configuration("data6", 1);
        Configuration data7 = new Configuration("data7", 1);
        Configuration data8 = new Configuration("data8", 1);

        Node node1 = new Node(data1);
        Node node2 = new Node(data2);
        Node node3 = new Node(data3);
        Node node4 = new Node(data4);
        Node node5 = new Node(data5);
        Node node6 = new Node(data6);
        Node node7 = new Node(data7);
        Node node8 = new Node(data8);


        LinkedList list = new LinkedList(node1);
        list.insert(node2);
        list.insert(node3);
        list.insert(node4);
        list.insert(node5);
        list.insert(node6);
        list.insert(node7);
        list.insert(node8);

        list.print();
        System.out.print("------------------------");

        list.removeLink(node7);
        list.print();

*/
    //}
    public LinkedList(Node node){
        head = node;
    }

    public LinkedList(){
        head = null;
    }

    public void insert(Node link){
        Node curr = head;

        while (curr.getNext()!=null){
            curr = curr.getNext();
        }

        curr.setNext(link);

    }

    public void removeLink(Node node){
        Node curr = head;
        while(curr.getNext()!=null){
            if (curr.getNext().getKey().equals(node.getKey())){
                curr.setNext(curr.getNext().getNext());
            }
            curr = curr.getNext();
        }

    }

    public void print(){
        Node temp = head;

        while (temp!=null){
            System.out.print(temp.getKey()+"\n");
            temp = temp.getNext();
        }
    }

}

