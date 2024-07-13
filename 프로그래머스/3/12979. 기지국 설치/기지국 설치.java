    class Solution {

        public int solution(int n, int[] stations, int w) {
            int idx = 1;
            int stationIdx = 0;
            
            int answer = 0;
            
            while (idx <= n) {
                if (stationIdx < stations.length && idx >= stations[stationIdx] - w) {
                    // 현재 위치가 기지국 전파 범위 내에 있는 경우
                    idx = stations[stationIdx] + w + 1;
                    stationIdx++;
                } else {
                    // 현재 위치가 기지국 전파 범위 밖에 있는 경우
                    answer++;
                    idx += 2 * w + 1;
                }
            }

            return answer;
        }
    }