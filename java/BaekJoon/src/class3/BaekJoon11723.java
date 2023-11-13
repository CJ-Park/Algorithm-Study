package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 집합
public class BaekJoon11723 {
    int m;
    Set<Integer> set;
    BufferedReader br;
    StringTokenizer st;
    StringBuilder sb;

    public void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        set = new HashSet<>();
        m = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String solve = st.nextToken();
            getResult(solve);
        }
        System.out.print(sb);
    }

    public void getResult(String s) {
        switch (s) {
            case "add" :
                set.add(Integer.parseInt(st.nextToken()));
                break;
            case "remove" :
                set.remove(Integer.parseInt(st.nextToken()));
                break;
            case "check" :
                if (set.contains(Integer.parseInt(st.nextToken()))) sb.append(1).append("\n");
                else sb.append(0).append("\n");
                break;
            case "toggle" :
                int value = Integer.parseInt(st.nextToken());
                if (set.contains(value)) set.remove(value);
                else set.add(value);
                break;
            case "all" :
                for (int i = 1; i <= 20; i++) {
                    set.add(i);
                }
                break;
            case "empty" :
                set.clear();
                break;
        }
    }
}