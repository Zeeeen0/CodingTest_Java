import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        // 1. 튜플 map 만들기
        Map<Integer, List<Integer>> map = new HashMap<>();

        s = s.substring(1, s.length() - 1);
        while (s.contains("{")) {
            int startIdx = s.indexOf("{") + 1;
            int endIdx = s.indexOf("}");
            String t = s.substring(startIdx, endIdx);
            s = s.substring(endIdx + 1);
            List<Integer> list = new ArrayList<>();

            while (t.contains(",")) {
                list.add(Integer.parseInt(t.substring(0, t.indexOf(","))));
                t = t.substring(t.indexOf(",") + 1);
            }
            list.add(Integer.parseInt(t));

            map.put(list.size(), list);
        }
        
        // 원소 개수로 정렬
        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        // 원소를 새로운 리스트로 입력
        List<Integer> answerList = new ArrayList<>();

        for (Integer key : keySet) {
            List<Integer> val = map.get(key);
            for (Integer v : val) {
                if (!answerList.contains(v)) {
                    answerList.add(v);
                }
            }
        }

        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}