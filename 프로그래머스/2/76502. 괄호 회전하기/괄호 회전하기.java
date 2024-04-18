import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i) + s.substring(0, i);

            Stack<Character> stack = new Stack<>();
            for (char c : temp.toCharArray()) {
                if (stack.isEmpty()
                    || '[' == c
                    || '{' == c
                    || '(' == c) {
                    stack.push(c);
                } else if ((']' == c && stack.peek().equals('['))
                    || ('}' == c && stack.peek().equals('{'))
                    || (')' == c && stack.peek().equals('('))) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
        }


        return answer;
    }
}