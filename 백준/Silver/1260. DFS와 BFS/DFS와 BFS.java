import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder result = new StringBuilder();

  public static void main(String[] args) throws IOException {
    solve();
    System.out.print(result);
  }

  private static void solve() throws IOException {
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);
    int V = Integer.parseInt(input[2]);

    boolean[][] graph = new boolean[N + 1][N + 1];
    boolean[] visited = new boolean[N + 1];

    for (int i = 0; i < M; i++) {
      String[] edge = br.readLine().split(" ");
      int a = Integer.parseInt(edge[0]);
      int b = Integer.parseInt(edge[1]);
      graph[a][b] = true;
      graph[b][a] = true;
    }

    result.append(dfs(N, V, graph, visited)).append("\n");
    result.append(bfs(N, V, graph)).append("\n");
  }

  private static String dfs(int n, int v, boolean[][] graph, boolean[] visited) {
    StringBuilder sb = new StringBuilder();
    visited[v] = true;
    sb.append(v).append(" ");

    for (int i = 1; i <= n; i++) {
      if (graph[v][i] && !visited[i]) {
        sb.append(dfs(n, i, graph, visited));
      }
    }
    return sb.toString();
  }

  private static String bfs(int n, int v, boolean[][] graph) {
    StringBuilder sb = new StringBuilder();
    boolean[] visited = new boolean[n + 1];
    Queue<Integer> queue = new LinkedList<>();

    queue.add(v);
    visited[v] = true;

    while (!queue.isEmpty()) {
      int current = queue.poll();
      sb.append(current).append(" ");

      for (int i = 1; i <= n; i++) {
        if (graph[current][i] && !visited[i]) {
          queue.add(i);
          visited[i] = true;
        }
      }
    }
    return sb.toString();
  }
}