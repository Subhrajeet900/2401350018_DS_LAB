import java.util.*;
public class GraphTraversal {
 private int V;
 private List<List<Integer>> adj;
 public GraphTraversal(int V) {
 this.V = V;
 adj = new ArrayList<>();
 for (int i = 0; i < V; i++) {
 adj.add(new ArrayList<>());
 }
 }
 public void addEdge(int u, int v) {
 adj.get(u).add(v);
 adj.get(v).add(u); // undirected graph
 }
 public void bfs(int start) {
 boolean[] visited = new boolean[V];
 Queue<Integer> queue = new LinkedList<>();
 visited[start] = true;
 queue.offer(start);
 while (!queue.isEmpty()) {
 int node = queue.poll();
 System.out.print(node + " ");
 for (int neighbor : adj.get(node)) {
 if (!visited[neighbor]) {
 visited[neighbor] = true;
 queue.offer(neighbor);
 }
 }
 }
 System.out.println();
 }
 public void dfs(int start) {
 boolean[] visited = new boolean[V];
 dfsUtil(start, visited);
 System.out.println();
 }
 private void dfsUtil(int node, boolean[] visited) {
 visited[node] = true;
 System.out.print(node + " ");
 for (int neighbor : adj.get(node)) {
 if (!visited[neighbor]) {
 dfsUtil(neighbor, visited);
 }
 }
 }
 public static void main(String[] args) {
 GraphTraversal graph = new GraphTraversal(5);
 graph.addEdge(0, 1);
 graph.addEdge(0, 2);
 graph.addEdge(1, 3);
 graph.addEdge(2, 4);
 graph.bfs(0);
 graph.dfs(0);
 }
}
