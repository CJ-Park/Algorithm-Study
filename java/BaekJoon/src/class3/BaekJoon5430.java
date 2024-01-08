package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

// AC - 덱 + 문자열 파싱 + 구현
public class BaekJoon5430 {
    int T, n;
    boolean reverse; // R 연산을 통해 뒤집힘 여부 판단
    Deque<Integer> deque;
    String fnc, arr;
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            deque = new ArrayDeque<>();
            reverse = false;
            fnc = br.readLine();
            n = Integer.parseInt(br.readLine());
            arr = br.readLine();

            if (arr.charAt(1) != ']') { // 입력 시 빈 배열이 아닐 경우 deque 채우기
                String[] num = arr.substring(1, arr.length() - 1).split(",");

                for (String number : num) {
                    deque.addLast(Integer.parseInt(number));
                }
            }

            getResult();
            sb.append("\n");
        }

        System.out.print(sb);
    }

    // 연산에 따른 결과값 sb에 넣기
    public void getResult() {
        String[] fncList = fnc.split("");

        for (String fn : fncList) {
            if (Objects.equals(fn, "R")) { // 순서 바꾸는 연산
                reverse = !reverse;
            } else { // 첫번째 요소 삭제 연산
                if (deque.isEmpty()){
                    sb.append("error");
                    return;
                }

                if (reverse)
                    deque.removeLast();
                else
                    deque.removeFirst();
            }
        }

        sb.append("[");
        int size = deque.size();
        if (reverse) {
            for (int i = 0; i < size; i++) {
                if (i == size - 1)
                    sb.append(deque.pollLast());
                else
                    sb.append(deque.pollLast()).append(",");
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (i == size - 1)
                    sb.append(deque.pollFirst());
                else
                    sb.append(deque.pollFirst()).append(",");
            }
        }
        sb.append("]");
    }
}
