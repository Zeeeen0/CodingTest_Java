import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    int M = Integer.parseInt(input[0]);
    int N = Integer.parseInt(input[1]);

    boolean[] isPrime = new boolean[N + 1];

    // 초기화: 모든 수를 소수로 가정
    for (int i = 2; i <= N; i++) {
      isPrime[i] = true;
    }

    // 에라토스테네스의 체 실행
    for (int i = 2; i * i <= N; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= N; j += i) {
          isPrime[j] = false;
        }
      }
    }

    // M 이상 N 이하의 소수를 출력
    StringBuilder sb = new StringBuilder();
    for (int i = M; i <= N; i++) {
      if (isPrime[i]) {
        sb.append(i).append("\n");
      }
    }

    System.out.print(sb.toString());
    
    br.close();
  }
}