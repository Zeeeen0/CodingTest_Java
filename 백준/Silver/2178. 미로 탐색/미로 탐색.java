import java.io.*;
import java.util.*;

public class Main {
    // 상, 하, 좌, 우 이동을 위한 방향 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 미로 맵 초기화 (1-indexed를 0-indexed로 변환)
        int[][] maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }
        
        // BFS로 최단 경로 찾기
        int result = bfs(maze, N, M);
        
        // 결과 출력
        System.out.println(result);
    }
    
    static int bfs(int[][] maze, int N, int M) {
        // 방문 여부와 거리를 저장하는 배열
        int[][] visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0}); // 시작 위치 (0, 0)
        visited[0][0] = 1; // 시작 위치도 카운트에 포함
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            // 목적지에 도달한 경우 거리 반환
            if (x == N - 1 && y == M - 1) {
                return visited[x][y];
            }
            
            // 네 방향으로 이동 시도
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 범위를 벗어나거나 벽이거나 이미 방문한 경우 스킵
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || maze[nx][ny] == 0 || visited[nx][ny] != -1) {
                    continue;
                }
                
                // 이동 가능한 경우 큐에 추가하고 거리 업데이트
                queue.offer(new int[] {nx, ny});
                visited[nx][ny] = visited[x][y] + 1;
            }
        }
        
        // 목적지에 도달할 수 없는 경우 (문제에서는 항상 도달 가능하다고 명시)
        return -1;
    }
}