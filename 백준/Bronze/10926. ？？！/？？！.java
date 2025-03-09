import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 사용자로부터 아이디 입력 받기
        String id = scanner.nextLine();
        
        // 입력받은 아이디 뒤에 ??! 붙여서 출력
        System.out.println(id + "??!");
        
        scanner.close();
    }
}