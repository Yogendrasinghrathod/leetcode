import java.util.*;

public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }
        List<String> result = new ArrayList<>();
        dfs("JFK", graph, result);
        return result;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> result) {
        PriorityQueue<String> destinations = graph.getOrDefault(airport, new PriorityQueue<>());
        while (!destinations.isEmpty()) {
            dfs(destinations.poll(), graph, result);
        }
        result.add(0, airport);
    }
}
