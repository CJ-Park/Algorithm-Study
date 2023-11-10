package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 스택 수열
public class BaekJoon1874 {
    int n;
    int[] arr;
    Stack<Integer> stack;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int s = 1;
        int idx = 0;
        // stack 에 1부터 n까지 push , pop
        // arr[0] 부터 stack.peek() 비교하면서 같으면 pop 후 idx++
        while (idx < n) {
            // stack 이 비었으면 push
            if (stack.isEmpty()) {
                stack.push(s);
                sb.append("+").append("\n");
                s++;
                continue;
            }

            // stack.peek 와 arr[idx] 가 같다면 pop
            // s > n 라면 break;
            if (arr[idx] == stack.peek()) {
                stack.pop();
                sb.append("-").append("\n");
                idx++;
            } else if (s <= n) {
                stack.push(s);
                sb.append("+").append("\n");
                s++;
            } else {
                sb.setLength(0);
                sb.append("NO");
                break;
            }
        }

        System.out.print(sb);
    }
}
