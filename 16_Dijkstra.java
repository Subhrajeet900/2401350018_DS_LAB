import java.util.*;
public class DijkstraAlgorithm {
 static class Edge {
 int to, weight;
 Edge(int to, int weight) {
 if (weight < 0) {
 throw new IllegalArgumentException("Negative weights not allowed in
Dijkstra's algorithm");
 }
 this.to = to;
 this.weight = weight;
 }
 }
 // Using adjacency matrix
 public static int[] dijkstraMatrix(int[][] graph, int src) {
 int V = graph.length;
 int[] dist = new int[V];
 boolean[] visited = new boolean[V];
 Arrays.fill(dist, Integer.MAX_VALUE);
 dist[src] = 0;
 for (int count = 0; count < V - 1; count++) {
 int u = minDistance(dist, visited);
 visited[u] = true;
 for (int v = 0; v < V; v++) {
 if (!visited[v] && graph[u][v] > 0 && dist[u] != Integer.MAX_VALUE
 && dist[u] + graph[u][v] < dist[v]) {
 if (graph[u][v] < 0) {
 throw new IllegalArgumentException("Negative weights not
allowed");
 }
 dist[v] = dist[u] + graph[u][v];
 }
 }
 }
 return dist;
 }
 private static int minDistance(int[] dist, boolean[] visited) {
 int min = Integer.MAX_VALUE, minIndex = -1;
 for (int v = 0; v < dist.length; v++) {
 if (!visited[v] && dist[v] <= min) {
 min = dist[v];
 minIndex = v;
 }
 }
 return minIndex;
 }
 // Using adjacency list + priority queue
 public static int[] dijkstraList(List<List<Edge>> adj, int src) {
 int V = adj.size();
 int[] dist = new int[V];
 Arrays.fill(dist, Integer.MAX_VALUE);
 dist[src] = 0;
 PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
 pq.offer(new int[]{src, 0});
 while (!pq.isEmpty()) {
 int[] curr = pq.poll();
 int u = curr[0];
 int d = curr[1];
 if (d > dist[u]) continue;
 for (Edge edge : adj.get(u)) {
 int v = edge.to;
 int w = edge.weight;
 if (w < 0) {
 throw new IllegalArgumentException("Negative weights not allowed");
 }
 if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
 dist[v] = dist[u] + w;
 pq.offer(new int[]{v, dist[v]});
 }
 }
 }
 return dist;
 }
 public static void main(String[] args) {
 int[][] graph = {
 {0, 4, 0, 0, 0, 0, 0, 8, 0},
 {4, 0, 8, 0, 0, 0, 0, 11, 0},
 {0, 8, 0, 7, 0, 4, 0, 0, 2},
 {0, 0, 7, 0, 9, 14, 0, 0, 0},
 {0, 0, 0, 9, 0, 10, 0, 0, 0},
 {0, 0, 4, 14, 10, 0, 2, 0, 0},
 {0, 0, 0, 0, 0, 2, 0, 1, 6},
 {8, 11, 0, 0, 0, 0, 1, 0, 7},
 {0, 0, 2, 0, 0, 0, 6, 7, 0}
 };
 int[] distMatrix = dijkstraMatrix(graph, 0);
 int V = 9;
 List<List<Edge>> adj = new ArrayList<>();
 for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
 adj.get(0).add(new Edge(1, 4));
 adj.get(0).add(new Edge(7, 8));
 // ... add remaining edges similarly
 int[] distList = dijkstraList(adj, 0);
 }
}
