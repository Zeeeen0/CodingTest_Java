import java.util.Scanner;

public class Main {

    static int whiteCount = 0;  // 하얀색 색종이의 개수
    static int blueCount = 0;   // 파란색 색종이의 개수

    // 재귀적으로 색종이의 개수를 세는 함수
    public static void divideAndCount(int[][] paper, int x, int y, int size) {
        int color = paper[x][y]; // 시작 점의 색 (0: 하얀색, 1: 파란색)

        // 해당 구간이 모두 같은 색인지 확인
        boolean isSameColor = true;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) {
                    isSameColor = false;
                    break;
                }
            }
            if (!isSameColor) {
                break;
            }
        }

        // 색이 동일한 경우
        if (isSameColor) {
            if (color == 0) {
                whiteCount++;
            } else {
                blueCount++;
            }
        } else {
            // 색이 다른 경우, 4개의 부분으로 나누어 재귀 호출
            int newSize = size / 2;
            divideAndCount(paper, x, y, newSize); // 왼쪽 위
            divideAndCount(paper, x, y + newSize, newSize); // 오른쪽 위
            divideAndCount(paper, x + newSize, y, newSize); // 왼쪽 아래
            divideAndCount(paper, x + newSize, y + newSize, newSize); // 오른쪽 아래
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력 받기
        int N = sc.nextInt();
        int[][] paper = new int[N][N];
        
        // 종이의 색 입력 받기 (0은 하얀색, 1은 파란색)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = sc.nextInt();
            }
        }
        
        // 종이를 재귀적으로 나누어 색종이의 개수 구하기
        divideAndCount(paper, 0, 0, N);
        
        // 결과 출력
        System.out.println(whiteCount);
        System.out.println(blueCount);
    }
}
