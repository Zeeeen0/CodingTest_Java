import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                answer[i] = -1;
                map.put(s.charAt(i), i);
            } else {
                answer[i] = i - map.get(s.charAt(i));
                map.put(s.charAt(i), i);
            }
        }
        return answer;
    }
}