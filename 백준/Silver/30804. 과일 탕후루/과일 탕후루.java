import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder result = new StringBuilder();

  public static void main(String[] args) throws IOException {
    solve();
    System.out.print(result);
  }

  private static void solve() throws IOException {
    Map<Integer, Integer> fruits = new HashMap<>();
    int N = Integer.parseInt(br.readLine());
    int[] all_fruits = new int[N];
    String[] input = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      all_fruits[i] = Integer.parseInt(input[i]);
    }

    int left = 0;
    int max = 0;

    for (int right = 0; right < N; right++) {
      fruits.put(all_fruits[right], fruits.getOrDefault(all_fruits[right], 0) + 1);

      while (fruits.size() > 2) {
        fruits.put(all_fruits[left], fruits.get(all_fruits[left]) - 1);
        if (fruits.get(all_fruits[left]) == 0) {
          fruits.remove(all_fruits[left]);
        }
        left++;
      }

      max = Math.max(max, right - left + 1);
    }

    result.append(max);
  }
}