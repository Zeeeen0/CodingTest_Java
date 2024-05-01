import java.util.*;

class Solution {
    public String solution(String rsp) {
        // key를 value가 이기는 map
        Map<Character, String> map = new HashMap<>();
        map.put('2', "0");
        map.put('0', "5");
        map.put('5', "2");
        
        StringBuilder sb = new StringBuilder();
        for (char c : rsp.toCharArray()) {
            sb.append(map.get(c));
        }
        return sb.toString();
    }
}