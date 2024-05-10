import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            queue.offer(work);
        }

        for (int i = 0; i < n; i++) {
            int work = queue.poll();
            if (work == 0) break;
            queue.offer(work - 1);
        }

        long answer = 0;
        for (int q : queue) {
            answer += Math.pow(q, 2);
        }
        return answer;
    }
}