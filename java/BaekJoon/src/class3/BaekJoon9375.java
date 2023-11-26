package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

// 패션완 신해빈 - HashMap 중복 value + 조합
public class BaekJoon9375 {
    int t;
    HashMap<String, ArrayList<String>> hashMap;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            hashMap = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String[] s = br.readLine().split(" ");
                if (!hashMap.containsKey(s[1])) {
                    hashMap.put(s[1], new ArrayList<>());
                    hashMap.get(s[1]).add(s[0]);
                } else {
                    hashMap.get(s[1]).add(s[0]);
                }
            }
            System.out.println(getCombination());
        }
    }

    // 조합 경우의 수 반환
    public int getCombination() {
        int result = 1;
        for (String key : hashMap.keySet()) {
            result *= hashMap.get(key).size() + 1; // null 추가로 인한 + 1
        }
        return result - 1; // 모두 null 인 경우 제외
    }
}
