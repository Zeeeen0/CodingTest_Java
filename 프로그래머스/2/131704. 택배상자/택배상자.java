import java.util.*;

class Solution {
    public int solution(int[] order) {
        
        Stack<Integer> stack = new Stack<>();

        int idx = 0;
        for (int i = 1; i <= order.length; i++) { // 1 ~ order.length 번째
            if (order[idx] != i) {
                stack.push(i);
            } else {
                idx++;
            }
            
            while (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
            }
        }

        return idx;
    }
}