import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    String input = sc.nextLine();

    int[] numbers = Arrays.stream(input.split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();

    int gcd = gcd(numbers[0], numbers[1]);
    System.out.println(gcd);
    int lcm = lcm(numbers[0], numbers[1], gcd);
    System.out.println(lcm);
    
    sc.close();
  }

  private static int lcm(int a, int b, int gcd) {
    return (a * b) / gcd;
  }

  private static int gcd(int a, int b) {
    int r;
    while (b >= 1) {
      r = a % b;
      a = b;
      b = r;
    }
    return a;
  }
}