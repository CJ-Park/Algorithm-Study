package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

// 균형잡힌 세상
public class BaekJoon4949 {
    Stack<String> stack;
    List<String> result;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stack = new Stack<>();
        result = new ArrayList<>();

        // 스택사용 - 대칭되는 괄호 연속으로 들어가면 스택에서 두개 빼기
        // 1. 괄호 종류만 스택에 쌓기 () / [] => ) / ] 두개가 먼저 스택에 쌓이면 바로 no 출력
        // 2. 연산 마무리 후 스택 확인해서 비었으면 yes 출력
        while (true) {
            String s = br.readLine();
            if (s.equals(String.valueOf('.'))) break;
            for (int i = 0; i < s.length(); i++) {
                // 1
                if(stack.isEmpty() && (s.charAt(i) == ']' || s.charAt(i) == ')')) {
                    stack.push("pass"); // for 문 탈출 후 스택 확인하므로 stack 에 데이터 넣고 break 처리
                    break;
                }
                if (s.charAt(i) == '[' || s.charAt(i) == '(') {
                    stack.push(String.valueOf(s.charAt(i)));
                } else if (i > 0 && s.charAt(i) == ']') {
                    if (Objects.equals(stack.peek(), "[")) {
                        stack.pop();
                    } else {
                        stack.push(String.valueOf(s.charAt(i)));
                    }
                } else if (i > 0 && s.charAt(i) == ')') {
                    if (Objects.equals(stack.peek(), "(")) {
                        stack.pop();
                    } else {
                        stack.push(String.valueOf(s.charAt(i)));
                    }
                }
            }
            // 2
            if (stack.isEmpty()) {
                result.add("yes");
            } else {
                result.add("no");
                stack.clear();
            }
        }

        for (String s : result) {
            System.out.println(s);
        }
    }
}
