package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 2018 카카오 블라인드
public class 뉴스_클러스터링_1차 {
    static int MOD = 65536;

    public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            String s = str1.substring(i, i + 2);

            if (Character.isAlphabetic(s.charAt(0))
                    && Character.isAlphabetic(s.charAt(1))) {
                list1.add(s.toLowerCase());
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String s = str2.substring(i, i + 2);

            if (Character.isAlphabetic(s.charAt(0))
                    && Character.isAlphabetic(s.charAt(1))) {
                list2.add(s.toLowerCase());
            }
        }

        // 전체 개수 저장
        List<String> all = new ArrayList<>(list1);
        all.addAll(list2);

        // 교집합 판별을 위해 각 list 요소 카운팅
        // [ab, ba, ab], [ba, ab, ba]
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (String s : list1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }

        for (String s : list2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }

        // 교집합 개수 구하기
        int child = 0;
        for (String s1 : list1) {
            for (String s2 : list2) {
                if (s1.equals(s2)) {
                    int count1 = map1.get(s1);
                    int count2 = map2.get(s1);
                    if (count1 > 0 && count2 > 0) { // 양쪽 리스트에 0개보다 더 있어야 교집합에 포함 가능
                        child++;
                        map1.put(s1, count1 - 1);
                        map2.put(s1, count2 - 1);
                    }
                }
            }
        }

        // 분모
        int parent = all.size() - child;

        if (all.size() == 0) {
            return MOD;
        }

        return MOD * child / parent;
    }
}
