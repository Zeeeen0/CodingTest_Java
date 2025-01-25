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
      int T = Integer.parseInt(br.readLine());
      for (int i = 0; i < T; i++) {
          int[] input = Arrays.stream(br.readLine().split(" "))
              .mapToInt(Integer::parseInt)
              .toArray();
          int H = input[0];
          int W = input[1];
          int N = input[2];
  
          int floor = (N - 1) % H + 1;
          int room = (N - 1) / H + 1;
  
          sb.append(String.format("%d%02d", floor, room)).append("\n");
    }
  }
}
