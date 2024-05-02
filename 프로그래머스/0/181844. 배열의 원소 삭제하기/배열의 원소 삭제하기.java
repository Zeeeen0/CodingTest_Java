import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        for (int del : delete_list) {
            list.remove((Integer) del);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}