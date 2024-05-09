import java.util.*;

class Solution {
    int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    class Point {
        int x, y, dist;
        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int solution(int[][] maps) {

        return bfs(maps, 0, 0);
    }

    private int bfs(int[][] maps, int x, int y) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];

        visited[x][y] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 1));

        while (!queue.isEmpty()) {
            Point current = queue.remove();
            int cx = current.x;
            int cy = current.y;
            
            // 도착지점인 경우 dist 리턴
            if (cx == n - 1 && cy == m - 1) {
                return current.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + D[i][0];
                int ny = cy + D[i][1];
                
                if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) continue; // 배열 외 값
                if (visited[nx][ny]) continue; // 이미 방문
                if (maps[nx][ny] == 0) continue; // 벽
                
                visited[nx][ny] = true;
                queue.add(new Point(nx, ny, current.dist + 1));
            }
        }
        
        // 도착하지 못할 경우 -1 리턴
        return -1;
    }
}