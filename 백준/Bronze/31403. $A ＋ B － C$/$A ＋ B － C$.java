import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력 받기
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        // 수로 계산
        System.out.println(a + b - c);
        
        // 문자열로 계산
        String result = String.valueOf(a) + String.valueOf(b);
        System.out.println(Integer.parseInt(result) - c);
        
        sc.close();
    }
}