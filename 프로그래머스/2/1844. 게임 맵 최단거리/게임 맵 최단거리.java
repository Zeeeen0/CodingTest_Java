import java.util.*;

class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        int[][] visited = new int[n][m];
        
        bfs(maps, visited);
        answer = visited[n - 1][m - 1];
        
        if (answer == 0) {
            return -1;
        }
        
        return answer;
    }
    
    private void bfs(int[][] maps, int[][] visited) {
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        
        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int cx = current[0];
            int cy = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx < 0 || ny < 0 || nx > maps.length - 1 || ny > maps[0].length - 1) {
                    continue;
                }
                
                if (visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[cx][cy] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}