package level3.re;

import java.util.HashMap;
import java.util.HashSet;

// 2020 카카오 인턴
// 슬라이딩 윈도우 알고리즘
public class 보석_쇼핑 {
    public int[] solution(String[] gems) {
        HashSet<String> gemType = new HashSet<>();
        HashMap<String, Integer> gemMap = new HashMap<>();

        for (String gem : gems) {
            gemType.add(gem);
        }

        int totalCount = gemType.size();
        int startIdx = 0, endIdx = 0, resStart = 0, resEnd = 0;
        int minLen = Integer.MAX_VALUE;

        // 최대 N * 2번 연산하므로 시간복잡도 O(N)
        while (true) {
            if (startIdx > endIdx) {
                break;
            }

            if (gemMap.keySet().size() == totalCount) { // 모든 보석 포함됨
                if (endIdx - startIdx < minLen) { // 갱신
                    resStart = startIdx;
                    resEnd = endIdx;
                    minLen = endIdx - startIdx;
                }

                // startIdx 위치 뒤로
                String startGem = gems[startIdx];
                int countGem = gemMap.get(startGem) - 1;

                // 보석 카운트 줄이는 작업
                if (countGem == 0) {
                    gemMap.remove(startGem);
                } else {
                    gemMap.put(startGem, countGem);
                }

                startIdx++;
            } else { // 아직 보석 다 포함 안됨
                if (endIdx == gems.length) {
                    break;
                }

                // 해당 위치 보석 카운팅
                String endGem = gems[endIdx];
                gemMap.put(endGem, gemMap.getOrDefault(endGem, 0) + 1);

                // endIdx 뒤로
                endIdx++;
            }
        }

        return new int[]{resStart + 1, resEnd};
    }
}
