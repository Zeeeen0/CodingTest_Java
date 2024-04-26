import java.util.*;

class Solution {
    List<Integer> list;
    public int[] solution(String[] operations) {
        list = new ArrayList<>();
        
        for (String o : operations) {
            String command = o.split(" ")[0];
            int num = Integer.parseInt(o.split(" ")[1]);
            if ("I".equals(command)) {
                add(num);
            } else if ("D".equals(command) && num == 1) {
                delMax();
            } else if ("D".equals(command) && num == -1) {
                delMin();
            }
        }
        
        if (list.isEmpty()) {
            return new int[]{0, 0};
        }
        int max = Collections.max(list);
        int min = Collections.min(list);
        return new int[]{max, min};
    }

    private void add(int i) {
        list.add(i);
    }

    private void delMax() {
        if (!list.isEmpty()) {
            int max = Collections.max(list);
            list.remove((Integer) max);
        }
    }

    private void delMin() {
        if (!list.isEmpty()) {
            int min = Collections.min(list);
            list.remove((Integer) min);
        }
    }
}