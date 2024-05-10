import java.util.*;

class Solution {
    List<String> list = new ArrayList<>();
    String[] words = new String[]{"A", "E", "I", "O", "U"};

    public int solution(String word) {

        dfs("", 0); // 0부터 시작해서 1글자씩 dfs

        return list.indexOf(word);
    }

    private void dfs(String str, int len) {
        list.add(str);
        if (len == 5) return;
        for (int i = 0; i < 5; i++) {
            dfs(str + words[i], len + 1);
        }
    }
}