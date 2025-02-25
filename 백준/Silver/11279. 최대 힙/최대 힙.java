import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder result = new StringBuilder();

  public static void main(String[] args) throws IOException {
    solve();
    System.out.print(result);
  }

  private static void solve() throws IOException {
    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      int x = Integer.parseInt(br.readLine());
      if (x == 0) {
        int poll = queue.isEmpty() ? 0 : queue.poll();
        result.append(poll).append("\n");
      } else {
        queue.offer(x);
      }
    }
  }
}