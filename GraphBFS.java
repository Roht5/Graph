import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * GraphBFS
 */
public class GraphBFS {

    // Vertex Or vertices are the point
    // Edges are the lines that connect different vertices

    // Creating a Edge class to Store Source, Destination, and weight of a
    // particular Edge

    static class Edge {
        int src;
        int dest;
        int wt;

        // Method to create a new edge
        public Edge(int source, int destination, int weight) {
            this.src = source;
            this.dest = destination;
            this.wt = weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        // Structure of the current Graph formed
        //
        // 1---- 3
        // 0< | | >5
        // 2---- 4
        //
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 2));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 4, 10));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 4, -1));
        graph[3].add(new Edge(3, 5, 2));

        graph[4].add(new Edge(4, 2, 2));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 2));

        graph[5].add(new Edge(5, 3, 2));
        graph[5].add(new Edge(5, 4, 2));
        graph[5].add(new Edge(5, 6, 2));

        graph[6].add(new Edge(6, 5, 2));
    }

    public static void bfs(ArrayList<Edge> graph[], int V) {
        // In breadth first search we first traverse nearest vetices
        // Created a Queue to store Vertex
        Queue<Integer> q = new LinkedList<>();
        // Creating a Array to check if we have visited that node previously or not
        boolean[] vis = new boolean[V];
        // Adding first edge to the queue here we have taken 0 but it can be anything
        // Remember we are storing Vertex not Edges
        q.add(0);
        // while q has values i.e until every node is traversed the loop is runned
        while (!q.isEmpty()) {
            // removing first node/Vertex from the queue
            int curr = q.remove();
            // only if the node has not been previously visited this code should run
            if (vis[curr] == false) {
                // First print the current node
                System.out.print(curr + "  ");
                // Mark the current node as visited
                vis[curr] = true;
                // now we will add the vetices which are connected to current vetex
                for (int i = 0; i < graph[curr].size(); i++) {
                    // add vertices connected to current graph
                    Edge ed = graph[curr].get(i);
                    q.add(ed.dest);
                }
            }
        }
    }


    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        //Breadth First Search
        bfs(graph, V);
    }
}