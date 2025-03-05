import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동을 위한 배열
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        // 그리드 초기화
        grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        
        // 적록색약이 아닌 사람이 보는 구역의 수 계산
        int normalCount = countRegions(false);
        
        // 적록색약인 사람이 보는 구역의 수 계산
        int colorBlindCount = countRegions(true);
        
        System.out.println(normalCount + " " + colorBlindCount);
    }
    
    // 구역의 수를 계산하는 메서드
    static int countRegions(boolean isColorBlind) {
        visited = new boolean[N][N];
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, isColorBlind);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    // BFS로 같은 색상 구역을 탐색하는 메서드
    static void bfs(int startX, int startY, boolean isColorBlind) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        char startColor = grid[startX][startY];
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 그리드 범위 검사
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                    continue;
                }
                
                // 색상 일치 여부 검사
                if (isSameColor(startColor, grid[nx][ny], isColorBlind)) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
    
    // 두 색상이 같은지 비교하는 메서드 (적록색약 고려)
    static boolean isSameColor(char color1, char color2, boolean isColorBlind) {
        if (color1 == color2) {
            return true;
        }
        
        if (isColorBlind && ((color1 == 'R' && color2 == 'G') || (color1 == 'G' && color2 == 'R'))) {
            return true;
        }
        
        return false;
    }
}