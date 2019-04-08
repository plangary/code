/**
 * Class to represent edges in the graph
 */
public class GraphEdge {

    private GraphNode u, v; //Declare variables
    private char line;


    /**
     * Constructor to initialize data with specified vallues
     * @param u
     * @param v
     * @param busLine
     */
    public GraphEdge (GraphNode u, GraphNode v, char busLine){
        this.v = v;
        this.u = u;
        this.line = busLine;



    }

    /**
     *
     * @return return first endpoint
     */
    public GraphNode firstEndpoint(){
        return u;
    }

    /**
     *
     * @return return second endpoint
     */
    public GraphNode secondEndpoint() {
        return v;
    }


    /**
     *
     * @return return busline
     */
    public char getBusLine(){
        return line;
    }
}
