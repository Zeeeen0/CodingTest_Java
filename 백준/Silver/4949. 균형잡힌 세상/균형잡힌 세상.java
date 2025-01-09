import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      String input = br.readLine();
      if (".".equals(input)) {
        break;
      }

      if (isBalanced(input)) {
        System.out.println("yes");
      } else {
        System.out.println("no");
      }
    }

    br.close();
  }

  private static boolean isBalanced(String input) {
    Stack<Character> stack = new Stack<>();

    for (char c : input.toCharArray()) {
      if (c == '(') {
        stack.push('(');
      }
      if (c == ')') {
        if (stack.isEmpty()) {
          return false;
        }
        if (stack.peek() != '(') {
          return false;
        }
        stack.pop();
      }
      if (c == '[') {
        stack.push('[');
      }
      if (c == ']') {
        if (stack.isEmpty()) {
          return false;
        }
        if (stack.peek() != '[') {
          return false;
        }
        stack.pop();
      }
    }
    return stack.isEmpty();
  }
}