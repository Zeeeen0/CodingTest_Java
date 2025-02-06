import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class ExpressionEvaluator {

  private final String expression;

  public ExpressionEvaluator(String expression) {
    this.expression = expression;
  }

  public int calculate() {
    String[] subtractionGroups = expression.split("-");
    int result = sumGroup(subtractionGroups[0]);

    for (int i = 1; i < subtractionGroups.length; i++) {
      result -= sumGroup(subtractionGroups[i]);
    }

    return result;
  }

  private int sumGroup(String group) {
    return Arrays.stream(group.split("\\+"))
        .mapToInt(Integer::parseInt)
        .sum();
  }
}

public class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder result = new StringBuilder();

  public static void main(String[] args) throws IOException {
    solve();
    System.out.print(result);
  }

  private static void solve() throws IOException {
    String input = br.readLine();
    ExpressionEvaluator evaluator = new ExpressionEvaluator(input);
    result.append(evaluator.calculate()).append("\n");
  }
}