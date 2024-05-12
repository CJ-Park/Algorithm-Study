package StackQueue.level2;

// 큐/스택 없이 해결
public class 올바른괄호 {
    boolean solution(String s) {
        // "(" 나올 경우 count + 1
        // ")" 나올 경우 count - 1
        // for 문 돌리면서 count 가 음수가 되거나 다 돌았을 때 count값이 0이 아닐 경우 false
        int size = s.length();
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }
}
