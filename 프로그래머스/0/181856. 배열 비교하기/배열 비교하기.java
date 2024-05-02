import java.util.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return arr1.length > arr2.length ? 1 : -1;
        }
        int[] sum = new int[]{
                Arrays.stream(arr1).sum(),
                Arrays.stream(arr2).sum()
        };
        
        return Integer.compare(sum[0], sum[1]);
    }
}