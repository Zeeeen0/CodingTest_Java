import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄 입력 처리
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);  // 동전 종류의 수
        int K = Integer.parseInt(firstLine[1]);  // 목표 금액

        // 두 번째 줄부터 N개의 동전 가치 입력 처리
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        
        // 최소 동전 개수 구하기
        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (K == 0) break;  // K가 0이면 더 이상 계산할 필요 없음
            if (coins[i] <= K) {
                count += K / coins[i];  // coins[i]로 만들 수 있는 동전 개수
                K = K % coins[i];  // 남은 금액 계산
            }
        }
        
        System.out.println(count);  // 최솟값 출력
    }
}
