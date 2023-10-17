package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 부녀회장이 될테야
public class BaekJoon2775 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            System.out.println(cal(a, b));
        }
    }

    public int cal(int a, int b) {
        // 403 = 402 + 303
        // a가 0되면 b 반환
        // b가 1일때 1 반환
        if(a == 0) return b;
        if(b == 1) return 1;
        return cal(a, b - 1) + cal(a - 1, b);
    }
}
