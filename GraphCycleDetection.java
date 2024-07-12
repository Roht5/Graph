import java.util.*;

public class GraphCycleDetection {
    
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


    public static boolean detectCycle(ArrayList<Edge> graph[], boolean[] vis, int curr, boolean rec[]) {
        vis[curr]=true;
        rec[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e=graph[curr].get(i);
            if (rec[e.dest]) {
                return true;
            }else if (!vis[e.dest]) {
                detectCycle(graph, vis, e.dest, rec);
            }
            rec[curr]=false;
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean ans=detectCycle(graph, new boolean[V], 0, new boolean[V]);
        System.out.println(ans);
    }
}
