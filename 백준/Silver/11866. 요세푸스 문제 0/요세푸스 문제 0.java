import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        int index = 0;
        while (!list.isEmpty()) {
            index = (index + (K - 1)) % list.size();
            
            if (list.size() == 1) {
                sb.append(list.remove(index));
            } else {
                sb.append(list.remove(index)).append(", ");
            }
        }
        
        sb.append(">");
        System.out.println(sb);
    }
}