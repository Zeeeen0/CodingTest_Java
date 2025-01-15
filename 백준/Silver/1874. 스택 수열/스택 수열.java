import java.io.*;
import java.util.*;

public class Main {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    solve();
    System.out.print(sb);
  }

  private static void solve() throws IOException {
    int n = Integer.parseInt(br.readLine());
    int[] sequence = getInputSequence(n);
    processSequence(sequence);
  }

  private static int[] getInputSequence(int n) throws IOException {
    int[] sequence = new int[n];
    for (int i = 0; i < n; i++) {
      sequence[i] = Integer.parseInt(br.readLine());
    }
    return sequence;
  }

  private static void processSequence(int[] sequence) {
    Stack<Integer> stack = new Stack<>();
    int current = 1;

    for (int target : sequence) {
      while (current <= target) {
        stack.push(current++);
        sb.append("+").append("\n");
      }

      if (stack.isEmpty() || stack.peek() != target) {
        sb.setLength(0);
        sb.append("NO");
        return;
      }

      stack.pop();
      sb.append("-").append("\n");
    }
  }
}