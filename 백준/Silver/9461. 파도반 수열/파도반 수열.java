import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();

  private static final int MAX = 100;
  private static final long[] dp = new long[MAX + 1];

  public static void main(String[] args) throws IOException {
    solve();
    System.out.print(sb);
  }

  private static void solve() throws IOException {
    initializeDp();
    processInputAndPrintResults();
  }

  private static void initializeDp() {
    dp[1] = dp[2] = dp[3] = 1;
    dp[4] = dp[5] = 2;

    for (int i = 6; i <= MAX; i++) {
      dp[i] = dp[i - 1] + dp[i - 5];
    }
  }

  private static void processInputAndPrintResults() throws IOException {
    int testCases = Integer.parseInt(br.readLine());

    for (int i = 0; i < testCases; i++) {
      int n = Integer.parseInt(br.readLine());
      sb.append(dp[n]).append("\n");
    }
  }
}