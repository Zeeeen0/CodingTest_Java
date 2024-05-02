class Solution {
    public int[] solution(int[] arr, int n) {
        for (int i = (arr.length + 1) % 2; i < arr.length; i += 2) {
            arr[i] += n;
        }
        return arr;
    }
}