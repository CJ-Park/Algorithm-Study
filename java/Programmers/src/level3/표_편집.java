package level3;

import java.util.Arrays;
import java.util.Stack;

/*
처음에 ArrayList 쓰고 시간초과 - 이중연결리스트로 직접 구현
이중연결리스트 + 스택

============
이중연결리스트 없이도 풀이 가능
 */
public class 표_편집 {
    public String solution(int n, int k, String[] cmd) {
        Node[] nodeList = new Node[n];

        for (int i = 0; i < n; i++) {
            nodeList[i] = new Node(i);
        }

        for (int i = 1; i < n; i++) {
            nodeList[i].prev = nodeList[i - 1];
            nodeList[i - 1].next = nodeList[i];
        }

        Node cur = nodeList[k];
        Stack<Node> removed = new Stack<>();

        for (String s : cmd) {
            String[] str = s.split(" ");

            String command = str[0];

            if (command.equals("C")) { // 삭제
                removed.push(cur);
                Node prevNode = cur.prev;
                Node nextNode = cur.next;

                if (prevNode != null) {
                    prevNode.next = nextNode;
                }
                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }

                cur = nextNode != null ? nextNode : prevNode;

                continue;
            }

            if (command.equals("Z")) { // 복구
                Node restoreNode = removed.pop();

                Node prevNode = restoreNode.prev;
                Node nextNode = restoreNode.next;

                if (prevNode != null) {
                    prevNode.next = restoreNode;
                }

                if (nextNode != null) {
                    nextNode.prev = restoreNode;
                }

                continue;
            }

            int move = Integer.parseInt(str[1]);

            if (command.equals("U")) {
                for (int i = 0; i < move; i++) {
                    cur = cur.prev;
                }
            }

            if (command.equals("D")) {
                for (int i = 0; i < move; i++) {
                    cur = cur.next;
                }
            }
        }

        char[] result = new char[n];
        Arrays.fill(result, 'O');

        while (!removed.isEmpty()) {
            Node node = removed.pop();
            result[node.index] = 'X';
        }

        return new String(result);
    }

    // 이중 연결 리스트 노드를 정의
    static class Node {
        int index;
        Node prev;
        Node next;

        public Node(int index) {
            this.index = index;
        }
    }

    // 이중연결리스트 없는 풀이
    public String solution_2(int n, int k, String[] cmd) {
        int tableSize = n;
        Stack<Integer> stack = new Stack<>();

        for (String s : cmd) {
            String[] str = s.split(" ");

            String command = str[0];

            if (command.equals("C")) { // 삭제
                stack.push(k);
                tableSize--;

                if (k == tableSize) {
                    k--;
                }
                continue;
            }

            if (command.equals("Z")) { // 복구
                Integer pop = stack.pop();
                if (k >= pop) {
                    k++;
                }
                tableSize++;
                continue;
            }

            int move = Integer.parseInt(str[1]);

            if (command.equals("U")) {
                k -= move;

                if (k < 0) {
                    k = 0;
                }
            }

            if (command.equals("D")) {
                k += move;

                if (k > tableSize - 1) {
                    k = tableSize - 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        // 현재 존재하는 tableSize 만큼 O 만들기
        for (int i = 0; i < tableSize; i++) {
            sb.append("O");
        }

        // stack 에서 꺼내면서 해당하는 인덱스에 X 추가
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            sb.insert(pop, "X");
        }

        return sb.toString();
    }
}
