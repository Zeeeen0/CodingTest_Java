import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    List<Long> trees = Arrays.stream(br.readLine().split(" "))
        .map(Long::parseLong)
        .collect(Collectors.toList());

    long low = 0;
    long high = Collections.max(trees);
    long answer = 0;

    while (low <= high) {
      long mid = low + (high - low) / 2;

      long total = 0;
      for (long tree : trees) {
        if (tree > mid) {
          total += tree - mid;
        }
        if (total >= M) {
          break; // Early exit for optimization
        }
      }

      if (total >= M) {
        answer = mid;
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    result.append(answer);
  }
}