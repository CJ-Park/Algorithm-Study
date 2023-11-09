package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 프린터 큐
public class BaekJoon1966 {
    ArrayList<Integer> list;
    int n, m, count;
    Queue<Integer> q;
    StringTokenizer st;
    BufferedReader br;
    public void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(br.readLine());
        q = new LinkedList<>();
        list = new ArrayList<>();

        for (int i = 0; i < testNum; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            saveArr();
        }
    }

    public void saveArr() throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
            q.offer(list.get(i));
        }

        list.sort(Comparator.naturalOrder());

        printQueue();
    }

    public void printQueue() {
        while (m >= 0) {
            if (q.peek() == list.get(list.size() - 1) && m == 0) {
                q.poll();
                count++;
                m = -1;
                System.out.println(count);
            } else if (q.peek() == list.get(list.size() - 1) && m != 0) {
                q.poll();
                count++;
                m--;
                list.remove(list.size() - 1);
            } else if (q.peek() != list.get(list.size() - 1) && m == 0){
                q.offer(q.poll());
                m = q.size() - 1;
            } else {
                q.offer(q.poll());
                m--;
            }
        }
        list.clear();
        count = 0;
        q.clear();
    }
}
