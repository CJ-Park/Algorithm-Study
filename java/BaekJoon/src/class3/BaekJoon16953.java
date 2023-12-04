package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// A -> B - dp 문제
public class BaekJoon16953 {
    int B, result, count;
    long A;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;

        recur(A);
        if (result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result + 1);
    }

    // A = A * 10 + 1 / A = 2 * A
    // 1. 곱하기 2
    // 2. 곱하기 10 후 더하기 1
    // 완전 탐색하면서 Math.min 으로 최소 연산 구하기
    // a == B 인 경우가 나오면 count 값 저장
    // a == B 인 경우가 없이 리턴됐다면 -1 출력
    public void recur(long a) {
        // a == b 가 되면 result 랑 count 값 비교 더 작은거 넣고 리턴
        if (a == B) {
            result = Math.min(result, count);
            count--;
            return;
        }

        // a > b 이면 리턴
        if (a > B) return;


        count++;
        recur(a * 2);
        recur(a * 10 + 1);

        // 두 방법 다 했는데 리턴당했으면 count - 1
        count--;
    }
}
