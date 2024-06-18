package level2;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

// 2018 카카오 블라인드
public class 캐시_1차 {
    // 캐시는 특정 인덱스를 날리고 다시 삽입 가능
    // => 순서쌍이 존재하며 중복은 불가함
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        // 중복을 직접 체크한다면 List 써도 무방
        Set<String> cache = new LinkedHashSet<>(cacheSize);
        int cost = 0;

        for (String city : cities) {
            String lowerCaseCity = city.toLowerCase();

            if (cache.contains(lowerCaseCity)) {
                cost++;
                cache.remove(lowerCaseCity);
            } else {
                if (cache.size() == cacheSize) { // 제일 오래된 캐시 날리기
                    Iterator<String> iter = cache.iterator();
                    iter.next();
                    iter.remove();
                }
                cost += 5;
            }
            cache.add(lowerCaseCity);
        }

        return cost;
    }
}
