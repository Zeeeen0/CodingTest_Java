import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        Queue<String> queue = new LinkedList<>();

        for (String c : cities) {
            c = c.toLowerCase();
            if (queue.contains(c)) {
                queue.remove(c);
                queue.add(c);
                answer += 1;
            } else {
                if (queue.size() >= cacheSize) {
                    queue.remove();
                }
                queue.add(c);
                answer += 5;
            }
        }

        return answer;
    }
}