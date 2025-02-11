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
    int[][] count = new int[41][2];

    count[0][0] = 1;
    count[0][1] = 0;
    count[1][0] = 0;
    count[1][1] = 1;

    for (int i = 2; i <= 40; i++) {
      count[i][0] = count[i - 1][0] + count[i - 2][0];
      count[i][1] = count[i - 1][1] + count[i - 2][1];
    }

    for (int t = 0; t < T; t++) {
      int N = Integer.parseInt(br.readLine());
      result.append(count[N][0])
          .append(" ")
          .append(count[N][1])
          .append("\n");
    }
  }
}