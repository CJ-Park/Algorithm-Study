package level1;

import java.util.Stack;

// 2018 카카오 블라인드
public class 다트게임_1차 {
    static int result = 0;
    static int num = 0;
    static Stack<Integer> stack = new Stack<>();

    public int solution(String dartResult) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (Character.isDigit(c)) {
                sb.append(c);
            } else if (Character.isAlphabetic(c)) {
                num = Integer.parseInt(sb.toString());
                sb.setLength(0);
                bonus(c);
            } else {
                option(c);
            }
        }

        stack.clear();
        return result;
    }

    // S, D, T 중 나온거 반영해서 num 에 저장
    private void bonus(char c) {
        if (c == 'D') {
            num = num * num;
        }

        if (c == 'T') {
            num = num * num * num;
        }

        stack.push(num);
        result += num;
    }

    // 옵션 연산
    // * 이면 이전 연산 한번 더 더하기 + 현재 연산 두배
    // # 이면 현재연산 -로 전환
    private void option(char c) {
        int afterNum = stack.pop();

        if (c == '*') { // 스택에 저장된 애들 한번씩 더 더하기 + 스택에 두배로 저장
            result += afterNum;

            if (!stack.isEmpty()) {
                int beforeNum = stack.pop();
                result += beforeNum;
                stack.push(beforeNum * 2);
            }

            stack.push(afterNum * 2);
        } else { // 스택에 저장된 애 결과에서 두번빼고 -1 곱해서 스택에 저장
            result -= afterNum * 2;
            stack.push(afterNum * -1);
        }
    }
}
