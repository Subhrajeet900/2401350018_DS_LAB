import java.util.*;
public class MSTAlgorithms {
 static class Edge implements Comparable<Edge> {
 int src, dest, weight;
 Edge(int src, int dest, int weight) {
 this.src = src;
 this.dest = dest;
 this.weight = weight;
 }
 @Override
 public int compareTo(Edge other) {
 return Integer.compare(this.weight, other.weight);
 }
 }
 // Prim's using adjacency matrix
 public static void primMST(int[][] graph) {
 int V = graph.length;
 int[] key = new int[V];
 boolean[] mstSet = new boolean[V];
 int[] parent = new int[V];
 Arrays.fill(key, Integer.MAX_VALUE);
 key[0] = 0;
 parent[0] = -1;
 for (int count = 0; count < V - 1; count++) {
 int u = minKey(key, mstSet);
 mstSet[u] = true;
 for (int v = 0; v < V; v++) {
 if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
 parent[v] = u;
 key[v] = graph[u][v];
 }
 }
 }
 }
 private static int minKey(int[] key, boolean[] mstSet) {
 int min = Integer.MAX_VALUE, minIndex = -1;
 for (int v = 0; v < key.length; v++) {
 if (!mstSet[v] && key[v] < min) {
 min = key[v];
 minIndex = v;
 }
 }
 return minIndex;
 }
 // Kruskal's using edge list
 static class DisjointSet {
 int[] parent, rank;
 DisjointSet(int n) {
 parent = new int[n];
 rank = new int[n];
 for (int i = 0; i < n; i++) parent[i] = i;
 }
 int find(int x) {
 if (parent[x] != x) parent[x] = find(parent[x]);
 return parent[x];
 }
 void union(int x, int y) {
 int rootX = find(x);
 int rootY = find(y);
 if (rootX == rootY) return;
 if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
 else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
 else {
 parent[rootY] = rootX;
 rank[rootX]++;
 }
 }
 }
 public static List<Edge> kruskalMST(int V, List<Edge> edges) {
 Collections.sort(edges);
 DisjointSet ds = new DisjointSet(V);
 List<Edge> result = new ArrayList<>();
 for (Edge edge : edges) {
 int x = ds.find(edge.src);
 int y = ds.find(edge.dest);
 if (x != y) {
 result.add(edge);
 ds.union(x, y);
 }
 }
 return result;
 }
 public static void main(String[] args) {
 int[][] graph = {
 {0, 2, 0, 6, 0},
 {2, 0, 3, 8, 5},
 {0, 3, 0, 0, 7},
 {6, 8, 0, 0, 9},
 {0, 5, 7, 9, 0}
 };
 primMST(graph);
 List<Edge> edges = new ArrayList<>();
 edges.add(new Edge(0, 1, 2));
 edges.add(new Edge(1, 2, 3));
 edges.add(new Edge(0, 3, 6));
 edges.add(new Edge(1, 3, 8));
 edges.add(new Edge(1, 4, 5));
 edges.add(new Edge(2, 4, 7));
 edges.add(new Edge(3, 4, 9));
 List<Edge> mst = kruskalMST(5, edges);
 }
}
