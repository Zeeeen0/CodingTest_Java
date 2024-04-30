class Solution {
    private int answer;
    private int[][] dungeons;
    private boolean[] visited;
    
    public int solution(int k, int[][] d) {
        dungeons = d;
        visited = new boolean[dungeons.length];
        
        dfs(0, k);
        
        return answer;
    }
    
    public void dfs(int depth, int k) {
        for (int i = 0; i < dungeons.length; i++) {
            // 방문하지 않은 상태면서 k가 최소 필요 피로도보다 크거나 같은 경우
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(depth + 1, k - dungeons[i][1]);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }
}