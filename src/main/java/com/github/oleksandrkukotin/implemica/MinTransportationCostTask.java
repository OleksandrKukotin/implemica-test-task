package com.github.oleksandrkukotin.implemica;

import java.util.*;

public class MinTransportationCostTask {

    // Represents a connection (edge) between two cities with a transportation cost.
    static class Edge {
        int to;
        int cost; // Destination city index and the cost to travel there.

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt(); // Number of test cases.

        while (s-- > 0) {
            int n = scanner.nextInt(); // Number of cities.
            Map<String, Integer> cityIndex = new HashMap<>(); // Maps city names to their indices.
            List<List<Edge>> graph = new ArrayList<>(); // Adjacency list representation of the graph.

            // Input cities and their connections.
            for (int i = 0; i < n; i++) {
                String name = scanner.next(); // City name.
                cityIndex.put(name, i); // Assign an index to this city.
                graph.add(new ArrayList<>()); // Create a new adjacency list for this city.

                int p = scanner.nextInt(); // Number of neighbors for this city.
                for (int j = 0; j < p; j++) {
                    int neighbor = scanner.nextInt() - 1; // Neighbor city index (1-based to 0-based).
                    int cost = scanner.nextInt(); // Transportation cost to the neighbor city.
                    graph.get(i).add(new Edge(neighbor, cost)); // Add the edge to the graph.
                }
            }

            int r = scanner.nextInt(); // Number of queries (pairs of cities to find paths for).
            while (r-- > 0) {
                String src = scanner.next(); // Source city.
                String dest = scanner.next(); // Destination city.
                // Find and print the minimum transportation cost between the source and destination.
                System.out.println(dijkstra(graph, cityIndex.get(src), cityIndex.get(dest)));
            }
        }
    }

    // Finds the shortest path cost from 'src' to 'dest' using Dijkstra's algorithm.
    static int dijkstra(List<List<Edge>> graph, int src, int dest) {
        // Priority queue to process nodes based on the current cost (minimum-cost first).
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        int[] dist = new int[graph.size()]; // Distance array to track the shortest distances from src.
        Arrays.fill(dist, Integer.MAX_VALUE); // Initialize all distances to "infinity".
        dist[src] = 0; // Distance to the source is zero.
        pq.add(new Edge(src, 0)); // Start processing from the source.

        while (!pq.isEmpty()) {
            Edge current = pq.poll(); // Get the node with the smallest cost.
            if (current.to == dest) return current.cost; // If we reach the destination, return the cost.

            // Process all neighbors of the current node.
            for (Edge edge : graph.get(current.to)) {
                // If a shorter path to a neighbor is found, update its distance.
                if (dist[current.to] + edge.cost < dist[edge.to]) {
                    dist[edge.to] = dist[current.to] + edge.cost; // Update the shortest distance.
                    pq.add(new Edge(edge.to, dist[edge.to])); // Add the neighbor to the priority queue.
                }
            }
        }

        return -1; // Return -1 if no path to the destination is found.
    }
}
