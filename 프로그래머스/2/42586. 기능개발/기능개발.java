import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int time = 0;
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] + (time * speeds[i]) < 100) {
                time++;
            }
            map.put(time, map.getOrDefault(time, 0) + 1);
        }

        return map.values().stream().mapToInt(i -> i).toArray();
    }
}