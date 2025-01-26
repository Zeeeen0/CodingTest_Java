import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    solve();
    System.out.println(sb);
  }

  private static void solve() throws IOException {
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int K = Integer.parseInt(input[1]);
    sb.append(binomialCoefficient(N, K));
  }

  private static int binomialCoefficient(int N, int K) {
    if (K == 0 || K == N) {
      return 1;
    }
    return binomialCoefficient(N - 1, K - 1) + binomialCoefficient(N - 1, K);
  }
}
