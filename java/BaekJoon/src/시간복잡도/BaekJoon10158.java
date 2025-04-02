package 시간복잡도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 개미
// 반복 체크 필요 -> 시간복잡도 제한(0.15초)
public class BaekJoon10158 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(br.readLine());

        int px = x + time;
        int py = y + time;
        int resX, resY;

        if ((px / w) % 2 == 0) {
            resX = px % w;
        } else {
            resX = w - px % w;
        }

        if ((py / h) % 2 == 0) {
            resY = py % h;
        } else {
            resY = h - py % h;
        }

        System.out.println(resX + " " + resY);
    }
}
