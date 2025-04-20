import java.util.PriorityQueue;

public class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // A min-heap to store the edges (cost, point index)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[] visited = new boolean[n];
        int totalCost = 0;
        int edgesUsed = 0;

        // Start from the first point (index 0)
        minHeap.offer(new int[]{0, 0}); // cost 0 to start from point 0

        while (edgesUsed < n) {
            int[] edge = minHeap.poll();
            int cost = edge[0];
            int u = edge[1];

            // Skip the point if it has already been visited
            if (visited[u]) continue;

            // Mark the point as visited and add the cost to the total
            visited[u] = true;
            totalCost += cost;
            edgesUsed++;

            // Add the edges of the current point to the heap
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    // Calculate the Manhattan distance between points u and v
                    int dist = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                    minHeap.offer(new int[]{dist, v});
                }
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println("Minimum cost to connect all points: " + solution.minCostConnectPoints(points));
    }
}
