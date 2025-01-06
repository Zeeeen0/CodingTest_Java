import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 수
        
        for(int i = 0; i < T; i++) {
            int k = sc.nextInt(); // 층
            int n = sc.nextInt(); // 호
            
            // k층 n호의 거주민 수 계산
            System.out.println(getResidents(k, n));
        }
        
        sc.close();
    }
    
    public static int getResidents(int k, int n) {
        // 아파트 거주민 수를 저장할 2차원 배열
        int[][] apartment = new int[k + 1][n + 1];
        
        // 0층 초기화
        for(int i = 1; i <= n; i++) {
            apartment[0][i] = i;
        }
        
        // 1층부터 k층까지 계산
        for(int i = 1; i <= k; i++) {
            for(int j = 1; j <= n; j++) {
                // i층 j호의 거주민 수는 i-1층의 1호부터 j호까지의 합
                for(int l = 1; l <= j; l++) {
                    apartment[i][j] += apartment[i-1][l];
                }
            }
        }
        
        return apartment[k][n];
    }
}