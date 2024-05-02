import java.util.*;

class Solution {
    public int solution(int n) {
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(new int[]{i, n / i});
            }
        }
        return list.size();
    }
}