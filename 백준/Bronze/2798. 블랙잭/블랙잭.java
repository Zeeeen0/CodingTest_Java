import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 카드의 개수 N과 목표 숫자 M을 입력받음
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        
        // N개의 카드 숫자를 배열에 저장
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = scanner.nextInt();
        }
        
        // 결과값 초기화
        int result = 0;
        
        // 세 장의 카드를 선택하는 모든 경우의 수를 확인
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    
                    // M을 넘지 않으면서 M과 가장 가까운 합을 찾음
                    if (sum <= M && sum > result) {
                        result = sum;
                    }
                }
            }
        }
        
        // 결과 출력
        System.out.println(result);
        
        scanner.close();
    }
}