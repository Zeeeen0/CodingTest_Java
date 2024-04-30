import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> list1 = new ArrayList<>(); // str1
        List<String> list2 = new ArrayList<>(); // str2

        for (int i = 0; i < str1.length() - 1; i++) {
            if (str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z'
               && str1.charAt(i + 1) >= 'a' && str1.charAt(i + 1) <= 'z') {
            list1.add(str1.substring(i, i + 2));
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            if (str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z'
               && str2.charAt(i + 1) >= 'a' && str2.charAt(i + 1) <= 'z') {
            list2.add(str2.substring(i, i + 2));
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);

        List<String> intersection = new ArrayList<>(); // 교집합
        List<String> union = new ArrayList<>(); // 합집합

        for (String s1 : list1) {
            union.add(s1);
            if (list2.remove(s1)) {
                intersection.add(s1);
            }
        }
        for (String s2 : list2) {
            union.add(s2);
        }
        
        return union.size() == 0 ? 65536 : intersection.size() * 65536 / union.size();
    }
}