package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BaekJoon1620 {
    int n, m;
    Map<String, Integer> map;
    String[] arr;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new String[n];
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            arr[i] = name;
            map.put(name, i);
        }

        for (int i = 0; i < m; i++) {
            String res = br.readLine();
            Integer number = map.get(res);
            if (number == null) {
                String name = arr[Integer.parseInt(res) - 1];
                sb.append(name).append("\n");
            } else {
                sb.append(number + 1).append("\n");
            }
        }

        System.out.print(sb);
    }
}
