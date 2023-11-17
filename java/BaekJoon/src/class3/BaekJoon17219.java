package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 비밀번호 찾기
public class BaekJoon17219 {
    Map<String, String> map;
    int n, m;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        map = new HashMap<>();

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().split(" ");
            String site = strings[0];
            String pass = strings[1];
            map.put(site, pass);
        }

        for (int i = 0; i < m; i++) {
            String key = br.readLine();
            sb.append(map.get(key)).append("\n");
        }

        System.out.print(sb);
    }
}
