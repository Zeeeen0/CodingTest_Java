import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (true) {
      String input = sc.nextLine();
      if ("0".equals(input)) {
        break;
      }

      int number = Integer.parseInt(input);

      if (isPalindrome(number)) {
        System.out.println("yes");
        continue;
      }

      System.out.println("no");
    }

    sc.close();
  }

  private static boolean isPalindrome(int number) {
    char[] digits = String.valueOf(number).toCharArray();
    int left = 0, right = digits.length - 1;

    while (left < right) {
      if (digits[left] != digits[right]) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}