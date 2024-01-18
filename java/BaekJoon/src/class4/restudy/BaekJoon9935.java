package class4.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 문자열 폭발 - 문자열 / 스택
// 스택 생각하기 어려웠음
// Stack<String> 으로 하면 메모리 초과 발생 => String 사용 주의
public class BaekJoon9935 {
    String word, bomb;
    Stack<Character> stack = new Stack<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        word = br.readLine();
        bomb = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));

            if (stack.size() >= bomb.length()) { // 폭탄 있는지 확인해서 삭제
                checkBomb();
            }
        }

        if (stack.isEmpty()) {
            System.out.print("FRULA");
            return;
        }

        for (char c : stack) {
            sb.append(c);
        }

        System.out.print(sb);
    }

    public void checkBomb() {
        boolean isBomb = true;

        for (int i = 0; i < bomb.length(); i++) { // 다른게 하나라도 있으면 폭탄 아님
            if (stack.get(stack.size() - 1 - i) != bomb.charAt(bomb.length() - 1 - i)) {
                isBomb = false;
                break;
            }
        }

        if (isBomb) { // 폭탄이면 스택에서 폭탄 지우기
            for (int i = 0; i < bomb.length(); i++) {
                stack.pop();
            }
        }
    }
}
