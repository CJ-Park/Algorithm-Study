package level1;

import java.util.HashMap;

// 2022 카카오 기술 인턴
public class 성격_유형_검사하기 {
    static String[] personality = new String[4];

    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();

        initPersonality();
        int size = choices.length;
        int[] choice = new int[size];

        for (int i = 0; i < size; i++) {
            choice[i] = choices[i] - 4;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            if (choice[i] < 0) { // survey의 앞쪽에 절대값 점수 추가
                char key = survey[i].charAt(0);
                map.put(key, map.getOrDefault(key, 0) + Math.abs(choice[i]));
            }

            if (choice[i] > 0) { // survey의 뒤쪽에 절대값 점수 추가
                char key = survey[i].charAt(1);
                map.put(key, map.getOrDefault(key, 0) + Math.abs(choice[i]));
            }
        }

        for (String s : personality) {
            if (map.getOrDefault(s.charAt(0), 0) < map.getOrDefault(s.charAt(1), 0)) {
                sb.append(s.charAt(1));
            } else {
                sb.append(s.charAt(0));
            }
        }

        return sb.toString();
    }

    private void initPersonality() {
        personality[0] = "RT";
        personality[1] = "CF";
        personality[2] = "JM";
        personality[3] = "AN";
    }
}
