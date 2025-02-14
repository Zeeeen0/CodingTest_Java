import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력: 계단 개수
        int n = scanner.nextInt();
        int[] scores = new int[n];

        // 입력: 각 계단의 점수
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        // 결과 출력
        System.out.println(maxStairScore(n, scores));

        scanner.close();
    }

    public static int maxStairScore(int n, int[] scores) {
        if (n == 1) {
            return scores[0];
        } else if (n == 2) {
            return scores[0] + scores[1];
        }

        // DP 배열 초기화
        int[] dp = new int[n];
        dp[0] = scores[0];
        dp[1] = scores[0] + scores[1];
        dp[2] = Math.max(scores[0] + scores[2], scores[1] + scores[2]);

        // 점화식을 이용해 DP 배열 채우기
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + scores[i], dp[i - 3] + scores[i - 1] + scores[i]);
        }

        // 마지막 계단까지의 최대 점수 반환
        return dp[n - 1];
    }
}
