import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    solve();
    System.out.print(sb);
  }

  private static void solve() throws IOException {
    int N = Integer.parseInt(br.readLine());
    Deque<Integer> deque = new ArrayDeque<>();

    for (int i = 1; i <= N; i++) {
      deque.add(i);
    }

    while (deque.size() > 1) {
      deque.pollFirst();
      deque.addLast(deque.pollFirst());
    }

    sb.append(deque.poll());
  }
}