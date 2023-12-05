package class3.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질 - bfs 문제
public class BaekJoon1697 {
    int n, k;
    int MAX = 100001;
    int[] arr = new int[MAX];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
        } else {
            bfs(n);
        }
    }

    public void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        arr[num] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) { // now - 1
                    next = now - 1;
                } else if (i == 1) { // now + 1
                    next = now + 1;
                } else {
                    next = now * 2;
                }

                if (k == next) {
                    System.out.println(arr[now] + 1);
                    return;
                }

                if (next >= 0 && next < MAX && arr[next] == 0) { // next 가 범위내면서 arr[next] 를 방문 안했을 경우
                    arr[next] = arr[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}
