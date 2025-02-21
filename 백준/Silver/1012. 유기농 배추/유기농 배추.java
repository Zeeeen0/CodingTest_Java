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
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      String[] input = br.readLine().split(" ");
      int M = Integer.parseInt(input[0]);
      int N = Integer.parseInt(input[1]);
      int K = Integer.parseInt(input[2]);

      boolean[][] field = new boolean[N][M];
      boolean[][] visited = new boolean[N][M];
      for (int j = 0; j < K; j++) {
        String[] position = br.readLine().split(" ");
        int X = Integer.parseInt(position[0]);
        int Y = Integer.parseInt(position[1]);
        field[Y][X] = true;
      }

      int wormsNeeded = 0;

      for (int y = 0; y < N; y++) {
        for (int x = 0; x < M; x++) {
          if (field[y][x] && !visited[y][x]) {
            dfs(field, visited, y, x, N, M);
            wormsNeeded++;
          }
        }
      }

      result.append(wormsNeeded).append("\n");
    }
  }

  private static void dfs(boolean[][] field, boolean[][] visited, int y, int x, int N, int M) {
    if (y < 0 || x < 0 || y >= N || x >= M || !field[y][x] || visited[y][x]) {
      return;
    }

    visited[y][x] = true;

    dfs(field, visited, y - 1, x, N, M);
    dfs(field, visited, y + 1, x, N, M);
    dfs(field, visited, y, x - 1, N, M);
    dfs(field, visited, y, x + 1, N, M);
  }
}