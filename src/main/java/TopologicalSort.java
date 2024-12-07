import java.util.List;
import java.util.Stack;

/**
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u-v,
 * vertex u comes before v in the ordering.
 * <p>
 * Note: Topological Sorting for a graph is not possible if the graph is not a DAG.
 * https://www.geeksforgeeks.org/topological-sorting/
 */
public class TopologicalSort {

    /**
     * Algorithm for Topological Sorting using DFS:
     * <p>
     * Here’s a step-by-step algorithm for topological sorting using Depth First Search (DFS):
     * <p>
     * Create a graph with n vertices and m-directed edges.
     * Initialize a stack and a visited array of size n.
     * For each unvisited vertex in the graph, do the following:
     * Call the DFS function with the vertex as the parameter.
     * In the DFS function, mark the vertex as visited and recursively call the DFS function for all unvisited neighbors of the vertex.
     * Once all the neighbors have been visited, push the vertex onto the stack.
     * After all, vertices have been visited, pop elements from the stack and append them to the output list until the stack is empty.
     * The resulting list is the topologically sorted order of the graph.
     */

    // Function to perform DFS and topological sorting
    static void
    topologicalSortUtil(int v, List<List<Integer>> adj,
                        boolean[] visited,
                        Stack<Integer> stack) {
        // Mark the current node as visited
        visited[v] = true;

        // Recur for all adjacent vertices
        for (int i : adj.get(v)) {
            if (!visited[i])
                topologicalSortUtil(i, adj, visited, stack);
        }

        // Push current vertex to stack which stores the
        // result
        stack.push(v);
    }

    // Function to perform Topological Sort
    static void topologicalSort(List<List<Integer>> adj,
                                int V) {
        // Stack to store the result
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        // Call the recursive helper function to store
        // Topological Sort starting from all vertices one
        // by one
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                topologicalSortUtil(i, adj, visited, stack);
        }

        // Print contents of stack
        System.out.print(
                "Topological sorting of the graph: ");
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

}
