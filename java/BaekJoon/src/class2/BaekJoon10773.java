package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BaekJoon10773 {
    int k, result;
    Stack<Integer> stack;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stack = new Stack<>();
        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            int s = Integer.parseInt(br.readLine());
            if (s == 0 && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(s);
            }
        }

        for (int a : stack) {
            result += a;
        }
        System.out.println(result);
    }
}
