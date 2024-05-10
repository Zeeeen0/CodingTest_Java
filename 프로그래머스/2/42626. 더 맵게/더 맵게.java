import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int s : scoville) {
            queue.offer(s);
        }

        while (queue.size() >= 2) {
            if (queue.peek() >= K) break;
            answer++;
            int first = queue.poll();
            int second = queue.poll();
            queue.offer(first + (second * 2));
        }

        if (queue.peek() < K) return -1;
        return answer;
    }
}