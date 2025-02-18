import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder result = new StringBuilder();

  public static void main(String[] args) throws IOException {
    solve();
    System.out.print(result);
  }

  private static void solve() throws IOException {
    int n = Integer.parseInt(br.readLine()); // Number of computers
    int m = Integer.parseInt(br.readLine()); // Number of connections

    // Adjacency list to represent the graph
    boolean[][] network = new boolean[n + 1][n + 1];
    for (int i = 0; i < m; i++) {
      String[] tokens = br.readLine().split(" ");
      int u = Integer.parseInt(tokens[0]);
      int v = Integer.parseInt(tokens[1]);
      network[u][v] = true;
      network[v][u] = true;
    }

    // Visited array to track visited computers
    boolean[] visited = new boolean[n + 1];

    // Start DFS from computer 1
    int count = dfs(1, network, visited) - 1;
    result.append(count).append("\n");
  }

  private static int dfs(int node, boolean[][] network, boolean[] visited) {
    visited[node] = true;
    int count = 1;

    for (int neighbor = 1; neighbor < network.length; neighbor++) {
      if (network[node][neighbor] && !visited[neighbor]) {
        count += dfs(neighbor, network, visited);
      }
    }

    return count;
  }
}