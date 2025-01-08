import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input1 = br.readLine();
    String input2 = br.readLine();
    String input3 = br.readLine();

    int num = getNumber(input1, input2, input3);
    String fizzBuzz = getFizzBuzz(num);
    System.out.println(fizzBuzz);

    br.close();
  }

  private static int getNumber(String input1, String input2, String input3) {
    try {
      int i = Integer.parseInt(input1);
      return i + 3;
    } catch (NumberFormatException ignored) {}
    try {
      int i = Integer.parseInt(input2);
      return i + 2;
    } catch (NumberFormatException ignored) {}
    try {
      int i = Integer.parseInt(input3);
      return i + 1;
    } catch (NumberFormatException ignored) {}
    return -1;
  }

  private static String getFizzBuzz(int num) {
    if (num % 3 == 0 && num % 5 == 0) {
      return "FizzBuzz";
    }
    if (num % 3 == 0) {
      return "Fizz";
    }
    if (num % 5 == 0) {
      return "Buzz";
    }
    return String.valueOf(num);
  }
}