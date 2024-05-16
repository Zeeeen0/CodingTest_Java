import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String X, String Y) {
        Map<String, Integer> xMap = new HashMap<>();
        Map<String, Integer> yMap = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (String x : X.split("")) {
            xMap.put(x, xMap.getOrDefault(x, 0) + 1);
        }
        for (String y : Y.split("")) {
            yMap.put(y, yMap.getOrDefault(y, 0) + 1);
        }

        for (String x : xMap.keySet()) {
            if (yMap.containsKey(x)) {
                int length = Math.min(xMap.get(x), yMap.get(x));
                for (int i = 0; i < length; i++) {
                    list.add(String.valueOf(x));
                }
            }
        }

        String answer = list.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining());

        if (answer.isEmpty()) return "-1";
        if (answer.matches("0+")) return "0";
        return answer;
    }
}