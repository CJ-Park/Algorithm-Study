package Hash.level2;

import java.util.HashMap;
import java.util.Map;

public class 의상 {
    public int solution(String[][] clothes) {
        int result = 1;
        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            String type = cloth[1];

            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        for (String type : map.keySet()) {
            result *= map.get(type) + 1;
        }

        return result - 1;
    }
}
