package level1;

import java.util.HashMap;

public class 숫자_문자열과_영단어 {
    static StringBuilder result = new StringBuilder();
    static StringBuilder word = new StringBuilder();
    static HashMap<String, String> map = new HashMap<>();

    public int solution(String s) {
        initMap();

        for (int i = 0; i < s.length(); i++) {
            word.append(s.charAt(i));
            String w = word.toString();

            if (map.containsValue(w)) { // 숫자 값 발견
                result.append(w);
                word.setLength(0);
            }

            if (map.containsKey(w)) { // 영문키값 발견
                result.append(map.get(w));
                word.setLength(0);
            }
        }

        return Integer.parseInt(result.toString());
    }

    private void initMap() {
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
    }
}
