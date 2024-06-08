class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        // A~Z 만들기 위한 최소 숫자 배열
        int[] counts = new int[26];
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                int c = keymap[i].charAt(j) - 'A';
                if (counts[c] == 0) {
                    counts[c] = j + 1;
                } else {
                    counts[c] = Math.min(j + 1, counts[c]);
                }
            }
        }

        // target 정리
        for (int i = 0; i < targets.length; i++) {
            int cnt = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                int c = targets[i].charAt(j) - 'A';
                if (counts[c] == 0) {
                    cnt = -1;
                    break;
                }
                cnt += counts[c];
            }
            answer[i] = cnt;
        }


        return answer;
    }
}