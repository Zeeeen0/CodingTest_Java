import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        List<String> l1 = new ArrayList<>(Arrays.asList(s1));
        List<String> l2 = new ArrayList<>(Arrays.asList(s2));

        l1.retainAll(l2);

        return l1.size();
    }
}