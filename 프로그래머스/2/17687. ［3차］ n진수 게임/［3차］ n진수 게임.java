class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder game = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        // t * m 만큼 n진수로 변환
        for (int i = 0; game.length() <= t * m; i++) {
            game.append(Integer.toString(i, n));
        }
        
        // 순서에 맞는 글자 추출
        for (int i = p - 1; answer.length() < t; i += m) {
            answer.append(game.charAt(i));
        }

        return answer.toString().toUpperCase();
    }
}