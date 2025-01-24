import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    solve();
    System.out.print(sb);
  }

  private static void solve() throws IOException {
    int N = Integer.parseInt(br.readLine());
    int num = 666;
    int count = 1;

    while (count != N) {
      num++;

      if (String.valueOf(num).contains("666")) {
        count++;
      }
    }
    sb.append(num);
  }
}