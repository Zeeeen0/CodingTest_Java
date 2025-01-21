import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    solve();
    System.out.print(sb);
  }

  private static void solve() throws IOException {
    int N = Integer.parseInt(br.readLine());
    int[] inputN = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    int M = Integer.parseInt(br.readLine());
    int[] inputM = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < N; i++) {
      map.put(inputN[i], map.getOrDefault(inputN[i], 0) + 1);
    }

    for (int i = 0; i < M; i++) {
      sb.append(map.getOrDefault(inputM[i], 0)).append(" ");
    }
  }
}