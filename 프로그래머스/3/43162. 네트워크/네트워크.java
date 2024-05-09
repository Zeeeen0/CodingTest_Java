class Solution {
    private int[][] computers;
    private boolean[] visited;
    
    public int solution(int n, int[][] c) {
        int answer = 0;
        
        computers = c;
        visited = new boolean[computers.length];
        
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }
        
        return answer;
    }
    
    private void dfs(int node) {
        visited[node] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[node][i] == 1) {
                dfs(i);
            }
        }
    }
}