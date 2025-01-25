import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    solve();
    System.out.println(sb);
  }

  private static void solve() throws IOException {

    int N = Integer.parseInt(br.readLine().trim());
    String[] shirtSizes = br.readLine().trim().split(" ");
    int[] sizes = Arrays.stream(shirtSizes).mapToInt(Integer::parseInt).toArray();
    String[] bundleInfo = br.readLine().trim().split(" ");
    int T = Integer.parseInt(bundleInfo[0]);
    int P = Integer.parseInt(bundleInfo[1]);

    int shirtBundles = Arrays.stream(sizes).map(size -> (size + T - 1) / T).sum();
    int penBundles = N / P;
    int penRemainder = N % P;

    sb.append(shirtBundles).append("\n")
        .append(penBundles).append(" ")
        .append(penRemainder).append("\n");
  }
}
