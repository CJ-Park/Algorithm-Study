package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 리모컨 - 브루트포스
public class BaekJoon1107 {
    int target, n;
    int result = Integer.MAX_VALUE;
    Set<Integer> brokenBtn = new HashSet<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        target = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        if (n != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                brokenBtn.add(Integer.parseInt(st.nextToken()));
            }
        }

        // 1. target == 100 인 경우 결과 0
        // 2. target 을 ++ -- 버튼으로만 찾는 경우
        // 3. 임의의 채널을 입력받아서 ++ -- 후 찾는 경우

        // 1
        if (target == 100) {
            result = 0;
            System.out.println(result);
            return;
        }

        // 2
        searchFrom100();


        // 3
        for (int i = 0; i < 1000000; i++) {
            searchTarget(i);
        }

        System.out.println(result);
    }

    public void searchFrom100() {
        int start = 100;

        if (target > start) {
            result = Math.min(result, target - start);
        } else {
            result = Math.min(result, start - target);
        }
    }

    // 입력 가능 채널 (000000 ~ 999999)
    public void searchTarget(int start) {
        String num = String.valueOf(start);
        for (int i = 0; i < num.length(); i++) {
            String s = String.valueOf(num.charAt(i));
            int number = Integer.parseInt(s);
            if (brokenBtn.contains(number))
                return;
        }

        if (target > start) {
            result = Math.min(result, target - start + num.length());
        } else if (target < start){
            result = Math.min(result, start - target + num.length());
        } else {
            result = Math.min(result, num.length());
        }
    }
}
