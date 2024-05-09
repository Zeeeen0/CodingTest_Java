class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    private void dfs(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) { // 더 탐색할 게 없으면
            if (sum == target) { // 타겟 넘버와 현재 합계가 같으면
                answer++;
            } 
        } else {
            dfs(numbers, target, depth + 1, sum + numbers[depth]); // 더하기
            dfs(numbers, target, depth + 1, sum - numbers[depth]); // 빼기
        }
    }
}