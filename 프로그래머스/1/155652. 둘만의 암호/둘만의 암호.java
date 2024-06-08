class Solution {
    public String solution(String s, String skip, int index) {

        // skip할 문자를 제외한 문자열 리스트 만들기
        String list = "abcdefghijklmnopqrstuvwxyz";
        for (char sk : skip.toCharArray()) {
            list = list.replace(String.valueOf(sk), "");
        }

        // 문자열 index 옮기기
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            int startIdx = list.indexOf(c);
            int targetIdx = list.charAt((startIdx + index) % list.length());
            sb.append(list.charAt(list.indexOf(targetIdx)));
        }

        return sb.toString();
    }
}