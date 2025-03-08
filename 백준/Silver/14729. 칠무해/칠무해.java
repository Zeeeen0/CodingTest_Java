import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder result = new StringBuilder();

  public static void main(String[] args) throws IOException {
    solve();
    System.out.print(result);
  }

  private static void solve() throws IOException {
    int N = Integer.parseInt(br.readLine());
    if (N < 8) {
      throw new IllegalArgumentException();
    }
    List<Float> score = new ArrayList<>(7);
    for (int i = 0; i < N; i++) {
      float currentScore = Float.parseFloat(br.readLine());
      if (score.size() < 7) {
        score.add(currentScore);
        Collections.sort(score);
      } else if (currentScore < score.get(6)) {
        score.set(6, currentScore);
        Collections.sort(score);
      }
    }
    score.forEach(num -> result.append(String.format("%.3f", num)).append("\n"));
  }
}