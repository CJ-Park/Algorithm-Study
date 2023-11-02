package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 지도자동구축 {
    int n, res; // 단계
    int[] arr; // 한 변에 존재하는 점 개수
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        arr[0] = 2;
        // 0 1 2  3  4
        // 2*2 3*3 5*5 9*9 17*17
        for (int i = 1; i <= n; i++) {
            arr[i] = 2 * arr[i - 1] - 1;
        }
        res = arr[n] * arr[n];
        System.out.println(res);
    }
}
