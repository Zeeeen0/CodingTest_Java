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
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);

    int[] dp = new int[N + 1];
    String[] numbers = br.readLine().split(" ");
    for (int i = 1; i <= N; i++) {
      dp[i] = Integer.parseInt(numbers[i - 1]) + dp[i - 1];
    }

    for (int i = 0; i < M; i++) {
      String[] ij = br.readLine().split(" ");
      int a = Integer.parseInt(ij[0]);
      int b = Integer.parseInt(ij[1]);

      result.append(dp[b] - dp[a - 1]).append("\n");
    }
  }
}