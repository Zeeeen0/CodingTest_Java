import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(List.of(words));

        if (!set.contains(target)) { // 변환할 수 없는 경우
            return 0;
        }

        // begin 추가
        queue.offer(begin);
        set.remove(begin);

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                String current = queue.poll();

                if (Objects.equals(current, target)) { // 타겟이랑 맞으면
                    return answer;
                }

                // set을 그대로 사용하면, set.remove 시 ConcurrentModificationException 오류 발생하게 됨. Array로 변환
                for (String word : set.toArray(new String[0])) {
                    if (canConvert(current, word)) { // 1자리만 다른 경우
                        // word 변환
                        queue.offer(word);
                        set.remove(word);
                    }
                }
            }
            answer++;
        }


        return 0; // 변환할 수 없는 경우
    }

    private boolean canConvert(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}