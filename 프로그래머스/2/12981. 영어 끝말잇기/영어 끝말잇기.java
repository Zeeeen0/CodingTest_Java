import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            char last_char = words[i - 1].charAt(words[i - 1].length() - 1);
            if (set.contains(word) || word.charAt(0) != last_char) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            set.add(word);
        }

        return new int[]{0, 0};
    }
}