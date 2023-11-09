package class2.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소수 구하기
// 처음에 단순히 계산 -> 시간복잡도 문제로 시간초과 발생 (O(N^2))
// 에라토스테네스의 체 방식을 사용해서 시간복잡도 (O(Nlog(logN)))
public class BaekJoon1929 {
    int m, n;
    boolean[] arr;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        // n 이하의 소수 - m - 1 이하의 소수
        getPrime(n, m - 1);

        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) sb.append(i).append("\n");
        }
        System.out.print(sb);
    }

    // n 이하 && m 이상의 소수 구함
    // 소수의 배수로 해당 수의 루트까지 걸러냄
    public void getPrime(int num1, int num2) {
        arr = new boolean[num1 + 1];
        arr[0] = arr[1] = true;
        for (int i = 2; i <= Math.sqrt(num1); i++) {
            if (arr[i]) continue;
            for (int j = 2 * i; j <= num1; j = j + i) {
                arr[j] = true;
            }
        }

        for (int i = 0; i <= num2; i++) {
            arr[i] = true;
        }
    }
}
