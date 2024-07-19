package level2.re;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 재귀문제 더 풀어보기
public class 수식_최대화 {
    List<Long> numbers = new ArrayList<>();
    List<Character> operators = new ArrayList<>();
    Set<String> sortOper = new HashSet<>();
    long result = 0;

    public long solution(String expression) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                sb.append(c);
            } else { // 연산자 등장
                long num = Long.parseLong(sb.toString());
                sb.setLength(0);

                numbers.add(num);
                operators.add(c);
            }
        }

        long num = Long.parseLong(sb.toString());
        numbers.add(num);

        Set<Character> oper = new HashSet<>(operators);
        List<Character> operList = new ArrayList<>(oper);

        // 연산 우선순위 재귀로 뽑아내기
        recur(new StringBuilder(), operList, operList.size());

        for (String s : sortOper) {
            getResult(s, new ArrayList<>(numbers), new ArrayList<>(operators));
        }

        return result;
    }

    private void getResult(String str, List<Long> num,
                           List<Character> ops) {
        char[] priority = str.toCharArray(); // 연산 우선순위

        for (char c : priority) {
            for (int i = 0; i < ops.size(); i++) {
                if (ops.get(i) == c) { // 연산 진행
                    long num1 = num.get(i);
                    long num2 = num.get(i + 1);
                    long total = 0;

                    if (c == '+') {
                        total = num1 + num2;
                    }
                    if (c == '-') {
                        total = num1 - num2;
                    }
                    if (c == '*') {
                        total = num1 * num2;
                    }

                    // num에서 num1, num2 삭제 후 total값 삽입
                    num.remove(i + 1);
                    num.remove(i);
                    num.add(i, total);

                    // ops에서 해당 인덱스 op연산 삭제
                    ops.remove(i);

                    // 전체 리스트 길이가 줄었으므로 i--;
                    i--;
                }
            }
        }

        result = Math.max(Math.abs(num.get(0)), result);
    }

    private void recur(StringBuilder sb, List<Character> operList, int size) {
        if (sb.length() == size) {
            sortOper.add(sb.toString());
            return;
        }

        for (int i = 0; i < operList.size(); i++) {
            char c = operList.get(i);

            sb.append(c);
            operList.remove(Character.valueOf(c));

            recur(sb, new ArrayList<>(operList), size);

            operList.add(i, c);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
