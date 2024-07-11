import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphDFS {
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

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean[] visited) {
        // In Depth First Search we traverse deep down a particular vetex
        // First print the current Vetex
        System.out.print(curr + "  ");
        // mark current visited as true
        visited[curr] = true;
        // Traverse through all the vertices connected to the current vetex
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // if destination of vertex e is not previuously visited the dfs for that node
            // first
            if (visited[e.dest] == false) {
                dfs(graph, e.dest, visited);
            }
        }
    }


    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        dfs(graph, 0, new boolean[V]);
    }
    
}
