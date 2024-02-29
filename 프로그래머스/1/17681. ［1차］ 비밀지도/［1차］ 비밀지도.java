class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            // 2진법으로 변환해서 0 LPAD 자릿수 맞추기
            String binary1 = String.format("%" + n + "s", Integer.toBinaryString(arr1[i])).replace(" ", "0");
            String binary2 = String.format("%" + n + "s", Integer.toBinaryString(arr2[i])).replace(" ", "0");
            
            // 1자리마다 OR 연산
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append((char)(binary1.charAt(j) | binary2.charAt(j)));
            }
            String map = sb.toString();
            // 형식에 맞춰서 replace
            map = map.replaceAll("1", "#");
            map = map.replaceAll("0", " ");
            answer[i] = map;
        }
        return answer;
    }
}