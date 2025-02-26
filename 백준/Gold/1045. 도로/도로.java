import java.util.*;

public class Main {
    static class Road implements Comparable<Road> {
        int u, v;

        Road(int u, int v) {
            if (u > v) {
                int temp = u;
                u = v;
                v = temp;
            }
            this.u = u;
            this.v = v;
        }

        @Override
        public int compareTo(Road other) {
            if (this.u != other.u) {
                return Integer.compare(this.u, other.u);
            }
            return Integer.compare(this.v, other.v);
        }
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX == rootY) return;
            
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();  // 개행 문자 처리

        List<Road> roads = new ArrayList<>();
        
        // 인접 행렬에서 도로 정보 추출
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            for (int j = i + 1; j < N; j++) {
                if (line.charAt(j) == 'Y') {
                    roads.add(new Road(i, j));
                }
            }
        }
        
        // 우선순위에 따라 도로 정렬 (튜플이 작을수록 우선순위가 높음)
        Collections.sort(roads);
        
        // 도로가 M개 미만이면 해결 불가능
        if (roads.size() < M) {
            System.out.println(-1);
            return;
        }
        
        // 최소 스패닝 트리(MST) 구성
        List<Road> mst = new ArrayList<>();
        boolean[] used = new boolean[roads.size()];
        UnionFind uf = new UnionFind(N);
        
        for (int i = 0; i < roads.size(); i++) {
            Road road = roads.get(i);
            if (uf.find(road.u) != uf.find(road.v)) {
                uf.union(road.u, road.v);
                mst.add(road);
                used[i] = true;
            }
        }
        
        // MST가 연결되어 있는지 확인
        int root = uf.find(0);
        boolean isConnected = true;
        for (int i = 1; i < N; i++) {
            if (uf.find(i) != root) {
                isConnected = false;
                break;
            }
        }
        
        // 연결된 그래프가 아니거나 MST 크기가 M보다 크면 해결 불가능
        if (!isConnected || mst.size() > M) {
            System.out.println(-1);
            return;
        }
        
        // MST에 도로를 더 추가하여 총 M개의 도로를 가진 집합 생성
        List<Road> result = new ArrayList<>(mst);
        for (int i = 0; i < roads.size() && result.size() < M; i++) {
            if (!used[i]) {
                result.add(roads.get(i));
            }
        }
        
        // 각 도시를 끝점으로 갖는 도로의 개수 계산
        int[] count = new int[N];
        for (Road road : result) {
            count[road.u]++;
            count[road.v]++;
        }
        
        // 결과 출력
        for (int cnt : count) {
            System.out.print(cnt + " ");
        }
        System.out.println();
    }
}