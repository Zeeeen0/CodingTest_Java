import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        scanner.close();
        
        // 목표 길이가 64인 경우 바로 1 반환
        if (X == 64) {
            System.out.println(1);
            return;
        }
        
        // 초기 막대 길이
        int stick = 64;
        // 현재 가지고 있는 막대 조각들
        ArrayList<Integer> sticks = new ArrayList<>();
        // 현재 막대 합
        int sum = 0;
        
        // 이진수로 표현했을 때 1의 개수를 세는 방식으로 접근
        // X를 이진수로 표현했을 때 각 비트가 1인 위치에 해당하는 길이의 막대가 필요함
        while (stick > 0) {
            // 현재 막대 길이가 X보다 작거나 같고, X의 이진수 표현에서 해당 비트가 1이면
            if (stick <= X && (X & stick) == stick) {
                sticks.add(stick);
                sum += stick;
            }
            stick /= 2;
        }
        
        // 결과: 필요한 막대의 개수 출력
        System.out.println(sticks.size());
    }
}