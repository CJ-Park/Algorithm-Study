package level2;

import java.util.ArrayDeque;
import java.util.Queue;

public class 두_큐_합_같게_만들기 {
    public int solution(int[] queue1, int[] queue2) {
        // 둘 중 하나의 큐만 확인
        // [1, 1, 1, 1], [1, 1, 7, 1] 일 경우 생각 => [7], [1, 1, 1, 1, 1, 1, 1]
        // => 9번 연산 가능
        // 최대 (n - 1) + (2n - 2) = 3(n - 1) 까지 pop + insert 연산 가능
        // 그만큼 했는데 결과 도출 안되면 -1 반환
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        long target = 0;
        long sum1 = 0;
        int result = -1;

        for (int i = 0; i < queue1.length; i++) {
            int num1 = queue1[i];
            int num2 = queue2[i];

            q1.add(num1);
            q2.add(num2);

            sum1 += num1;
            target += num1;
            target += num2;
        }

        target /= 2;

        int count = 0;
        int max = 3 * (queue1.length - 1);
        for (int i = 0; i < max; i++) {
            if (sum1 == target) {
                break;
            }

            if (sum1 < target) {
                int poll = q2.poll();
                q1.add(poll);
                sum1 += poll;
            } else {
                int poll = q1.poll();
                q2.add(poll);
                sum1 -= poll;
            }

            count++;
        }

        return sum1 == target ? count : result;
    }
}
