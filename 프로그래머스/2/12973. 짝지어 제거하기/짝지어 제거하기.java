import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) stack.push(c); // 없으면 push
            else {
                if (stack.peek() == c) stack.pop(); // top과 c가 같으면 pop
                else stack.push(c); // top과 c가 다르면 push
            }
        }
        return stack.isEmpty() ? 1 : 0; // 최종적으로 stack에 없으면 1
    }
}