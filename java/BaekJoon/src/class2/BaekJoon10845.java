package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 큐
public class BaekJoon10845 {
    int n;
    Queue<Integer> q;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        q = new LinkedList<>();
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (Objects.equals(order, "push")) {
                q.offer(Integer.parseInt(st.nextToken()));
            } else {
                myQueue(order);
            }
        }
    }

    public void myQueue(String s) {
        switch (s) {
            case "pop" :
                if (q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.poll());
                }
                break;
            case "size" :
                System.out.println(q.size());
                break;
            case "empty" :
                if (q.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                break;
            case "front" :
                if (q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.peek());
                }
                break;
            case "back" :
                if (q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    List<Integer> qToList = new ArrayList<>(q);
                    System.out.println(qToList.get(qToList.size() - 1));
                }
                break;
        }
    }
}
