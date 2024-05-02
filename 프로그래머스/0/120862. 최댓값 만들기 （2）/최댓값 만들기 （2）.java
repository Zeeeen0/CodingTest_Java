import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int start = numbers[0] * numbers[1];
        int end = numbers[numbers.length - 2] * numbers[numbers.length - 1];
        return Math.max(start, end);
    }
}