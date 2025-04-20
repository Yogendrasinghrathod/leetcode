import java.util.*;

public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Build the graph (adjacency list)
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        // Step 2: Use Dijkstra's algorithm to find the shortest time to each node
        int[] dist = new int[n + 1]; // distance array to track the shortest time to each node
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; // The starting node has a delay of 0

        // Min-heap to process nodes with the smallest delay first
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0}); // Start from node k with time 0

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int time = current[1];

            // Process each neighbor of the current node
            for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                int nextNode = neighbor[0];
                int travelTime = neighbor[1];

                // Relax the edge: if we found a shorter time to reach nextNode, update it
                if (dist[node] + travelTime < dist[nextNode]) {
                    dist[nextNode] = dist[node] + travelTime;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        // Step 3: Find the maximum time to reach all nodes
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // If any node is unreachable, return -1
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime; // Return the maximum time to reach the farthest node
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        System.out.println("Network delay time: " + solution.networkDelayTime(times, n, k));
    }
}
