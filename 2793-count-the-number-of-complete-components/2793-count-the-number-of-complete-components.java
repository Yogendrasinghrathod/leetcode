import java.util.*;

public class Solution {
    // Helper function to perform DFS
    private void dfs(int node, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, graph);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        // Step 1: Build the adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // Step 2: Identify all connected components using DFS
        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // Perform DFS to find all nodes in the component
                List<Integer> componentNodes = new ArrayList<>();
                dfsHelper(i, visited, graph, componentNodes);
                
                // Step 3: Check if the component is a complete graph (clique)
                if (isCompleteGraph(componentNodes, graph)) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }

    private void dfsHelper(int node, boolean[] visited, List<List<Integer>> graph, List<Integer> componentNodes) {
        visited[node] = true;
        componentNodes.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited, graph, componentNodes);
            }
        }
    }

    // Helper function to check if a component is a complete graph (clique)
    private boolean isCompleteGraph(List<Integer> componentNodes, List<List<Integer>> graph) {
        int k = componentNodes.size();
        int edgeCount = 0;

        // Count edges in the component
        for (int node : componentNodes) {
            edgeCount += graph.get(node).size();
        }

        // Each edge is counted twice, so divide by 2
        edgeCount /= 2;

        // A component with k nodes must have exactly k * (k - 1) / 2 edges to be a complete graph
        return edgeCount == (k * (k - 1)) / 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {3, 4}};
        int n = 5;  // Number of nodes
        System.out.println("Number of complete components: " + solution.countCompleteComponents(n, edges));
    }
}
