import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    solve();
    System.out.print(sb);
  }
  
  private static void solve() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
  
    int[] lengths = new int[K];
    long maxLen = 0;
  
    for (int i = 0; i < K; i++) {
      lengths[i] = Integer.parseInt(br.readLine());
      maxLen = Math.max(maxLen, lengths[i]);
    }
  
    long left = 1, right = maxLen, result = 0;
  
    while (left <= right) {
      long mid = (left + right) / 2;
      long count = 0;
  
      for (int length : lengths) {
        count += length / mid;
      }
  
      if (count >= N) {
        result = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
  
    sb.append(result);
  }
}