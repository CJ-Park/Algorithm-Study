package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

// 2018 카카오 블라인드
public class 압축_3차 {
    static HashMap<String, Integer> map = new HashMap<>();

    public int[] solution(String msg) {
        initMap();
        int idx = 27;
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        // K 탐색, KA 탐색 - 없음, A 탐색, AK 탐색 - 없음, K 탐색, KA 탐색, O 탐색
        // KAKAO
        // K (0, 1) - 11
        // KA (0, 2) - x => 27 저장 => idx++
        // A (1, 2) - 1
        // AK (1, 3) - x => 28 저장 => idx++
        // K (2, 3) - 11
        // KA (2, 4) - 27
        // KAO (2, 5) - x => 29 저장 => idx++
        // O (4, 5) - 15
        int i = 0;
        while (i < msg.length()) {
            int count = 0;
            for (int j = i + 1; j <= msg.length(); j++) {
                String s = msg.substring(i, j);

                if (map.containsKey(s)) { // 사전에 있는 경우
                    stack.push(map.get(s)); // stack에 넣고 다음 문자 확인
                    count++;
                } else { // 사전에 없는 경우
                    map.put(s, idx); // 사전에 새롭게 추가
                    idx++; // idx 값 늘리기
                    break;
                }
            }
            list.add(stack.pop()); // stack 에 저장된 마지막꺼 꺼내서 list 에 저장
            stack.clear();
            i += count; // count만큼 이동한 위치부터 다시 문자열 자르기
        }

        int[] result = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            result[k] = list.get(k);
        }

        return result;
    }

    private void initMap() {
        for (int i = 1; i <= 26; i++) {
            int num = 64 + i;
            char c = (char) num;
            String s = String.valueOf(c);
            map.put(s, i);
        }
    }
}
