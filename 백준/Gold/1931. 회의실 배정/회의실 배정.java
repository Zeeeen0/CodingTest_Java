import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // Create an array to store meeting times
        int[][] meetings = new int[n][2];
        
        // Read input
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            meetings[i][0] = Integer.parseInt(st.nextToken()); // Start time
            meetings[i][1] = Integer.parseInt(st.nextToken()); // End time
        }
        
        // Sort by end time, and if end times are equal, sort by start time
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        
        int count = 0;
        int prevEndTime = 0;
        
        // Greedy algorithm: select meeting rooms that end earliest
        for (int i = 0; i < n; i++) {
            // If the current meeting starts at or after the previous meeting ends
            if (meetings[i][0] >= prevEndTime) {
                count++;
                prevEndTime = meetings[i][1];
            }
        }
        
        System.out.println(count);
    }
}