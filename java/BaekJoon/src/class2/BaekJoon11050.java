package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11050 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(cal(N, K));
    }

    public int cal(int a, int b) {
        if(b == 0 || b == a) {
            return 1;
        }
        return cal(a - 1, b) + cal(a - 1, b - 1);
    }
}
