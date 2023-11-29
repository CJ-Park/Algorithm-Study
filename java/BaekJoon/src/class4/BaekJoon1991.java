package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

// 트리 순회 - 재귀
public class BaekJoon1991 {
    int n;
    Map<String, Node> tree;
    StringBuilder sb = new StringBuilder();
    Map<String, Boolean> visited;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        tree = new HashMap<>();
        visited = new HashMap<>();

        // nodeList 인덱스마다 값 추가
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            tree.put(key, new Node(key, st.nextToken(), st.nextToken()));
            visited.put(key, false);
        }

        preOrder("A");
        System.out.println(sb);
        sb.setLength(0);
        inOrder("A");
        System.out.println(sb);
        sb.setLength(0);
        postOrder("A");
        System.out.println(sb);
    }

    public void preOrder(String node) { // 루트 -> 왼쪽자식 -> 우측자식
        if (node == null) return;
        if (!visited.get(node)) {
            sb.append(node);
            visited.put(node, true);
        }
        preOrder(tree.get(node).leftChild);
        preOrder(tree.get(node).rightChild);
    }

    // 좌측 출력 -> 루트 출력 -> 우측 출력
    public void inOrder(String node) { // 왼쪽 -> 루트 -> 우측
        if (node == null) return;
        visited.put(node, true); // 방문처리
        inOrder(tree.get(node).leftChild);
        if (visited.get(node)) { // 방문처리 됐으면 저장
            sb.append(node);
            visited.put(node, false);
        }
        inOrder(tree.get(node).rightChild);
    }

    public void postOrder(String node) { // 왼쪽 -> 우측 -> 루트
        if (node == null) return;
        postOrder(tree.get(node).leftChild);
        postOrder(tree.get(node).rightChild);
        visited.put(node, true);
        if (visited.get(node)) {
            sb.append(node);
        }
    }

    public class Node {
        String value;
        String leftChild;
        String rightChild;

        public Node(String v, String l, String r) {
            this.value = v;
            if (!Objects.equals(l, ".")) this.leftChild = l;
            if (!Objects.equals(r, ".")) this.rightChild = r;
        }
    }
}
