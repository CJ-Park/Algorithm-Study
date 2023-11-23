package class3.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1로 만들기
public class BaekJoon1463 {
    int n, count;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 연산이 끝났을 때 연산의 총 합이 제일 작아야됨 => 3으로 나눈 경우 or 2로 나눈 경우중에 더 적은 경우 찾기
        int result = recur(n, count);

        System.out.println(result);
    }

    // 3으로 나눈 경우와 2로 나눈 경우 비교하며 재귀
    public int recur(int n, int count) { //
        if (n < 2) return count;

        return Math.min(recur(n / 2, count + 1 + (n % 2)), recur(n / 3, count + 1 + (n % 3)));
    }
}
