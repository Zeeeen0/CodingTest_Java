import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for (int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            for (int w = 0; w < want.length; w++) {
                map.put(want[w], number[w]);
            }
            for (int j = i; j < i + 10; j++) {
                map.put(discount[j], map.getOrDefault(discount[j], 0) - 1);
            }
            boolean isSuccess = true;
            for (String s : want) {
                if (map.get(s) > 0) {
                    isSuccess = false;
                }
            }
            if (isSuccess) {
                answer++;
            }
        }
        return answer;
    }
}