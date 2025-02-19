import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder result = new StringBuilder();

  public static void main(String[] args) throws IOException {
    solve();
    System.out.print(result);
  }

  private static void solve() throws IOException {
    int n = Integer.parseInt(br.readLine());
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= Math.sqrt(i); j++) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
      }
    }
    result.append(dp[n]).append("\n");
  }
}