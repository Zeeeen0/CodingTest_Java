import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int answer = n;
        int[] student = new int[n + 1];
        
        for (int l : lost) {
            student[l]--;
        }
        for (int r : reserve) {
            student[r]++;
        }
        for (int i = 1; i < student.length; i++) {
            if (student[i] == -1) {
                if (i - 1 >= 1 && student[i - 1] == 1) {
                    student[i]++;
                    student[i-1]--;
                } else if (i + 1 < student.length && student[i + 1] == 1) {
                    student[i]++;
                    student[i+1]--;
                } else {
                    answer--;
                }
            }
        }
        
        return answer;
    }
}