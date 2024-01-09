package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// DSLR - 그래프 탐색 / bfs
// 시간초과 발생 -> boolean 을 통해 중복 방문 체크로 해결
public class BaekJoon9019 {
    int T;
    int MOD = 10000;
    Queue<Node> q;
    boolean[] visited; // 중복 방문을 통한 시간 초과를 막기 위함
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().split(" ");
            q = new LinkedList<>();
            visited = new boolean[10001]; // 0 ~ 10000 까지 방문여부 체크
            Node root = new Node(Integer.parseInt(s[0]), null);
            bfs(root, Integer.parseInt(s[1]));
        }

        System.out.print(sb);
    }

    // 연산 4가지 돌려서 Queue 넣기
    // Queue 에서 꺼내서 인수로 다시 받아서 연산
    public void bfs(Node node, int result) {
        q.add(node);
        visited[node.number] = true;

        while (!q.isEmpty()) {
            Node poll = q.poll();

            if (poll.number == result) {
                sb.append(poll.order).append("\n");
                break;
            }

            D(poll);
            S(poll);
            L(poll);
            R(poll);
        }
    }

    // 4 가지 연산 진행해서 Queue 에 추가
    public void D(Node node) {
        int number = node.number * 2;
        String order = node.order;

        if (number >= MOD)
            number = number % MOD;

        if (visited[number])
            return;
        else
            visited[number] = true;

        order = order == null ? "D" : order + "D";

        q.add(new Node(number, order));
    }

    public void S(Node node) {
        int number = node.number - 1;
        String order = node.order;

        if (number == -1)
            number = MOD - 1;

        if (visited[number])
            return;
        else
            visited[number] = true;

        order = order == null ? "S" : order + "S";

        q.add(new Node(number, order));
    }

    public void L(Node node) {
        int number = node.number;
        String order = node.order;

        if (number < 1000) {
            number *= 10;
        } else { // 자리수 바꾸기
            number *= 10;
            int n = number / MOD;
            number = number % MOD + n;
        }

        if (visited[number])
            return;
        else
            visited[number] = true;

        order = order == null ? "L" : order + "L";

        q.add(new Node(number, order));
    }

    public void R(Node node) {
        int number = node.number;
        String order = node.order;

        if (number % 10 == 0) {
            number /= 10;
        } else { // 맨 우측이 0이 아닐 경우
            int n = number % 10;
            number /= 10;
            number += 1000 * n;
        }

        if (visited[number])
            return;
        else
            visited[number] = true;

        order = order == null ? "R" : order + "R";

        q.add(new Node(number, order));
    }

    class Node {
        int number;
        String order;
        boolean root = false;

        public Node(int n, String o) {
            this.number = n;
            this.order = o;
        }
    }
}
