import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder result = new StringBuilder();

  private static final char EMPTY_SPACE = 'O';
  private static final char WALL = 'X';
  private static final char DOYEON = 'I';
  private static final char PERSON = 'P';

  public static void main(String[] args) throws IOException {
    solve();
    System.out.print(result);
  }

  private static void solve() throws IOException {
    String[] dimensions = br.readLine().split(" ");
    int n = Integer.parseInt(dimensions[0]);
    int m = Integer.parseInt(dimensions[1]);

    char[][] campus = new char[n][m];
    boolean[][] visited = new boolean[n][m];

    int startX = 0, startY = 0;
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        campus[i][j] = line.charAt(j);
        if (campus[i][j] == DOYEON) {
          startX = i;
          startY = j;
        }
      }
    }

    int peopleCount = bfs(campus, visited, startX, startY, n, m);
    result.append(peopleCount > 0 ? peopleCount : "TT");
  }

  private static int bfs(char[][] campus, boolean[][] visited, int startX, int startY, int n,
      int m) {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{startX, startY});
    visited[startX][startY] = true;

    int peopleCount = 0;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int x = current[0];
      int y = current[1];

      if (campus[x][y] == PERSON) {
        peopleCount++;
      }

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && campus[nx][ny] != WALL) {
          visited[nx][ny] = true;
          queue.add(new int[]{nx, ny});
        }
      }
    }

    return peopleCount;
  }
}