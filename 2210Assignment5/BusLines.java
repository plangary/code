import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BusLines {

    private int C, W, H, K, numNodes;
    private String line1;
    private String[] parts;
    private GraphNode start, end;
    private int counter = 0;



    public BusLines(String inputFile) throws MapException, GraphException {


        try {
            BufferedReader file = new BufferedReader(new FileReader(inputFile)); // Open file, throw exception if it does not exist
            line1 = file.readLine();
            parts = line1.split("\\s+");

            C = Integer.parseInt(parts[0]); //Parse file and initialize values
            H = Integer.parseInt(parts[1]);
            W = Integer.parseInt(parts[2]);
            K = Integer.parseInt(parts[3]);
            numNodes = H * W;


            Graph g = new Graph(numNodes); //create graph with specified size
            char c;


            String s;

            for (int i = 0; i< H; i++){
                s = file.readLine();
                for (int j = 0; j < W ; j++){

                    c = s.charAt(j);
                    System.out.print(c);

                    if ( c == 'S'){ //set start node
                        start = g.getNode(counter);
                        counter++;
                    }
                    else if(c == 'D'){ //set end node
                        end = g.getNode(counter);
                        counter++;


                    }
                    else if( c == '.'){
                        counter++;
                    }
                    else if(Character.isLetter(c) || Character.isDigit(c)){
                        g.insertEdge(g.getNode(counter-1),g.getNode(counter), c);

                    }

                }



            }


        } catch (IOException e) {
            throw new MapException("ERROR");

        }



    }


}










