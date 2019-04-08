/**
 * Name: Pouya Langary
 * Student ID: 250798366
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Graph implements GraphADT {

    private GraphEdge[][] matrix; //Adjacency matrix that contains edges
    private GraphNode[] nodes;    //Array that contains the nodes
    private int size;             //Size of graph


    /**
     * Constructor which initializes the specified number of nodes as well as the matrix
     * @param n number of total nodes
     */
    public Graph(int n) { // initialize values

        size = n;
        matrix = new GraphEdge[n][n];
        nodes = new GraphNode[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new GraphNode(i);

        }
    }

    /**
     * Insert edge into the matrix
     * @param u node that represents first endpoint
     * @param v node that represents second endpoint
     * @param busLine char representing busline
     * @throws GraphException
     */
    public void insertEdge(GraphNode u, GraphNode v, char busLine) throws GraphException {


        if (!exists(u.getName()) || !(exists(v.getName()))) { //Check if specified nodes exists
            throw new GraphException("ERROR INSERTING");      //Throw exception

        }


        else if (emptyEdge(u,v) == true) { //Check if edge already exists
            matrix[u.getName()][v.getName()] = new GraphEdge(u, v, busLine); //Insert edge
            matrix[v.getName()][u.getName()] = new GraphEdge(v, u, busLine);
        } else {

            throw new GraphException("ERROR INSERTING");



        }

    }

    /**
     *
     * @param name
     * @return returns node associated with specified name
     * @throws GraphException
     */
    public GraphNode getNode(int name) throws GraphException {
        if (!exists(name))
            throw new GraphException("Node does not exist");
        else {
            return nodes[name];
        }

    }

    /**
     *
     *returns iterator of all incident edges on node u
     */
    public Iterator<GraphEdge> incidentEdges(GraphNode u) throws GraphException { // throw exception
        ArrayList<GraphEdge> incidents = new ArrayList<>(); //arrayList to hold all incident edges

        if (!(exists(u.getName()))) { //Check to see if it exists
            throw new GraphException("ERROR!");

        } else {
            for (int i = 0; i < size; i++) {
                GraphEdge temp = matrix[u.getName()][i]; //Temporary edge holder
                if (temp != null) { // add to arraylist if temp is not null
                    incidents.add(temp);
                }
            }

        }

        return incidents.iterator();

    }

    /**
     *
     * @param u first endpoint
     * @param v second endpoint
     * @return return edge between specified nodes
     * @throws GraphException
     */
    public GraphEdge getEdge(GraphNode u, GraphNode v) throws GraphException {

        if (!exists(u.getName()) || !exists(v.getName())) { //Check to see if nodes exist
            throw new GraphException("ERROR FINDING EDGE!"); //Throw exception
        }


        else if (emptyEdge(u,v)) { //Check to see if the edges exist
            throw new GraphException("ERROR FINDING EDGE!"); //Throw exception
        } else {
            return matrix[u.getName()][v.getName()]; //Return edge

        }
    }

    /**
     *
     * @param u
     * @param v
     * @return true if specified nodes are adjacent
     * @throws GraphException
     */
    public boolean areAdjacent(GraphNode u, GraphNode v) throws GraphException {

        if (!exists(u.getName()) || !exists(v.getName())) { //Check if nodes exists
            throw new GraphException("ERROR!");
        }

        else if (emptyEdge(u,v) == false) //If empty edge is false, return true. Return false otherwise
            return true;
        else {
            return false;
        }


    }


    private boolean exists(int n) { // Check to see if name exists

        if (n >= size)
            return false;
        else {
            return true;
        }

    }


    private boolean emptyEdge(GraphNode u, GraphNode v){ //check to see if edge is empty
        if(matrix[u.getName()][v.getName()] == null){
            return true;
        }
        else{
            return false;
        }

    }


}
