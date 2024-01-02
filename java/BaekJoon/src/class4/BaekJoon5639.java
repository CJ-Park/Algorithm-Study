package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 이진 검색 트리 - 트리 및 postOrder 구현
public class BaekJoon5639 {
    List<Integer> list = new ArrayList<>();
    Node root;
    StringBuilder sb = new StringBuilder();
    Map<Integer, Boolean> visited = new HashMap<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            if (s.length() == 0) break;
            int num = Integer.parseInt(s);
            list.add(num);
        }

        root = new Node(list.get(0), null);

        for (int value : list) {
            makeTree(root, value);
        }

        postOrder(root);

        System.out.print(sb);
    }


    public void makeTree(Node node, int value) {
        if (root.value == value) {
            root.setRoot();
            return;
        }
        if (node.value > value) {
            if (node.left != null)
                makeTree(node.left, value);
            else
                node.setLeft(new Node(value, node));
        }
        if (node.value < value) {
            if (node.right != null)
                makeTree(node.right, value);
            else
                node.setRight(new Node(value, node));
        }
    }

    public void postOrder(Node node) {
        if (node.left == null && node.right == null) {
            sb.append(node.value).append("\n");
            visited.put(node.value, true);
            return;
        }

        if (node.left != null) {
            if (!visited.containsKey(node.left.value)) {
                postOrder(node.left);
            }
        }

        if (node.right != null) {
            if (!visited.containsKey(node.right.value)) {
                postOrder(node.right);
            }
        }

        sb.append(node.value).append("\n");
    }

    public class Node {
        int value;
        boolean root;
        Node parent;
        Node left;
        Node right;

        public Node(int val, Node parent) {
            this.value = val;
            this.parent = parent;
            this.root = false;
        }

        public void setLeft(Node l) {
            this.left = l;
        }
        public void setRight(Node r) {
            this.right = r;
        }

        public void setRoot() {
            this.root = true;
        }
    }
}
