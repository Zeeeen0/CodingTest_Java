import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        List<String> list = List.of(name);

        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (String s : photo[i]) {
                if (list.contains(s)) {
                    score += yearning[list.indexOf(s)];
                }
            }
            answer[i] = score;
        }

        return answer;
    }
}