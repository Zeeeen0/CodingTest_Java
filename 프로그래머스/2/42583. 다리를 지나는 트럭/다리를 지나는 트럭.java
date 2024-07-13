import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> bridge = new LinkedList<>();
        
        int currentWeight = 0;
        int time = 0;
        int index = 0;

        while (index < truck_weights.length) {
            // 시간 증가
            time++;

            // 다리가 꽉 찼는지 확인 (다리 길이에 도달)
            if (bridge.size() == bridge_length) {
                // 다리에서 트럭 하나 내림
                currentWeight -= bridge.poll();
            }

            // 다음 트럭이 다리에 올라갈 수 있는지 확인
            if (currentWeight + truck_weights[index] <= weight) {
                // 트럭 다리에 올리기
                bridge.offer(truck_weights[index]);
                currentWeight += truck_weights[index];
                index++;  // 다음 트럭으로 이동
            } else {
                // 트럭을 올릴 수 없다면, 다리에 0을 추가 (빈 공간 유지)
                bridge.offer(0);
            }
        }

        // 마지막 트럭이 다리를 완전히 건너는 데 필요한 시간 추가
        return time + bridge_length;
    }
}