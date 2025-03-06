import java.util.*;

public class Main {
    // 상하좌우 이동을 위한 배열
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 지도의 크기 입력
        int n = sc.nextInt();  // 세로 크기
        int m = sc.nextInt();  // 가로 크기
        
        // 지도 정보 저장
        int[][] map = new int[n][m];
        // 거리 정보 저장
        int[][] dist = new int[n][m];
        
        // 시작점(목표지점) 좌표
        int startX = 0, startY = 0;
        
        // 지도 정보 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                
                // 목표지점(2) 위치 저장
                if (map[i][j] == 2) {
                    startX = j;
                    startY = i;
                    map[i][j] = 1;  // 목표지점도 이동 가능한 땅으로 표시
                }
                
                // 거리 초기화: 갈 수 없는 땅은 0, 갈 수 있는 땅은 -1
                if (map[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = -1;
                }
            }
        }
        
        // BFS로 최단거리 계산
        bfs(map, dist, startX, startY, n, m);
        
        // 결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dist[i][j] + (j < m - 1 ? " " : ""));
            }
            System.out.println();
        }
        
        sc.close();
    }
    
    // BFS를 이용한 최단거리 계산
    static void bfs(int[][] map, int[][] dist, int startX, int startY, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        
        // 시작점 설정
        queue.offer(new int[]{startY, startX});
        dist[startY][startX] = 0;  // 시작점의 거리는 0
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            
            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                // 지도 범위 내이고, 이동 가능한 땅이며, 아직 방문하지 않은 경우
                if (ny >= 0 && ny < n && nx >= 0 && nx < m && map[ny][nx] == 1 && dist[ny][nx] == -1) {
                    dist[ny][nx] = dist[y][x] + 1;  // 거리 업데이트
                    queue.offer(new int[]{ny, nx});  // 큐에 추가
                }
            }
        }
    }
}