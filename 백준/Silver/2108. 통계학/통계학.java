import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder result = new StringBuilder();

  public static void main(String[] args) throws IOException {
    solve();
    System.out.print(result);
  }

  private static void solve() throws IOException {
    int N = Integer.parseInt(br.readLine());
    int[] numbers = new int[N];
    for (int i = 0; i < N; i++) {
      numbers[i] = Integer.parseInt(br.readLine());
    }
    result.append(arithmetic_mean(numbers)).append("\n");
    result.append(median(numbers)).append("\n");
    result.append(mode(numbers)).append("\n");
    result.append(range(numbers)).append("\n");
  }

  private static int arithmetic_mean(int[] numbers) {
    int sum = Arrays.stream(numbers).sum();
    float mean = (float) sum / numbers.length;
    return Math.round(mean);
  }

  private static int median(int[] numbers) {
    Arrays.sort(numbers);
    return numbers[numbers.length / 2];
  }

  private static int mode(int[] numbers) {
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int num : numbers) {
      countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }
    int maxCount = Collections.max(countMap.values());
    List<Integer> modes = countMap.entrySet().stream()
        .filter(entry -> entry.getValue() == maxCount)
        .map(Map.Entry::getKey)
        .sorted()
        .collect(Collectors.toList());
    return modes.size() > 1 ? modes.get(1) : modes.get(0);
  }

  private static int range(int[] numbers) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int number : numbers) {
      if (number < min) {
        min = number;
      }
      if (number > max) {
        max = number;
      }
    }
    return max - min;
  }
}