import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 색인번호 사전 map
        Map<String, Integer> map = new HashMap<>();

        char word = 'A';
        for (int i = 1; i <= ('Z' - 'A') + 1; i++) {
            map.put(word + "", i);
            word++;
        }

        // 압축 데이터 list
        List<Integer> list = new ArrayList<Integer>();
        int idx = 0;
        while (idx < msg.length()) {
            // 사전에 포함된 최대한 긴 문자열 구하기
            StringBuilder str = new StringBuilder();
            while (idx < msg.length()) {
                if (!map.containsKey(str.toString() + msg.charAt(idx))) {
                    break;
                }
                str.append(msg.charAt(idx));
                idx++;
            }
            
            // 최대한 문자열의 색인번호 추가
            list.add(map.get(str.toString()));
            
            // 다음 글자를 추가한 문자열을 사전에 추가
            if (idx < msg.length()) {
                map.put(str.toString() + msg.charAt(idx), map.size() + 1);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}