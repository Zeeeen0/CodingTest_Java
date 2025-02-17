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
    int n = Integer.parseInt(br.readLine());

    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
    }
    
    result.append(dp[n]).append("\n");
  }
}