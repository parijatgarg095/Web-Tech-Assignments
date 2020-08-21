import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ans {
    private static void allPaths(int vertex, int start, int end, boolean[][] graph, ArrayList<Integer> v,
            int dist, boolean[] visited) 
    {
        v.add(start);
        visited[start] = true;
        if (start == end) {
            System.out.print("\nPath: ");
            for (Integer integer : v) {
                System.out.print(integer + 1 + " ");
            }
            System.out.println("\nDistance From Source: " + dist);
            visited[start] = false;
            v.remove(v.size() - 1);
            return;
        }

        for (int i = 0; i < vertex; i++) {
            if (visited[i] == false && graph[start][i]) {
                allPaths(vertex, i, end, graph, v, dist + 1, visited);
            }
        }
        visited[start] = false;
        v.remove(v.size() - 1);
    }
    public static class edge_of_graph {


        int start;
        int end;
        int wt_edge;

        public edge_of_graph(int start, int end, int wt_edge) {



            this.end = end - 1;
            this.start = start - 1;
            this.wt_edge = wt_edge;
        }

    }
    private static void shortst_path_finder(int vertex, int start, int end, int edges, edge_of_graph[] edges_list) {


        int[] dist = new int[vertex];
        int[] parent = new int[vertex];
        for (int i = 0; i < vertex; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
        dist[start] = 0;
        for (int i = 0; i < vertex - 1; i++) {

            for (int j = 0; j < edges; j++) {
                if (dist[edges_list[j].start] != Integer.MAX_VALUE
                        && dist[edges_list[j].start] + edges_list[j].wt_edge < dist[edges_list[j].end]) {
                    dist[edges_list[j].end] = dist[edges_list[j].start] + edges_list[j].wt_edge;
                    parent[edges_list[j].end] = edges_list[j].start;
                }
            }

        }
        for (int j = 0; j < edges; j++) {
            if (dist[edges_list[j].start] != Integer.MAX_VALUE
                    && dist[edges_list[j].start] + edges_list[j].wt_edge < dist[edges_list[j].end]) {
                System.out.println("Negative Cycles Exist");
                return;
            }
        }
        Stack<Integer> myStack = new Stack<Integer>();
        int node = end;
        while (node != -1) {
            myStack.push(node + 1);
            node = parent[node];
        }
        System.out.print("Path: ");
        while (!myStack.empty()) {
            System.out.print(myStack.pop() + " ");
        }
        System.out.println("\nDistance From Source: " + dist[end]);

    }


    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of Vertices: ");
        int vertex = input.nextInt();
        System.out.print("Enter number of edge_of_graphs: ");
        int edges = input.nextInt();
        edge_of_graph[] edges_list = new edge_of_graph[edges];
        for (int i = 0; i < edges; i++) {
            System.out.print("Enter edge_of_graph: ");
            int start = input.nextInt(), end = input.nextInt(), wt_edge = input.nextInt();
            edges_list[i] = new ans.edge_of_graph(start, end, wt_edge);
        }
        System.out.println("Enter Start and End");
        int start = input.nextInt(), end = input.nextInt();
        input.close();

        System.out.println("\nShortest Path:");
        shortst_path_finder(vertex, start - 1, end - 1, edges, edges_list);

        System.out.println("\nAll Paths: ");
        boolean[][] graph = new boolean[vertex][vertex];
        boolean[] visited = new boolean[vertex];
        for (edge_of_graph edge : edges_list) {
            graph[edge.start][edge.end] = true;
        }
        ArrayList<Integer> v = new ArrayList<Integer>();
        allPaths(vertex, start - 1, end - 1, graph, v, 0, visited);
    }
}