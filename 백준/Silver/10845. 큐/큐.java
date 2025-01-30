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
    System.out.println(sb);
  }

  private static void solve() throws IOException {
    int n = Integer.parseInt(br.readLine());
    Deque<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
      String command = br.readLine();

      if (command.startsWith("push")) {
        int value = Integer.parseInt(command.split(" ")[1]);
        queue.add(value);
      } else if (command.equals("pop")) {
        sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
      } else if (command.equals("size")) {
        sb.append(queue.size()).append("\n");
      } else if (command.equals("empty")) {
        sb.append(queue.isEmpty() ? 1 : 0).append("\n");
      } else if (command.equals("front")) {
        sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
      } else if (command.equals("back")) {
        sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
      }
    }
  }
}