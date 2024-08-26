package level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
이진트리 만들기
1. y 내림차순 정렬, 같은 계층은 x 오름차순 정렬
2. head 노드 통해서 트리 생성하도록 재귀방식으로 insert 메서드 구현
3. 생성된 트리 기반으로 preorder, postorder 구하기
 */
public class 길_찾기_게임 {
    int[][] result;
    List<Integer> pre = new ArrayList<>();
    List<Integer> post = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodeList = new ArrayList<>();

        for (int i = 0; i < nodeinfo.length; i++) {
            Node n = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
            nodeList.add(n);
        }

        Collections.sort(nodeList);

        Node head = nodeList.get(0);
        for (int i = 1; i < nodeList.size(); i++) {
            head.insertNode(nodeList.get(i));
        }

        result = new int[2][nodeList.size()];
        order(head);

        for (int i = 0; i < nodeList.size(); i++) {
            result[0][i] = pre.get(i);
            result[1][i] = post.get(i);
        }

        return result;
    }

    // 전위순회 / 후위순회 한번에 저장
    private void order(Node head) {
        if (head == null) {
            return;
        }

        pre.add(head.value);
        order(head.left);
        order(head.right);
        post.add(head.value);
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int value;

        Node left;
        Node right;

        public Node (int x, int y, int v){
            this.x = x;
            this.y = y;
            this.value = v;
        }

        public void insertNode(Node n) {
            if (this.x > n.x) {
                if (this.left != null) {
                    this.left.insertNode(n);
                } else {
                    this.left = n;
                }
            } else { // x 가 같은 경우는 주어지지 않음
                if (this.right != null) {
                    this.right.insertNode(n);
                } else {
                    this.right = n;
                }
            }
        }

        public int compareTo(Node n) {
            if (this.y == n.y) { // y 가 같으면 x 오름차순
                return this.x - n.x;
            }
            return n.y - this.y; // 아니라면 y 내림차순
        }
    }
}
