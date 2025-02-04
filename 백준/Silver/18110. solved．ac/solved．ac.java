import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  private static final float TRIMMED_MEAN = 0.30f;

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder result = new StringBuilder();

  public static void main(String[] args) throws IOException {
    solve();
    System.out.print(result);
  }

  private static void solve() throws IOException {
    // 1. 입력
    int n = Integer.parseInt(br.readLine());
    List<Integer> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      arr.add(Integer.parseInt(br.readLine()));
    }

    // 2. 정렬
    Collections.sort(arr);

    // 3. 절사평균 구하기
    int trimCount = Math.round(n * (TRIMMED_MEAN / 2));
    int sum = arr.subList(trimCount, n - trimCount)
        .stream()
        .mapToInt(Integer::intValue)
        .sum();

    int average = Math.round((float) sum / (n - 2 * trimCount));
    result.append(average);
  }
}