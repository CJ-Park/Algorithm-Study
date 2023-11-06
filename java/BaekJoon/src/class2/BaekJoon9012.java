package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

// 괄호, 스택문제
public class BaekJoon9012 {
    int n;
    Stack<String> stack;
    List<String> result;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stack = new Stack<>();
        result = new ArrayList<>();
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if (stack.isEmpty() && s.charAt(j) == ')') {
                    stack.add("pass");
                    break;
                } else if (s.charAt(j) == '(') {
                    stack.push(String.valueOf(s.charAt(j)));
                } else if (s.charAt(j) == ')' && Objects.equals(stack.peek(), "(")) {
                    stack.pop();
                }
            }
            String res = stack.isEmpty() ? "YES" : "NO";
            result.add(res);
            stack.clear();
        }

        for (String res : result) {
            System.out.println(res);
        }
    }
}
