package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.StringTokenizer;

// 덱
public class BaekJoon10866 {
    int n;
    int SIZE = 10000;
    Deque<Integer> deque;

    public void solution () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        deque = new ArrayDeque<>(SIZE);
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (Objects.equals(order, "push_front")) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
            } else if (Objects.equals(order, "push_back")) {
                deque.offer(Integer.parseInt(st.nextToken()));
            } else {
                myDeque(order);
            }
        }
    }

    public void myDeque(String o) {
        switch (o) {
            case "pop_front" :
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.poll());
                }
                break;
            case "pop_back" :
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.pollLast());
                }
                break;
            case "size" :
                System.out.println(deque.size());
                break;
            case "empty" :
                if (deque.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                break;
            case "front" :
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peekFirst());
                }
                break;
            case "back" :
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peekLast());
                }
                break;
        }
    }
}
