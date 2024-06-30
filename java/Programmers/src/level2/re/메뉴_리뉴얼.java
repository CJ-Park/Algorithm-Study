package level2.re;

import java.util.*;

// 2021 카카오 블라인드
public class 메뉴_리뉴얼 {
    // 문자열 조합필요
    private HashSet<Integer> set = new HashSet<>();
    private HashMap<String, Integer> courseCount = new HashMap<>();
    private HashMap<Integer, List<String>> resultMap = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        for (int i : course) {
            set.add(i);
            resultMap.put(i, new ArrayList<>());
        }

        for (String order : orders) {
            char[] ch = order.toCharArray();
            Arrays.sort(ch);

            getCombi(ch, new StringBuilder(), 0);
        }

        // key의 길이별로 가장 큰 value를 가진 key만 list에 추가
        // 단 value가 2보다 작으면 추가 X
        for (int key : set) {
            List<String> list = resultMap.get(key);
            int maxCount = 2;

            for (String str : courseCount.keySet()) {
                if (str.length() == key) { // 메뉴 개수가 맞는 애들끼리 정리
                    int menuCount = courseCount.get(str);

                    if (menuCount > maxCount) {
                        list.clear();
                        list.add(str);
                        maxCount = menuCount;
                    } else if (menuCount == maxCount) {
                        list.add(str);
                    }
                }
            }
        }

        List<String> res = new ArrayList<>();
        for (int key : resultMap.keySet()) {
            for (String s : resultMap.get(key)) {
                res.add(s);
            }
        }

        Collections.sort(res);

        return res.stream().toArray(String[]::new);
    }

    // 조합 구하면서 courseCount 구하는 메소드
    private void getCombi(char[] order, StringBuilder result, int start) {
        if (set.contains(result.length())) { // 카운트 추가
            String res = result.toString();
            courseCount.put(res, courseCount.getOrDefault(res, 0) + 1);
        }

//         직관적이지만 성능적으로 차이가 심함
//         for (int i = start; i < order.length; i++) {
//             if (visited[i]) {
//                 continue;
//             }

//             visited[i] = true;
//             getCombi(order, visited, result + order[i], i + 1);
//             visited[i] = false;
//         }

        for (int i = start; i < order.length; i++) {
            result.append(order[i]);
            getCombi(order, result, i + 1);
            result.deleteCharAt(result.length() - 1);
        }
    }
}
