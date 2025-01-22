import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int i = Integer.parseInt(sc.nextLine());
        System.out.println(S.substring(i - 1, i));
        sc.close();
    }
}