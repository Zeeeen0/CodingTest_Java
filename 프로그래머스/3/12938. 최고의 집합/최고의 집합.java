class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};
        
        int[] answer = new int[n];
        
        // 최대의 몫을 구하고
        for (int i = 0; i < answer.length; i++) {
            answer[i] = s / n;
        }
        // 나머지는 추가로 더해주기
        for (int i = 0; i < s % n; i++) {
            answer[n - i - 1]++;
        }
        
        return answer;
    }
}