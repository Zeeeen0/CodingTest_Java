import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }
        
        int answer = 1;
        for (Integer cnt : map.values()) {
            answer *= cnt + 1; // 벗는 경우의 수 + 1
        }
        return answer - 1; // 전부 벗는 경우의 수 - 1
    }
}